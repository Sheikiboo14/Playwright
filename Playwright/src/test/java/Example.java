import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

public class Example {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      page.navigate("http://localhost:8080/v2.1.106/auth/login");
      page.getByPlaceholder("User Name").click();
      page.getByPlaceholder("User Name").fill("testenv_admin@doocti.com");
      page.getByLabel("Password").fill("o");
      page.getByLabel("Password").click();
      page.getByLabel("Password").fill("Doocti@123");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
      page.navigate("http://localhost:8080/v2.1.106/realtime/live-agents");
      page.getByText("Configurations").click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("TI Ticket Status")).click();
      page.locator("nav").filter(new Locator.FilterOptions().setHasText("menu User Licenses: 4")).getByRole(AriaRole.BUTTON).click();
      page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName("Thing thing Active")).locator("i").first().click();
      page.locator(".v-select__selections").first().click();
      page.locator("a").filter(new Locator.FilterOptions().setHasText("Inactive")).nth(1).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Update")).click();
    }
  }
}