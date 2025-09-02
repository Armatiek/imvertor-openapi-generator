package nl.imvertor.model.fietsenwinkel.contacten;

import nl.imvertor.mim.annotation.*;
import nl.imvertor.mim.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.*;
import java.util.*;

/**
 * <p>Rekening bij een bank.</p>
 */
@Objecttype
@Schema(description = "Rekening bij een bank.")
public class Bankrekening {

  @Schema(description = "URL-referentie naar de resource waarnaar verwezen wordt", type = "string", format = "uri", requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_ONLY, minLength = 1)
  private String url;

  /**
   * <p>Nummer van de rekening.</p>
   * Attribuutsoort
   */
  @Schema(description = "Nummer van de rekening.", requiredMode = RequiredMode.REQUIRED)
  private String rekeningnummer;

  public void setUrl(String url) {
    this.url = url;
  }

  public String getRekeningnummer() {
    return rekeningnummer;
  }

  public void setRekeningnummer(String rekeningnummer) {
    this.rekeningnummer = rekeningnummer;
  }

}
