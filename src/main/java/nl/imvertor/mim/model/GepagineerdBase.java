package nl.imvertor.mim.model;

import io.swagger.v3.oas.annotations.media.Schema;

public abstract class GepagineerdBase {
  
  @Schema(type = "string", format = "uri", nullable = true, example = "http://mijn-api.org/api/v1/klanten/?pagina=4&paginaGrootte=10&sorteer=name,-geboorteDatum")
  private String volgende;

  @Schema(type = "string", format = "uri", nullable = true, example = "http://mijn-api.org/api/v1/klanten/?pagina=2&paginaGrootte=10&sorteer=name,-geboorteDatum")
  private String vorige;

  public String getVolgende() {
    return volgende;
  }

  public void setVolgende(String volgende) {
    this.volgende = volgende;
  }

  public String getVorige() {
    return vorige;
  }

  public void setVorige(String vorige) {
    this.vorige = vorige;
  }
  
}