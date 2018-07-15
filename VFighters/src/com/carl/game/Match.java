package com.carl.game;

import com.carl.game.fighter.Fighter;

/**
 * This is the class that will start each match. Fighters are received from the {@link Game} class.  The match starts by rolling the dice to determine
 * which player goes first.  The winner of the roll will be the first to attack followed by the opponent.  Each player has a set number of attacks.  
 * The round is ended once both players fully consumes thier attack turns.  And the Match is ended as soon as one of the player's health has reached 0.
 * 
 * @author Carl 
 *
 */
public class Match {

	/**
	 * Reference to player 1.
	 */
	Fighter player1;
	
	/**
	 * Reference to player 2.
	 */
	Fighter player2;
	
	/**
	 * Reference to the starting health of player 1
	 */
	private int health1;
	
	/**
	 * Reference to player 1's damage output.
	 */
	private int damage1;
	
	/**
	 * Reference to the number of attacks player 1 will have.
	 */
	private int attack1;

	/**
	 * Reference to the starting health of player 2
	 */
	private int health2;
	
	/**
	 * Reference to player 2's damage output.
	 */
	private int damage2;
	
	/**
	 * Reference to the number of attacks player 2 will have.
	 */
	private int attack2;
	
	
/**
 * This is the constructor of the {@link Match} class that will take in 2 fighters from the {@link Game} class.  
 * 
 * @param fighter1 Player 1
 * @param fighter2 Player 2
 */
	public Match(final Fighter fighter1, final Fighter fighter2) {
		
		//Set each player the class
		this.player1 = fighter1;
		this.player2 = fighter2;
		
		//Display each players information.
		intro();

		//Start the match using player 1 and player 2.
		run(this.player1,this.player2);
	}

	
	/**
	 * This method is the intro for Fighter 1 and Fighter 2.  Each players name, health, damage, and attacks will be 
	 * set and displayed.
	 */
	private void intro() {
		
		//Set player 1's attributes 
		this.health1 = this.player1.getHealth();
		this.damage1 = this.player1.getDamage();
		this.attack1 = this.player1.getAttacks();
		
		//Display player 1's information.
		System.out.println("Fighter 1: " + this.player1.getVendor() + "              Health: " + this.health1 + "              Damage: "
				+ this.damage1 + "              Attacks: " + this.attack1);

		//Set player 2's attributes 
		health2 = player2.getHealth();
		damage2 = player2.getDamage();
		attack2 = player2.getAttacks();
		//Display player 1's information.
		System.out.println("Fighter 2: " + this.player2.getVendor() + "              Health: " + this.health2 + "              Damage: "
				+ this.damage2 + "              Attacks: " + this.attack2);
	}

	
	/**
	 * This method is where both fighters will attack each other.  The round is over when both players consume all their attacks. 
	 * The match is ended when a player's health is 0 or below. 
	 * 
	 * @param thePlayer1 
	 * @param thePlayer2
	 */
	private void run(final Fighter thePlayer1, final Fighter thePlayer2) 
	{
		//Set player 1's health.
		int p1Health = this.health1;
		
		//Set player 2's health.
		int p2Health = this.health2;
		
		//Set the current round of the match.
		int round = 1;
		
		//Set the number of wins for player 1.
		int p1WinNumber;
		
		//Set the number of wins for player 2.
		int p2WinNumber;
		
		//Continue the round until an oppenent's health is 0 or less;
		while(p1Health > 0 || p2Health > 0)
		{
			//If player 2's health is 0 or below, set player 1 as the winner.
			if(p2Health <= 0) {
				System.out.println("Player 1 wins!");
				break;
			}
			//If player 2's health is 0 or below, set player 1 as the winner.
			if(p1Health <= 0) {
				System.out.println("Player 2 wins!");
				break;
			}
			
			System.out.println("Round "+ round);
			
			//Set the roll for each player to determine who goes first.
			thePlayer1.roll();
			thePlayer2.roll();
			
			//Decide who will go first
			if (thePlayer1.getRoll() > thePlayer2.getRoll()) 
			{
				this.player1.setRollWinner(true);
				this.player2.setRollWinner(false);
				System.out.println("Fighter 1 is randomly selected to go first ("+ thePlayer1.getRoll() + " > " +  thePlayer2.getRoll()+ ")");
			} else 
			{
				this.player2.setRollWinner(true);
				this.player1.setRollWinner(false);
				System.out.println("Fighter 2 is randomly selected to go first ("+ thePlayer2.getRoll() + " > " +  thePlayer1.getRoll()+ ")");
			}
			
			//Set both players to be able to attack. Attack is determined by health and attack turns.
			this.player1.setCanAttack(true);
			this.player2.setCanAttack(true);
			
			//Set the number of attack turns.
			int p1Attack = this.attack1;
			int p2Attack = this.attack2;
			
			//If any player can attack, enter loop.
			while (player1.isCanAttack() || player2.isCanAttack()) 
			{
				//Player one will attack first if winner of the roll.
				if(player1.isRollWinner()) 
		{
					//Check if player 1 can attack.
				if (player1.isCanAttack()) 
			{
				//Display the action fighter 1 has done.
				System.out.println("Fighter 1 hits fighter 2 for " + damage1 + " damage (" + p2Health +" ->"+  (p2Health-damage1)+")" );
				//Set the new health for player 2
				p2Health = p2Health-damage1;
				
				//Exit if player 2 is dead.
				if(p2Health <= 0) {
					break;
				}
				//Remove an attack turn from player 1
				p1Attack--;
				
				//Check both players health and attack turns
				if(p1Health <= 0 || p1Attack == 0) 
				{
					player1.setCanAttack(false);
				}
				if(p2Health <=0 || p2Attack == 0) 
				{
					player2.setCanAttack(false);
				}
			} 
		}
		
			//Change the winner to true so that player 1 may attack
			player1.setRollWinner(true);
			
			//Check if player 2 can attack.
			if (player2.isCanAttack())
					{
				//Display the action fighter 2 has done.
				System.out.println("Fighter 2 hits fighter 1 for " + damage2 + " damage (" + p1Health +" ->"+  (p1Health-damage2)+")" );
				//Set the new health for player 1
				p1Health = p1Health-damage2;
				
				//Exit if player 2 is dead.
				if(p1Health <= 0) {
					break;	
				}
				p2Attack--;
				
				//Check both player's health and attack turns.
				if(p1Health <= 0 || p1Attack == 0) 
				{
					player1.setCanAttack(false);
				}
				if(p2Health <=0 || p2Attack == 0) 
				{
					player2.setCanAttack(false);
				}	
					}		
		}
			round++;
		}			
	}

}
