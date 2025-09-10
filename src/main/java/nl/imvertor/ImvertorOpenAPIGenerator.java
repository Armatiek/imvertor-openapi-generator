package nl.imvertor;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.v3.core.util.Json;
import io.swagger.v3.core.util.Yaml;
import io.swagger.v3.jaxrs2.integration.JaxrsOpenApiContextBuilder;
import io.swagger.v3.oas.integration.OpenApiConfigurationException;
import io.swagger.v3.oas.integration.SwaggerConfiguration;
import io.swagger.v3.oas.integration.api.OpenApiContext;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.SwaggerParseResult;
import nl.imvertor.resource.OpenApiDefinition;
import nl.imvertor.resource.OpenApiDefinition.OpenAPISpecVersion;

public class ImvertorOpenAPIGenerator {
  
  private static final Logger logger = LoggerFactory.getLogger(ImvertorOpenAPIGenerator.class);
  
  private OpenAPI createOpenAPI() throws OpenApiConfigurationException, IOException {
    OpenAPI api = new OpenAPI();
    
    // Define the resource classes to scan
    Set<String> resourcePackages = new HashSet<>();
    resourcePackages.add("nl.imvertor.resource");

    // Create Swagger configuration
    SwaggerConfiguration config = new SwaggerConfiguration()
            .openAPI(api)
            .openAPI31(OpenApiDefinition.getOpenAPISpecVersion().equals(OpenAPISpecVersion.API31))
            .resourcePackages(resourcePackages)
            .prettyPrint(true);

    // Create OpenAPI context and read the specification
    @SuppressWarnings({ "rawtypes" })
    OpenApiContext context = new JaxrsOpenApiContextBuilder()
            .openApiConfiguration(config)
            .buildContext(true);

    return context.read();
  }
  
  private void generateOpenAPIYamlAndJson(String[] args) throws Exception {
    logger.info("Generating OpenAPI specification ...");
    OpenAPI openApi = createOpenAPI();
    String openApiYaml = Yaml.pretty(openApi);
    String openApiJson = Json.pretty(openApi);
    validateOpenAPISpec(openApiYaml);
    logger.info("Writing OpenAPI specification to files ...");
    String fileNameNoExt = FilenameUtils.removeExtension(args[0]);
    FileUtils.write(new File(fileNameNoExt + ".yaml"), openApiYaml, StandardCharsets.UTF_8);
    FileUtils.write(new File(fileNameNoExt + ".json"), openApiJson, StandardCharsets.UTF_8);
    logger.info("Finished.");
  }
  
  private void validateOpenAPISpec(String openApiYaml) {
    logger.info("Validating OpenAPI specification ...");
    OpenAPIV3Parser parser = new OpenAPIV3Parser();
    SwaggerParseResult result = parser.readContents(openApiYaml);
    OpenAPI openAPI = result.getOpenAPI();
    if (openAPI == null) {
      logger.error("Invalid OpenAPI specification.");
    }
    if (result.getMessages() != null && !result.getMessages().isEmpty()) {
      for (String msg : result.getMessages()) {
        logger.error("[validator] - " + msg);
      }
    } else {
      logger.info("OpenAPI specification is valid.");
    }
  }
  
  public static void main(String[] args) {
    if (args.length == 0) {
      logger.info("Please specify the output path of the OpenAPI yaml file as the first argument");
      return;
    }
    try {
      ImvertorOpenAPIGenerator generator = new ImvertorOpenAPIGenerator();
      generator.generateOpenAPIYamlAndJson(args);
    } catch (Throwable e) {
      logger.error("Error generating OpenAPI specification", e);
      logger.error("[generator] - " + e.getMessage());
      System.exit(1);
    }
  }

}