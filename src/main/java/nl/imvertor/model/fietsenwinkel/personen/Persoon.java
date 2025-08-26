package nl.imvertor.model.fietsenwinkel.personen;

import nl.imvertor.mim.annotation.*;
import nl.imvertor.mim.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.*;

/**
 * <p>Een natuurlijk persoon.</p>
 */
@Objecttype
@Schema(description = "Een natuurlijk persoon.")
public class Persoon {

  /**
   * Field that is not part of the model but added to define an identifying field for this entity
   */
  @Schema(description = "Field that is not part of the model but added to define an identifying field for this entity", requiredMode = RequiredMode.REQUIRED)
  private Long id;

  /**
   * <p>De roepnaam van een <strong>Persoon</strong>, vol uitgeschreven.</p>
   * Attribuutsoort
   */
  @Schema(description = "De roepnaam van een Persoon , vol uitgeschreven.", requiredMode = RequiredMode.NOT_REQUIRED)
  private String voornaam;

  /**
   * <p>De achternaam van de <strong>Persoon</strong>.</p>
   * Attribuutsoort
   */
  @Schema(description = "De achternaam van de Persoon .", requiredMode = RequiredMode.REQUIRED)
  private String achternaam;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getVoornaam() {
    return voornaam;
  }

  public void setVoornaam(String voornaam) {
    this.voornaam = voornaam;
  }

  public String getAchternaam() {
    return achternaam;
  }

  public void setAchternaam(String achternaam) {
    this.achternaam = achternaam;
  }

}
