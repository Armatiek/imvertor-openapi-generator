package nl.imvertor.model.fietsenwinkel.gemeenschappelijketypen;

import nl.imvertor.mim.annotation.*;
import nl.imvertor.mim.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.*;
import java.util.*;

/**
 * <p>De dimensies van een 3-dimensionaal object.</p>
 */
@GestructureerdDatatype
@Schema(description = "De dimensies van een 3-dimensionaal object.")
public class Dimensies {

  @Schema(description = "Unieke identificatie van de resource waarnaar verwezen wordt", type = "string", requiredMode = RequiredMode.REQUIRED, minLength = 1)
  private String id;

  @Schema(description = "URL-referentie naar de resource waarnaar verwezen wordt", type = "string", format = "uri", requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_ONLY, minLength = 1)
  private String url;

  /**
   * <p>Lengte van het object in mm.</p>
   * DataElement
   */
  @Schema(description = "Lengte van het object in mm.", requiredMode = RequiredMode.REQUIRED)
  private Integer lengte;

  /**
   * <p>Breedte van het object in mm.</p>
   * DataElement
   */
  @Schema(description = "Breedte van het object in mm.", requiredMode = RequiredMode.REQUIRED)
  private Integer breedte;

  /**
   * <p>Hoogte van het object in mm.</p>
   * DataElement
   */
  @Schema(description = "Hoogte van het object in mm.", requiredMode = RequiredMode.REQUIRED)
  private Integer hoogte;

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

  public Integer getLengte() {
    return lengte;
  }

  public void setLengte(Integer lengte) {
    this.lengte = lengte;
  }

  public Integer getBreedte() {
    return breedte;
  }

  public void setBreedte(Integer breedte) {
    this.breedte = breedte;
  }

  public Integer getHoogte() {
    return hoogte;
  }

  public void setHoogte(Integer hoogte) {
    this.hoogte = hoogte;
  }

}
