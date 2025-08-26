package nl.imvertor.model.fietsenwinkel.contacten;

import nl.imvertor.mim.annotation.*;
import nl.imvertor.mim.model.PaginatedBase;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.*;

@Schema(allOf = PaginatedBase.class)
public class PaginatedAdresList {

  @Schema(requiredMode = RequiredMode.REQUIRED)
  private List<Adres> results;

  public List<Adres> getResults() {
    return this.results;
  }

  public void setResults(List<Adres> results) {
    this.results = results;
  }

}
