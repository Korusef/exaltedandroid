package anathema.android.manse;

public class Squatters implements ManseSpecialty{

  @Override
  public String getCaption() {
    return "Squatters";
  }

  @Override
  public String getRisk() {
    return "These people can give away the location of the manse, or they can damage it if they try to remodel it.";
  }

  @Override
  public String getReward() {
    return "If the Exalt deals with them correctly they can have followers on site maintaining the Manse when they are away.";
  }

  @Override
  public String getDetails() {
    return "Manses are mostly abandoned 1st Age buildings. You don't have to be an essence user to find having a near indestructible shelter as a good idea to live in. Assuming no physical defenses to keep people out then it is very possible that refugees will set up tends near the building, or take over unused rooms near the entryways as their homes. Mortals may not be able to get the benefit of some of the magical tools in a Manse, but you can 'leave the water' on for them and it would go a long way toward making the like you. Add in some training charms, loyalty bonding oaths, and eventually squatters can become staff!";
  }

  @Override
  public int getRoll() {
    return 1;
  }
}