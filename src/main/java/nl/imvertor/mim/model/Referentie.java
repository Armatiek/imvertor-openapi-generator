package nl.imvertor.mim.model;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

@Schema(description = "Referentie naar een andere resource")
public class Referentie {
  
  @Schema(type = "string", description = "ID van de resource waarnaar verwezen wordt", requiredMode = RequiredMode.REQUIRED, minLength = 1)
  private String id;
  
  @Schema(type = "string", format = "uri", description = "URL-referentie naar de resource waarnaar verwezen wordt", requiredMode = RequiredMode.REQUIRED, minLength = 1, accessMode = AccessMode.READ_ONLY )
  private String url;

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
  
}