import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTest extends TestData {

	@BeforeTest
	public void MySetup() {
		Setup();
	}

	@Test(priority = 1)
	public void CheckWebsiteLanguage() {
		String ActualLanguage = driver.findElement(By.tagName("html")).getDomAttribute("lang");
		String ExpectedLanguage = "en";
		Assert.assertEquals(ActualLanguage, ExpectedLanguage);
	}

	@Test(priority = 2)
	public void CheckCurrency() {

		String ActualCurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']"))
				.getText();

		Assert.assertEquals(ActualCurrency, ExpectedCurrency);

	}

	@Test(priority = 3)
	public void CheckContactNo() {
		String ActualContactNo = driver.findElement(By.linkText("+966554400000")).getText();

		Assert.assertEquals(ActualContactNo, ExpectedContactNo);
	}

	@Test(priority = 4)
	public void CheckQitafLogo() {

		WebElement TheFooter = driver.findElement(By.tagName("footer"));
		boolean ActualImageIsDisplayed = TheFooter.findElement(By.cssSelector(".sc-ekulBa.iOOTo"))
				.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-lcpuFF.jipXfR")).isDisplayed();
		// System.out.println(ActualImageIsDisplayed);
		Assert.assertEquals(ActualImageIsDisplayed, true);
	}

	@Test(priority = 5)
	public void CheckHotelTabIsNotSeleced() {
		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String ActualValue = HotelTab.getDomAttribute("aria-selected");

		Assert.assertEquals(ActualValue, ExpectedCheckHotelTabIsNotSeleced);
	}

	@Test(priority = 6)
	public void FlightDepatureDate() {

		List<WebElement> dates = driver.findElements(By.cssSelector(".sc-dXfzlN.iPVuSG"));
		String ActualdepatureDate = dates.get(0).getText();
		Assert.assertEquals(ActualdepatureDate, tomorrowAsFormatedValue);
	}

	@Test(priority = 7)
	public void FlightReturnDate() {
		List<WebElement> dates = driver.findElements(By.cssSelector(".sc-dXfzlN.iPVuSG"));
		String ActualReturnDate = dates.get(1).getText();
		String DayAfterTomorrowAsFormatedValue = String.format("%02d", DayAfterTomorrow);
		Assert.assertEquals(ActualReturnDate, DayAfterTomorrowAsFormatedValue);
	}

	@Test(priority = 8)
	public void ChangeTheWebsiteLanguage() {
		driver.get(websites[randomIndex]);

//		if (driver.getCurrentUrl().contains("en")) {
//			CheckWebsiteLanguage("en");
//		} else {
//			CheckWebsiteLanguage("ar");
//		}

	}

	@Test(priority = 9)
	public void RandomlySelectCity() {
		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		HotelTab.click();
		WebElement SearchInputFeild = driver.findElement(By.cssSelector(".sc-phbroq-2.uQFRS.AutoComplete__Input"));

		if (driver.getCurrentUrl().contains("en")) {

			SearchInputFeild.sendKeys(englishCities[randomEnglishCity]);

		} else {
			SearchInputFeild.sendKeys(arabicCities[randomArabicCity]);
		}
		WebElement SelectVisitorNumber = driver.findElement(By.cssSelector(".sc-tln3e3-1.gvrkTi"));
		Select mySelctor = new Select(SelectVisitorNumber);

		mySelctor.selectByValue(values[randomvalue]);
		driver.findElement(By.cssSelector(".sc-1vkdpp9-5.btwWVk")).click();
	}

	@Test(priority = 10)
	public void CheckTheResultIsRetrived() throws InterruptedException {
		Thread.sleep(10000);
		String Results = driver.findElement(By.xpath("//span[@data-testid='srp_properties_found']")).getText();
		System.out.println(Results + "@@@@@@@@");

		if (driver.getCurrentUrl().contains("en")) {
			Assert.assertEquals(Results.contains("found"), true);
		} else {
			Assert.assertEquals(Results.contains("مكان اقامة"), true);

		}
	}

	public void AfterMyTest() {

	}
}
