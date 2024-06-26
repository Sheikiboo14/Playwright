package Tasks;

import java.util.List;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class Task_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
	
		
		Playwright palywright = Playwright.create();
		
		Page page = palywright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false)).newPage();
		
		page.navigate("https://letcode.in/dropdowns");
		
		Locator fruitDD = page.locator("#fruits");
		fruitDD.selectOption("2");
		
		Locator herosDD = page.locator("#superheros");
		
		herosDD.selectOption(new SelectOption().setLabel("Iron Man"));
		
		Locator languageDD = page.locator("#lang");
		
		Locator options = languageDD.locator("option");
		
		List<String> allText = options.allInnerTexts();
		
		for (String Text : allText) {
			
			System.out.println(Text);
	
		}
		
		int langcount = options.count();

		languageDD.selectOption(new SelectOption().setIndex(langcount-1));

	}

}
