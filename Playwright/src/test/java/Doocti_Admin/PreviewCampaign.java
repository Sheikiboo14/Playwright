package Doocti_Admin;

import java.util.regex.Pattern;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class PreviewCampaign {

	public static void main(String[] args) {
		
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
		      page.getByText("CRM").click();
		      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("CA Campaigns")).click();
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add Campaign")).click();
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Name").setExact(true)).click();
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Name").setExact(true)).fill("Test Preview");
		      page.locator("div:nth-child(21) > .v-dialog > .v-card > .v-card__text > .v-form > .container > .layout > div:nth-child(2) > .v-input").click();
		      page.getByText("check_box_outline_blankTickets").nth(1).click();
		      page.getByText("check_box_outline_blankMeetings").nth(1).click();
		      page.locator("div:nth-child(23) > .v-dialog > .v-card > .v-card__text > .v-form > .container > .layout > div:nth-child(3) > .v-input > .v-input__control > .v-input__slot > .v-select__slot > .v-select__selections").click();
		      page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Outbound Caller ID")).click();
		      page.locator("a").filter(new Locator.FilterOptions().setHasText("7363129115")).nth(1).click();
		      page.locator("div:nth-child(5) > .autocompleteDiv > .v-input > .v-input__control > .v-input__slot > .v-select__slot > .v-select__selections").click();
		      page.locator("a").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^IT$"))).nth(1).click();
		      page.locator("div:nth-child(23) > .v-dialog > .v-card > .v-card__text > .v-form > .container > .layout > div:nth-child(6) > .autocompleteDiv > .v-input > .v-input__control > .v-input__slot > .v-select__slot > .v-select__selections").click();
		      page.locator("a").filter(new Locator.FilterOptions().setHasText("Test01_Lead")).click();
		      page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Add Queue")).click();
		      page.getByText("check_box_outline_blanktestenv_8633537829").nth(1).click();
		      page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Pause Code")).click();
		      page.getByText("check_box_outline_blankMeeting").nth(2).click();
		      page.getByText("check_box_outline_blankLunch").nth(1).click();
		      page.getByText("check_box_outline_blankTea").nth(1).click();
		      page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Dial Status")).click();
		      page.getByText("check_box_outline_blankAction").nth(3).click();
		      page.getByText("check_box_outline_blankInterested").nth(3).click();
		      page.getByText("check_box_outline_blankNew").nth(3).click();
		      page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Dispo Status")).click();
		      page.getByText("check_box_outline_blankAction").nth(2).click();
		      page.getByText("check_box_outline_blankInterested").nth(2).click();
		      page.getByText("check_box_outline_blankNew").nth(2).click();
		      page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Inbound")).click();
		      page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Inbound")).click();
		      page.locator("a").filter(new Locator.FilterOptions().setHasText("9876543120")).nth(1).click();
		      page.locator("div:nth-child(23) > .v-dialog > .v-card > .v-card__text > .v-form > .container > .layout > div:nth-child(15) > .v-input > .v-input__control > .v-input__slot > .v-select__slot > .v-select__selections").click();
		      page.locator("a").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Testing$"))).nth(1).click();
		      page.locator("div:nth-child(23) > .v-dialog > .v-card > .v-card__text > .v-form > .container > .layout > div:nth-child(18) > .v-input > .v-input__control > .v-input__slot > .v-input--selection-controls__input > .v-input--selection-controls__ripple").click();
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create")).click();
		    }

	}

}
