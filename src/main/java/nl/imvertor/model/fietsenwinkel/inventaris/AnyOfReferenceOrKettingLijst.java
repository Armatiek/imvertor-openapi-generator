package nl.imvertor.model.fietsenwinkel.inventaris;

import nl.imvertor.mim.model.Reference;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(anyOf = { Reference.class, KettingLijst.class })
public class AnyOfReferenceOrKettingLijst { }
