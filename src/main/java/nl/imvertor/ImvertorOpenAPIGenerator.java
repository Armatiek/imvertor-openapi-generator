package nl.imvertor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.v3.core.util.Yaml;
import io.swagger.v3.jaxrs2.integration.JaxrsOpenApiContextBuilder;
import io.swagger.v3.oas.integration.OpenApiConfigurationException;
import io.swagger.v3.oas.integration.SwaggerConfiguration;
import io.swagger.v3.oas.integration.api.OpenApiContext;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.SwaggerParseResult;

import static java.lang.String.format;

public class ImvertorOpenAPIGenerator {
  
  private static final Logger logger = LoggerFactory.getLogger(ImvertorOpenAPIGenerator.class);
  
  private OpenAPI createOpenAPI(String[] args) throws OpenApiConfigurationException, IOException {
    Properties properties = loadPropertiesFromClassPath("openapi.properties");
    
    List<Server> servers = new ArrayList<Server>();
    
    String title = properties.getProperty("openapi.description", "No title");
    String description = properties.getProperty("openapi.description", null);
    String version = properties.getProperty("openapi.version", "1.0.0");
    String contact = properties.getProperty("openapi.contact", null);
    String license = properties.getProperty("openapi.license", null);
    
    Info info = new Info().title(title);
    if (description != null) {
      info.setDescription(description);
    }
    if (version != null) {
      info.setVersion(version);
    }
    if (contact != null) {
      Contact cnt = new Contact();
      cnt.setUrl(contact);
      info.setContact(cnt);
    }
    if (true) {
      /* TODO: read from properties file: */
      License lic = new License();
      lic.setName("European Union Public License, version 1.2 (EUPL-1.2)");
      lic.setUrl("https://eupl.eu/1.2/nl/");
      info.setLicense(lic);
    }
    
    OpenAPI api = new OpenAPI()
        .servers(servers)
        .info(info);
    
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
  
  private Properties loadPropertiesFromClassPath(String path) throws IOException {
    try (InputStream input = getClass().getClassLoader().getResourceAsStream(path)) {
      if (input == null) {
        throw new FileNotFoundException("Could not find openapi.properties on classpath");
      }
      Properties properties = new Properties();
      properties.load(input);
      return properties;
    }
  }  
  
  private void generateOpenAPIYaml(String[] args) throws Exception {
    logger.info("Generating OpenAPI specification ...");
    OpenAPI openApi = createOpenAPI(args);
    String openApiYaml = Yaml.pretty(openApi);
    validateOpenAPISpec(openApiYaml);
    logger.info(format("Writing OpenAPI specification to \"%s\" ...", args[0]));
    FileUtils.write(new File(args[0]), openApiYaml, StandardCharsets.UTF_8);
    logger.info("Finished.");
  }
  
  private void validateOpenAPISpec(String openApiYaml) {
    logger.info("Validating OpenAPI specification ...");
    OpenAPIV3Parser parser = new OpenAPIV3Parser();
    SwaggerParseResult result = parser.readContents(openApiYaml);
    OpenAPI openAPI = result.getOpenAPI();
    if (openAPI == null) {
      logger.warn("Invalid OpenAPI specification");
    }
    if (result.getMessages() != null && !result.getMessages().isEmpty()) {
      for (String msg : result.getMessages()) {
        logger.warn(" - validation message: " + msg);
      }
    } else {
      logger.info("OpenAPI specification is valid");
    }
  }

  public static void main(String[] args) {
    if (args.length == 0) {
      logger.info("Please specify the output path of the OpenAPI yaml file as the first argument");
      logger.info("Please optionally specify \"api31\" as the second argument if you want to generate an OpenAPI specification version 3.1.0");
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