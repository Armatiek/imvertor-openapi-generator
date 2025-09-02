package nl.imvertor.model.fietsenwinkel.personen;

import nl.imvertor.mim.annotation.*;
import nl.imvertor.mim.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.*;
import java.util.*;

/**
 * <p>Een natuurlijk persoon.</p>
 */
@Objecttype
@Schema(description = "Een natuurlijk persoon.")
public class Persoon {

  @Schema(description = "Unieke identificatie van de resource waarnaar verwezen wordt", type = "string", requiredMode = RequiredMode.REQUIRED, minLength = 1)
  private String id;

  @Schema(description = "URL-referentie naar de resource waarnaar verwezen wordt", type = "string", format = "uri", requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_ONLY, minLength = 1)
  private String url;

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

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
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
