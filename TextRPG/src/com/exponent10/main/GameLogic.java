package com.exponent10.main;
import java.util.Scanner;

public class GameLogic {
	static Scanner scanner = new Scanner(System.in);
	
	static Player player;
	
	public static boolean isRunning;
	
	//method to get user input from console
	public static int readInt(String prompt, int userChoices) {
		int input;
		
		do {
			System.out.println(prompt);
			try {
				input = Integer.parseInt(scanner.next());
			}catch(Exception e) {
				input = -1;
				System.out.println("Please enter an integer");
			}
		}while(input < 1 || input > userChoices);
		
		return input;
	}
	
	// method to simulate clearing the console
	public static void clearConsole() {
		for(int i = 0; i < 100; i++) 
			System.out.println();
		}
		
		//method to print a separator with length n
	public static void printSeparator(int n){
		for(int i = 0; i > n; i++) 
			System.out.print("-");
			System.out.println();
		}
	
	//method to print a heading
	public static void printHeading(String title){
		printSeparator(30);
		System.out.println(title);
		printSeparator(30);
	}
	
	//method to stop the game until user inputs
	public static void anythingContinue() {
		System.out.println("\nEnter anything to continue...");
		scanner.next();
	}
	
	//method to start the game
	public static void startGame() {
		boolean nameSet = false;
		String name;
		//print title screen
		clearConsole();
		printSeparator(40);
		printSeparator(30);
		System.out.println("AGE OF THE EVIL EMPEROR");
		System.out.println("TEXT RPG BY TOM FOR EXPONENT10.COM");
		printSeparator(40);
		printSeparator(30);
		anythingContinue();
		
		//getting player name
		do {
			clearConsole();
			printHeading("What is your name?");
			name = scanner.next();
			//asking the player if he wants to correct his choice
			clearConsole();
			printHeading("Your name is " + name + "\nIs that correct?");
			System.out.println("(1) Yes!");
			System.out.println("(2) No, I want to change my name.");
			int input = readInt("-> " ,2);
			if(input == 1)
				nameSet = true;
		}while(!nameSet);
		
		//create new player object with the name
		player = new Player(name);
		
		//setting isRussing to true, so the game loop can continue
		isRunning = true;
		
		//start main game loop
		gameLoop();
	}
	
	//method to continue the journey
	public static void continueJourney() {
		
	}
	
	//printing out the most important information about the player character
	public static void characterInfo() {
		clearConsole();
		printHeading("CHARACTER INFO");
		System.out.println(player.name + "\tHP" + player.hp + "/" + player.maxHp);
		printSeparator(20);
		System.out.println("XP: " + player.xp);
		
		//printing the chosen traits
		if (player.numAtkUpgrades > 0) {
			System.out.println("Offensive trait: " + player.atkUpgrades[player.numAtkUpgrades -1]);
			printSeparator(20);
		}
		if (player.numDefUpgrades > 0) {
			System.out.println("Defensive trait: " + player.defUpgrades[player.numDefUpgrades -1]);
			printSeparator(20);	
		}
		
		anythingContinue();
	}
	
	//printing the main menu
	public static void printMenu() {
		clearConsole();
		printHeading("MENU");
		System.out.println("Choose action:");
		printSeparator(20);
		System.out.println("(1) Continue on your journey");
		System.out.println("(2) Character Info");
		System.out.println("(3) Exit Game");
		
	}
	
	//main game loop
	public static void gameLoop() {
		while(isRunning) {
			printMenu();
			int input = readInt("-> ", 3);
			if (input == 1) 
				continueJourney();
			else if(input == 2)
				characterInfo();
			else 
				isRunning = false;
			}
		}
	}

}
