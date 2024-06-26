import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Playwright;

public class playwrightmanager {

	private Playwright playwright;

	private Browser browser;

	private BrowserContext incognitocontext;
	
	public  playwrightmanager() {
		
		playwright = Playwright.create();
		
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		incognitocontext = browser.newContext();
		
	}

	public BrowserContext getIncogniticontext() {
		return incognitocontext;
		
	}
	
	public void close() {
		
		if(incognitocontext !=null) {
			
			incognitocontext.close();
			
		}
		
	    if (browser != null) {
	        browser.close();
	      }
	      if (playwright != null) {
	        playwright.close();
	      }
	}
}
