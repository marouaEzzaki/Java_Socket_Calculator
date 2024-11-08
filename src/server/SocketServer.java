package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

	public static final int PORT = 2017;

	public static void main(String[] args) {

		System.out.println("    CALCULATOR SERVER ");
		System.out.println("-----------------------------------");	

		InputStreamReader input = null;
		PrintStream output = null;

		Socket clientSocket = null;

		InetSocketAddress address = new InetSocketAddress(PORT);

		try (ServerSocket serverSocket = new ServerSocket()) {

			serverSocket.bind(address);

			int requestCount = 0;

			while (true) {

				System.out.println("SERVER: Waiting for requests on port " + PORT);

				clientSocket = serverSocket.accept();

				System.out.println("SERVER: Request number " + ++requestCount + " received");

				input = new InputStreamReader(clientSocket.getInputStream());
				BufferedReader bf = new BufferedReader(input);

				String receivedNumbers = bf.readLine();
				String operationToPerform = bf.readLine();

				System.out.println("SERVER: Received from client: " + receivedNumbers);
				System.out.println("SERVER: Option number: " + operationToPerform);

				String[] operands = receivedNumbers.split("_");
				int num1 = Integer.parseInt(operands[0]);
				int num2 = Integer.parseInt(operands[1]);

				int operation = Integer.parseInt(operationToPerform);

				boolean isCalculationDone = false;
				int result = 0;

				switch (operation) {
					case 1 -> {
						result = num1 + num2;
						isCalculationDone = true;
					}
					case 2 -> {
						result = num1 - num2;
						isCalculationDone = true;
					}
					case 3 -> {
						result = num1 * num2;
						isCalculationDone = true;
					}
					case 4 -> {
						if (num2 != 0) {
							result = num1 / num2;
							isCalculationDone = true;
							
						} else {
							System.out.println("SERVER: Division by zero is not allowed.");
						}
					}
				}

				if (isCalculationDone) {
					System.out.println("SERVER: The result of the calculation is: " + result);
				} else {
					System.out.println("SERVER: Calculation not completed because an invalid operation.");
				}

				output = new PrintStream(clientSocket.getOutputStream());
				output.println(result);

				clientSocket.close();
			}

		} catch (IOException e) {
			System.err.println("SERVER: Input/output error");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("SERVER: Error -> " + e);
			e.printStackTrace();
		}
	}
}
