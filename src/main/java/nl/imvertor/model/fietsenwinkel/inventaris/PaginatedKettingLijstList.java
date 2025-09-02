package nl.imvertor.model.fietsenwinkel.inventaris;

import nl.imvertor.mim.model.PaginatedBase;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.*;

@Schema(allOf = PaginatedBase.class)
public class PaginatedKettingLijstList {

  @Schema(requiredMode = RequiredMode.REQUIRED)
  private List<KettingLijst> results;

  public List<KettingLijst> getResults() {
    return this.results;
  }

  public void setResults(List<KettingLijst> results) {
    this.results = results;
  }

}
