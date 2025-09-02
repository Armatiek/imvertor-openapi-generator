package nl.imvertor.model.fietsenwinkel.contacten;

import nl.imvertor.mim.annotation.*;
import nl.imvertor.mim.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.*;
import java.util.*;

/**
 * <p>Het adres van een contact.</p>
 */
@Keuze(fieldNames = {"punt", "vlak"} , message = "Exactly one of punt, vlak must be non-zero")
@Schema(description = "Het adres van een contact.")
public class Adres {

  @Schema(description = "Unieke identificatie van de resource waarnaar verwezen wordt", type = "string", requiredMode = RequiredMode.REQUIRED, minLength = 1)
  private String id;

  @Schema(description = "URL-referentie naar de resource waarnaar verwezen wordt", type = "string", format = "uri", requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_ONLY, minLength = 1)
  private String url;

  /**
   * <p>Postcode in een adres.</p>
   * Attribuutsoort
   */
  @Schema(description = "Postcode in een adres.", requiredMode = RequiredMode.REQUIRED)
  private String postcode;

  /**
   * <p>Huisnummer met eventuele toevoegingen.</p>
   * Attribuutsoort
   */
  @Schema(description = "Huisnummer met eventuele toevoegingen.", requiredMode = RequiredMode.REQUIRED)
  private String huisnummer;

  /**
   * <p>De geografische plek waar het adres is geregistreerd.</p>
   * Attribuutsoort -> Constructie
   */
  @Schema(description = "De geografische plek waar het adres is geregistreerd.", requiredMode = RequiredMode.NOT_REQUIRED)
  private nl.imvertor.model.fietsenwinkel.gml.GM_Point punt;

  /**
   * <p>De geografische plek waar het adres is geregistreerd.</p>
   * Attribuutsoort -> Constructie
   */
  @Schema(description = "De geografische plek waar het adres is geregistreerd.", requiredMode = RequiredMode.NOT_REQUIRED)
  private nl.imvertor.model.fietsenwinkel.gml.GM_Polygon vlak;

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

  public String getPostcode() {
    return postcode;
  }

  public void setPostcode(String postcode) {
    this.postcode = postcode;
  }

  public String getHuisnummer() {
    return huisnummer;
  }

  public void setHuisnummer(String huisnummer) {
    this.huisnummer = huisnummer;
  }

  public nl.imvertor.model.fietsenwinkel.gml.GM_Point getPunt() {
    return punt;
  }

  public void setPunt(nl.imvertor.model.fietsenwinkel.gml.GM_Point punt) {
    this.punt = punt;
  }

  public nl.imvertor.model.fietsenwinkel.gml.GM_Polygon getVlak() {
    return vlak;
  }

  public void setVlak(nl.imvertor.model.fietsenwinkel.gml.GM_Polygon vlak) {
    this.vlak = vlak;
  }

}
