# Imvertor OpenAPI generator
[![standard-readme compliant](https://img.shields.io/badge/readme%20style-standard-brightgreen.svg?style=flat-square)](https://github.com/RichardLitt/standard-readme)

De "Imvertor OpenAPI generator" is een voorziening waarmee [OpenAPI](https://swagger.io/specification/) specificaties kunnen worden gegenereerd op basis van andere resultaten die door [Imvertor](https://github.com/Imvertor/Imvertor-Maven) worden opgeleverd, met name de MIM XML serialisatie en Java code. De Imvertor OpenAPI generator kan worden gezien als een alternatief voor twee bestaande voorzieningen waarmee OpenAPI specificaties kunnen worden gegenereerd uit Imvertor resultaten: 
1. Het genereren van specificaties op basis van een specifiek BSM (Bericht Structuur Model) dat voldoet aan het [MBG - Metamodel BerichtstructuurGegevens](https://vng-realisatie.github.io/MBG-Werkomgeving/). In dit BSM kan een API worden gespecificeerd op basis van gegevens in een UGM (Uitwisselings Gegevensmodellen). De implementatie van deze voorziening is ontwikkeld door de [VNG](https://vng.nl/) en is als open source opgenomen in Imvertor.
2. Onderdelen van de Datahub services van het Kadaster waarbij onder andere APIs (GraphQL, OpenAPI) kunnen worden gegenereerd uit MIM modellen en aanvullende configuraties (momenteel nog closed source). 

## Inhoudsopgave

- [Overzicht](#imvertor-openapi-generator)
- [Inhoudsopgave](#inhoudsopgave)
- ["API-first" versus "code-first" API ontwikkeling](#api-first-versus-code-first-api-ontwikkeling)
- [Globale werking van de Imvertor OpenAPI generator](#globale-werking-van-de-imvertor-openapi-generator)
  - [Het genereren van de MIM XML serialisatie](#1-het-genereren-van-de-mim-xml-serialisatie)
  - [Het genereren van de Java code en property file](#2-het-genereren-van-de-java-code-en-property-file)
  - [Het samenvoegen van de Java code en het Imvertor OpenAPI generator project](#3-het-samenvoegen-van-de-java-code-en-het-imvertor-openapi-generator-project)
  - [Het genereren van de OpenAPI specificatie](#4-het-genereren-van-de-openapi-specificatie)
- [Kenmerken van de gegenereerde OpenAPI specificatie](#kenmerken-van-de-gegenereerde-openapi-specificatie)
- [Configuratie mogelijkheden](#configuratie-mogelijkheden)
- [Voorbeeld OpenAPI specificatie](#voorbeeld-openapi-specificatie)

## "API-first" versus "code-first" API ontwikkeling
In de wereld van API (Application Programming Interface) ontwikkeling zijn er globaal twee benaderingen, de z.g. "API-first" benadering en de "code-first" benadering. In de "API-first" benadering staat het API-ontwerp centraal en wordt als eerste de specificatie van de API gemaakt. Pas daarna wordt de implementatie van de API gebouwd op basis van deze specificatie. In de "code-first" benadering wordt eerst de applicatiecode en logica worden ontwikkeld. De API ontstaat vervolgens uit die code, vaak door middel van code-annotaties of automatische generatie van documentatie en specificaties.

In de [Nederlandse API strategie](https://geonovum.github.io/KP-APIs/API-strategie-algemeen/Inleiding/) heeft de overheid duidelijk gekozen voor de [API-first benadering](https://geonovum.github.io/KP-APIs/API-strategie-algemeen/Inleiding/#api-first-strategie):

> _"Iedere organisatie zou voor ontsluiting van data en functionaliteit altijd "API first" moeten werken"_

## Globale werking van de Imvertor OpenAPI generator
De Imvertor OpenAPI generator tracht de "API-first" en "code-first" benaderingen te combineren door met behulp van Imvertor uit een op [MIM](https://www.geonovum.nl/geo-standaarden/metamodel-informatiemodellering-mim) gebaseerd informatiemodel (Java) programmacode te genereren en vervolgens uit deze programmacode de API specificatie te genereren waarbij gebruik wordt gemaakt van standaard software ([de Swagger Java libraries](https://github.com/swagger-api/swagger-core)). Meer specifiek bestaat dit proces uit vier stappen.

1. Op basis van een op het MIM metamodel gebaseerd informatiemodel wordt met behulp van Imvertor een MIM XML serialisatie gegenereerd.
2. Deze MIM serialisatie wordt (ook met behulp van Imvertor) omgezet naar Java programmacode en een property file met daarin meta- en stuurgegevens.
3. Deze Java code en property file worden samengevoegd met een bestaand Java project (het Github project waar je nu naar kijkt).
4. Met behulp van de Swagger Java libraries wordt de OpenAPI specificatie (versie 3.0.1 of 3.1.0) gegenereerd.
 
#### 1. Het genereren van de MIM XML serialisatie
Imvertor ondersteund sinds enige tijd het genereren van een XML representatie (serialisatie) van een in [Sparx Enterprise Architect](https://sparxsystems.com/products/ea/17.1/) opgesteld informatiemodel dat is gebaseerd op het MIM metamodel versie 1.1.0, 1.1.1 of 1.2. 

#### 2. Het genereren van de Java code en property file
Imvertor ondersteund tevens het genereren van Java code uit een [MIM versie 1.2](https://docs.geostandaarden.nl/mim/mim/) serialisatie. Het ondersteund hierbij ook een modus waarin het specifieke Java classes genereerd die kunnen worden gebruikt om OpenAPI specificaties te genereren. Het genereren van deze Java code is momenteel nog niet beschikbaar in de master branch van het Imvertor Github project maar wel in de feature branch [CodeGeneration](https://github.com/Imvertor/Imvertor-Maven/tree/CodeGeneration).

De CodeGeneration module is in staat de volgende programmacode te genereren: 

* Een verzameling Java classes (beans) die de MIM modelelementen zoals Objecttypen, Codelijsten, Referentielijsten, Gegevensgroeptypen uit het MIM model representeren. Deze Java classes zijn voorzien van specieke instructies (annotaties genoemd) die door de Swagger Java library kunnen worden gebruikt om een gedetailleerde OpenAPI specificatie te genereren.
* Een verzameling Java resource classes die elk een aantal method/operaties op één (niet abstract) Objecttype bevatten. Standaard worden alle [CRUD](https://en.wikipedia.org/wiki/Create,_read,_update_and_delete) operaties voor dat Objecttype gegenereerd (zie ook [Kenmerken van de gegenereerde OpenAPI specificatie](#kenmerken-van-de-gegenereerde-openapi-specificatie)). 
* Een property file met daarin metagegevens uit het MIM model in een voor het Java project leesbare vorm (zoals de titel, omschrijving, versie en contactpersonen)
  
#### 3. Het samenvoegen van de Java code en het Imvertor OpenAPI generator project
Wanneer de Java code is gegenereerd kan deze worden samengevoegd met het "Imvertor OpenAPI Generator" Java project (dit Github project). Hierbij wordt een aantal directories en files vervangen. Deze bestaande directories bevatten voorbeeldcode dat is gebaseerd op het Fietsenwinkel informatiemodel uit de [MIM Primer](https://armatiek.nl/MIMPrimer/fietsenwinkel.html). 

De volgende files en directories dienen te worden vervangen:
* De package directory `src/main/java/nl/imvertor/model` met daarin de Java classes die de niet-abstracte Objecttypen representeren. 
* De package directory `src/main/java/nl/imvertor/resource` met daarin de Java resource classes. 
* De properties file `src/main/resources/openapi.properties`
  
#### 4. Het genereren van de OpenAPI specificatie
Wanneer de Java code en de property file is samengevoegd kan het Java project worden gebuild en vervolgens gestart. Daartie dient wel Java versie 11 of hoger te zijn geinstalleerd en de [Apache Maven](https://maven.apache.org/) build tooling.

Voor het genereren van een OpenAPI versie 3.0.1 specificatie:

`mvn clean compile exec:java -Dexec.args="my-open-api-spec.yaml"`

Voor het genereren van een OpenAPI versie 3.1.0 specificatie:

`mvn clean compile exec:java -Dexec.args="my-open-api-spec.yaml api31"`

Dit commando genereert niet alleen de OpenAPI specificatie, maar valideert deze ook. De resultaten van de validatie worden op het scherm getoond maar ook weggeschreven in de log file `imvertor-openapi-gnerator.log`.

### Kenmerken van de gegenereerde OpenAPI specificatie
De gegenereerde OpenAPI specificatie heeft de volgende kenmerken:
* De Imvertor OpenAPI Generator tracht OpenAPI specificaties te genereren die voldoen aan de functionele en technische eisen zoals beschreven in de [NLGov REST API Design Rules](https://gitdocumentatie.logius.nl/publicatie/api/adr/2.0.2).
* Standaard worden per niet-abstract Objecttype alle CRUD endpoints gegenereerd (zie ook [NLGov REST API Design Rules - HTTP Methods](https://gitdocumentatie.logius.nl/publicatie/api/adr/2.0.2/#http-methods), bijvoorbeeld voor het Objecttype "Klant":
  * `GET    /klanten` -> retourneert de collectie van alle Klant objecten
  * `POST   /klanten` -> maakt een nieuw Klant object aan
  * `GET    /klanten/{id}` -> retourneert het Klant object met de unieke identificatie "id"
  * `PUT    /klanten/{id}` -> vervangt een bestaand Klant object (full update)
  * `DELETE /klanten/{id}` -> verwijdert het Klant object met de unieke identificatie "id"
  * `PATCH  /klanten/{id}` -> werkt alleen bepaalde gegevens van een bestaand Klant object bij (partial update)
* Het is echter mogelijk de automatisch gegenereerde endpoints uit te breiden op twee manieren:
  * Door aan het Java project nog een extra Java resource class toe te voegen met de eigen operatie(s). Een voorbeeld van zo'n resource class is [CustomKlantResource](src/main/java/nl/imvertor/resource/fietsenwinkel/contacten/CustomKlantResource.java). Deze resource class bevat een GET operatie op een collectie van Klant objecten waarbij gefilterd kan worden op de naam en/of adres van een Klant. Omdat deze operatie het pad deelt met de automatisch gegenereerde GET collectie operatie , zou deze moeten worden uitgeschakeld, zie [Configuratie mogelijkheden](#configuratie-mogelijkheden).
  * Door aan het model een class toe te voegen met stereotype QueryParameters en deze via een MIM Relatiesoort te relateren met het Objectype waarvan een nieuw GET collectie endpoint moet worden toegevoegd. De MIM Attribuutsoorten die worden toegevoegd aan deze class worden de querystring parameters van dit nieuwe endpoint (NB. deze functionaliteit is nog in ontwikkeling).  
* De GET operaties die collecties van objecten opleveren kunnen gepagineerd worden opgevraagd. Aan deze operaties kan telkens een pagina, een paginagrootte en een sortering worden meegegeven. In de resultaten is (naast de lijst van objecten) telkens een link aanwezig naar de vorige en de volgende pagina.  
* Het MIM kenmerk [aggregatieType](https://docs.geostandaarden.nl/mim/mim/#metagegeven-aggregatietype) van een Relatiesoort bepaald of het target van de Relatiesoort integraal wordt "ingebed" in het JSON schema van zijn Objecttype of dat er alleen een verwijzing naar het target van de relatie wordt opgenomen. Als het aggregatieType de waarde "Compositie" of "Geen" heeft wordt het target van de relatie ingebed, als de waarde "Gedeeld" is wordt een link opgenomen. Zie ook [NLGov REST API Design Rules - Relationships](https://gitdocumentatie.logius.nl/publicatie/api/adr/2.0.2/#relationships).
* Momenteel worden MIM Keuze modelelementen nog niet omgezet naar JSON schema `anyOf` constructies. In plaats daarvan wordt een Keuze tussen Attribuutsoorten of Relatiesoorten omgezet naar twee optionele key/values.     
* De gebruikte response codes en error response schema's verwijzen momenteel naar de door VNG realisatie gedefinieerde codes in hun API-Kennisbank.

## Configuratie mogelijkheden
Het genereren van een OpenAPI specificatie kan met de Imvertor OpenAPI generator in principe gedaan worden zonder configuratie. Via het toevoegen van specifieke tags aan het informatiemodel in Enterprise Architect kan er echter invloed worden uitgeoefend op het standaard gedrag van de generator:

Tags die kunnen worden toegevoegd op modelelementen met stereotype "Informatiemodel":

* `openapi.title`: De `title` van de OpenAPI specificatie (zie [Info Object](https://swagger.io/specification/#info-object)). Als deze tag niet is gespecificeerd dan wordt de MIM `naam` van het Informatiemodel gebruikt. 
* `openapi.description`: De `description` van de OpenAPI specificatie (zie [Info Object](https://swagger.io/specification/#info-object)). Als deze tag niet is gespecificeerd dan wordt de MIM `definitie` van het Informatiemodel gebruikt.
* `openapi.version`: De `versie` van de OpenAPI specificatie (zie [Info Object](https://swagger.io/specification/#info-object)). Er is geen verstekwaarde voor deze tag. Voorbeeld '2.0.2'.
* `openapi.pathVersion`:  Het versienummer dat wordt opgenomen als onderdeel van de url paden (bijvoorbeeld `https://api.example.org/v1/`). Dit moet een enkelvoudig nummer zijn zonder prefix 'v'. De verstekwaarde is '1'.  
* `openapi.contact`: Het `contact` van de OpenAPI specificatie (zie [Contact Object](https://swagger.io/specification/#contact-object)). Er is geen verstekwaarde voor deze tag.
* `openapi.license`: De `license` waaronder de OpenAPI specificatie wordt gepubliceerd zie [License Object](https://swagger.io/specification/#license-object)). Er is geen verstekwaarde voor deze tag. 
* `openapi.methods`: De standaard CRUD operaties die moeten worden ondersteund in de OpenAPI specificatie. Als bijvoorbeeld de GET method voor zowel items als collecties moet worden ondersteund, alsmede POST, PUT, DELETE, maar geen PATCH, dan moet de waarde van deze tag zijn: `getCol,getItem,post,put,delete`.  

Tags die kunnen worden toegevoegd op modelelementen met stereotype "Objecttype":

* `openapi.expose`: Via deze tag kan worden aangegeven of endpoints voor dit Objecttype beschikbaar moeten worden gemaakt in de OpenAPI specificatie of niet ("true" of "false", default "true").
* `openapi.methods`: De standaard CRUD operaties die moeten worden ondersteund voor dit Objecttype in de OpenAPI specificatie.              
* `openapi.path`: Het path van het endpoint voor dit Objecttype, bijvoorbeeld `klanten` (zie [Paths Object](https://swagger.io/specification/#paths-object))
* `openapi.getCol.operationId`: De id van de operation voor de GET method van collecties voor dit Objecttype (zie [Path Item Object](https://swagger.io/specification/#path-item-object)).
* `openapi.getItem.operationId`: De id van de operation voor de GET method van items voor dit Objecttype (zie [Path Item Object](https://swagger.io/specification/#path-item-object)).
* `openapi.post.operationId`: De id van de operation voor de POST method van items voor dit Objecttype (zie [Path Item Object](https://swagger.io/specification/#path-item-object)).
* `openapi.delete.operationId`: De id van de operation voor de DELETE method van items voor dit Objecttype (zie [Path Item Object](https://swagger.io/specification/#path-item-object)).
* `openapi.put.operationId`: De id van de operation voor de PUT method van items voor dit Objecttype (zie [Path Item Object](https://swagger.io/specification/#path-item-object)).
* `openapi.patch.operationId`: De id van de operation voor de PATCH method van items voor dit Objecttype (zie [Path Item Object](https://swagger.io/specification/#path-item-object)).

## Voorbeeld OpenAPI specificatie
Zie [Fietsenwinkel OpenAPI specificatie](https://armatiek.github.io/imvertor-openapi-generator/examples/fietsenwinkel.yaml) voor een voorbeeld dat is gegenereerd via deze methode. Dit voorbeeld bevat ook de custom GET collectie method op Klant objecten.
