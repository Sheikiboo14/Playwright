

import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;



public class LoginPage2 {


	public static void main(String arg[]) {

		try(Playwright playwright=Playwright.create()){
			
			BrowserType browserType = playwright.chromium();
			
			Browser browser = browserType.launch(
					new BrowserType.LaunchOptions()
					.setHeadless(false)
					);
			
			BrowserContext context = browser.newContext();
			
			context.tracing().start(
					new Tracing.StartOptions()
					.setScreenshots(true)
					.setSnapshots(true)
					.setSources(!true)
					);
			
			
			Page page = context.newPage();
			
			page.navigate("http://localhost:8080/v2.1.106/auth/login");
			
			page.locator("//input[@aria-label='UserName']").fill("testenv_admin@doocti.com");
			
			page.locator("//input[@aria-label='Password']").fill("Doocti@123");
			
			page.click("//button[@type='submit']");
			
			page.click("//i[@title='Sign Out']");
			
			page.click("//div[text()='OK']");
			
			context.tracing().stop(
					new Tracing.StopOptions()
					.setPath(Paths.get("Tracing/trace.zip"))
					);
			
			context.close();

		}
	}
	


}