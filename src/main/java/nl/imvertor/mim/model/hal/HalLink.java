package nl.imvertor.mim.model.hal;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

@Schema()
public class HalLink {
  
  @Schema(ref = "#/components/schemas/Href", requiredMode = RequiredMode.REQUIRED)
  private Object href;

  @Schema()
  private boolean templated;
  
  @Schema(description = "Voor mens leesbaar label bij de link")
  private String title;
  
  
  public Object getHref() {
    return href;
  }

  public void setHref(Object href) {
    this.href = href;
  }

  public boolean isTemplated() {
    return templated;
  }

  public void setTemplated(boolean templated) {
    this.templated = templated;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

}