package com.carl.game.fighter;

import java.util.Random;

/**
 * This is the class that has the Fighters information.  Once parsing has been completed from the {@link CSVParser} information of each
 * fighter is created through this class.
 * @author Carl
 *
 */
public class Fighter {

	/**
	 * Reference to the name of the fighter.
	 */
	private String vendor;
	
	/**
	 * Reference to the health of the fighter
	 */
	private int health;
	
	/**
	 * Reference to the amount of damage
	 */
	private int damage;
	
	/**
	 * The number of attacks of the fighter
	 */
	private int attacks;
	
	/**
	 * Number of wins for each round
	 */
	private int win;
	
	/**
	 * Number of loss for each round
	 */
	private int loss;
	
	/**
	 * Calculate the wins/loss
	 */
	private int percentage;
	
	/**
	 * Reference if fighter is allowed to attack.
	 */
	private boolean canAttack;
	
	/**
	 * Reference to the random dice roll
	 */
	private int roll;
	
	/**
	 * Set if fighter is winner of dice roll.
	 */
	public boolean rollWinner;

	/**
	 * This is the constructor of {@link Fighter} that will set and initialize the fighter's attributes. Attributes is received from 
	 * the {@link CSVParser} class.
	 * 
	 * @param theName The name of the vendor.
	 * @param theHealth The current health .
	 * @param theDamage The amount of damage.
	 * @param theAttacks The number of attacks allowed per round.
	 */
	public Fighter(final String theName, final int theHealth, final int theDamage, final int theAttacks) {
		super();
		this.vendor = theName;
		this.health = theHealth;
		this.damage = theDamage;
		this.attacks = theAttacks;
		this.canAttack = false;
		this.rollWinner = false;
		roll();
	}

	
	/**
	 * 
	 * @return The rollWinner
	 */
	public boolean isRollWinner() {
		return rollWinner;
	}


	/**
	 * Set the rollWinner
	 * @param rollWinner
	 */
	public void setRollWinner(final boolean rollWinner) {
		this.rollWinner = rollWinner;
	}


	/**
	 * Roll a random number from 1 to 50.
	 */
	public void roll() {
		Random rand = new Random();
		this.roll = rand.nextInt(50) + 1;
	}

	/**
	 * 
	 * @return the result of the roll
	 */
	public int getRoll() {
		return this.roll;
	}

	/**
	 * 
	 * @return The name of the fighter
	 */
	public String getVendor() {
		return vendor;
	}

	/**
	 * 
	 * @return The health of the player
	 */
	public int getHealth() {
		return health;
	}


	/**
	 * 
	 * @return The amount of damage fighter will deal
	 */
	public int getDamage() {
		return damage;
	}

	/**
	 * 
	 * @return The number of attacks
	 */
	public int getAttacks() {
		return attacks;
	}

	/**
	 * 
	 * @return Retrieve the number of wins
	 */
	public int getWin() {
		return win;
	}

	/**
	 * Set the amount of win from the match
	 * @param win
	 */
	public void setWin(final int win) {
		this.win = win;
	}

	/**
	 * 
	 * @return Retrieve the number of loss
	 */
	public int getLoss() {
		return loss;
	}

	/**
	 * Set the amount of loss from the match
	 * @param loss
	 */
	public void setLoss(final int loss) {
		this.loss = loss;
	}

	/**
	 * 
	 * @return The fighters win percentage
	 */
	public int getPercentage() {
		return percentage;
	}

	/**
	 * Set the win percentage
	 * @param percentage
	 */
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	/**
	 * 
	 * @return True if allowed to attack, otherwise false.
	 */
	public boolean isCanAttack() {
		return canAttack;
	}

	/**
	 * Set the boolean to allow fighter to attack
	 * @param canAttack
	 */
	public void setCanAttack(boolean canAttack) {
		this.canAttack = canAttack;
	}

}
