package nl.imvertor.resource.fietsenwinkel.contacten;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.headers.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.constraints.Min;

import nl.imvertor.model.fietsenwinkel.contacten.Klant;
import nl.imvertor.model.fietsenwinkel.contacten.PaginatedKlantList;

@Path("/v1/klant")
@Tag(name = "Klant", description = "Een persoon die een fiets heeft gekocht.")
public class KlantResource {

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(summary = "Maakt een nieuw Klant object", description = "Maakt een nieuw Klant object aan op basis van de aangeleverde gegevens")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Klant succesvol aangemaakt",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = Klant.class)),
      headers = {@Header(name = "api-version", ref = "https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/headers/api_version"),
        @Header(name = "Location", description = "URI van het opgeslagen object", schema = @Schema(type = "string", format = "uri"))}),
    @ApiResponse(responseCode = "400", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/400"),
    @ApiResponse(responseCode = "401", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/401"),
    @ApiResponse(responseCode = "403", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/403"),
    @ApiResponse(responseCode = "409", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/409"),
    @ApiResponse(responseCode = "410", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/410"),
    @ApiResponse(responseCode = "415", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/415"),
    @ApiResponse(responseCode = "429", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/429"),
    @ApiResponse(responseCode = "500", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/500"),
    @ApiResponse(responseCode = "501", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/501"),
    @ApiResponse(responseCode = "503", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/503")
  })
  public Response createKlant(@Parameter(description = "De gegevens van het Klant object", required = true) Klant klant) {
    return Response.ok().build();
  }

  @DELETE
  @Path("/{id}")
  @Operation(summary = "Verwijderd een Klant object", description = "Verwijderd een specifiek Klant object permanent uit het systeem")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "204", description = "Klant object succesvol verwijderd",
      headers = {@Header(name = "api-version", ref = "https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/headers/api_version")}),
    @ApiResponse(responseCode = "400", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/400"),
    @ApiResponse(responseCode = "401", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/401"),
    @ApiResponse(responseCode = "403", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/403"),
    @ApiResponse(responseCode = "404", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/404"),
    @ApiResponse(responseCode = "409", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/409"),
    @ApiResponse(responseCode = "410", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/410"),
    @ApiResponse(responseCode = "415", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/415"),
    @ApiResponse(responseCode = "429", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/429"),
    @ApiResponse(responseCode = "500", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/500"),
    @ApiResponse(responseCode = "501", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/501"),
    @ApiResponse(responseCode = "503", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/503")
  })
  public Response deleteKlant(@Parameter(description = "Klant ID", example="1", required = true) @PathParam("id") Long id) {
    return Response.noContent().build();
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(summary = "Retourneert een Klant object op basis van zijn unieke identificatie", description = "Retourneert een individueel Klant object op basis van zijn unieke identificatie")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Klant was gevonden",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = Klant.class)),
      headers = {@Header(name = "api-version", ref = "https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/headers/api_version")}),
    @ApiResponse(responseCode = "400", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/400"),
    @ApiResponse(responseCode = "401", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/401"),
    @ApiResponse(responseCode = "403", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/403"),
    @ApiResponse(responseCode = "404", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/404"),
    @ApiResponse(responseCode = "409", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/409"),
    @ApiResponse(responseCode = "410", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/410"),
    @ApiResponse(responseCode = "415", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/415"),
    @ApiResponse(responseCode = "429", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/429"),
    @ApiResponse(responseCode = "500", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/500"),
    @ApiResponse(responseCode = "501", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/501"),
    @ApiResponse(responseCode = "503", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/503")
  })
  public Response getKlantById(@Parameter(description = "Klant ID", example="1", required = true) @PathParam("id") Long id) {
    return Response.ok().build();
  }

  @PUT
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(summary = "Maakt nieuw of overschrijft bestaand Klant object", description = "Maakt een nieuw of overschrijft (volledig) een bestaand Klant object")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Klant object succesvol aangemaakt/overschreven",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = Klant.class)),
      headers = {@Header(name = "api-version", ref = "https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/headers/api_version"),
        @Header(name = "Location", description = "URI van het opgeslagen object", schema = @Schema(type = "string", format = "uri"))}),
    @ApiResponse(responseCode = "400", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/400"),
    @ApiResponse(responseCode = "401", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/401"),
    @ApiResponse(responseCode = "403", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/403"),
    @ApiResponse(responseCode = "404", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/404"),
    @ApiResponse(responseCode = "409", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/409"),
    @ApiResponse(responseCode = "410", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/410"),
    @ApiResponse(responseCode = "415", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/415"),
    @ApiResponse(responseCode = "429", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/429"),
    @ApiResponse(responseCode = "500", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/500"),
    @ApiResponse(responseCode = "501", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/501"),
    @ApiResponse(responseCode = "503", ref="https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/responses/503")
  })
  public Response updateKlant(
    @Parameter(description = "Klant ID", example="1", required = true) @PathParam("id") Long id,
    @Parameter(description = "Complete Klant update data", required = true) Klant klant) {
    return Response.ok().build();
  }

}
