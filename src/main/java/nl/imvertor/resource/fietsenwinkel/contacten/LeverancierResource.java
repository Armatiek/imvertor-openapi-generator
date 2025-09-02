package nl.imvertor.resource.fietsenwinkel.contacten;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.headers.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.constraints.Min;

import nl.imvertor.model.fietsenwinkel.contacten.Leverancier;
import nl.imvertor.model.fietsenwinkel.contacten.PaginatedLeverancierList;

@Path("/v1/leveranciers")
@Tag(name = "Leverancier", description = "Een instelling die een fietsen levert.")
public class LeverancierResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(summary = "Retourneert de lijst van alle Leverancier objecten", description = "Retourneert een gepagineerde lijst van alle Leverancier objecten")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "OK",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = PaginatedLeverancierList.class)),
      headers = {@Header(name = "api-version", ref = "https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/headers/API-Version")}),
    @ApiResponse(responseCode = "400", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/400"),
    @ApiResponse(responseCode = "401", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/401"),
    @ApiResponse(responseCode = "403", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/403"),
    @ApiResponse(responseCode = "404", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/404"),
    @ApiResponse(responseCode = "405", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/405"),
    @ApiResponse(responseCode = "415", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/415"),
    @ApiResponse(responseCode = "429", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/429"),
    @ApiResponse(responseCode = "500", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/500"),
    @ApiResponse(responseCode = "503", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/503")
  })
  public Response getAllLeverancier(
    @Parameter(ref = "https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/parameters/page")
    int page,
    @Parameter(ref = "https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/parameters/pageSize")
    int pageSize,
    @Parameter(ref = "https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/parameters/sortField")
    String sortField) {
    return Response.ok().build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(summary = "Maakt een nieuw Leverancier object", description = "Maakt een nieuw Leverancier object aan op basis van de aangeleverde gegevens")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Leverancier succesvol aangemaakt",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = Leverancier.class)),
      headers = {@Header(name = "api-version", ref = "https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/headers/API-Version"),
        @Header(name = "Location", description = "URI van het opgeslagen object", schema = @Schema(type = "string", format = "uri"))}),
    @ApiResponse(responseCode = "400", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/400"),
    @ApiResponse(responseCode = "401", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/401"),
    @ApiResponse(responseCode = "403", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/403"),
    @ApiResponse(responseCode = "405", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/405"),
    @ApiResponse(responseCode = "409", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/409"),
    @ApiResponse(responseCode = "415", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/415"),
    @ApiResponse(responseCode = "422", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/422"),
    @ApiResponse(responseCode = "429", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/429"),
    @ApiResponse(responseCode = "500", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/500"),
    @ApiResponse(responseCode = "503", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/503")
  })
  public Response createLeverancier(@Parameter(description = "De gegevens van het Leverancier object", required = true) Leverancier leverancier) {
    return Response.ok().build();
  }

  @DELETE
  @Path("/{naam}")
  @Operation(summary = "Verwijderd een Leverancier object", description = "Verwijderd een specifiek Leverancier object permanent uit het systeem")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "202", description = "Leverancier object zal worden verwijderd",
      headers = {@Header(name = "api-version", ref = "https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/headers/API-Version")}),
    @ApiResponse(responseCode = "204", description = "Leverancier object succesvol verwijderd",
      headers = {@Header(name = "api-version", ref = "https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/headers/API-Version")}),
    @ApiResponse(responseCode = "401", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/401"),
    @ApiResponse(responseCode = "403", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/403"),
    @ApiResponse(responseCode = "404", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/404"),
    @ApiResponse(responseCode = "405", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/405"),
    @ApiResponse(responseCode = "409", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/409"),
    @ApiResponse(responseCode = "415", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/415"),
    @ApiResponse(responseCode = "429", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/429"),
    @ApiResponse(responseCode = "500", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/500"),
    @ApiResponse(responseCode = "503", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/503")
  })
  public Response deleteLeverancier(@Parameter(description = "Leverancier ID", example="1", required = true) @PathParam("naam") String naam) {
    return Response.ok().build();
  }

  @GET
  @Path("/{naam}")
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(summary = "Retourneert een Leverancier object op basis van zijn unieke identificatie", description = "Retourneert een individueel Leverancier object op basis van zijn unieke identificatie")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Leverancier was gevonden",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = Leverancier.class)),
      headers = {@Header(name = "api-version", ref = "https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/headers/API-Version")}),
    @ApiResponse(responseCode = "400", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/400"),
    @ApiResponse(responseCode = "401", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/401"),
    @ApiResponse(responseCode = "403", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/403"),
    @ApiResponse(responseCode = "404", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/404"),
    @ApiResponse(responseCode = "405", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/405"),
    @ApiResponse(responseCode = "415", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/415"),
    @ApiResponse(responseCode = "429", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/429"),
    @ApiResponse(responseCode = "500", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/500"),
    @ApiResponse(responseCode = "503", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/503")
  })
  public Response getLeverancierById(@Parameter(description = "Leverancier ID", example="1", required = true) @PathParam("naam") String naam) {
    return Response.ok().build();
  }

  @PUT
  @Path("/{naam}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(summary = "Maakt nieuw of overschrijft bestaand Leverancier object", description = "Maakt een nieuw of overschrijft (volledig) een bestaand Leverancier object")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Leverancier object succesvol aangemaakt/overschreven",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = Leverancier.class)),
      headers = {@Header(name = "api-version", ref = "https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/headers/API-Version"),
        @Header(name = "Location", description = "URI van het opgeslagen object", schema = @Schema(type = "string", format = "uri"))}),
    @ApiResponse(responseCode = "201", description = "Leverancier object succesvol aangemaakt",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = Leverancier.class)),
      headers = {@Header(name = "api-version", ref = "https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/headers/API-Version"),
        @Header(name = "Location", description = "URI van het opgeslagen object", schema = @Schema(type = "string", format = "uri"))}),
    @ApiResponse(responseCode = "204", description = "Leverancier object succesvol overschreven",
      headers = {@Header(name = "api-version", ref = "https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/headers/API-Version")}),
    @ApiResponse(responseCode = "400", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/400"),
    @ApiResponse(responseCode = "401", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/401"),
    @ApiResponse(responseCode = "403", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/403"),
    @ApiResponse(responseCode = "404", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/404"),
    @ApiResponse(responseCode = "405", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/405"),
    @ApiResponse(responseCode = "409", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/409"),
    @ApiResponse(responseCode = "415", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/415"),
    @ApiResponse(responseCode = "429", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/429"),
    @ApiResponse(responseCode = "500", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/500"),
    @ApiResponse(responseCode = "503", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/503")
  })
  public Response updateLeverancier(
    @Parameter(description = "Leverancier ID", example="1", required = true) @PathParam("naam") String naam,
    @Parameter(description = "Complete Leverancier update data", required = true) Leverancier leverancier) {
    return Response.ok().build();
  }

  @PATCH
  @Path("/{naam}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(summary = "Werkt een bestaand Leverancier object gedeeltelijk bij", description = "Werkt een bestaand Leverancier object gedeeltelijk bij door alleen de aangeleverde velden te overschrijven")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Leverancier object succesvol aangemaakt/overschreven",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = Leverancier.class)),
      headers = {@Header(name = "api-version", ref = "https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/headers/API-Version"),
        @Header(name = "Location", description = "URI van het opgeslagen object", schema = @Schema(type = "string", format = "uri"))}),
    @ApiResponse(responseCode = "204", description = "Leverancier object succesvol overschreven",
      headers = {@Header(name = "api-version", ref = "https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/headers/API-Version")}),
    @ApiResponse(responseCode = "400", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/400"),
    @ApiResponse(responseCode = "401", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/401"),
    @ApiResponse(responseCode = "403", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/403"),
    @ApiResponse(responseCode = "404", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/404"),
    @ApiResponse(responseCode = "405", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/405"),
    @ApiResponse(responseCode = "409", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/409"),
    @ApiResponse(responseCode = "415", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/415"),
    @ApiResponse(responseCode = "422", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/422"),
    @ApiResponse(responseCode = "429", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/429"),
    @ApiResponse(responseCode = "500", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/500"),
    @ApiResponse(responseCode = "503", ref="https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/responses/503")
  })
  public Response patchLeverancier(
    @Parameter(description = "Leverancier ID", example="1", required = true) @PathParam("naam") String naam,
    @Parameter(description = "Leverancier update data", required = true) Leverancier leverancier) {
    return Response.ok().build();
  }

}
