package Tasks;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Test1 {
	
	protected Playwright playwright;
	
	protected Browser browser;
	
	protected BrowserContext context;
	
	protected Page page;
	
	@Test
	public void launchBrowser() {
	
		
		playwright = Playwright.create();
		
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		context=browser.newContext();
		
		page = context.newPage();
		
		page.navigate("https://letcode.in/");	
		
	}
	
	@Test
	public void comeOut() {
		
		
		context.close();
		
		
	}

}
