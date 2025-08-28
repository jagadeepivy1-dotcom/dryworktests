# Selenium Java Assignment

## Overview
Automates registration and login on [LambdaTest Ecommerce Playground](https://ecommerce-playground.lambdatest.io/index.php) using Selenium WebDriver and TestNG.

## Features
- Register a new user and login
- Reusable utilities and common methods
- Logical test organization
- Setup and teardown with TestNG annotations
- Assertions for validation
- Clean code practices
- Supports headless and headed modes

## Prerequisites
- Java 8+
- Maven

## Setup
1. Clone this repository
2. Run `mvn clean install` to download dependencies

## Running Tests
- Headed mode: `mvn test -Dheadless=false`
- Headless mode: `mvn test -Dheadless=true`

## Project Structure
- `src/main/java/com/ecommerce/pages`: Page Object classes
- `src/main/java/com/ecommerce/util`: Utility classes
- `src/test/java/com/ecommerce/tests`: Test classes

## Customization
- Update test data in test classes as needed

## Contact
For questions, contact the maintainer.
