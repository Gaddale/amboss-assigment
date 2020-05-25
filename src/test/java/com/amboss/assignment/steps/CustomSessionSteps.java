package com.amboss.assignment.steps;

import com.amboss.assignment.Configuration;
import com.amboss.assignment.pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

import static org.apache.log4j.Logger.getLogger;
import static org.assertj.core.api.Assertions.assertThat;

public class CustomSessionSteps {
    private static final int noOfQuestions = 5;
    private static final String customTitle = "Custom Session Title";

    private static Logger logger = getLogger(CustomSessionSteps.class.getName());
    private LoginPage loginPage = PageFactory.getInstance(LoginPage.class);
    private DashboardPage dashboardPage = PageFactory.getInstance(DashboardPage.class);
    private CustomSessionPage customSessionPage = PageFactory.getInstance(CustomSessionPage.class);
    private ExamPage examPage = PageFactory.getInstance(ExamPage.class);
    private AnalysisPage analysisPage = PageFactory.getInstance(AnalysisPage.class);

    @Given("^user is on custom session page$")
    public void userIsOnCustomSessionPage() {
        loginPage.login();
        dashboardPage.navigateToCustomSession();
        logger.info("Landed on Custom Session Page");
    }

    @When("^user starts the new custom session$")
    public void userStartsTheNewCustomSession() {
        customSessionPage.clickStartButton();
        logger.info("Started the session");
    }

    @Then("^user should see exam started$")
    public void userShouldSeeExamStarted() {
        assertThat(customSessionPage.getSessionTitle().isDisplayed()).isTrue();
    }

    @And("^Analysis page should be displayed once session is completed$")
    public void analysisPageShouldBeDisplayedOnceSessionIsCompleted() {
        logger.info("Simulate Exam");
        examPage.simulateExam(noOfQuestions);
        logger.info("End Block");
        examPage.getEndBlockButton().click();
        assertThat(analysisPage.getAnalysisSection().isDisplayed()).isTrue();
    }

    @And("^user should see default number of questions as \"([^\"]*)\"$")
    public void userShouldSeeDefaultNumberOfQuestionsAs(String text) {
        logger.info("Assert default number of questions");
        assertThat(customSessionPage.getQuestionsCount().getText().contains(text)).isTrue();
    }

    @When("^user sets questions and filters$")
    public void userStartsTheNewCustomSessionWithQuestionsAndFilters() {
        logger.info("Set questions and filters");
        customSessionPage.selectOptions(Configuration.TOPIC.getValue(), Configuration.SEARCH_OPTIONS.getValue());
        customSessionPage.setFilterDifficulty();
        customSessionPage.customSessionTitleName(customTitle);
        customSessionPage.selectExamOption();
        customSessionPage.enterQuestionNumber(noOfQuestions);
    }

    @Then("^user should see exam started with end block$")
    public void userShouldSeeExamStartedWithEndBlock() {
        logger.info("Assert new session started");
        assertThat(examPage.getEndBlock().isDisplayed()).isTrue();
    }

    @And("^user reset the session options$")
    public void userResetTheSessionOptions() {
        logger.info("Reset Options");
        customSessionPage.resetOptions();
    }

    @Then("^user should see the custom options reset to default values$")
    public void userShouldSeeTheCustomOptionsResetToDefaultValues() {
        logger.info("Assert default settings is restored");
        assertThat(customSessionPage.getNoOfQuestions().contains("40")).isTrue();
        assertThat(customSessionPage.getStartExamButton().isSelected()).isFalse();
    }
}
