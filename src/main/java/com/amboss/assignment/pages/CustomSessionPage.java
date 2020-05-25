package com.amboss.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomSessionPage extends BasePage {

    private final By inputQuestionNumber = By.cssSelector("[data-e2e-test-id='inputQuestionNumber'] input");
    private final By startExamButton = By.cssSelector("[data-e2e-test-id='buttonCreateSession'] button");
    private final By selectExamSimulation = By.name("examSimulation");
    private final By doneButton = By.cssSelector("[data-e2e-test-id='buttonDone']");
    private final By sessionTitle = By.cssSelector("[data-e2e-test-id='sessionTitle']");
    private final By questionsCount = By.cssSelector("[data-e2e-test-id='sessionQuestionCount']");
    private final By search = By.cssSelector("[data-e2e-test-id='filterModalSearch'] input");
    private final By difficultyCheckBox = By.cssSelector("[data-e2e-test-id='checkbox-Difficulty']");
    private final By selectAllDifficulty = By.cssSelector("[data-e2e-test-id='checkbox-neutral_checked']");
    private final By titleToggleButton = By.cssSelector("[data-e2e-test-id='automatic-title-toggle'] input");
    private final By titleTextField = By.cssSelector("[data-e2e-test-id='modalInput']");
    private final By resetButton = By.cssSelector("[data-e2e-test-id='CustomSessionPage'] button");

    private final String questionCountLocator = "[data-e2e-test-id='sessionQuestionCount']";

    public CustomSessionPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getInputQuestionNumber() {
        return getElement(inputQuestionNumber);
    }

    public WebElement getResetButton() {
        return getElement(resetButton);
    }

    public WebElement getExamSimulation() {
        return getElement(selectExamSimulation);
    }

    public WebElement getTitleTextField() {
        return getElement(titleTextField);
    }

    public WebElement getTitleToggleButton() {
        return getElement(titleToggleButton);
    }

    public WebElement getSelectAllDifficulty() {
        return getElement(selectAllDifficulty);
    }

    public WebElement getDifficultyCheckBox() {
        return getElement(difficultyCheckBox);
    }

    public WebElement getDoneButton() {
        return getElement(doneButton);
    }

    public WebElement getSearch() {
        return getElement(search);
    }

    public WebElement getStartExamButton() {
        return getElement(startExamButton);
    }

    public WebElement getSessionTitle() {
        return getElement(sessionTitle);
    }

    public WebElement getQuestionsCount() {
        visibilityOfElementLocatedCss(questionCountLocator);
        return getElement(questionsCount);
    }

    public void enterQuestionNumber(int questionNumber) {
        getInputQuestionNumber().click();
        getInputQuestionNumber().clear();
        getInputQuestionNumber().sendKeys(Integer.toString(questionNumber));
    }

    public void clickStartButton() {
        getStartExamButton().click();
    }

    private void clickAllOptions() {
        driver.findElements(By.xpath("//*[@data-test-id='checkbox']//*[@data-e2e-test-id='checkbox-neutral_checked']"))
                .get(0).click();
    }

    public void selectOptions(String topic, String searchOptions) {
        driver.findElement(By.cssSelector("[data-e2e-test-id='checkbox-" + topic + "']")).click();
        getSearch().sendKeys(searchOptions);
        clickAllOptions();
        getDoneButton().click();
    }

    public void setFilterDifficulty() {
        getDifficultyCheckBox().click();
        getSelectAllDifficulty().click();
        getDoneButton().click();
    }

    public void customSessionTitleName(String customSessionTitle) {
        getTitleToggleButton().click();
        getTitleTextField().clear();
        getTitleTextField().sendKeys(customSessionTitle);
    }

    public void selectExamOption() {
        getExamSimulation().click();
    }

    public void resetOptions() {
        getResetButton().click();
    }

    public String getNoOfQuestions() {
        return getInputQuestionNumber().getAttribute("value");
    }
}
