package br.ce.wcaquino.runners;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/",
		glue = {"br.ce.wcaquino.steps", "br.ce.wcaquino.config"},
		tags = "@funcionais",
		plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
		monochrome = false,
		snippets = SnippetType.CAMELCASE,
		dryRun  = false, //Validar se o mapeamento está correto - util para validar quando temos vários cenários - padrão é false
		strict = false
		)
public class RunnerFuncionalTest {
	
	@BeforeClass
	
	public static void reset() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chrome\\85\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://srbarriga.herokuapp.com/login");
		driver.findElement(By.id("email")).sendKeys("elvercio@mail.com");
		driver.findElement(By.name("senha")).sendKeys("123456");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.linkText("reset")).click();
		driver.quit();
	}

}
