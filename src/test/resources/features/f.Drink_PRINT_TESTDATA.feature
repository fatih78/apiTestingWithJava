@karate @ignore
Feature: Print all Generated Testdata

  Background:
  #    Variable's from Helper class 'TestDataGenerator':
    * def testData = Java.type('utils.TestDataGenerator')
    * def newDrink = karate.get('newDrink') != undefined ? newDrink : testData.generateDrink()
    * def email = karate.get('email') != undefined ? email : testData.generateRandomEmail()
    * def encodedEmail = karate.get('encodedEmail') != undefined ? encodedEmail : testData.generateEncodedEmail()
    * def futureDate = karate.get('futureDate') != undefined ? futureDate : testData.futureDate(1, "yyyy-MM-dd")
    * def currentDate = karate.get('currentDate') != undefined ? currentDate : testData.currentDate()
    * def generateUUID = karate.get('generateUUID') != undefined ? generateUUID : testData.generateUUID()
    * def generateTimeStamp = karate.get('generateTimeStamp') != undefined ? generateTimeStamp : testData.generateTimeStamp()
    * def generateRandomInt = karate.get('generateRandomInt') != undefined ? generateRandomInt : testData.generateRandomInt()
    * def generateRandomAlphaNumeric = karate.get('generateRandomAlphaNumeric') != undefined ? generateRandomAlphaNumeric : testData.generateRandomAlphaNumeric()

  #    x-api-key from the 'Key' class:
    * def key = Java.type('utils.Key')
    * def apiKey = key.getKey()

  #    reading from the 'karate-config.js' file:
    * def secretKey = apiKey2
    * def urlFromConfigFile = baseUrl

  Scenario: Print all Generated Testdata
    * print newDrink
    * print email
    * print encodedEmail
    * print futureDate
    * print currentDate
    * print generateUUID
    * print generateTimeStamp
    * print generateRandomInt
    * print generateRandomAlphaNumeric
    * print apiKey
    * print secretKey
    * print urlFromConfigFile


