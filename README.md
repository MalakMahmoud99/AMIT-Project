# AMIT-Project
# Demoblaze Automation Project

## Overview
This project is an automated testing solution for the Demoblaze web application. It uses **Selenium WebDriver** for browser automation and **Cucumber** for behavior-driven development (BDD). The tests are written in Java and designed to validate the functionality of the Demoblaze application.

---

## Features
- **Automated Login and Purchase Test**
- **Registration Workflow Validation**
- Supports BDD with readable Gherkin syntax
- Page Object Model (POM) for reusable and maintainable code
- Integration with **Allure Reports** for test reporting

---

## Prerequisites
Make sure you have the following installed:
1. **Java Development Kit (JDK)** 8 or higher
2. **Maven**
3. **IntelliJ IDEA**
4. **Google Chrome** 
5. **Git**

---

## Setup and Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/MalakMahmoud99/AMIT-Project.git
   ```
2. Open the project in IntelliJ IDEA or your preferred IDE.
3. Run the following command to install dependencies:
   ```bash
   mvn clean install
   ```
4. Set up the Allure plugin (if not already configured in your IDE).

---

## Running the Tests

### Using Maven
To execute the tests:
```bash
mvn test
```

### With Tags
Run specific scenarios using tags (e.g., `@test`):
```bash
mvn test -Dcucumber.filter.tags="@test"
```

---

## Project Structure
```
.
├── src
│   ├── main
│   │   ├── java
│   │   │   
│   │   └── resources
│   │       └── Features    # Cucumber feature files
                ├── Loginandpurchase.feature
│   │   │       ├── Register.feature        
│   ├── test
│       ├── java
│       │   ├── GeneralMethods   # Common methods used across tests
│       │   │       └── GeneralMethods.java
└           |── Pages             # Page Object Model classes
│   │   │   |       ├── P01_RegisterPage.java
│   │   │   |       ├── P02_HomePage.java
│   │   │   |       └── P03_Login.java
│       │   ├── TestRunner       # Cucumber Test Runner
│       │   │       └── TestRunner.java
│       │   ├── StepDefinitions  # Step definitions for scenarios
│       │   │       ├── Hooks.java
│       │   │       ├── D01_Register.java
│       │   │       ├── D02_Login.java
│       │   │       └── D03_AddItems.java
│       └── resources            # Test resources (e.g., config files)
├── pom.xml                      # Maven dependencies
└── README.md                    # Project documentation
```

---

## Reporting
This project integrates **Allure Reports** to provide detailed test execution reports. To generate and view reports:
1. Run the tests.
2. Generate the report:
   ```bash
   allure serve target/allure-results
   ```
3. The report will open in your default browser.

---

## Contribution
Feel free to contribute to this project by following these steps:
1. Fork the repository.
2. Create a new branch:
   ```bash
   git checkout -b feature-name
   ```
3. Commit your changes:
   ```bash
   git commit -m "Add a meaningful message"
   ```
4. Push to the branch:
   ```bash
   git push origin feature-name
   ```
5. Create a pull request.

---

## License
This project is licensed under the MIT License. See the LICENSE file for details.

---

## Contact
For any questions or suggestions, feel free to contact:
- **Name**: Malak Mahmoud
- **GitHub**: [MalakMahmoud99](https://github.com/MalakMahmoud99)
