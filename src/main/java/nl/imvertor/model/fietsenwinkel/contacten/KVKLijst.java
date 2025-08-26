package nl.imvertor.model.fietsenwinkel.contacten;

import nl.imvertor.mim.annotation.*;
import nl.imvertor.mim.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.*;

/**
 * <p>Lijst van KVK nummers met daaraan gekoppeld de bedrijfsnaam.</p>
 */
@Referentielijst
@Schema(description = "Lijst van KVK nummers met daaraan gekoppeld de bedrijfsnaam.")
public class KVKLijst {

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
