package nl.imvertor.resource;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.*;
import io.swagger.v3.oas.annotations.servers.*;
import io.swagger.v3.oas.annotations.tags.*;

@OpenAPIDefinition(
  info = @Info(
    title = "Fietsenwinkel OpenAPI specificatie",
    description = "Dit is een demo OpenAPI specificatie voor registratie van inventaris en betrokken producenten en klanten van fietsenwinkels. Dit is een model voor registratie van inventaris en betrokken producenten en klanten van fietsenwinkels. Dit model heeft alleen tot doel de aard en toepassing van constructies te illustreren, en is opgezet als een UML realisatie van de in MIM besproken modelelementen. Het model staat bekend als IMFW. Het model is ontwikkeld onder toezicht van de IFO: Internationale Fietsenwinkels Organisatie. Dit model is opgezet conform MIM 1.2 .",
    version = "1.2.3",
    contact = @Contact(
      url = "https://armatiek.nl"
    ),
    license = @License(
      name = "European Union Public License, version 1.2 (EUPL-1.2)",
      url = "https://eupl.eu/1.2/nl/"
    )
  ),
  servers = {
  }
)
public class OpenApiDefinition { }
