import java.time.Duration;
import java.time.LocalDate;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestData {

	String TheWebsiteURL = "https://www.almosafer.com/en";
	WebDriver driver = new ChromeDriver();
	String ExpectedCurrency = "SAR";
	String ExpectedContactNo = "+966554400000";
	String ExpectedCheckHotelTabIsNotSeleced = "false";

	LocalDate date = LocalDate.now();
	int tomorrow = date.plusDays(1).getDayOfMonth();
	String tomorrowAsFormatedValue = String.format("%02d", tomorrow);

	int DayAfterTomorrow = date.plusDays(2).getDayOfMonth();

	String[] websites = { "https://www.almosafer.com/en", "https://www.almosafer.com/ar" };
	Random rand = new Random();
	int randomIndex = rand.nextInt(websites.length);

	String[] englishCities = { "Dubai", "Jeddah", "Riyadh" };
	int randomEnglishCity = rand.nextInt(englishCities.length);

	String[] arabicCities = { "دبي", "جدة" };
	int randomArabicCity = rand.nextInt(arabicCities.length);

	String[] values = { "A", "B" };
	int randomvalue = rand.nextInt(values.length);

	public void Setup() {

		driver.get(TheWebsiteURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();

		WebElement SettingButtonEn = driver
				.findElement(By.cssSelector(".sc-jTzLTM.cta__button.cta__saudi.btn.btn-primary"));
		// WebElement SettingButtonAr = driver
		// .findElement(By.cssSelector(".sc-jTzLTM.eJkYKb.cta__button.cta__saudi btn
		// btn-primary"));
		SettingButtonEn.click();

	}

}
