package Doocti_Admin;

import com.microsoft.playwright.options.AriaRole;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	    try (Playwright playwright = Playwright.create()) {
	        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
	          .setHeadless(false));
	        BrowserContext context = browser.newContext();
	        Page page = context.newPage();
	        page.navigate("http://localhost:8080/v2.1.106/");
	        page.getByPlaceholder("User Name").click();
	        page.getByPlaceholder("User Name").fill("testenv_admin@doocti.com");
	        page.getByPlaceholder("User Name").press("Tab");
	        page.getByLabel("Password").fill("Doocti@123");
	        page.getByLabel("Password").press("Tab");
	        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
	        page.navigate("http://localhost:8080/v2.1.106/realtime/live-agents");
	}

}
}
