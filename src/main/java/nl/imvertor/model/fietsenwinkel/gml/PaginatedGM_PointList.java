package nl.imvertor.model.fietsenwinkel.gml;

import nl.imvertor.mim.annotation.*;
import nl.imvertor.mim.model.PaginatedBase;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.*;

@Schema(allOf = PaginatedBase.class)
public class PaginatedGM_PointList {

  @Schema(requiredMode = RequiredMode.REQUIRED)
  private List<GM_Point> results;

  public List<GM_Point> getResults() {
    return this.results;
  }

  public void setResults(List<GM_Point> results) {
    this.results = results;
  }

}
