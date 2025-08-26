package nl.imvertor.model.fietsenwinkel.contacten;

import nl.imvertor.mim.annotation.*;
import nl.imvertor.mim.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.*;

/**
 * <p>Rekening bij een bank.</p>
 */
@Objecttype
@Schema(description = "Rekening bij een bank.")
public class Bankrekening {

  /**
   * <p>Nummer van de rekening.</p>
   * Attribuutsoort
   */
  @Schema(description = "Nummer van de rekening.", requiredMode = RequiredMode.REQUIRED)
  private String rekeningnummer;

  public String getRekeningnummer() {
    return rekeningnummer;
  }

  public void setRekeningnummer(String rekeningnummer) {
    this.rekeningnummer = rekeningnummer;
  }

}
