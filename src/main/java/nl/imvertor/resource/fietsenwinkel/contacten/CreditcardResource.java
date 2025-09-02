package nl.imvertor.resource.fietsenwinkel.contacten;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.headers.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.constraints.Min;

import nl.imvertor.model.fietsenwinkel.contacten.Creditcard;
import nl.imvertor.model.fietsenwinkel.contacten.PaginatedCreditcardList;

@Path("/v1/creditcards")
@Tag(name = "Creditcard", description = "Kaart waarmee op basis van kredieten een betaling wordt gedaan.")
public class CreditcardResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(summary = "Retourneert de lijst van alle Creditcard objecten", description = "Retourneert een gepagineerde lijst van alle Creditcard objecten")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "OK",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = PaginatedCreditcardList.class)),
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
  public Response getAllCreditcard(
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
  @Operation(summary = "Maakt een nieuw Creditcard object", description = "Maakt een nieuw Creditcard object aan op basis van de aangeleverde gegevens")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Creditcard succesvol aangemaakt",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = Creditcard.class)),
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
  public Response createCreditcard(@Parameter(description = "De gegevens van het Creditcard object", required = true) Creditcard creditcard) {
    return Response.ok().build();
  }

  @DELETE
  @Path("/{kaartnummer}")
  @Operation(summary = "Verwijderd een Creditcard object", description = "Verwijderd een specifiek Creditcard object permanent uit het systeem")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "202", description = "Creditcard object zal worden verwijderd",
      headers = {@Header(name = "api-version", ref = "https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/headers/API-Version")}),
    @ApiResponse(responseCode = "204", description = "Creditcard object succesvol verwijderd",
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
  public Response deleteCreditcard(@Parameter(description = "Creditcard ID", example="1", required = true) @PathParam("kaartnummer") String kaartnummer) {
    return Response.ok().build();
  }

  @GET
  @Path("/{kaartnummer}")
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(summary = "Retourneert een Creditcard object op basis van zijn unieke identificatie", description = "Retourneert een individueel Creditcard object op basis van zijn unieke identificatie")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Creditcard was gevonden",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = Creditcard.class)),
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
  public Response getCreditcardById(@Parameter(description = "Creditcard ID", example="1", required = true) @PathParam("kaartnummer") String kaartnummer) {
    return Response.ok().build();
  }

  @PUT
  @Path("/{kaartnummer}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(summary = "Maakt nieuw of overschrijft bestaand Creditcard object", description = "Maakt een nieuw of overschrijft (volledig) een bestaand Creditcard object")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Creditcard object succesvol aangemaakt/overschreven",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = Creditcard.class)),
      headers = {@Header(name = "api-version", ref = "https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/headers/API-Version"),
        @Header(name = "Location", description = "URI van het opgeslagen object", schema = @Schema(type = "string", format = "uri"))}),
    @ApiResponse(responseCode = "201", description = "Creditcard object succesvol aangemaakt",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = Creditcard.class)),
      headers = {@Header(name = "api-version", ref = "https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/headers/API-Version"),
        @Header(name = "Location", description = "URI van het opgeslagen object", schema = @Schema(type = "string", format = "uri"))}),
    @ApiResponse(responseCode = "204", description = "Creditcard object succesvol overschreven",
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
  public Response updateCreditcard(
    @Parameter(description = "Creditcard ID", example="1", required = true) @PathParam("kaartnummer") String kaartnummer,
    @Parameter(description = "Complete Creditcard update data", required = true) Creditcard creditcard) {
    return Response.ok().build();
  }

  @PATCH
  @Path("/{kaartnummer}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(summary = "Werkt een bestaand Creditcard object gedeeltelijk bij", description = "Werkt een bestaand Creditcard object gedeeltelijk bij door alleen de aangeleverde velden te overschrijven")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Creditcard object succesvol aangemaakt/overschreven",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = Creditcard.class)),
      headers = {@Header(name = "api-version", ref = "https://armatiek.github.io/imvertor-openapi-generator/openapi/generiek.yaml#/components/headers/API-Version"),
        @Header(name = "Location", description = "URI van het opgeslagen object", schema = @Schema(type = "string", format = "uri"))}),
    @ApiResponse(responseCode = "204", description = "Creditcard object succesvol overschreven",
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
  public Response patchCreditcard(
    @Parameter(description = "Creditcard ID", example="1", required = true) @PathParam("kaartnummer") String kaartnummer,
    @Parameter(description = "Creditcard update data", required = true) Creditcard creditcard) {
    return Response.ok().build();
  }

}
