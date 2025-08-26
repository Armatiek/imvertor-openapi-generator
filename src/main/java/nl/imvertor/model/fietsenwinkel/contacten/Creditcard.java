package nl.imvertor.model.fietsenwinkel.contacten;

import nl.imvertor.mim.annotation.*;
import nl.imvertor.mim.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.*;

/**
 * <p>Kaart waarmee op basis van kredieten een betaling wordt gedaan.</p>
 */
@Objecttype
@Schema(description = "Kaart waarmee op basis van kredieten een betaling wordt gedaan.")
public class Creditcard {

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
