package nl.imvertor.model.fietsenwinkel.gemeenschappelijketypen;

import nl.imvertor.mim.annotation.*;
import nl.imvertor.mim.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.*;

/**
 * <p>De dimensies van een 3-dimensionaal object.</p>
 */
@GestructureerdDatatype
@Schema(description = "De dimensies van een 3-dimensionaal object.")
public class Dimensies {

  /**
   * Field that is not part of the model but added to define an identifying field for this entity
   */
  @Schema(description = "Field that is not part of the model but added to define an identifying field for this entity", requiredMode = RequiredMode.REQUIRED)
  private Long id;

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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
