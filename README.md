# Capstone-CP-087-WatchNext

# WatchNext – Genre-Preference Content Recommendation Engine

WatchNext is a console-based Java application designed to recommend movies and other content based on users' genre preferences and watching history. It allows users to add content, record watched titles and ratings, calculate genre preference scores, receive personalized recommendations, and view trending content based on recorded views during the last seven days.

This project was developed as an academic capstone project to demonstrate Java programming, array handling, conditional statements, loops, sorting, and basic recommendation system logic.

## Features

- **Content Management:** Add new content with title, genre, and language.
- **View Content:** Display all available content.
- **Watch History:** Record watched titles and user ratings.
- **Genre Preference Calculation:** Calculate preference scores based on ratings given to different genres.
- **Content Recommendations:** Recommend up to five unwatched titles matching user preferences.
- **Trending Content:** Display popular titles based on recorded views during the last seven days.
- **Input Validation:** Handle invalid menu choices and user inputs.

## Recommendation System Workflow

```text
User Adds Content
       |
       v
Record Watched Titles
       |
       v
Collect User Ratings
       |
       v
Calculate Genre Preferences
       |
       v
Find Unwatched Content
       |
       v
Rank Matching Content
       |
       v
Display Top 5 Recommendations
```

## Technologies Used

- Java
- Java Arrays
- Scanner Class
- Conditional Statements
- Loops
- Sorting and Ranking
- Java Date and Time API (LocalDate)

## Project Structure

```text
CP087-WatchNext-Java/
├── Main.java
└── README.md
```

## Getting Started

### Prerequisites

- Java Development Kit (JDK 21 or compatible version)
- Visual Studio Code or any Java-supported IDE
- Command Prompt or Terminal
- Git

Check Java installation:

```bash
java -version
javac -version
```

### Installation and Execution

Clone the repository:

```bash
git clone https://github.com/singh459/WatchNext--Genre-Preference-Content-Recommendation-Engine
```

Navigate to the project directory:

```bash
cd CP087-WatchNext-Java
```

Compile the program:

```bash
javac Main.java
```

Run the application:

```bash
java Main
```

## Application Menu

```text
========== WATCHNEXT ==========

1. Add New Content
2. View All Content
3. Record Watched Content and Rating
4. View Watch History
5. Calculate Genre Preferences
6. Get Top 5 Recommendations
7. View Trending Content (Last 7 Days)
8. Exit
```

## Sample Content

```text
----- CONTENT DETAILS -----

Title: Inception
Genre: Sci-Fi
Language: English
```

## Sample Genre Preference

```text
----- GENRE PREFERENCES -----

Sci-Fi: 8.5
Horror: 5.0
```

## Sample Trending Content

```text
----- TRENDING CONTENT (LAST 7 DAYS) -----

1. Inception - 2 views
2. Interstellar - 1 view
3. The Conjuring - 1 view
```

*Note: The above outputs are examples. Actual results depend on the content and watch records entered by the user. Each recorded watch entry is counted as one view.*

## Learning Outcomes

- Understanding Java programming fundamentals.
- Working with arrays to store and manage data.
- Using loops and conditional statements.
- Implementing a basic recommendation system.
- Calculating genre preference scores using ratings.
- Ranking and displaying recommended content.
- Working with Java Date and Time API.
- Developing problem-solving and debugging skills.

## Future Enhancements

- Database integration for permanent data storage.
- User login and registration.
- Graphical user interface.
- Language-based content filtering.
- Explanation for each recommendation.
- Integration with external movie APIs.
- Advanced recommendation algorithms.

## Project Information

- **Project Name:** WatchNext – Genre-Preference Content Recommendation Engine
- **Project Code:** CP-087
- **Project Type:** Academic Capstone Project
- **Language:** Java
- **Application Type:** Console-Based Application
- **Domain:** Java Programming / Recommendation Systems

---

Developed as an academic capstone project to explore Java programming and personalized content recommendation techniques.