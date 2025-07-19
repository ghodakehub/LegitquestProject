package UtilityClass;

import org.testng.annotations.DataProvider;

public class ActTypeProvider {


    @DataProvider(name = "actTypes")
    public static Object[][] getActTypes() {
        return new Object[][]{
            {"Main Act"},
            {"amendment"},
            {"order"},
            {"ordinance"},
            {"policy"},
            {"regulation"},
            {"rule"},
            {"schemesguideline"},
            {"stateamendment"}
        };
    }
}




