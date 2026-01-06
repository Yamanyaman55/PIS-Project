package com.parcel.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SeleniumScenarios {

    private static WebDriver driver;
    private static WebDriverWait wait;
    // Assuming Frontend runs on port 3000 based on standard React apps and typical
    // docker-compose.
    // Will verify with docker-compose.yaml content and update if needed.
    private static String BASE_URL = "http://localhost:3000";

    @BeforeAll
    static void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // Better headless mode
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--remote-allow-origins=*");
        // Explicitly set binary path for Jenkins/Linux environments if standard path
        // fails
        options.setBinary("/usr/bin/chromium");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Allow overriding URL via system property
        String envUrl = System.getProperty("app.url");
        if (envUrl != null && !envUrl.isEmpty()) {
            BASE_URL = envUrl;
        }
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Order(1)
    @DisplayName("Scenario 1: Send Parcel (Nadaj Paczkę)")
    void testSendParcel() {
        driver.get(BASE_URL);

        // Find Tracking Form container
        WebElement form = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("tracking-form")));

        // Input Tracking Number
        WebElement trackingInput = form.findElement(By.tagName("input"));
        trackingInput.clear();
        trackingInput.sendKeys("JP123456789");

        // Select Carrier (InPost)
        WebElement carrierOption = form
                .findElement(By.xpath(".//div[contains(@class, 'carrier-option') and .//p[text()='InPost']]"));
        carrierOption.click();

        // Click "Nadaj Paczkę"
        WebElement submitButton = form.findElement(By.xpath(".//button[text()='Nadaj Paczkę']"));
        submitButton.click();

        // Wait for potential network request/UI update - simplified check
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    @Test
    @Order(2)
    @DisplayName("Scenario 2: Search Parcel")
    void testSearchParcel() {
        driver.get(BASE_URL);

        WebElement searchContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search")));
        WebElement searchInput = searchContainer.findElement(By.tagName("input"));
        searchInput.clear();
        searchInput.sendKeys("JP123456789");

        WebElement searchButton = searchContainer.findElement(By.xpath(".//button[text()='Szukaj']"));
        searchButton.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    @Test
    @Order(3)
    @DisplayName("Scenario 3: Generate Report")
    void testGenerateReport() {
        driver.get(BASE_URL);

        WebElement searchContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search")));
        WebElement reportButton = searchContainer.findElement(By.xpath(".//button[text()='Wygeneruj raport']"));
        reportButton.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
}
