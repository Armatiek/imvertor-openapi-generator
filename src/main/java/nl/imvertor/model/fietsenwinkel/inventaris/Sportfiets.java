package nl.imvertor.model.fietsenwinkel.inventaris;

import nl.imvertor.mim.annotation.*;
import nl.imvertor.mim.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.*;
import java.util.*;

/**
 * <p>Een fiets bedoeld voor gebruik in sportieve toepassingen.</p>
 */
@Objecttype
@Schema(description = "Een fiets bedoeld voor gebruik in sportieve toepassingen.")
public class Sportfiets extends nl.imvertor.model.fietsenwinkel.inventaris.Fiets {

  @Schema(description = "URL-referentie naar de resource waarnaar verwezen wordt", type = "string", format = "uri", requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_ONLY, minLength = 1)
  private String url;

  /**
   * <p>Het type van de sportfiets, een waarde uit een enumeratieve lijst.</p>
   * Attribuutsoort -> Enumeratie
   */
  @Schema(description = "Het type van de sportfiets, een waarde uit een enumeratieve lijst.", requiredMode = RequiredMode.REQUIRED)
  private nl.imvertor.model.fietsenwinkel.inventaris.SportfietsTypen type;

  public void setUrl(String url) {
    this.url = url;
  }

  public nl.imvertor.model.fietsenwinkel.inventaris.SportfietsTypen getType() {
    return type;
  }

  public void setType(nl.imvertor.model.fietsenwinkel.inventaris.SportfietsTypen type) {
    this.type = type;
  }

}
