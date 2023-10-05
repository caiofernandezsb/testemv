## Anagram Service

This project provides an Anagram Service and API developed for evaluation purposes, specifically for MV Informatica's DEV III hiring process.

### Index

1. [Requirements](#requirements)
2. [Project Configuration](#project-configuration)
3. [Anagram Service](#anagram-service)
4. [Usage](#usage)
5. [Exception Handling](#exception-handling)
6. [Contributing](#contributing)
7. [API Endpoint](#api-endpoint)
8. [API Usage](#api-usage)
9. [Running Tests](#running-tests)

### Requirements

Ensure you have the following installed:

- [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Git](https://git-scm.com/)
- [Gradle](https://gradle.org/install/)

### Project Configuration

In order to properly run the project in your local environment, follow the steps below:

1.  **Clone the Project:**
   git clone https://github.com/caiofernandezsb/testemv.git

2. **Proceed to the Project Directory:**
   cd testemv

3. **Compile:**
  ./gradlew build<br>

*By using this command your computer is going to compile the project and create an executable JAR file*

4. **Run:**
  In order to initiate the Spring Boot app, use the following command:
  ./gradlew bootRun<br>

*The app will be available at http://localhost:8080*

### Anagram Service

The Anagram Service offers functionality to check whether two words are anagrams. Anagrams are words or phrases formed by rearranging the letters of another, using all the original letters exactly once.

### Usage

To use the Anagram Service, follow these steps:

1. **Instantiate the anagram service:**
   
   AnagramService anagramService = new AnagramService();

2. **Check whether words are anagrams:**
   
   String firstWord = "listen";<br>
   String secondWord = "silent";<br>
   
   boolean areAnagrams = anagramService.checkWhetherIsAnagram(firstWord, secondWord);

This method returns true if the provided words are anagrams and false otherwise.

**Note:** The service considers words with different lengths as invalid anagrams and checks for the presence of numeric or special characters.

### Exception Handling

The Anagram Service throws a NonLetterCharacterException if a word contains special characters or numbers. Handle this exception appropriately in your application.

   try {<br>
   		// your code that uses the Anagram Service<br>
   	} catch (NonLetterCharacterException e) {<br>
	    // Handle the exception, e.g., log it or return an error response<br>
	    System.err.println("NonLetterCharacterException: " + e.getMessage());
	}


**The API handles the NonLetterCharacterException thrown by the Anagram Service when a word contains special characters or numbers. In such cases, a 400 Bad Request response is returned with an error message.**

{
  "error": "Erro - Foi detectado caractere especial ou numérico"
}

### Contributing

If you would like to contribute to the Anagram Service, feel free to fork the repository, make improvements, and create a pull request.

### API Endpoint	

URL: /areanagrams/{firstWord}/{secondWord}<br>
Method: GET<br>
Response Format: JSON

### API Usage

To check whether two words are anagrams, make a GET request to the /areanagrams/{firstWord}/{secondWord} endpoint with the two words as path variables.

**Example Request:**

curl -X GET "http://localhost:8080/areanagrams/listen/silent"

**Example Response (Anagrams):**

{<br>
  "result": true<br>
}

**Example Response (Not Anagrams):**

{<br>
  "result": false<br>
}

### Running Tests

To run the tests, execute the following command in your project directory:

./gradlew test

***Test Cases:***

*Positive Test Cases*

Case 1: Words "listen" and "silent" are anagrams.<br>
Case 2: Words "abc" and "bca" are anagrams.<br>
Case 3: Words "LUA" and "ula" are anagrams.

*Negative Test Cases*

Case 4: Words "hello" and "world" are not anagrams.<br>
Case 5: Words "abc" and "abcd" are not anagrams.<br>
Case 6: Words "abcf" and "abcd" are not anagrams.

*Exception Handling Test Cases*

Case 7: Exception thrown for a word containing a special character.<br>
Case 8: Exception thrown for a word containing a numeric character.