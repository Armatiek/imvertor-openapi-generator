package nl.imvertor.model.fietsenwinkel.contacten;

import nl.imvertor.mim.annotation.*;
import nl.imvertor.mim.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.*;
import java.util.*;

/**
 * <p>Kaart waarmee op basis van kredieten een betaling wordt gedaan.</p>
 */
@Objecttype
@Schema(description = "Kaart waarmee op basis van kredieten een betaling wordt gedaan.")
public class Creditcard {

  @Schema(description = "URL-referentie naar de resource waarnaar verwezen wordt", type = "string", format = "uri", requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_ONLY, minLength = 1)
  private String url;

  /**
   * <p>Nummer van de kaart.</p>
   * Attribuutsoort
   */
  @Schema(description = "Nummer van de kaart.", requiredMode = RequiredMode.REQUIRED)
  private String kaartnummer;

  /**
   * <p>Verloopdatum van de kaart (jaar, maand)</p>
   * Attribuutsoort
   */
  @Schema(description = "Verloopdatum van de kaart (jaar, maand)", requiredMode = RequiredMode.REQUIRED)
  private String verloopdatum;

  public void setUrl(String url) {
    this.url = url;
  }

  public String getKaartnummer() {
    return kaartnummer;
  }

  public void setKaartnummer(String kaartnummer) {
    this.kaartnummer = kaartnummer;
  }

  public String getVerloopdatum() {
    return verloopdatum;
  }

  public void setVerloopdatum(String verloopdatum) {
    this.verloopdatum = verloopdatum;
  }

}
