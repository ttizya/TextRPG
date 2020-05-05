package com.exponent10.main;

public class Player extends Character{
	
	//integers to store number of upgrades/skills in each path
	public int numAtkUpgrades, numDefUpgrades;
	
	//Arrays to store skill names
	public String[] atkUpgrades = {"Strength", "Power", "Might", "Godlike Strength"};
	public String[] defUpgrades = {"Heavy Bones", "Stoneskin", "Scale Armor", "Holy Aura"};

	//Player specific constructor
	public Player(String name) {
		//calling constructor of superclass
		super(name, 100, 0);
		//Setting # of upgrades to 0
		this.numAtkUpgrades = 0;
		this.numDefUpgrades = 0;
		// let the player choose a trait when creating a new character
		chooseTrait();
	}

	
	//Player specific methods
	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int defend() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//let the player choose a trait of either skill path
	public void chooseTrait() {
		GameLogic.clearConsole();
		GameLogic.printHeading("Choose a trait:");
		System.out.println("(1) " + atkUpgrades[numAtkUpgrades]);
		System.out.println("(2) " + defUpgrades[numDefUpgrades]);
		//get the players choice:
		int input = GameLogic.readInt("->", 2);
		GameLogic.clearConsole();
		//deal with both cases
		if(input == 1) {
			GameLogic.printHeading("You chose " + atkUpgrades[numAtkUpgrades] + "!");
			numAtkUpgrades++;
		}else {
			GameLogic.printHeading("You choose " + defUpgrades[numDefUpgrades] + "!");
			numDefUpgrades++;
		}
		GameLogic.anythingContinue();
	}

}
