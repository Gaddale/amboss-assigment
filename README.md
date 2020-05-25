# Task 2: Create automation test framework for custom session functionality

* Automated couple of scenarios

## Tools used

* Selenium with Java, Cucumber and Junit
* Log4J for logging
* Cucumber html for reporting

## Execution

* Default browser is set to `chrome`
* Default url is set to `https://qa-assignment.us.next.medicuja.de/us/`
* Default os is set to `linux`
* Run against chrome and linux `mvn verify -Dbrowser='chrome' -Dos='linux'` 
* Run against firefox and linux `mvn verify -Dbrowser='firefox' -Dos='linux'` 
* Run against specific url `mvn verify -Dbrowser='chrome' -Durl='https://google.co.in'`

## Logging

* Captured logging under file `log/logging.log`

## Reporting

* Cucumber html reports `target/cucumber-html-reports/overview-features.html`

## Note

* Did not test against windows machine, as I work on linux machine.
