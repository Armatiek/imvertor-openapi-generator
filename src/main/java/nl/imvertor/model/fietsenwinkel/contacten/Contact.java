package nl.imvertor.model.fietsenwinkel.contacten;

import nl.imvertor.mim.annotation.*;
import nl.imvertor.mim.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.*;

/**
 * <p>Een persoon of instelling waar mee wordt gecommuniceerd.</p>
 */
@Keuze(fieldNames = {"betalingBankBankrekening", "betalingCreditCreditcard"} , message = "Exactly one of betalingBankBankrekening, betalingCreditCreditcard must be non-zero")
@Schema(description = "Een persoon of instelling waar mee wordt gecommuniceerd.")
public abstract class Contact {

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
  private List<nl.imvertor.model.fietsenwinkel.contacten.Bankrekening> betalingBankBankrekening;

  /**
   * <p>Een contact doet een betaling met een betaalmiddel.</p>
   * Relatiesoort -> Objecttype
   */
  @Schema(description = "Een contact doet een betaling met een betaalmiddel.", requiredMode = RequiredMode.REQUIRED)
  private List<nl.imvertor.model.fietsenwinkel.contacten.Creditcard> betalingCreditCreditcard;

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

  public List<nl.imvertor.model.fietsenwinkel.contacten.Bankrekening> getBetalingBankBankrekening() {
    return betalingBankBankrekening;
  }

  public void setBetalingBankBankrekening(List<nl.imvertor.model.fietsenwinkel.contacten.Bankrekening> betalingBankBankrekening) {
    this.betalingBankBankrekening = betalingBankBankrekening;
  }

  public List<nl.imvertor.model.fietsenwinkel.contacten.Creditcard> getBetalingCreditCreditcard() {
    return betalingCreditCreditcard;
  }

  public void setBetalingCreditCreditcard(List<nl.imvertor.model.fietsenwinkel.contacten.Creditcard> betalingCreditCreditcard) {
    this.betalingCreditCreditcard = betalingCreditCreditcard;
  }

}
