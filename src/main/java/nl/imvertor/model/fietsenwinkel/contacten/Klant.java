package nl.imvertor.model.fietsenwinkel.contacten;

import nl.imvertor.mim.annotation.*;
import nl.imvertor.mim.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.*;

/**
 * <p>Een persoon die een fiets heeft gekocht.</p>
 */
@Objecttype
@Schema(description = "Een persoon die een fiets heeft gekocht.")
public class Klant extends nl.imvertor.model.fietsenwinkel.contacten.Contact {

  /**
   * <p>Indicatie dat de klant de nieuwsbrief wenst te ontvangen.</p>
   * Attribuutsoort
   */
  @Schema(description = "Indicatie dat de klant de nieuwsbrief wenst te ontvangen.", requiredMode = RequiredMode.REQUIRED)
  private Boolean nieuwsbrief;

  /**
   * ExterneKoppeling -> Objecttype
   */
  @Schema(requiredMode = RequiredMode.REQUIRED)
  private nl.imvertor.model.fietsenwinkel.personen.Persoon betreft;

  public Boolean isNieuwsbrief() {
    return nieuwsbrief;
  }

  public void setNieuwsbrief(Boolean nieuwsbrief) {
    this.nieuwsbrief = nieuwsbrief;
  }

  public nl.imvertor.model.fietsenwinkel.personen.Persoon getBetreft() {
    return betreft;
  }

  public void setBetreft(nl.imvertor.model.fietsenwinkel.personen.Persoon betreft) {
    this.betreft = betreft;
  }

}
