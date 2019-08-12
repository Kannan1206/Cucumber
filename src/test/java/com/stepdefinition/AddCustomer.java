package com.stepdefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddCustomer {
	static WebDriver driver;
	@Given("User launch the browser")
	public void user_launch_the_browser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\KANNAN A\\eclipse-workspace\\WebDriver\\Driver\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("http://demo.guru99.com/telecom/");
	}
	
	@When("User click the add customer")
	public void user_click_the_add_customer() {
		driver.findElement(By.xpath("//a[text()='Add Customer']")).click();
	}

	@When("Entered valid details")
	public void entered_valid_details(io.cucumber.datatable.DataTable dataTable) {
	   List	<String> onedlist = dataTable.asList();
	   driver.findElement(By.xpath("//label[text()='Done']")).click();
	    driver.findElement(By.id("fname")).sendKeys(onedlist.get(0));
	    driver.findElement(By.id("lname")).sendKeys(onedlist.get(1));
	    driver.findElement(By.id("email")).sendKeys(onedlist.get(2));
	    driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys(onedlist.get(3));
	    driver.findElement(By.id("telephoneno")).sendKeys(onedlist.get(4));
	    driver.findElement(By.xpath("//input[@name='submit']")).click();
	   }

	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
		Assert.assertTrue(driver.findElement(By.xpath("(//td[@align='center'])[2]")).isDisplayed());
	}
}