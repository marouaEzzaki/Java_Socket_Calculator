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
   git clone https://github.com/yourusername/Java_Socket_Calculator.git
   cd Java_Socket_Calculator
2. **Change IP for Network Testing (Optional)**:
In the client code, the localhost IP can be changed to the server's IP to test across different computers.
Update the line in SocketCliente as follows:
```bash
public static final String IP_SERVER = "other-computer-ip";
```

## How to Run

1. **Start the Server**:
   - Navigate to the server project directory.
   - Compile and run `SocketServidor`:
     ```bash
     javac SocketServidor.java
     java SocketServidor
     ```

2. **Start the Client**:
   - Open a new terminal window.
   - Navigate to the client project directory.
   - Compile and run `SocketCliente`:
     ```bash
     javac SocketCliente.java
     java SocketCliente
     ```

## Usage

The Client will display a menu with options for each operation (Addition, Subtraction, Multiplication, Division) and an option to Exit. Enter your choice, followed by the two numbers you want to calculate. The result will be displayed on the Client after the Server processes it.



