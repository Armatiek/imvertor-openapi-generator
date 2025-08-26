package nl.imvertor.model.fietsenwinkel.inventaris;

import nl.imvertor.mim.annotation.*;
import nl.imvertor.mim.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.*;

/**
 * <p>De batterij van de E-Bike.</p>
 */
@Objecttype
@Schema(description = "De batterij van de E-Bike.")
public class Batterij {

  /**
   * Field that is not part of the model but added to define an identifying field for this entity
   */
  @Schema(description = "Field that is not part of the model but added to define an identifying field for this entity", requiredMode = RequiredMode.REQUIRED)
  private Long id;

  /**
   * <p>Garantienummer op de <strong>Batterij</strong> (wanneer e-bike).</p>
   * Attribuutsoort
   */
  @Schema(description = "Garantienummer op de Batterij (wanneer e-bike).", requiredMode = RequiredMode.REQUIRED)
  private String garantienummer;

  /**
   * <p>De omvang van de batterij.</p>
   * Attribuutsoort -> GestructureerdDatatype
   */
  @Schema(description = "De omvang van de batterij.", requiredMode = RequiredMode.REQUIRED)
  private nl.imvertor.mim.model.Reference omvang;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getGarantienummer() {
    return garantienummer;
  }

  public void setGarantienummer(String garantienummer) {
    this.garantienummer = garantienummer;
  }

  public nl.imvertor.mim.model.Reference getOmvang() {
    return omvang;
  }

  public void setOmvang(nl.imvertor.mim.model.Reference omvang) {
    this.omvang = omvang;
  }

}
