package nl.imvertor.model.fietsenwinkel.inventaris;

import nl.imvertor.mim.annotation.*;
import nl.imvertor.mim.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.*;
import java.util.*;

/**
 * <p>Een locatie waar fietsen worden verkocht. </p>
 */
@Keuze(fieldNames = {"punt", "vlak"} , message = "Exactly one of punt, vlak must be non-zero")
@Schema(description = "Een locatie waar fietsen worden verkocht.")
public class Winkel {

  @Schema(description = "URL-referentie naar de resource waarnaar verwezen wordt", type = "string", format = "uri", requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_ONLY, minLength = 1)
  private String url;

  /**
   * <p>Naam van de winkel. </p>
   * Attribuutsoort
   */
  @Schema(description = "Naam van de winkel.", requiredMode = RequiredMode.REQUIRED)
  private String naam;

  /**
   * <p>De (geografische) locatie van de winkel.</p>
   * Attribuutsoort -> Constructie
   */
  @Schema(description = "De (geografische) locatie van de winkel.", requiredMode = RequiredMode.REQUIRED)
  private nl.imvertor.model.fietsenwinkel.gml.GM_Point punt;

  /**
   * <p>De (geografische) locatie van de winkel.</p>
   * Attribuutsoort -> Constructie
   */
  @Schema(description = "De (geografische) locatie van de winkel.", requiredMode = RequiredMode.REQUIRED)
  private nl.imvertor.model.fietsenwinkel.gml.GM_Polygon vlak;

  /**
   * <p>De handelswaar van een fietsenwinkel.</p>
   * Relatiesoort -> Objecttype
   */
  @Schema(description = "De handelswaar van een fietsenwinkel.", requiredMode = RequiredMode.NOT_REQUIRED)
  private List<nl.imvertor.model.fietsenwinkel.inventaris.Fiets> verhandelt;

  public void setUrl(String url) {
    this.url = url;
  }

  public String getNaam() {
    return naam;
  }

  public void setNaam(String naam) {
    this.naam = naam;
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

  public List<nl.imvertor.model.fietsenwinkel.inventaris.Fiets> getVerhandelt() {
    return verhandelt;
  }

  public void setVerhandelt(List<nl.imvertor.model.fietsenwinkel.inventaris.Fiets> verhandelt) {
    this.verhandelt = verhandelt;
  }

}
