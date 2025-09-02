package nl.imvertor.model.fietsenwinkel.contacten;

import nl.imvertor.mim.annotation.*;
import nl.imvertor.mim.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.*;
import java.util.*;

/**
 * <p>Lijst van KVK nummers met daaraan gekoppeld de bedrijfsnaam.</p>
 */
@Referentielijst
@Schema(description = "Lijst van KVK nummers met daaraan gekoppeld de bedrijfsnaam.")
public class KVKLijst {

  @Schema(description = "Unieke identificatie van de resource waarnaar verwezen wordt", type = "string", requiredMode = RequiredMode.REQUIRED, minLength = 1)
  private String id;

  @Schema(description = "URL-referentie naar de resource waarnaar verwezen wordt", type = "string", format = "uri", requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_ONLY, minLength = 1)
  private String url;

  /**
   * <!-- FOUT: De waarde voor dit verplichte metagegeven is niet gespecificeerd in het model -->
   * ReferentieElement
   */
  @Schema(requiredMode = RequiredMode.REQUIRED)
  private String nummer;

  /**
   * <!-- FOUT: De waarde voor dit verplichte metagegeven is niet gespecificeerd in het model -->
   * ReferentieElement
   */
  @Schema(requiredMode = RequiredMode.REQUIRED)
  private String bedrijfsnaam;

  /**
   * <!-- FOUT: De waarde voor dit verplichte metagegeven is niet gespecificeerd in het model -->
   * ReferentieElement
   */
  @Schema(requiredMode = RequiredMode.REQUIRED)
  private String vestigingsadres;

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

  public String getNummer() {
    return nummer;
  }

  public void setNummer(String nummer) {
    this.nummer = nummer;
  }

  public String getBedrijfsnaam() {
    return bedrijfsnaam;
  }

  public void setBedrijfsnaam(String bedrijfsnaam) {
    this.bedrijfsnaam = bedrijfsnaam;
  }

  public String getVestigingsadres() {
    return vestigingsadres;
  }

  public void setVestigingsadres(String vestigingsadres) {
    this.vestigingsadres = vestigingsadres;
  }

}
