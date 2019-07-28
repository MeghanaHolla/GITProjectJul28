package kdf;

import java.io.IOException;

import org.testng.annotations.Test;

import utils.GenericMethods;

public class Application {
	
	@Test
	public void applicationTest() throws IOException {
		String[][] data = GenericMethods.getData("D:\\SelJun30\\TestData.xlsx", "Sheet2");
		for(int i =1; i<data.length;i++) {
			switch(data[i][3]) {
			case "openBrowser":
				Methods.openBrowser();
				break;
			case "maxBrowser":
				Methods.maximizeBrowserWindow();
				break;
			case "impWait":
				Methods.implicitWait();
				break;
			case "navToApp":
				Methods.navigateToAUT(data[i][6]);
				break;
			case "enterUserID":
				Methods.enterUserID(data[i][4],data[i][5], data[i][6]);
				break;
			case "enterPassword":
				Methods.enterPassword(data[i][4],data[i][5], data[i][6]);
				break;
			case "clickSignIn":
				Methods.clickSignIn(data[i][4],data[i][5]);
				break;
			case "verifyErrMsg":
				Methods.verifyErrorMessage(data[i][5], data[i][6]);
				break;
			case "closeApp":
				Methods.closeApplication();
				break;
			}
		}
	}

}
