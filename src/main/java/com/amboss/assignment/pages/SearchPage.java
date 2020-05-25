package com.amboss.assignment.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.log4j.Logger.getLogger;

public class SearchPage extends BasePage {

  private static Logger logger = getLogger(SearchPage.class.getName());

  private int resultsPerPage = 72, counter = 1;
  private String nextPage = "[aria-label='Next']";
  private By homePageHeader = By.cssSelector("[role=\"navigation\"]");
  private By filterYear = By.cssSelector("[data-qa-selector=\"filter-year\"]");
  private By registrationOptions = By.name("yearRange.min");
  private By filterLoad = By.cssSelector("[data-qa-selector=\"results-amount\"]");
  private By sortDescending = By.name("sort");
  private By pageSize = By.name("pageSize");
  private By resultsDate = By.cssSelector("[data-qa-selector=\"spec-list\"]>li:nth-child(1)");
  private By resultsPrice = By.cssSelector("[data-qa-selector=\"price\"]");
  private By nextPageLocator = By.cssSelector(nextPage);

  public SearchPage(WebDriver driver) {
    super(driver);
  }

  public WebElement getNextPage() {
    return getElement(nextPageLocator);
  }

  public WebElement getHeader() {
    waitForElementToLoad(homePageHeader);
    return getElement(homePageHeader);
  }

  public WebElement getNumberOfResults() {
    return getElement(filterLoad);
  }

  public WebElement getFilterYear() {
    return getElement(filterYear);
  }

  public WebElement getRegistrationOptions() {
    return getElement(registrationOptions);
  }

  public WebElement getSortDropDown() {
    return getElement(sortDescending);
  }

  public WebElement getPageSize() {
    return getElement(pageSize);
  }

  public void applyFilterYear(Integer year) {
    getFilterYear().click();
    getRegistrationOptions().click();
    Select selectEleYear = new Select(getRegistrationOptions());
    selectEleYear.selectByVisibleText(year.toString());
    waitForSearchResults(filterLoad, "Lädt...");
  }

  public void sortByDescending() {
    Select selectSort = new Select(getSortDropDown());
    selectSort.selectByVisibleText("Höchster Preis");
    waitForSearchResults(filterLoad, "Lädt...");
  }

  public void increaseResultsPerPage(Integer resultsPerPage) {
    Select selectResultsPerPage = new Select(getPageSize());
    selectResultsPerPage.selectByVisibleText(resultsPerPage.toString());
    waitForSearchResults(filterLoad, "Lädt...");
  }

  private int getTotalPageCount() {
    int total;
    int temp = Integer.parseInt(getNumberOfResults().getText().split(" ")[0].trim().replace(".",""));
    if (temp % resultsPerPage == 0) {
      total = temp / resultsPerPage;
    } else {
      total = (temp / resultsPerPage) + 1;
    }
    return total;
  }

  private void clickNextPage() {
    waitForSearchResults(filterLoad, "Lädt...");
    visibilityOfElementLocatedCss(nextPage);
    getNextPage().click();
    waitForSearchResults(filterLoad, "Lädt...");
  }

  public Map<Integer, List> captureAllResultsYearAndPrice() {
    int pagesToBeTraversed = getTotalPageCount();
    List<Integer> allYearRecords = new ArrayList<>();
    List<Double> allPricesRecords = new ArrayList<>();
    Map<Integer, List> listMap = new HashMap<>();
    while (counter <= pagesToBeTraversed) {
      List<WebElement> dateElements = driver.findElements(resultsDate);
      List<WebElement> amountElements = driver.findElements(resultsPrice);
      for (int i = 0; i < dateElements.size(); i++) {
        String dateValue = dateElements.get(i).getText().substring(5).trim();
        String tmpValue = amountElements.get(i).getText();
        String amount = tmpValue.substring(0, tmpValue.indexOf(" ")).trim();
        allYearRecords.add(Integer.parseInt(dateValue));
        allPricesRecords.add(Double.parseDouble(amount));
      }
      scrollDown();
      if (counter != pagesToBeTraversed) {
        clickNextPage();
      }
      counter++;
    }
    listMap.put(1, allYearRecords);
    listMap.put(2, allPricesRecords);
    return listMap;
  }

  public boolean checkLesserValueForYear(Integer year, List<Integer> listToBeChecked) {
    List<Boolean> allRecords = new ArrayList<>();
    for (int yearCount = 0; yearCount < listToBeChecked.size(); yearCount++) {
      logger.info("Result No "+yearCount+ ": Year appeared : "+listToBeChecked.get(yearCount));
      if (listToBeChecked.get(yearCount) < year) {
        allRecords.add(Boolean.parseBoolean(String.valueOf(false)));
      } else {
        allRecords.add(Boolean.parseBoolean(String.valueOf(true)));
      }
    }
    for (boolean b : allRecords) if (!b) return false;
    return true;
  }

  public boolean checkPriceDescendingOrder(List<Double> listToBeChecked) {
    for (int priceCount = 1; priceCount < listToBeChecked.size(); priceCount++) {
      if (listToBeChecked.get(priceCount - 1) < listToBeChecked.get(priceCount)) {
        return false;
      }
    }
    return true;
  }
}
