package nl.imvertor.model.fietsenwinkel.contacten;

import nl.imvertor.mim.annotation.*;
import nl.imvertor.mim.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.*;
import java.util.*;

/**
 * <p>Een instelling die een fietsen levert.</p>
 */
@Objecttype
@Schema(description = "Een instelling die een fietsen levert.")
public class Leverancier extends nl.imvertor.model.fietsenwinkel.contacten.Contact {

  @Schema(description = "URL-referentie naar de resource waarnaar verwezen wordt", type = "string", format = "uri", requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_ONLY, minLength = 1)
  private String url;

  /**
   * <p>Het nummer uit de KVK lijst.</p>
   * Attribuutsoort -> Referentielijst
   */
  @Schema(description = "Het nummer uit de KVK lijst.", requiredMode = RequiredMode.REQUIRED)
  private nl.imvertor.model.fietsenwinkel.contacten.KVKLijst kvkNummer;

  public void setUrl(String url) {
    this.url = url;
  }

  public nl.imvertor.model.fietsenwinkel.contacten.KVKLijst getKvkNummer() {
    return kvkNummer;
  }

  public void setKvkNummer(nl.imvertor.model.fietsenwinkel.contacten.KVKLijst kvkNummer) {
    this.kvkNummer = kvkNummer;
  }

}
