package nl.imvertor.resource.fietsenwinkel.contacten;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.headers.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.constraints.Min;

import nl.imvertor.model.fietsenwinkel.contacten.Bankrekening;
import nl.imvertor.model.fietsenwinkel.contacten.PaginatedBankrekeningList;

@Path("/v1/bankrekeningen")
@Tag(name = "Bankrekening", description = "Rekening bij een bank.")
public class BankrekeningResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(summary = "Retourneert de lijst van alle Bankrekening objecten", description = "Retourneert een gepagineerde lijst van alle Bankrekening objecten")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "OK",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = PaginatedBankrekeningList.class)),
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
  public Response getAllBankrekening(
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
  @Operation(summary = "Maakt een nieuw Bankrekening object", description = "Maakt een nieuw Bankrekening object aan op basis van de aangeleverde gegevens")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Bankrekening succesvol aangemaakt",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = Bankrekening.class)),
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
  public Response createBankrekening(@Parameter(description = "De gegevens van het Bankrekening object", required = true) Bankrekening bankrekening) {
    return Response.ok().build();
  }

  @DELETE
  @Path("/{rekeningnummer}")
  @Operation(summary = "Verwijderd een Bankrekening object", description = "Verwijderd een specifiek Bankrekening object permanent uit het systeem")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "202", description = "Bankrekening object zal worden verwijderd",
      headers = {@Header(name = "api-version", ref = "https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/headers/API-Version")}),
    @ApiResponse(responseCode = "204", description = "Bankrekening object succesvol verwijderd",
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
  public Response deleteBankrekening(@Parameter(description = "Bankrekening ID", example="1", required = true) @PathParam("rekeningnummer") String rekeningnummer) {
    return Response.ok().build();
  }

  @GET
  @Path("/{rekeningnummer}")
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(summary = "Retourneert een Bankrekening object op basis van zijn unieke identificatie", description = "Retourneert een individueel Bankrekening object op basis van zijn unieke identificatie")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Bankrekening was gevonden",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = Bankrekening.class)),
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
  public Response getBankrekeningById(@Parameter(description = "Bankrekening ID", example="1", required = true) @PathParam("rekeningnummer") String rekeningnummer) {
    return Response.ok().build();
  }

  @PUT
  @Path("/{rekeningnummer}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(summary = "Maakt nieuw of overschrijft bestaand Bankrekening object", description = "Maakt een nieuw of overschrijft (volledig) een bestaand Bankrekening object")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Bankrekening object succesvol aangemaakt/overschreven",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = Bankrekening.class)),
      headers = {@Header(name = "api-version", ref = "https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/headers/API-Version"),
        @Header(name = "Location", description = "URI van het opgeslagen object", schema = @Schema(type = "string", format = "uri"))}),
    @ApiResponse(responseCode = "201", description = "Bankrekening object succesvol aangemaakt",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = Bankrekening.class)),
      headers = {@Header(name = "api-version", ref = "https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/headers/API-Version"),
        @Header(name = "Location", description = "URI van het opgeslagen object", schema = @Schema(type = "string", format = "uri"))}),
    @ApiResponse(responseCode = "204", description = "Bankrekening object succesvol overschreven",
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
  public Response updateBankrekening(
    @Parameter(description = "Bankrekening ID", example="1", required = true) @PathParam("rekeningnummer") String rekeningnummer,
    @Parameter(description = "Complete Bankrekening update data", required = true) Bankrekening bankrekening) {
    return Response.ok().build();
  }

  @PATCH
  @Path("/{rekeningnummer}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(summary = "Werkt een bestaand Bankrekening object gedeeltelijk bij", description = "Werkt een bestaand Bankrekening object gedeeltelijk bij door alleen de aangeleverde velden te overschrijven")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Bankrekening object succesvol aangemaakt/overschreven",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = Bankrekening.class)),
      headers = {@Header(name = "api-version", ref = "https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/headers/API-Version"),
        @Header(name = "Location", description = "URI van het opgeslagen object", schema = @Schema(type = "string", format = "uri"))}),
    @ApiResponse(responseCode = "204", description = "Bankrekening object succesvol overschreven",
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
  public Response patchBankrekening(
    @Parameter(description = "Bankrekening ID", example="1", required = true) @PathParam("rekeningnummer") String rekeningnummer,
    @Parameter(description = "Bankrekening update data", required = true) Bankrekening bankrekening) {
    return Response.ok().build();
  }

}
