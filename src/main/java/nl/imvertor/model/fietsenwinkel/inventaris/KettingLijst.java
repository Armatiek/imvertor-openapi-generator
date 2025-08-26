package nl.imvertor.model.fietsenwinkel.inventaris;

import nl.imvertor.mim.annotation.*;
import nl.imvertor.mim.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.*;

/**
 * <p>Lijst van ketting-typen voor fietsen met ketting aandrijving.</p>
 */
@Codelijst
@Schema(description = "Lijst van ketting-typen voor fietsen met ketting aandrijving.")
public class KettingLijst {

  /**
   * Field that is not part of the model but added to define an identifying field for this entity
   */
  @Schema(description = "Field that is not part of the model but added to define an identifying field for this entity", requiredMode = RequiredMode.REQUIRED)
  private Long id;

  /**
   * <p>Lijst van ketting-typen voor fietsen met ketting aandrijving.</p>
   * Codelijst -> Waardeitem
   */
  @Schema(description = "Lijst van ketting-typen voor fietsen met ketting aandrijving.", requiredMode = RequiredMode.REQUIRED)
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
