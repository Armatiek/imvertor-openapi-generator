package nl.imvertor.mim.model;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

public abstract class GepagineerdBase {
  
  @Schema(description = "Huidig paginanummer", type = "integer", format = "int32", requiredMode = RequiredMode.REQUIRED, minimum = "1")
  private int pagina;
  
  @Schema(description = "Aantal objecten per pagina", type = "integer", format = "int32", requiredMode = RequiredMode.REQUIRED, maximum = "100")
  private int paginaGrootte;
  
  @Schema(description = "Totaal aantal beschikbare objecten", type = "integer", format = "int32", nullable = true, requiredMode = RequiredMode.NOT_REQUIRED, minimum = "0")
  private int totaalAantal;
  
  @Schema(description = "Komma gescheiden lijst van velden waarop gesorteerd moet worden. Door een minteken (-) voor de veldnaam te zetten wordt het veld in aflopende sorteervolgorde gesorteerd.", 
      type = "string", requiredMode = RequiredMode.NOT_REQUIRED, example = "name,-geboorteDatum")
  private String sorteer;
  
  @Schema(description = "Link naar de volgende pagina", type = "string", format = "uri", nullable = true, requiredMode = RequiredMode.NOT_REQUIRED, example = "http://mijn-api.org/api/v1/klanten/?pagina=4&paginaGrootte=10&sorteer=name,-geboorteDatum")
  private String volgende;

  @Schema(description = "Link naar de vorige pagina", type = "string", format = "uri", nullable = true, requiredMode = RequiredMode.NOT_REQUIRED, example = "http://mijn-api.org/api/v1/klanten/?pagina=2&paginaGrootte=10&sorteer=name,-geboorteDatum")
  private String vorige;
  
  public int getPagina() {
    return pagina;
  }

  public void setPagina(int pagina) {
    this.pagina = pagina;
  }

  public int getPaginaGrootte() {
    return paginaGrootte;
  }

  public void setPaginaGrootte(int paginaGrootte) {
    this.paginaGrootte = paginaGrootte;
  }

  public int getTotaalAantal() {
    return totaalAantal;
  }

  public void setTotaalAantal(int totaalAantal) {
    this.totaalAantal = totaalAantal;
  }

  public String getSorteer() {
    return sorteer;
  }

  public void setSorteer(String sorteer) {
    this.sorteer = sorteer;
  }

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