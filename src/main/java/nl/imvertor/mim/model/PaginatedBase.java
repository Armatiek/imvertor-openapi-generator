package nl.imvertor.mim.model;

import io.swagger.v3.oas.annotations.media.Schema;

public abstract class PaginatedBase {
  
  @Schema(type = "string", format = "uri", nullable = true, example = "http://api.example.org/accounts/?pagina=4&paginaGrootte=10&sorteer=name,-geboorteDatum")
  private String next;

  @Schema(type = "string", format = "uri", nullable = true, example = "http://api.example.org/accounts/?pagina=2&paginaGrootte=10&sorteer=name,-geboorteDatum")
  private String previous;

  public String getNext() {
    return this.next;
  }

  public void setNext(String next) {
    this.next = next;
  }

  public String getPrevious() {
    return this.previous;
  }

  public void setPrevious(String previous) {
    this.previous = previous;
  }
  
}