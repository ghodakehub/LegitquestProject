package TestClass;

import java.util.List;
import org.testng.annotations.Test;
import Pomclass.Login;
import Pomclass.StateActListpage;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("ActList")
@Feature("Verify stateActlist")
public class StateActList extends NewBaseTest {


	
	@Test
	@Description("This test case Verify that apply filter for type and state and check all Links and paginations")
	public void Actlistverify() throws Exception
	
	{
		Login log= new Login(driver);
		
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);

		
		 StateActListpage state= new StateActListpage(driver);

		 List<String> brokenLinks = state.validateAllStateActs();

		    if (!brokenLinks.isEmpty()) {
		    	generic.AllureListeners.captureScreenshot(driver, "Stateactlist error");
		    	 String screenshot=  UtilityClass.Capaturescreenshot(driver ,"statelist error" );
	             	
		    	 String testUrl = driver.getCurrentUrl();

		    	
		    	StringBuilder body = new StringBuilder();
		    	body.append("Please check Issue of not dispaly the Maincontent after open the statelist links .\n");
		    	body.append(" for some actlist The content is not displaying correctly.\n\n");

		    	body.append("Broken Links Detected:\n");
		    	for (String url : brokenLinks) {
		    	    body.append(url).append("\n");
		    	}

		    	body.append("\nTest Page URL: ").append(testUrl);

		    	ForMultiplemailReceipent.sendEmail(
		    	    driver, 
		    	    new String[]{"ghodake6896@gmail.com"}, 
		    	    "Actlist - StateActList", 
		    	    body.toString(), 
		    	    screenshot, 
		    	    testUrl
		    	);
		         } else {
		             System.out.println("All links open successfully");
		         }
	
	}
}

