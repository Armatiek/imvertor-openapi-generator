package nl.imvertor.model.fietsenwinkel.inventaris;

import nl.imvertor.mim.annotation.*;
import nl.imvertor.mim.model.PaginatedBase;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.*;

@Schema(allOf = PaginatedBase.class)
public class PaginatedSnaarLijstList {

  @Schema(requiredMode = RequiredMode.REQUIRED)
  private List<SnaarLijst> results;

  public List<SnaarLijst> getResults() {
    return this.results;
  }

  public void setResults(List<SnaarLijst> results) {
    this.results = results;
  }

}
