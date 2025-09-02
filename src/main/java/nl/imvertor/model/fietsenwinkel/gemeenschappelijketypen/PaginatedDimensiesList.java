package nl.imvertor.model.fietsenwinkel.gemeenschappelijketypen;

import nl.imvertor.mim.model.PaginatedBase;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.*;

@Schema(allOf = PaginatedBase.class)
public class PaginatedDimensiesList {

  @Schema(requiredMode = RequiredMode.REQUIRED)
  private List<Dimensies> results;

  public List<Dimensies> getResults() {
    return this.results;
  }

  public void setResults(List<Dimensies> results) {
    this.results = results;
  }

}
