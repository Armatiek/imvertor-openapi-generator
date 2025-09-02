package nl.imvertor.model.fietsenwinkel.contacten;

import nl.imvertor.mim.model.PaginatedBase;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.*;

@Schema(allOf = PaginatedBase.class)
public class PaginatedContactList {

  @Schema(requiredMode = RequiredMode.REQUIRED)
  private List<Contact> results;

  public List<Contact> getResults() {
    return this.results;
  }

  public void setResults(List<Contact> results) {
    this.results = results;
  }

}
