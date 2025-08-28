package nl.imvertor.resource.fietsenwinkel.inventaris;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.headers.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.constraints.Min;

import nl.imvertor.model.fietsenwinkel.inventaris.Sportfiets;
import nl.imvertor.model.fietsenwinkel.inventaris.PaginatedSportfietsList;

@Path("/v1/sportfiets")
@Tag(name = "Sportfiets", description = "Een fiets bedoeld voor gebruik in sportieve toepassingen.")
public class SportfietsResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(summary = "Retourneert de lijst van alle Sportfiets objecten", description = "Retourneert een gepagineerde lijst van alle Sportfiets objecten")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "OK",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = PaginatedSportfietsList.class)),
      headers = {@Header(name = "api-version", ref = "https://raw.githubusercontent.com/VNG-Realisatie/API-Kennisbank/master/common/common.yaml#/components/headers/api_version")}),
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
  public Response getAllSportfiets(
    @QueryParam("page")
    @DefaultValue("0")
    @Parameter(description = "Pagina nummer (beginnend bij 0)", example = "0")
    @Min(0) int page,

    @QueryParam("size")
    @DefaultValue("20")
    @Parameter(description = "Aantal objecten per pagina", example = "20")
    @Min(1) int size,

    @QueryParam("sort")
    @DefaultValue("id")
    @Parameter(description = "Sorteer veld", example = "name")
    String sortBy) {
    return Response.ok().build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(summary = "Maakt een nieuw Sportfiets object", description = "Maakt een nieuw Sportfiets object aan op basis van de aangeleverde gegevens")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Sportfiets succesvol aangemaakt",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = Sportfiets.class)),
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
  public Response createSportfiets(@Parameter(description = "De gegevens van het Sportfiets object", required = true) Sportfiets sportfiets) {
    return Response.ok().build();
  }

  @DELETE
  @Path("/{id}")
  @Operation(summary = "Verwijderd een Sportfiets object", description = "Verwijderd een specifiek Sportfiets object permanent uit het systeem")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "204", description = "Sportfiets object succesvol verwijderd",
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
  public Response deleteSportfiets(@Parameter(description = "Sportfiets ID", example="1", required = true) @PathParam("id") Long id) {
    return Response.noContent().build();
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(summary = "Retourneert een Sportfiets object op basis van zijn unieke identificatie", description = "Retourneert een individueel Sportfiets object op basis van zijn unieke identificatie")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Sportfiets was gevonden",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = Sportfiets.class)),
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
  public Response getSportfietsById(@Parameter(description = "Sportfiets ID", example="1", required = true) @PathParam("id") Long id) {
    return Response.ok().build();
  }

  @PUT
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(summary = "Maakt nieuw of overschrijft bestaand Sportfiets object", description = "Maakt een nieuw of overschrijft (volledig) een bestaand Sportfiets object")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Sportfiets object succesvol aangemaakt/overschreven",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = Sportfiets.class)),
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
  public Response updateSportfiets(
    @Parameter(description = "Sportfiets ID", example="1", required = true) @PathParam("id") Long id,
    @Parameter(description = "Complete Sportfiets update data", required = true) Sportfiets sportfiets) {
    return Response.ok().build();
  }

  @PATCH
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(summary = "Werkt een bestaand Sportfiets object gedeeltelijk bij", description = "Werkt een bestaand Sportfiets object gedeeltelijk bij door alleen de aangeleverde velden te overschrijven")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Sportfiets succesvol bijgewerkt",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = Sportfiets.class)),
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
  public Response patchSportfiets(
    @Parameter(description = "Sportfiets ID", example="1", required = true) @PathParam("id") Long id,
    @Parameter(description = "Complete Sportfiets update data", required = true) Sportfiets sportfiets) {
    return Response.ok().build();
  }

}
