package nl.imvertor.model.fietsenwinkel.contacten;

import nl.imvertor.mim.annotation.*;
import nl.imvertor.mim.model.PaginatedBase;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.*;

@Schema(allOf = PaginatedBase.class)
public class PaginatedBankrekeningList {

  @Schema(requiredMode = RequiredMode.REQUIRED)
  private List<Bankrekening> results;

  public List<Bankrekening> getResults() {
    return this.results;
  }

  public void setResults(List<Bankrekening> results) {
    this.results = results;
  }

}
