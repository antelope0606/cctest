package test;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HomePageBrowserTest {

	private static HtmlUnitDriver browser;

	@BeforeClass
	public static void setup() {
		browser = new HtmlUnitDriver(true);
		browser.setJavascriptEnabled(true);
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void teardown() {
		browser.quit();
	}

	@Test
	public void testHomePage() {
		String path = System.getProperty("user.dir");
        //System.out.println("["+path+"]");
		String html = path + "\\src\\test\\resources\\index.html";
		//System.out.println("["+html+"]");

		browser.get("file:"+ html);
		
		String titleText = browser.getTitle();
		Assert.assertEquals("index", titleText);

		browser.findElementById("btn").click();
		//browser.findElementById("btn").sendKeys(Keys.RETURN);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			System.exit(0);
		}
		//System.out.println("[" + browser.findElementById("demo").getText() + "]");
		Assert.assertEquals("Hello JavaScript!", browser.findElementById("demo").getText());
	}
}
