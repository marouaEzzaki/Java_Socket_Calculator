package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketClient {

	public static final int PORT = 2017;
	public static final String SERVER_IP = "localhost";

	public static void main(String[] args) {

		System.out.println("	SOCKET CALCULATOR ");
		System.out.println("-----------------------------------");

		InetSocketAddress serverAddress = new InetSocketAddress(SERVER_IP, PORT);

		try (Scanner scInt = new Scanner(System.in); Scanner scString = new Scanner(System.in);) {

			int option;

			do {

				menu();
				System.out.print("Choose an option ->  ");
				option = scInt.nextInt();

				if (option != 5) {

					System.out.println("Enter the numbers");
					System.out.print("Num 1 : ");
					String number1 = scString.nextLine();
					System.out.print("Num 2 : ");
					String number2 = scString.nextLine();

					String operands = null;
					String operation = null;

					switch (option) {
						case 1 -> {
							operands = number1 + "_" + number2;
							operation = "1";
						}
						case 2 -> {
							operands = number1 + "_" + number2;
							operation = "2";
						}
						case 3 -> {
							operands = number1 + "_" + number2;
							operation = "3";
						}
						case 4 -> {
							operands = number1 + "_" + number2;
							operation = "4";
						}
					}

					Socket serverSocket = new Socket();
					serverSocket.connect(serverAddress);
					System.out.println("CLIENT: Waiting for the server to accept the connection");
					System.out.println("CLIENT: Connection established... to " + SERVER_IP + " on port " + PORT);

					PrintStream output = new PrintStream(serverSocket.getOutputStream());

					if (operands != null && operation != null) {
						output.println(operands);
						output.println(operation);
					} else {
						System.out.println("Did not pass through the switch");
					}

					InputStreamReader input = new InputStreamReader(serverSocket.getInputStream());
					BufferedReader bf = new BufferedReader(input);

					System.out.println("CLIENT: Waiting for the result from the server...");

					String result = bf.readLine();

					String displayResult = "The result ";

					switch (option) {
						case 1 -> displayResult += "of addition is " + result;
						case 2 -> displayResult += "of subtraction is " + result;
						case 3 -> displayResult += "of multiplication is " + result;
						case 4 -> displayResult += "of division is " + result;
					}

					System.out.println("CLIENT: " + displayResult);

				}

			} while (option > 0 && option < 5);

			System.out.println("Exiting the calculator... Thank you for using our app! :D");

		} catch (UnknownHostException e) {
			System.err.println("CLIENT: Cannot find the server at address " + SERVER_IP);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("CLIENT: Input/output error");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("CLIENT: Error -> " + e);
			e.printStackTrace();
		}
	}

	public static void menu() {
		System.out.println("*********** MENU ***********\n");

		System.out.println("1. Add");
		System.out.println("2. Subtract");
		System.out.println("3. Multiply");
		System.out.println("4. Divide");
		System.out.println("5. Exit");

	}
}
