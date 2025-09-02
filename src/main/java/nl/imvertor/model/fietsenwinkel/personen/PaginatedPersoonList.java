package nl.imvertor.model.fietsenwinkel.personen;

import nl.imvertor.mim.model.PaginatedBase;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.*;

@Schema(allOf = PaginatedBase.class)
public class PaginatedPersoonList {

  @Schema(requiredMode = RequiredMode.REQUIRED)
  private List<Persoon> results;

  public List<Persoon> getResults() {
    return this.results;
  }

  public void setResults(List<Persoon> results) {
    this.results = results;
  }

}
