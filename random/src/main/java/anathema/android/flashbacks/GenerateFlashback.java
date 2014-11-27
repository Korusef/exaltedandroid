package anathema.android.flashbacks;

import anathema.android.DiceAndCoins;
import anathema.android.util.FileToString;
import anathema.android.util.JsonRandomizer;
import anathema.android.util.PlaceholderResolver;

public class GenerateFlashback {
  private final JsonRandomizer randomizer;
  private final PlaceholderResolver resolver;
  private final FileToString fileToString;

  public GenerateFlashback(DiceAndCoins diceAndCoins, FileToString fileToString) {
    this.fileToString = fileToString;
    this.randomizer = new JsonRandomizer("flashbacks", diceAndCoins, fileToString);
    this.resolver = new PlaceholderResolver(GenerateFlashback.class, this);
  }

  public String generate() {
    String unresolved = fileToString.loadFile("flashbacks/flashbackpattern.txt");
    return resolver.resolvePlaceholders(unresolved, randomizer);
  }
}
