package nl.imvertor.model.fietsenwinkel.inventaris;

import nl.imvertor.mim.model.PaginatedBase;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.*;

@Schema(allOf = PaginatedBase.class)
public class PaginatedFietsList {

  @Schema(requiredMode = RequiredMode.REQUIRED)
  private List<Fiets> results;

  public List<Fiets> getResults() {
    return this.results;
  }

  public void setResults(List<Fiets> results) {
    this.results = results;
  }

}
