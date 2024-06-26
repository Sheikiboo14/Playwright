import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LaunchBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Playwright playwright=  Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false)
				);
		Page page = browser.newPage();
		page.navigate("https://console-v2.doocti.com/v2.1.106/auth/login");
		
		String title = page.title();
		
		System.out.println("Page Title : "+title);
		
		page.close();
		browser.close();
		playwright.close();
		
		
	}

}
