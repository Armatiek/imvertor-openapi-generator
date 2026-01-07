package nl.imvertor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import io.swagger.v3.core.util.Json;
import io.swagger.v3.core.util.Yaml;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.media.Schema;

@SuppressWarnings("rawtypes")
public class OpenAPIExploder {
     
  public void explode(OpenAPI openAPI, String format, File zipFile, String baseUrl) throws FileNotFoundException, IOException {
    if (openAPI.getComponents() != null && openAPI.getComponents().getSchemas() != null) {
      Map<String, OpenAPI> explodedOpenAPIMap = new HashMap<>();
      
      Map<String, Schema> allSchemas = openAPI.getComponents().getSchemas();

      // Create a separate OpenAPI spec for each schema
      for (Map.Entry<String, Schema> entry : allSchemas.entrySet()) {
        String schemaName = entry.getKey();
        Schema schema = entry.getValue();

        // Clone the schema to avoid modifying the original
        Schema clonedSchema = cloneSchema(schema);

        // Rewrite references to external files
        rewriteReferences(clonedSchema, schemaName, format, (StringUtils.isBlank(baseUrl) ? null : StringUtils.stripEnd(baseUrl, "/")));

        // Create new OpenAPI object with single schema
        OpenAPI newOpenAPI = new OpenAPI();
        newOpenAPI.setOpenapi(openAPI.getOpenapi());
        newOpenAPI.setInfo(openAPI.getInfo());
        
        Paths paths = new Paths();
        newOpenAPI.setPaths(paths);

        Components components = new Components();
        components.addSchemas(schemaName, clonedSchema);
        newOpenAPI.setComponents(components);
        
        explodedOpenAPIMap.put(schemaName, newOpenAPI);
      }
      
      createZipFile(explodedOpenAPIMap, format, zipFile);
    } else {
      throw new IOException("OpenAPI description does not contains JSON schemas");
    }
  }
  
  private void createZipFile(Map<String, OpenAPI> specs, String format, File zipFile) throws FileNotFoundException, IOException {
    if (zipFile.isFile()) {
      FileUtils.deleteQuietly(zipFile);
    }
    try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile));
        OutputStreamWriter osw = new OutputStreamWriter(zos, StandardCharsets.UTF_8);
        BufferedWriter writer = new BufferedWriter(osw)) {
      for (Map.Entry<String, OpenAPI> entry : specs.entrySet()) {
        try {
          String serialization;
          if (format.equals("yaml")) {
            serialization = Yaml.pretty(entry.getValue());
          } else {
            serialization = Json.pretty(entry.getValue());
          }
          zos.putNextEntry(new ZipEntry(entry.getKey() + "." + format));
          writer.write(serialization);
          writer.flush();
          zos.closeEntry();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }  
    }
  }

  private void rewriteReferences(Schema schema, String currentSchemaName, String format, String baseUrl) {
    if (schema == null)
      return;

    // Rewrite direct $ref
    if (schema.get$ref() != null) {
      String refSchemaName = extractSchemaNameFromRef(schema.get$ref());
      String ref;
      if (baseUrl == null) {
        ref = "./" + refSchemaName + "." + format + "#/components/schemas/" + refSchemaName;
      } else {
        ref = baseUrl + "/" + refSchemaName + "." + format + "#/components/schemas/" + refSchemaName;
      }
      schema.set$ref(ref);
    }

    // Rewrite references in properties
    if (schema.getProperties() != null) {
      Map<String, Schema> properties = schema.getProperties();
      for (Object value : properties.values()) {
        if (value instanceof Schema) {
          rewriteReferences((Schema) value, currentSchemaName, format, baseUrl);
        }
      }
    }

    // Rewrite references in allOf, oneOf, anyOf
    if (schema.getAllOf() != null) {
      for (Object composedSchema : schema.getAllOf()) {
        if (composedSchema instanceof Schema) {
          rewriteReferences((Schema) composedSchema, currentSchemaName, format, baseUrl);
        }
      }
    }

    if (schema.getOneOf() != null) {
      for (Object composedSchema : schema.getOneOf()) {
        if (composedSchema instanceof Schema) {
          rewriteReferences((Schema) composedSchema, currentSchemaName, format, baseUrl);
        }
      }
    }

    if (schema.getAnyOf() != null) {
      for (Object composedSchema : schema.getAnyOf()) {
        if (composedSchema instanceof Schema) {
          rewriteReferences((Schema) composedSchema, currentSchemaName, format, baseUrl);
        }
      }
    }

    // Rewrite references in items (for arrays)
    if (schema.getItems() != null) {
      rewriteReferences(schema.getItems(), currentSchemaName, format, baseUrl);
    }

    // Rewrite references in additionalProperties
    if (schema.getAdditionalProperties() instanceof Schema) {
      rewriteReferences((Schema) schema.getAdditionalProperties(), currentSchemaName, format, baseUrl);
    }

    // Handle not schema
    if (schema.getNot() != null) {
      rewriteReferences(schema.getNot(), currentSchemaName, format, baseUrl);
    }
  }

  private String extractSchemaNameFromRef(String ref) {
    if (ref != null && ref.startsWith("#/components/schemas/")) {
      return ref.substring("#/components/schemas/".length());
    }
    return ref;
  }

  private Schema cloneSchema(Schema original) {
    // Deep clone by serializing and deserializing
    try {
      String json = Json.mapper().writeValueAsString(original);
      return Json.mapper().readValue(json, Schema.class);
    } catch (Exception e) {
      throw new RuntimeException("Failed to clone schema", e);
    }
  }

}