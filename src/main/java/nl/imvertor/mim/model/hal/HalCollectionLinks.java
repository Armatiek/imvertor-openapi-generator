package nl.imvertor.mim.model.hal;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(title = "HalCollectionLinks")
public class HalCollectionLinks {
  
  @Schema(ref = "#/components/schemas/HalLink")
  private Object self;

  public Object getSelf() {
    return self;
  }

  public void setSelf(Object self) {
    this.self = self;
  }

}