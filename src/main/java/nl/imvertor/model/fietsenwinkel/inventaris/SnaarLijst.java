package nl.imvertor.model.fietsenwinkel.inventaris;

import nl.imvertor.mim.annotation.*;
import nl.imvertor.mim.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.*;

/**
 * <p>Lijst van snaar-typen voor fietsen met snaaraandrijving.</p>
 */
@Codelijst
@Schema(description = "Lijst van snaar-typen voor fietsen met snaaraandrijving.")
public class SnaarLijst {

  /**
   * Field that is not part of the model but added to define an identifying field for this entity
   */
  @Schema(description = "Field that is not part of the model but added to define an identifying field for this entity", requiredMode = RequiredMode.REQUIRED)
  private Long id;

  /**
   * <p>Lijst van snaar-typen voor fietsen met snaaraandrijving.</p>
   * Codelijst -> Waardeitem
   */
  @Schema(description = "Lijst van snaar-typen voor fietsen met snaaraandrijving.", requiredMode = RequiredMode.REQUIRED)
  private String value;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

}
