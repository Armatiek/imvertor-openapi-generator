package nl.imvertor.mim.model;

import io.swagger.v3.oas.annotations.media.Schema;

public abstract class PaginatedBase {
  
  @Schema(type = "string", format = "uri", nullable = true, example = "http://api.example.org/accounts/?page=4")
  private String next;

  @Schema(type = "string", format = "uri", nullable = true, example = "http://api.example.org/accounts/?page=2")
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