package nl.imvertor.model.fietsenwinkel.contacten;

import nl.imvertor.mim.model.PaginatedBase;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.*;

@Schema(allOf = PaginatedBase.class)
public class PaginatedKVKLijstList {

  @Schema(requiredMode = RequiredMode.REQUIRED)
  private List<KVKLijst> results;

  public List<KVKLijst> getResults() {
    return this.results;
  }

  public void setResults(List<KVKLijst> results) {
    this.results = results;
  }

}
