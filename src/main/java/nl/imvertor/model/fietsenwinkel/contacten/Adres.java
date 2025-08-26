package nl.imvertor.model.fietsenwinkel.contacten;

import nl.imvertor.mim.annotation.*;
import nl.imvertor.mim.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.*;

/**
 * <p>Het adres van een contact.</p>
 */
@Keuze(fieldNames = {"punt", "vlak"} , message = "Exactly one of punt, vlak must be non-zero")
@Schema(description = "Het adres van een contact.")
public class Adres {

  /**
   * Field that is not part of the model but added to define an identifying field for this entity
   */
  @Schema(description = "Field that is not part of the model but added to define an identifying field for this entity", requiredMode = RequiredMode.REQUIRED)
  private Long id;

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
  private nl.imvertor.mim.model.Reference punt;

  /**
   * <p>De geografische plek waar het adres is geregistreerd.</p>
   * Attribuutsoort -> Constructie
   */
  @Schema(description = "De geografische plek waar het adres is geregistreerd.", requiredMode = RequiredMode.NOT_REQUIRED)
  private nl.imvertor.mim.model.Reference vlak;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public nl.imvertor.mim.model.Reference getPunt() {
    return punt;
  }

  public void setPunt(nl.imvertor.mim.model.Reference punt) {
    this.punt = punt;
  }

  public nl.imvertor.mim.model.Reference getVlak() {
    return vlak;
  }

  public void setVlak(nl.imvertor.mim.model.Reference vlak) {
    this.vlak = vlak;
  }

}
