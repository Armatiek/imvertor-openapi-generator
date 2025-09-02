package nl.imvertor.model.fietsenwinkel.contacten;

import nl.imvertor.mim.model.Reference;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(anyOf = { Reference.class, KVKLijst.class })
public class AnyOfReferenceOrKVKLijst { }
