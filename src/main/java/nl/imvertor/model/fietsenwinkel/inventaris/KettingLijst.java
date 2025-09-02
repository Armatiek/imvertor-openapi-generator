package nl.imvertor.model.fietsenwinkel.inventaris;

import nl.imvertor.mim.annotation.*;
import nl.imvertor.mim.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.*;
import java.util.*;

/**
 * <p>Lijst van ketting-typen voor fietsen met ketting aandrijving.</p>
 */
@Codelijst
@Schema(description = "Lijst van ketting-typen voor fietsen met ketting aandrijving.")
public class KettingLijst {

  @Schema(description = "Unieke identificatie van de resource waarnaar verwezen wordt", type = "string", requiredMode = RequiredMode.REQUIRED, minLength = 1)
  private String id;

  @Schema(description = "URL-referentie naar de resource waarnaar verwezen wordt", type = "string", format = "uri", requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_ONLY, minLength = 1)
  private String url;

  /**
   * <p>Lijst van ketting-typen voor fietsen met ketting aandrijving.</p>
   * Codelijst -> Waardeitem
   */
  @Schema(description = "Lijst van ketting-typen voor fietsen met ketting aandrijving.", requiredMode = RequiredMode.REQUIRED)
  private String value;

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

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

}
