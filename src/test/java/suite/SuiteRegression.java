package suite;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import testClean.LoginTest;
import testClean.ProjectTest;

@Suite
@SelectClasses({ LoginTest.class,
                 ProjectTest.class})
public class SuiteRegression {
}
