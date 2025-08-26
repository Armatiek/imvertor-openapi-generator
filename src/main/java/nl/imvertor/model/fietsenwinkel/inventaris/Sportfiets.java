package nl.imvertor.model.fietsenwinkel.inventaris;

import nl.imvertor.mim.annotation.*;
import nl.imvertor.mim.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.*;

/**
 * <p>Een fiets bedoeld voor gebruik in sportieve toepassingen.</p>
 */
@Objecttype
@Schema(description = "Een fiets bedoeld voor gebruik in sportieve toepassingen.")
public class Sportfiets extends nl.imvertor.model.fietsenwinkel.inventaris.Fiets {

  /**
   * <p>Het type van de sportfiets, een waarde uit een enumeratieve lijst.</p>
   * Attribuutsoort -> Enumeratie
   */
  @Schema(description = "Het type van de sportfiets, een waarde uit een enumeratieve lijst.", requiredMode = RequiredMode.REQUIRED)
  private nl.imvertor.mim.model.Reference type;

  public nl.imvertor.mim.model.Reference getType() {
    return type;
  }

  public void setType(nl.imvertor.mim.model.Reference type) {
    this.type = type;
  }

}
