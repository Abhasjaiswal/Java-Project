# Java Quiz Application

A desktop quiz application built with Java Swing that tests programming knowledge through 10 multiple-choice questions.

![Quiz Application]

## Features

- Modern UI with gradient headers and custom styling
- User login with name input
- 10 multiple-choice programming questions
- Automatic scoring (5 points per question)
- Performance feedback with color-coded results
- Simple navigation between questions

## Installation

1. Clone the repository:

```bash
git clone https://github.com/Abhasjaiswal/Java-Project
```

2. Compile the application:

```bash
javac src/quizApplication/*.java -d bin/
```

3. Run the application:

```bash
java -cp bin quizApplication.mainPage
```

## Project Structure

- `mainPage.java`: Entry point and login screen
- `startPage.java`: Instructions and welcome screen
- `q1.java` through `q10.java`: Individual question pages
- `score.java`: Manages score tracking between screens
- `resultPage.java`: Displays final results and feedback

## Future Enhancements

- Database integration for question storage
- User account system with password protection
- Timer functionality for timed quizzes
- Question categories and difficulty levels
