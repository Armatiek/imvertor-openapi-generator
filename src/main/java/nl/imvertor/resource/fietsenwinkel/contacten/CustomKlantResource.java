package nl.imvertor.resource.fietsenwinkel.contacten;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import nl.imvertor.model.fietsenwinkel.contacten.PaginatedKlantList;

@Path("/v1/klanten")
@Tag(name = "Klant", description = "Een persoon die een fiets heeft gekocht.")
public class CustomKlantResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(summary = "Get all Klant objects filtered by name and/or address", description = "Retrieves a paginated list of all Klant objects filtered by name and/or address")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "OK",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = PaginatedKlantList.class)),
      headers = {@Header(name = "api-version", ref = "https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/headers/API-Version"), 
        @Header(name = "Location", description = "URI van het opgeslagen object", schema = @Schema(type = "string", format = "uri"))}),
    @ApiResponse(responseCode = "400", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/400"),
    @ApiResponse(responseCode = "401", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/401"),
    @ApiResponse(responseCode = "403", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/403"),
    @ApiResponse(responseCode = "409", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/409"),
    @ApiResponse(responseCode = "410", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/410"),
    @ApiResponse(responseCode = "415", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/415"),
    @ApiResponse(responseCode = "429", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/429"),
    @ApiResponse(responseCode = "500", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/500"),
    @ApiResponse(responseCode = "501", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/501"),
    @ApiResponse(responseCode = "503", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/503")
  })
  public Response getKlantenByNameAndAddress(
      
    @Parameter(ref = "https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/parameters/page")
    int page,

    @Parameter(ref = "https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/parameters/pageSize")
    int pageSize,
    
    @Parameter(ref = "https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/parameters/sortField")
    String sortField,
    
    @QueryParam("naam")
    @Parameter(description = "Name of the Klant", example = "Johan")
    String name,
    
    @QueryParam("address")
    @Parameter(description = "Address of the Klant", example = "Dorpsstraat 1")
    String address) {
    return Response.ok().build();
  }

}