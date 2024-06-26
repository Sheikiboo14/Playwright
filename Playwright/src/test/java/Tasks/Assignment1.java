package Tasks;

import java.util.regex.Pattern;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.GetByRoleOptions;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {

		try(Playwright pw = Playwright.create()){

			Browser browser = pw.chromium()
					.launch(new BrowserType.LaunchOptions()
							.setHeadless(false));
			BrowserContext context = browser.newContext();

			Page page = context.newPage();

			page.navigate("https://letcode.in/");
/*
			page.getByRole(AriaRole.LINK, 
					new Page.GetByRoleOptions()
					.setName(Pattern.compile("Sign up")))
			.click();

			page.getByPlaceholder("Enter your name").fill("Iboo");
			page.getByPlaceholder("Enter valid email address").fill("Ib@mail.com");
			page.getByPlaceholder("Enter your password").fill("123456");
			page.getByRole(AriaRole.CHECKBOX,
					new Page.GetByRoleOptions().setName("agree"))
			.click();
			
			page.getByRole(AriaRole.BUTTON,
					new Page.GetByRoleOptions()
					.setName("SIGN UP"))
			.click();
			
			System.out.println(page.locator("id=toast-container").textContent());

			
			page.getByRole(AriaRole.LINK, 
					new Page.GetByRoleOptions()
					.setName(Pattern.compile("Sign out")))
			.click();
			
			System.out.println(page.locator("id=toast-container").textContent());
*/
			page.getByRole(AriaRole.LINK, 
					new Page.GetByRoleOptions()
					.setName(Pattern.compile("Log in")))
			.click();
			
			
			
			page.getByRole(AriaRole.TEXTBOX,
					new Page.GetByRoleOptions()
					.setName("Enter registered email"))
			.nth(0)
			.fill("Iboo@mail.com");
			
			page.getByPlaceholder("Enter password").fill("123456");

			page.getByRole(AriaRole.BUTTON,
					new Page.GetByRoleOptions()
					.setName("LOGIN"))
			.click();
			
			Thread.sleep(4000);

			
			System.out.println(page.locator("id=toast-container").textContent().split(" ")[2]);

			

			Thread.sleep(4000);

		}


	}

}
