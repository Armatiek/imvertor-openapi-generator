package nl.imvertor.model.fietsenwinkel.contacten;

import nl.imvertor.mim.annotation.*;
import nl.imvertor.mim.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.*;
import java.util.*;

/**
 * <p>Een persoon of instelling waar mee wordt gecommuniceerd.</p>
 */
@Keuze(fieldNames = {"betalingBank", "betalingCredit"} , message = "Exactly one of betalingBank, betalingCredit must be non-zero")
@Schema(description = "Een persoon of instelling waar mee wordt gecommuniceerd.")
public abstract class Contact {

  @Schema(description = "URL-referentie naar de resource waarnaar verwezen wordt", type = "string", format = "uri", requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_ONLY, minLength = 1)
  private String url;

  /**
   * <p>De naam van het contact. </p>
   * Attribuutsoort
   */
  @Schema(description = "De naam van het contact.", requiredMode = RequiredMode.REQUIRED)
  private String naam;

  /**
   * <p>Het postadres van dit contact. </p>
   * Gegevensgroep -> Gegevensgroeptype
   */
  @Schema(description = "Het postadres van dit contact.", requiredMode = RequiredMode.REQUIRED)
  private nl.imvertor.model.fietsenwinkel.contacten.Adres postadres;

  /**
   * <p>Een contact doet een betaling met een betaalmiddel.</p>
   * Relatiesoort -> Objecttype
   */
  @Schema(description = "Een contact doet een betaling met een betaalmiddel.", requiredMode = RequiredMode.REQUIRED)
  private List<nl.imvertor.model.fietsenwinkel.contacten.Bankrekening> betalingBank;

  /**
   * <p>Een contact doet een betaling met een betaalmiddel.</p>
   * Relatiesoort -> Objecttype
   */
  @Schema(description = "Een contact doet een betaling met een betaalmiddel.", requiredMode = RequiredMode.REQUIRED)
  private List<nl.imvertor.model.fietsenwinkel.contacten.Creditcard> betalingCredit;

  public void setUrl(String url) {
    this.url = url;
  }

  public String getNaam() {
    return naam;
  }

  public void setNaam(String naam) {
    this.naam = naam;
  }

  public nl.imvertor.model.fietsenwinkel.contacten.Adres getPostadres() {
    return postadres;
  }

  public void setPostadres(nl.imvertor.model.fietsenwinkel.contacten.Adres postadres) {
    this.postadres = postadres;
  }

  public List<nl.imvertor.model.fietsenwinkel.contacten.Bankrekening> getBetalingBank() {
    return betalingBank;
  }

  public void setBetalingBank(List<nl.imvertor.model.fietsenwinkel.contacten.Bankrekening> betalingBank) {
    this.betalingBank = betalingBank;
  }

  public List<nl.imvertor.model.fietsenwinkel.contacten.Creditcard> getBetalingCredit() {
    return betalingCredit;
  }

  public void setBetalingCredit(List<nl.imvertor.model.fietsenwinkel.contacten.Creditcard> betalingCredit) {
    this.betalingCredit = betalingCredit;
  }

}
