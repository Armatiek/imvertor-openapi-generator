package nl.imvertor.model.fietsenwinkel.gml;

import nl.imvertor.mim.model.Reference;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(anyOf = { Reference.class, GM_Polygon.class })
public class AnyOfReferenceOrGM_Polygon { }
