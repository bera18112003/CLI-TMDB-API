# cli-tmdb-app
CLI for fetching data from movie database (tmdb) and displaying it on the terminal.

## Features
- Fetch movies by type: **Now Playing, Popular, Top Rated, Upcoming**  
- Display movie **title, release date, and rating** in the terminal  
- Easy-to-use CLI powered by **Picocli**  

---
## Prerequisites
- **Java 17** or higher  
- **Maven** for building the project  
- **TMDB API Key** (v3 or v4 Read Access Token)  
---

## Installation & Setup

**Clone the repository:**

- git clone https://github.com/Abhishek-ghosh-03/cli-tmdb-app.git
- cd cli-tmdb-app

---
**Setup Your Own Api**
- Place an api key by generating it from the tmdb website
private final String API_KEY = ""; 

---
**Build the project using Maven:**

- mvn clean package


- This generates a fat JAR in target/tmdb-app-1.0.0.jar.

---
**CLI commands for testing**

- java -jar target/tmdb-app-1.0.0.jar --type popular
- java -jar target/tmdb-app-1.0.0.jar --type playing
- java -jar target/tmdb-app-1.0.0.jar --type top
- java -jar target/tmdb-app-1.0.0.jar --type upcoming

---
**Dependencies**

Picocli
 → CLI argument parsing

OkHttp
 → HTTP requests

Jackson
 → JSON parsing

---
**Workflow**
- ![WhatsApp Image 2025-08-23 at 12 16 30 AM](https://github.com/user-attachments/assets/26e911db-2f92-4437-993f-a9e4e4521d51)
- ![WhatsApp Image 2025-08-23 at 12 18 21 AM](https://github.com/user-attachments/assets/57afaffc-42d4-4a96-b771-1b3f8e8c3dd6)
---
- **The Output**
- ![WhatsApp Image 2025-08-23 at 12 26 04 AM](https://github.com/user-attachments/assets/44495857-a378-4fc8-9e00-67378da994d7)




---

## Commands
```bash
java -jar target/tmdb-app-1.0.0.jar --type popular
java -jar target/tmdb-app-1.0.0.jar --type top
java -jar target/tmdb-app-1.0.0.jar --type upcoming
java -jar target/tmdb-app-1.0.0.jar --type playing

---
 
