package nl.imvertor.model.fietsenwinkel.inventaris;

import nl.imvertor.mim.model.PaginatedBase;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.*;

@Schema(allOf = PaginatedBase.class)
public class PaginatedStadsfietsList {

  @Schema(requiredMode = RequiredMode.REQUIRED)
  private List<Stadsfiets> results;

  public List<Stadsfiets> getResults() {
    return this.results;
  }

  public void setResults(List<Stadsfiets> results) {
    this.results = results;
  }

}
