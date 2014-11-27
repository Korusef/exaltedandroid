package anathema.android.lifepath;

import anathema.android.DiceAndCoins;
import anathema.android.util.FileToString;
import anathema.android.util.JsonRandomizer;
import anathema.android.util.PlaceholderResolver;

public class GenerateLifepath {
  private final DiceAndCoins diceAndCoins;
  private final JsonRandomizer randomizer;
  private final PlaceholderResolver resolver;
  private Lifepath lifepath;

  public GenerateLifepath(DiceAndCoins diceAndCoins, FileToString fileToString) {
    this.diceAndCoins = diceAndCoins;
    this.randomizer = new JsonRandomizer("lifepath", diceAndCoins, fileToString);
    this.resolver = new PlaceholderResolver(GenerateLifepath.class, this);
  }

  public Lifepath generate() {
    this.lifepath = new Lifepath();
    rollOrigin();
    lifepath.lifepath.append(" ");
    rollFamily();
    lifepath.lifepath.append("\n");
    rollChildhood();
    lifepath.lifepath.append(" ");
    rollAdultCareer();
    lifepath.lifepath.append("\n");
    rollExaltation();
    lifepath.lifepath.append("\n");
    lifepath.lifepath.append("Now, forge your destiny!");
    return lifepath;
  }

  private void rollChildhood() {
    String childhood = randomizer.pickElementFromJsonArray("childhood");
    String youth = resolver.resolvePlaceholders(childhood);
    lifepath.lifepath.append(youth);
  }

  private void rollFamily() {
    int roll = diceAndCoins.rollTenSidedDie();
    lifepath.suggestedTraits.add("Influence and Connections to represent your upbringing");
    if (roll == 10) {
      lifepath.lifepath.append("Raised by monks, you never met your family.");
      return;
    }
    String family = resolver.resolvePlaceholders("You were born %rollFamilySize%.");
    lifepath.lifepath.append(family);
  }

  @SuppressWarnings("UnusedDeclaration")    // called via JSON reflection
  public String rollFamilySize() {
    return randomizer.pickElementFromJsonArray("familySize");
  }

  @SuppressWarnings("UnusedDeclaration")    // called via JSON reflection
  public String rollOccupation() {
    return randomizer.pickElementFromJsonArray("familyOccupation");
  }

  private void rollAdultCareer() {
    String adultCareer = resolver.resolvePlaceholders("As an adult, you became %rollCareer%.");
    lifepath.lifepath.append(adultCareer);
  }

  @SuppressWarnings("UnusedDeclaration") // called via JSON reflection
  public String rollCareer() {
    return randomizer.pickElementFromJsonArray("adultCareer");
  }

  public void rollOrigin() {
    String generalOrigin = randomizer.pickElementFromJsonArray("generalOrigin");
    String origin = resolver.resolvePlaceholders(generalOrigin);
    lifepath.lifepath.append("You hail from ");
    lifepath.lifepath.append(origin);
    lifepath.lifepath.append(".");
  }

  public void rollExaltation() {
    String exaltation = resolver.resolvePlaceholders("When %rollExaltationTrigger%, you exalted as a %rollExaltationResult% and found yourself %rollExaltationFallout% shortly after.");
    lifepath.lifepath.append(exaltation);
  }

  @SuppressWarnings("UnusedDeclaration") // called via JSON reflection
  public String rollExaltationTrigger() {
    String exaltationTrigger = randomizer.pickElementFromJsonArray("exaltationTrigger");
    return resolver.resolvePlaceholders(exaltationTrigger);
  }

  @SuppressWarnings("UnusedDeclaration") // called via JSON reflection
  public String rollAssassin() {
    return randomizer.pickElementFromJsonArray("assassin");
  }

  @SuppressWarnings("UnusedDeclaration") // called via JSON reflection
  public String rollSupernaturalCreature() {
    return randomizer.pickElementFromJsonArray("supernaturalCreature");
  }

  @SuppressWarnings("UnusedDeclaration") // called via JSON reflection
  public String rollAngryCreature() {
    return randomizer.pickElementFromJsonArray("angryCreature");
  }

  @SuppressWarnings("UnusedDeclaration") // called via JSON reflection
  public String rollConflict() {
    return randomizer.pickElementFromJsonArray("conflict");
  }

  @SuppressWarnings("UnusedDeclaration") // called via JSON reflection
  public String rollHorror() {
    return randomizer.pickElementFromJsonArray("horror");
  }

  @SuppressWarnings("UnusedDeclaration") // called via JSON reflection
  public String rollJourney() {
    return randomizer.pickElementFromJsonArray("journey");
  }

  @SuppressWarnings("UnusedDeclaration") // called via JSON reflection
  public String rollExaltationResult() {
    return randomizer.pickElementFromJsonArray("exaltationResult");
  }

  @SuppressWarnings("UnusedDeclaration") // called via JSON reflection
  public String rollExaltationFallout() {
    int roll = diceAndCoins.rollTenSidedDie();
    switch (roll) {
      case 1:
        addTrait("Charms to improve your reputation");
        addTrait("Charms to stay out of sight");
        return "hunted by Immaculates";
      case 2:
        addTrait("a Cult");
        addTrait("some Followers");
        return "worshipped by a local village";
      case 3:
        addTrait("Martial Arts Charms");
        return "mentored by a Sidereal";
      case 4:
        addTrait("Artifacts");
        return "supported by a Deathlord";
      case 5:
        addTrait("social influence");
        return "in an alliance with a local God";
      case 6:
        addTrait("a Manse");
        return "drawn by dreams to a lost Manse";
      case 7:
        addTrait("a Familiar");
        addTrait("Charms to interact with beasts");
        return "bonded with a local beast";
      case 8:
        addTrait("an Ally");
        return "in the arms of your Lunar mate";
      case 9:
        addTrait("Sorcery");
        return "awakening to a deeper understanding of Creation";
      case 10:
        addTrait("Merits to represent your Mortal cover");
        return "hidden from Creation's eye, remaining secret to everyone";
      default:
        throw new IllegalArgumentException("Die roll out of bounds [1,10].");
    }
  }

  private void addTrait(String object) {
    lifepath.suggestedTraits.add(object);
  }

  @SuppressWarnings("UnusedDeclaration") // called via JSON reflection
  public String rollBeastmanOrigin() {
    addTrait("racial merits");
    return randomizer.pickElementFromJsonArray("beastmanOrigin");
  }

  @SuppressWarnings("UnusedDeclaration") // called via JSON reflection
  public String rollBarbarianOrigin() {
    return randomizer.pickElementFromJsonArray("barbarianOrigin");
  }

  @SuppressWarnings("UnusedDeclaration") // called via JSON reflection
  public String rollShadowlandOrigin() {
    return randomizer.pickElementFromJsonArray("shadowlandOrigin");
  }

  @SuppressWarnings("UnusedDeclaration") // called via JSON reflection
  public String rollNorthernOrigin() {
    return randomizer.pickElementFromJsonArray("northernOrigin");
  }

  @SuppressWarnings("UnusedDeclaration") // called via JSON reflection
  public String rollEasternOrigin() {
    return randomizer.pickElementFromJsonArray("easternOrigin");
  }

  @SuppressWarnings("UnusedDeclaration") // called via JSON reflection
  public String rollWesternOrigin() {
    return randomizer.pickElementFromJsonArray("westernOrigin");
  }

  @SuppressWarnings("UnusedDeclaration") // called via JSON reflection
  public String rollSouthernOrigin() {
    return randomizer.pickElementFromJsonArray("southernOrigin");
  }

  @SuppressWarnings("UnusedDeclaration") // called via JSON reflection
  public String rollSoutheastOrigin() {
    return randomizer.pickElementFromJsonArray("southeastOrigin");
  }

  @SuppressWarnings("UnusedDeclaration") // called via JSON reflection
  public String rollSouthwestOrigin() {
    return randomizer.pickElementFromJsonArray("southwestOrigin");
  }
}