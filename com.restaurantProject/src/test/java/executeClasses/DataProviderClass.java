package executeClasses;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderClass {
  

  @DataProvider(name="SuccessfulLogin")
  public Object[][] dp() {
    return new Object[][] {
      new Object[] {"admin","password"}
      
    };
  }
  @DataProvider(name="UnSuccessfulLogin")
  public Object[][] dp1() {
    return new Object[][] {
      new Object[] {"admin","passwordd" },
      new Object[] {"adamin","passw"},
      new Object[] { "adam","password"}
    };
  }
}
