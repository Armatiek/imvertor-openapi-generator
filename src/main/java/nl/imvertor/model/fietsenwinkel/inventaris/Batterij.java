package nl.imvertor.model.fietsenwinkel.inventaris;

import nl.imvertor.mim.annotation.*;
import nl.imvertor.mim.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.*;
import java.util.*;

/**
 * <p>De batterij van de E-Bike.</p>
 */
@Objecttype
@Schema(description = "De batterij van de E-Bike.")
public class Batterij {

  @Schema(description = "Unieke identificatie van de resource waarnaar verwezen wordt", type = "string", requiredMode = RequiredMode.REQUIRED, minLength = 1)
  private String id;

  @Schema(description = "URL-referentie naar de resource waarnaar verwezen wordt", type = "string", format = "uri", requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_ONLY, minLength = 1)
  private String url;

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
  private nl.imvertor.model.fietsenwinkel.gemeenschappelijketypen.Dimensies omvang;

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

  public String getGarantienummer() {
    return garantienummer;
  }

  public void setGarantienummer(String garantienummer) {
    this.garantienummer = garantienummer;
  }

  public nl.imvertor.model.fietsenwinkel.gemeenschappelijketypen.Dimensies getOmvang() {
    return omvang;
  }

  public void setOmvang(nl.imvertor.model.fietsenwinkel.gemeenschappelijketypen.Dimensies omvang) {
    this.omvang = omvang;
  }

}
