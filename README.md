# Java Multi-Client Chat Application

A terminal-based, multi-client chat server built with Java sockets and
multithreading. Multiple users can connect to a central server and exchange
real-time messages.

## Features

- Supports multiple simultaneous clients (thread-per-client model)
- Real-time message broadcasting
- Unique username enforcement
- Graceful disconnect via `/quit`
- Persistent event logging to `server_log.txt`

## Technologies Used

- Java (Sockets, Multithreading, Collections, File I/O)
- No external dependencies — pure Java standard library

## Project Structure

ChatApp/
├── src/
│   ├── Server.java
│   ├── ClientHandler.java
│   ├── UserManager.java
│   ├── Logger.java
│   └── Client.java
├── README.md
├── statement.md
└── .gitignore

## Setup & Installation

### Prerequisites
- Java Development Kit (JDK) 8 or higher installed
- Verify with: `java -version` and `javac -version`

### Steps
1. Clone this repository: