package anathema.android.manse;

public class OnLoan implements ManseSpecialty {
  @Override
  public String getCaption() {
    return "On Loan";
  }

  @Override
  public String getRisk() {
    return null;
  }

  @Override
  public String getReward() {
    return null;
  }

  @Override
  public String getDetails() {
    return null;
  }

  @Override
  public int getRoll() {
    return 8;
  }
}
