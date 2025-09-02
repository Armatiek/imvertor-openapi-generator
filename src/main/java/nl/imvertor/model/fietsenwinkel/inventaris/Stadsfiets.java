package nl.imvertor.model.fietsenwinkel.inventaris;

import nl.imvertor.mim.annotation.*;
import nl.imvertor.mim.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.*;
import java.util.*;

/**
 * <p>Een fiets die is ingericht op gebruik in het stadsverkeer.</p>
 */
@Objecttype
@Schema(description = "Een fiets die is ingericht op gebruik in het stadsverkeer.")
public class Stadsfiets extends nl.imvertor.model.fietsenwinkel.inventaris.Fiets {

  @Schema(description = "URL-referentie naar de resource waarnaar verwezen wordt", type = "string", format = "uri", requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_ONLY, minLength = 1)
  private String url;

  public void setUrl(String url) {
    this.url = url;
  }

}
