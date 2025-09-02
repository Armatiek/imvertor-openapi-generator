package nl.imvertor;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.Strings;
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

public class ImvertorOpenAPIGenerator {
  
  private static final Logger logger = LoggerFactory.getLogger(ImvertorOpenAPIGenerator.class);
  
  private OpenAPI createOpenAPI(String[] args) throws OpenApiConfigurationException, IOException {
    OpenAPI api = new OpenAPI();
    
    // Define the resource classes to scan
    Set<String> resourcePackages = new HashSet<>();
    resourcePackages.add("nl.imvertor.resource");

    // Create Swagger configuration
    SwaggerConfiguration config = new SwaggerConfiguration()
            .openAPI(api)
            .openAPI31(args.length > 1 && Strings.CI.equals(args[1], "api31"))
            .resourcePackages(resourcePackages)
            .prettyPrint(true);

    // Create OpenAPI context and read the specification
    @SuppressWarnings({ "rawtypes" })
    OpenApiContext context = new JaxrsOpenApiContextBuilder()
            .openApiConfiguration(config)
            .buildContext(true);

    return context.read();
  }
  
  private void generateOpenAPIYaml(String[] args) throws Exception {
    logger.info("Generating OpenAPI specification ...");
    OpenAPI openApi = createOpenAPI(args);
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
        logger.error(" - validation message: " + msg);
      }
    } else {
      logger.info("OpenAPI specification is valid.");
    }
  }
  
  public static void main(String[] args) {
    if (args.length == 0) {
      logger.info("Please specify the output path of the OpenAPI yaml file as the first argument");
      logger.info("And optionally specify \"api31\" as the second argument if you want to generate an OpenAPI specification version 3.1.0");
      return;
    }
    try {
      ImvertorOpenAPIGenerator generator = new ImvertorOpenAPIGenerator();
      generator.generateOpenAPIYaml(args);
    } catch (Throwable e) {
      logger.error("Error generating OpenAPI specification", e);
      System.exit(1);
    }
  }

}