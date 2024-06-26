package Tasks;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Task_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Playwright playWright = Playwright.create();
		Page page = playWright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false)
				).newPage();
		
		page.navigate("https://letcode.in/alert");

		page.locator("#accept").click();
		
		
	}

}
