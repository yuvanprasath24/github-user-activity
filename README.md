# GitHub User Activity CLI

A lightweight command-line application that fetches and displays the recent public activity of a GitHub user in a clean, human-readable format using the GitHub Events API.



## Features

This CLI currently supports the following GitHub event types:

- **PushEvent** – Displays commit-related activity per repository (handled safely even when commit data is missing).
- **IssuesEvent** – Shows issue-related activity.
- **WatchEvent** – Indicates when a repository is starred by the user.
- **ForkEvent** – Shows when a repository is forked by the user.

Other event types are intentionally ignored to keep the output focused and readable.



## How It Works

1. Accepts a GitHub username as a command-line argument.
2. Fetches recent public events from:
3. Parses the JSON response.
4. Formats supported events into readable terminal output.
5. Prints the result to the console.


## Prerequisites

- Java 17 or higher  
- Maven 3.8+  


## How to Run

From the project root directory, run:

```bash
git clone https://github.com/yuvanprasath24/simple-http-server.git

cd github-user-activity
mvn spring-boot:run "-Dspring-boot.run.arguments={username}"
