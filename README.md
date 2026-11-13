# LootCrate System

## - Stefan, Ayman, Ahmad og Magnus

## Projektbeskrivelse
LootCrate System er et mindre Java-projekt, der simulerer et loot crate-system i et spil. Spillere har credits, som de kan bruge til at åbne forskellige typer loot crates. Hver loot crate har et navn og en pris. Systemet kontrollerer, om spilleren har nok credits, før spilleren får lov til at åbne en loot crate.

## Projektets formål
Formålet med projektet er at øve og anvende exceptions og objektorienteret programmering (OOP) i Java. Projektet fokuserer på følgende programmeringsbegreber:
* Klasser og objekter
* Constructors
* Indkapsling (Encapsulation)
* Metoder
* Arv (Inheritance)
* Fejlhåndtering (Exception Handling)
* ArrayList

## Projektstruktur
```text
UV_13_LootCrate_System/
│
├── src/
│   ├── exceptions/
│   │   ├── NegativeAmountException.java
│   │   ├── NotEnoughCreditsException.java
│   │   └── PlayerNotFoundException.java
│   │
│   ├── models/
│   │   ├── LootCrate.java
│   │   └── Player.java
│   │
│   └── LootCrateSystem.java
│
└── README.md
```

## Forklaring af klasserne

### Player.java
`Player`-klassen repræsenterer en spiller i spillet.

**Attributter:**
* `name`: Spillerens brugernavn.
* `credits`: Antallet af credits, som spilleren har.

**Metoder:**
* `addCredits(int amount, Player player)`: Tilføjer credits til spilleren og kaster en `NegativeAmountException`, hvis beløbet er under 0.
* `buyCrate(int cratePrice)`: Tjekker om spilleren har nok credits, trækker prisen fra og returnerer `true` eller `false`.
* `getName()`: Henter spillerens brugernavn.
* `getCredits()`: Henter spillerens credits.
* `displayDetails()`: Udskriver spillerens navn og nuværende antal credits.

`LootCrate`-klassen repræsenterer en loot crate i spillet.

**Attributter:**
* `id`: Loot cratens navn.
* `price`: Prisen for at åbne loot craten.

**Metoder:**
* `open(Player player)`: Kontrollerer først, om spilleren findes (`null`), og kaster `PlayerNotFoundException` hvis ikke. Kontrollerer derefter, om spilleren har nok credits, og kaster `NotEnoughCreditsException` hvis saldoen er for lav. Hvis betingelserne er opfyldt, trækkes prisen fra via `buyCrate()`, og loot craten åbnes.

**System:**
* `LootCrateSystem` (Indeholder `main`, oprettelsesmetoder og test-metoder)


## Fejlhåndtering (Exception Handling)
Projektet bruger egne exceptions i `exceptions`-packagen til at håndtere forskellige fejl:

* `NegativeAmountException` (Unchecked): Bruges, når en spiller forsøger at tilføje et negativt antal credits.
* `NotEnoughCreditsException` (Checked): Bruges, når en spiller ikke har nok credits til at åbne en loot crate.
* `PlayerNotFoundException` (Checked): Bruges, når systemet ikke kan finde en bestemt spiller (`null`).

Exceptions hjælper med at håndtere fejl på en kontrolleret måde, så programmet ikke crasher eller fortsætter med ugyldige handlinger.

## Test af systemet
I `LootCrateSystem`-klassen er der oprettet forskellige testmetoder til at kontrollere systemets funktioner:

* `openCrateTestSuccess()`: Tester, om en spiller (`Rich`) kan åbne en `Diamond Crate`, når spilleren har nok credits, og om saldoen opdateres korrekt.
* `openCrateTestFail()`: Tester, hvad der sker, når en spiller (`Noob999`) forsøger at åbne en `Gold Crate` uden nok credits (`NotEnoughCreditsException`).
* `testNegativCredits()`: Tester, om systemet forhindrer tilføjelse af `-50` credits til `Gamer123` (`NegativeAmountException`).
* `testPlayerNotFound()`: Tester, hvad der sker, når en crate forsøges åbnet for en spiller, der ikke findes (`null` / `PlayerNotFoundException`).

## Hvad vi har lært
* **Try-catch og throws** → at kaste exceptions videre fra metoder med `throws` og fange dem sikkert med `try-catch` blokke.
* **Egne exception-klasser** → at oprette exceptions med meningsfulde fejlbeskeder (`getMessage()`).
* **Struktur og packages** → at organisere klasser i mapper/packages (`exceptions` og `models`)

## Udfordringer
En af vores største udfordringer har været helt at forstå teorien bag checked og unchecked exceptions – særligt hvorfor nogle fejl vælges som checked, mens andre er unchecked, og hvornår man i praksis skal vælge det ene frem for det andet.
