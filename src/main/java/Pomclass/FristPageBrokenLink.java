package Pomclass;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import generic.NewBaseTest;

public class FristPageBrokenLink extends BasePage1{
	
	public FristPageBrokenLink(WebDriver driver) {
		super(driver);
	
	}
	
	public void brokenLink() throws MalformedURLException {

	List<WebElement> alllinks = driver.findElements(By.tagName("a"));
		System.out.println(alllinks.size());

		for (WebElement element : alllinks) {

			String url = element.getAttribute("href");

			if (url == null || url.isEmpty()) {

				System.out.println("URL is Empty");
				continue;
			}

			URL link = new URL(url);

			try {
				HttpURLConnection httpconn = (HttpURLConnection) link.openConnection();
				httpconn.connect();

				if (httpconn.getResponseCode() >= 400) {

					System.out.println(httpconn.getResponseCode() + url + ": Broken Link");
				}

				else {

					System.out.println(httpconn.getResponseCode() + url + ": is valid link");

				}

			} catch (Exception e) {

				System.out.println(e);
			}
		}

	}

}
