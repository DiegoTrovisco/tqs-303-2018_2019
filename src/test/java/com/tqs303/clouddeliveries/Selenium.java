package com.tqs303.clouddeliveries;

import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SeleniumExtension.class)
class Selenium {

  @LocalServerPort private int port;

  @Test
  void viewRequest(FirefoxDriver driver) {

    driver.get("http://localhost:" + port + "/");
    driver.findElement(By.linkText("Login")).click();
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("tqs");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("tqs");
    driver
        .findElement(
            By.xpath(
                "(.//*[normalize-space(text()) and normalize-space(.)='Password'])[1]/following::b[1]"))
        .click();
    driver.findElement(By.linkText("See Requests")).click();
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("tqs");
    driver
        .findElement(
            By.xpath(
                "(.//*[normalize-space(text()) and normalize-space(.)='Search request by Username'])[1]/following::button[1]"))
        .click();
  }

  @Test
  void updateRequest(FirefoxDriver driver) {
    driver.get("http://localhost:" + port + "/");
    driver.findElement(By.linkText("Login")).click();
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("test");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("admin");
    driver
        .findElement(
            By.xpath(
                "(.//*[normalize-space(text()) and normalize-space(.)='Password'])[1]/following::b[1]"))
        .click();
    driver.findElement(By.linkText("Edit Requests")).click();
    driver.findElement(By.id("idpedido")).click();
    driver.findElement(By.id("idpedido")).clear();
    driver.findElement(By.id("idpedido")).sendKeys("16");
    driver
        .findElement(
            By.xpath(
                "(.//*[normalize-space(text()) and normalize-space(.)='Search request by ID'])[1]/following::b[1]"))
        .click();
    driver
        .findElement(
            By.xpath(
                "(.//*[normalize-space(text()) and normalize-space(.)='Weight (kg)'])[1]/following::button[1]"))
        .click();
  }
}
