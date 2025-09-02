package nl.imvertor.model.fietsenwinkel.personen;

import nl.imvertor.mim.model.Reference;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(anyOf = { Reference.class, Persoon.class })
public class AnyOfReferenceOrPersoon { }
