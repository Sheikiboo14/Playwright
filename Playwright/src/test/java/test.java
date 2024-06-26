import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class test {

	public static void main(String[] args) {

		

		      try(Playwright palywright = Playwright.create()) {
		    	  
		    	  Browser browser = palywright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		    	  
		    	  BrowserContext context = browser.newContext();
		    	  
		    	  Page page = context.newPage();
		    	  
		          try {
		              // Your code here
		        	  page.navigate("https://letcode.in/");

		              // Keep the browser open for a certain time
		              page.waitForTimeout(5000); // Adjust the timeout as needed

		            } catch (Exception e) {
		              e.printStackTrace();
		            } finally {
		              // Ensure the browser closes properly even if there are exceptions
		              browser.close();
		            }
		          }

}
}

