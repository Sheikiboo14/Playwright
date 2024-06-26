package Tasks;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.LocatorAssertions;

public class Task_01 {

	public static void main(String[] args) {

		Playwright playwright=  Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(true)
				);
		Page page = browser.newPage();
		page.navigate("https://letcode.in/edit");
		page.fill("#fullName", "Iboo");
		
		Locator locator = page.locator("#join");
		locator.press("End");
		locator.type(" Man");
		locator.press("Tab");
		
		String value = page.locator("#getMe").getAttribute("value");
		
		System.out.println(value);
		
		page.locator("#clearMe").clear();
		
		boolean edit = page.locator("#noEdit").isDisabled();
		
		System.out.println("Enable Result : "+ edit);
		
		boolean readonly = page.locator("#dontwrite").isEditable();
		
		System.out.println("Edit Result : "+ readonly);

//		page.close();
//		browser.close();
//		playwright.close();
		


	}

}
