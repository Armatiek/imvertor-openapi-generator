package nl.imvertor.mim.model.hal;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(title = "HalPaginationLinks", allOf = { HalCollectionLinks.class })
public class HalPaginationLinks {
  
  @Schema(title = "Eerste pagina", ref = "#/components/schemas/HalLink", example = "/resourcenaam?page=1")
  private Object first;
  
  @Schema(title = "Vorige pagina", ref = "#/components/schemas/HalLink", example = "/resourcenaam?page=3")
  private Object previous;
  
  @Schema(title = "Volgende pagina", ref = "#/components/schemas/HalLink", example = "/resourcenaam?page=5")
  private Object next;
  
  @Schema(title = "Laatste pagina", ref = "#/components/schemas/HalLink", example = "/resourcenaam?page=15")
  private Object last;

  public Object getFirst() {
    return first;
  }

  public void setFirst(Object first) {
    this.first = first;
  }

  public Object getPrevious() {
    return previous;
  }

  public void setPrevious(Object previous) {
    this.previous = previous;
  }

  public Object getNext() {
    return next;
  }

  public void setNext(Object next) {
    this.next = next;
  }

  public Object getLast() {
    return last;
  }

  public void setLast(Object last) {
    this.last = last;
  }
   
}