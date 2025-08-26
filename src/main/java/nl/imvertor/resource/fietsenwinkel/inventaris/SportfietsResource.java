package nl.imvertor.resource.fietsenwinkel.inventaris;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.constraints.Min;

import nl.imvertor.model.fietsenwinkel.inventaris.Sportfiets;
import nl.imvertor.model.fietsenwinkel.inventaris.PaginatedSportfietsList;

@Path("/sportfiets")
@Tag(name = "Sportfiets", description = "Een fiets bedoeld voor gebruik in sportieve toepassingen.")
public class SportfietsResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(summary = "Get all Sportfiets objects", description = "Retrieves a paginated list of all Sportfiets objects")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "OK",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = PaginatedSportfietsList.class))),
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
    @Parameter(description = "Page number (0-based)", example = "0")
    @Min(0) int page,

    @QueryParam("size")
    @DefaultValue("20")
    @Parameter(description = "Number of items per page", example = "20")
    @Min(1) int size,

    @QueryParam("sort")
    @DefaultValue("id")
    @Parameter(description = "Field to sort by", example = "name")
    String sortBy) {
    return Response.ok().build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(summary = "Create a new Sportfiets", description = "Creates a new Sportfiets with the provided information")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Sportfiets created successfully",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = Sportfiets.class))),
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
  public Response createSportfiets(@Parameter(description = "Sportfiets creation data", required = true) Sportfiets sportfiets) {
    return Response.ok().build();
  }

  @DELETE
  @Path("/{id}")
  @Operation(summary = "Delete Sportfiets", description = "Permanently deletes a Sportfiets from the system")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "204", description = "Sportfiets deleted successfully"),
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
  @Operation(summary = "Get Sportfiets by id", description = "Retrieves a specific Sportfiets by their unique identifier")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Sportfiets was found",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = Sportfiets.class))),
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
  @Operation(summary = "Update Sportfiets", description = "Completely updates a Sportfiets with new information (replaces all fields)")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Sportfiets updated successfully",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = Sportfiets.class))),
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
  @Operation(summary = "Partially update Sportfiets", description = "Partially updates a Sportfiets by modifying only the provided fields")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Sportfiets updated successfully",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = Sportfiets.class))),
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
