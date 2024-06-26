package Doocti_Admin;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator.FilterOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.AriaRole;

public class configuration {

	public static void main(String[] args) {

		try(Playwright playwirght = Playwright.create()){
			
			Browser browser = playwirght.chromium().launch(new BrowserType.LaunchOptions()
					.setHeadless(false)	);
			
			BrowserContext context = browser.newContext(new Browser.NewContextOptions()
					.setRecordVideoDir(Paths.get("ScriptVideo/Config"))
					.setRecordVideoSize(1080, 720));
			
			Page page = context.newPage();
			
			
			
			//Tracing Code
			context.tracing().start(
					new Tracing.StartOptions()
					.setScreenshots(true)
					.setSnapshots(true)
					);
		
		//Login		
			
			page.navigate("http://localhost:8080/v2.1.106/auth/login");
			
			page.getByPlaceholder("User Name").fill("testenv_admin@doocti.com");
			
			page.locator("//input[@type='password']").fill("Doocti@123");
			
			page.getByRole(AriaRole.BUTTON,
					new Page
					.GetByRoleOptions()
					.setName("Login"))
			.click();
			
			page.waitForURL("http://localhost:8080/v2.1.106/realtime/live-agents");
		
			System.out.println(page.url());
			
			page.getByText("Configurations").click();

			
			//Queue Creation
		/*	
			page.getByText("Queues").click();
			page.getByRole(AriaRole.BUTTON,
					new Page.GetByRoleOptions()
					.setName(" Add Queue "))
			.click();
			page.locator("//input[@aria-label='Queue Name']").fill("TestQueue");
			
			page.getByRole(AriaRole.BUTTON,
					new Page.GetByRoleOptions()
					.setName("Create"))
			.click();
			
			page.locator("(//div[text()='Close'])[3]").click();
			
			//Disposition Creation
			
			page.locator("//span[text()='Dispositions']").click();
			
			page.getByRole(AriaRole.BUTTON,
					new Page.GetByRoleOptions()
					.setName(" Add Disposition "))
			.click();
			
			page.locator("(//input[@aria-label='Disposition'])[2]").fill("Test Disposition 01");
			
			page.locator("(//input[@aria-label='Description'])[2]").fill("Test Description");
			
			page.locator("(//div[@class='v-select__selections'])[3]").click();

			page.locator("(//div[text()='Reassign'])[2]").click();

			page.locator("//div[text()='Create']").click();
			
			page.locator("(//div[text()='Close'])[3]").click();
			
						*/

			//Sub-Dispositions Creation
			
			page.locator("//span[text()='Sub-Dispositions']").click();
			
			page.getByRole(AriaRole.BUTTON,
					new Page.GetByRoleOptions()
					.setName(" Add Sub-Dispo "))
			.click();
			
			page.keyboard().press("Control");
			page.keyboard().press("Shift");
			page.keyboard().press("J");
			
			
			
			page.locator("(//div[@class='v-select__selections'])[3]").click();
			
//			page.locator("//input[@aria-label='Sub-Disposition']").fill("Test Sub Dispo");
//
//			page.locator("div").filter(new FilterOptions().setHasText("Test Disposition 01")).click();
			
			
			context.tracing().stop(
					new Tracing.StopOptions()
					.setPath(Paths.get("Tracing/config.zip"))
					);
			
			
			context.close();
		}
	}

}
