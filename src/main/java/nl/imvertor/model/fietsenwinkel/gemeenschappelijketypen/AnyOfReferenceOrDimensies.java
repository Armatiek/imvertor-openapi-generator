package nl.imvertor.model.fietsenwinkel.gemeenschappelijketypen;

import nl.imvertor.mim.model.Reference;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(anyOf = { Reference.class, Dimensies.class })
public class AnyOfReferenceOrDimensies { }
