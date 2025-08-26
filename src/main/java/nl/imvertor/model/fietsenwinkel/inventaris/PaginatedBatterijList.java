package nl.imvertor.model.fietsenwinkel.inventaris;

import nl.imvertor.mim.annotation.*;
import nl.imvertor.mim.model.PaginatedBase;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.*;

@Schema(allOf = PaginatedBase.class)
public class PaginatedBatterijList {

  @Schema(requiredMode = RequiredMode.REQUIRED)
  private List<Batterij> results;

  public List<Batterij> getResults() {
    return this.results;
  }

  public void setResults(List<Batterij> results) {
    this.results = results;
  }

}
