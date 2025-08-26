package nl.imvertor.model.fietsenwinkel.inventaris;

import nl.imvertor.mim.annotation.*;
import nl.imvertor.mim.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.*;

/**
 * <p>Een tweewieler.</p>
 */
@Keuze(fieldNames = {"kettingaandrijving", "snaaraandrijving"} , message = "Exactly one of kettingaandrijving, snaaraandrijving must be non-zero")
@Schema(description = "Een tweewieler.")
public abstract class Fiets {

  /**
   * <p>De identificatie van de fiets. </p>
   * Attribuutsoort
   */
  @Schema(description = "De identificatie van de fiets.", requiredMode = RequiredMode.REQUIRED)
  private String id;

  /**
   * <p>Datum waarop de fiets is geleverd aan de winkel.</p>
   * Attribuutsoort
   */
  @Schema(description = "Datum waarop de fiets is geleverd aan de winkel.", requiredMode = RequiredMode.REQUIRED)
  private java.time.LocalDate leveringsdatum;

  /**
   * <p>De omvang van de fiets in dimensies vanaf voor tot achterband (opgepompt), uitersten van trappers of bak of bagagedrager, en hoogste punt vanaf de weg (stuur, zadel).</p>
   * Attribuutsoort -> GestructureerdDatatype
   */
  @Schema(description = "De omvang van de fiets in dimensies vanaf voor tot achterband (opgepompt), uitersten van trappers of bak of bagagedrager, en hoogste punt vanaf de weg (stuur, zadel).", requiredMode = RequiredMode.REQUIRED)
  private nl.imvertor.mim.model.Reference omvang;

  /**
   * <p>Het type nummer van de fiets.</p>
   * Attribuutsoort
   */
  @Schema(description = "Het type nummer van de fiets.", requiredMode = RequiredMode.REQUIRED)
  private String typenummer;

  /**
   * <p>De verkoopprijs van de fiets, met twee decimalen, in Euro.</p>
   * Attribuutsoort
   */
  @Schema(description = "De verkoopprijs van de fiets, met twee decimalen, in Euro.", requiredMode = RequiredMode.REQUIRED)
  private java.math.BigDecimal verkoopprijs;

  /**
   * <p>Het aantal versnellingen van de fiets. </p>
   * Attribuutsoort
   */
  @Schema(description = "Het aantal versnellingen van de fiets.", requiredMode = RequiredMode.NOT_REQUIRED)
  private Integer versnellingen;

  /**
   * <p>Het volgummer van de fiets in één levering.</p>
   * Attribuutsoort
   */
  @Schema(description = "Het volgummer van de fiets in één levering.", requiredMode = RequiredMode.REQUIRED)
  private Integer volgnummer;

  /**
   * <p>De code van het type kettingaandrijving.</p>
   * Attribuutsoort -> Codelijst
   */
  @Schema(description = "De code van het type kettingaandrijving.", requiredMode = RequiredMode.REQUIRED)
  private nl.imvertor.mim.model.Reference kettingaandrijving;

  /**
   * <p>De code van het type snaaraandrijving.</p>
   * Attribuutsoort -> Codelijst
   */
  @Schema(description = "De code van het type snaaraandrijving.", requiredMode = RequiredMode.REQUIRED)
  private nl.imvertor.mim.model.Reference snaaraandrijving;

  /**
   * <p>Een fiets kan zijn aangestuurd door een motor. Wanneer electrische fiets, dan spreken we over "aansturing door Batterij".</p>
   * Relatiesoort -> Objecttype
   */
  @Schema(description = "Een fiets kan zijn aangestuurd door een motor. Wanneer electrische fiets, dan spreken we over \"aansturing door Batterij\".", requiredMode = RequiredMode.NOT_REQUIRED)
  private nl.imvertor.model.fietsenwinkel.inventaris.Batterij aangestuurdDoor;

  /**
   * <p>De Fiets is geleverd door een Leverancier. </p>
   * Relatiesoort -> Objecttype
   */
  @Schema(description = "De Fiets is geleverd door een Leverancier.", requiredMode = RequiredMode.REQUIRED)
  private nl.imvertor.model.fietsenwinkel.contacten.Leverancier geleverdDoor;

  /**
   * <p>Overdracht van geld heeft plaatsgevonden waarmee een relatie is opgebouwd met de <strong>Klant</strong>, w.o. garantieverplichtingen.</p>
   * Relatiesoort -> Objecttype
   */
  @Schema(description = "Overdracht van geld heeft plaatsgevonden waarmee een relatie is opgebouwd met de Klant , w.o. garantieverplichtingen.", requiredMode = RequiredMode.NOT_REQUIRED)
  private nl.imvertor.model.fietsenwinkel.contacten.Klant verkochtAan;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public java.time.LocalDate getLeveringsdatum() {
    return leveringsdatum;
  }

  public void setLeveringsdatum(java.time.LocalDate leveringsdatum) {
    this.leveringsdatum = leveringsdatum;
  }

  public nl.imvertor.mim.model.Reference getOmvang() {
    return omvang;
  }

  public void setOmvang(nl.imvertor.mim.model.Reference omvang) {
    this.omvang = omvang;
  }

  public String getTypenummer() {
    return typenummer;
  }

  public void setTypenummer(String typenummer) {
    this.typenummer = typenummer;
  }

  public java.math.BigDecimal getVerkoopprijs() {
    return verkoopprijs;
  }

  public void setVerkoopprijs(java.math.BigDecimal verkoopprijs) {
    this.verkoopprijs = verkoopprijs;
  }

  public Integer getVersnellingen() {
    return versnellingen;
  }

  public void setVersnellingen(Integer versnellingen) {
    this.versnellingen = versnellingen;
  }

  public Integer getVolgnummer() {
    return volgnummer;
  }

  public void setVolgnummer(Integer volgnummer) {
    this.volgnummer = volgnummer;
  }

  public nl.imvertor.mim.model.Reference getKettingaandrijving() {
    return kettingaandrijving;
  }

  public void setKettingaandrijving(nl.imvertor.mim.model.Reference kettingaandrijving) {
    this.kettingaandrijving = kettingaandrijving;
  }

  public nl.imvertor.mim.model.Reference getSnaaraandrijving() {
    return snaaraandrijving;
  }

  public void setSnaaraandrijving(nl.imvertor.mim.model.Reference snaaraandrijving) {
    this.snaaraandrijving = snaaraandrijving;
  }

  public nl.imvertor.model.fietsenwinkel.inventaris.Batterij getAangestuurdDoor() {
    return aangestuurdDoor;
  }

  public void setAangestuurdDoor(nl.imvertor.model.fietsenwinkel.inventaris.Batterij aangestuurdDoor) {
    this.aangestuurdDoor = aangestuurdDoor;
  }

  public nl.imvertor.model.fietsenwinkel.contacten.Leverancier getGeleverdDoor() {
    return geleverdDoor;
  }

  public void setGeleverdDoor(nl.imvertor.model.fietsenwinkel.contacten.Leverancier geleverdDoor) {
    this.geleverdDoor = geleverdDoor;
  }

  public nl.imvertor.model.fietsenwinkel.contacten.Klant getVerkochtAan() {
    return verkochtAan;
  }

  public void setVerkochtAan(nl.imvertor.model.fietsenwinkel.contacten.Klant verkochtAan) {
    this.verkochtAan = verkochtAan;
  }

}
