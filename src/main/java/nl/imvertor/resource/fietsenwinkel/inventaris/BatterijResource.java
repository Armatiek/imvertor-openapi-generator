package nl.imvertor.resource.fietsenwinkel.inventaris;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.headers.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.constraints.Min;

import nl.imvertor.model.fietsenwinkel.inventaris.Batterij;
import nl.imvertor.model.fietsenwinkel.inventaris.PaginatedBatterijList;

@Path("/v1/batterij")
@Tag(name = "Batterij", description = "De batterij van de E-Bike.")
public class BatterijResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(summary = "Retourneert de lijst van alle Batterij objecten", description = "Retourneert een gepagineerde lijst van alle Batterij objecten")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "OK",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = PaginatedBatterijList.class)),
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
  public Response getAllBatterij(
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
  @Operation(summary = "Maakt een nieuw Batterij object", description = "Maakt een nieuw Batterij object aan op basis van de aangeleverde gegevens")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Batterij succesvol aangemaakt",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = Batterij.class)),
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
  public Response createBatterij(@Parameter(description = "De gegevens van het Batterij object", required = true) Batterij batterij) {
    return Response.ok().build();
  }

  @DELETE
  @Path("/{id}")
  @Operation(summary = "Verwijderd een Batterij object", description = "Verwijderd een specifiek Batterij object permanent uit het systeem")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "204", description = "Batterij object succesvol verwijderd",
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
  public Response deleteBatterij(@Parameter(description = "Batterij ID", example="1", required = true) @PathParam("id") Long id) {
    return Response.noContent().build();
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(summary = "Retourneert een Batterij object op basis van zijn unieke identificatie", description = "Retourneert een individueel Batterij object op basis van zijn unieke identificatie")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Batterij was gevonden",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = Batterij.class)),
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
  public Response getBatterijById(@Parameter(description = "Batterij ID", example="1", required = true) @PathParam("id") Long id) {
    return Response.ok().build();
  }

  @PUT
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(summary = "Maakt nieuw of overschrijft bestaand Batterij object", description = "Maakt een nieuw of overschrijft (volledig) een bestaand Batterij object")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Batterij object succesvol aangemaakt/overschreven",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = Batterij.class)),
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
  public Response updateBatterij(
    @Parameter(description = "Batterij ID", example="1", required = true) @PathParam("id") Long id,
    @Parameter(description = "Complete Batterij update data", required = true) Batterij batterij) {
    return Response.ok().build();
  }

  @PATCH
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(summary = "Werkt een bestaand Batterij object gedeeltelijk bij", description = "Werkt een bestaand Batterij object gedeeltelijk bij door alleen de aangeleverde velden te overschrijven")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Batterij succesvol bijgewerkt",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = Batterij.class)),
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
  public Response patchBatterij(
    @Parameter(description = "Batterij ID", example="1", required = true) @PathParam("id") Long id,
    @Parameter(description = "Complete Batterij update data", required = true) Batterij batterij) {
    return Response.ok().build();
  }

}
