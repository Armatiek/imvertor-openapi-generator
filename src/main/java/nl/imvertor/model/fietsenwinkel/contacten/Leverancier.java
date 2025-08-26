package nl.imvertor.model.fietsenwinkel.contacten;

import nl.imvertor.mim.annotation.*;
import nl.imvertor.mim.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.*;

/**
 * <p>Een instelling die een fietsen levert.</p>
 */
@Objecttype
@Schema(description = "Een instelling die een fietsen levert.")
public class Leverancier extends nl.imvertor.model.fietsenwinkel.contacten.Contact {

  /**
   * <p>Het nummer uit de KVK lijst.</p>
   * Attribuutsoort -> Referentielijst
   */
  @Schema(description = "Het nummer uit de KVK lijst.", requiredMode = RequiredMode.REQUIRED)
  private nl.imvertor.mim.model.Reference kvkNummer;

  public nl.imvertor.mim.model.Reference getKvkNummer() {
    return kvkNummer;
  }

  public void setKvkNummer(nl.imvertor.mim.model.Reference kvkNummer) {
    this.kvkNummer = kvkNummer;
  }

}
