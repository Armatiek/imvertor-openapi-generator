package nl.imvertor.model.fietsenwinkel.gml;

import nl.imvertor.mim.annotation.*;
import nl.imvertor.mim.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.*;

@Constructie
public class GM_Polygon {

  /**
   * Field that is not part of the model but added to define an identifying field for this entity
   */
  @Schema(description = "Field that is not part of the model but added to define an identifying field for this entity", requiredMode = RequiredMode.REQUIRED)
  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}
