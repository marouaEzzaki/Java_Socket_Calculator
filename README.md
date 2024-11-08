# Java Socket Calculator

This project includes a client-server application for performing basic arithmetic operations over sockets.

## Features

The **Client** sends requests to the **Server** for:
- Addition
- Subtraction
- Multiplication
- Division

The Server processes each request and returns the result to the Client. This setup allows users to test simple arithmetic calculations over a network.

## Setup Instructions

1. **Clone the repository**: 
   ```bash
   git clone https://github.com/marouaEzzaki/Java_Socket_Calculator.git
   cd Java_Socket_Calculator
2. **Change IP for Network Testing (Optional)**:
If you want to test the connection between two different computers, you can change the IP in the client code to the server's IP. If you're testing on the same computer, you can leave it as `localhost`.
Update the line in SocketCliente as follows to test:
```bash
public static final String IP_SERVER = "other-computer-ip";
```

## How to Run

1. **Start the Server**:
   - Navigate to the server project directory.
   - Compile and run `SocketServer`:
     ```bash
     javac SocketServer.java
     java SocketServer
     ```

2. **Start the Client**:
   - Open a new terminal window.
   - Navigate to the client project directory.
   - Compile and run `SocketClient`:
     ```bash
     javac SocketClient.java
     java SocketClient
     ```

## Usage

The Client will display a menu with options for each operation (Addition, Subtraction, Multiplication, Division) and an option to Exit. Enter your choice, followed by the two numbers you want to calculate. The result will be displayed on the Client after the Server processes it.



