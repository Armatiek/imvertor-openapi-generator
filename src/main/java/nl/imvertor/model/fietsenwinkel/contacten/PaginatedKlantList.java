package nl.imvertor.model.fietsenwinkel.contacten;

import nl.imvertor.mim.annotation.*;
import nl.imvertor.mim.model.PaginatedBase;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.*;

@Schema(allOf = PaginatedBase.class)
public class PaginatedKlantList {

  @Schema(requiredMode = RequiredMode.REQUIRED)
  private List<Klant> results;

  public List<Klant> getResults() {
    return this.results;
  }

  public void setResults(List<Klant> results) {
    this.results = results;
  }

}
