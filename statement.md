# Problem Statement

Real-time text communication between multiple users over a network often requires
dedicated infrastructure. This project implements a lightweight, self-hosted
multi-client chat server using Java sockets, demonstrating core networking and
concurrency concepts.

## Scope

- A TCP-based server that accepts multiple simultaneous client connections
- Real-time message broadcasting between connected clients
- Unique username enforcement per session
- Event logging (connections, messages, disconnections) to a persistent file

## Target Users

Students or small teams needing a simple, dependency-free chat tool for local
networks, and developers learning Java socket programming and multithreading.

## High-Level Features

- Multi-client support via one thread per connection
- Broadcast messaging to all connected users
- Username uniqueness validation
- Graceful disconnect handling (`/quit` command)
- Persistent, timestamped server-side logging