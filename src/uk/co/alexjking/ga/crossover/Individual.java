package uk.co.alexjking.ga.crossover;

import java.util.Arrays;
import java.util.Random;

/**
 * Models a string of random characters which can then mutate to model a genetic algorithm.
 * 
 * @author Alex King
 *
 */
public class Individual {
	private char[] characters;
	private static final String alphabet = "abcdefghijklmnopqrstuvwxyz ";
	private static final String targetString = "methinks it is like a weasel";
	
	/**
	 * Initialise object with random characters.
	 */
	public Individual(){
		initCharacters(28);
	}
	
	/**
	 * Initialise object with existing char array.
	 * 
	 * @param characters
	 */
	public Individual(char[] characters){
		this.characters = characters;
	}
	
	/**
	 * Initialises the char array with random lower case letters or a space.
	 * @param numCharacters The length of the character array
	 */
	private void initCharacters(int numCharacters){
		characters = new char[numCharacters];
		
		Random r = new Random();
		
		for(int i=0; i<numCharacters; i++){
			characters[i] = alphabet.charAt(r.nextInt(alphabet.length()));
		}
	}

	public char[] getCharacters() {
		return characters;
	}

	public void setCharacters(char[] characters) {
		this.characters = characters;
	}
	
	/**
	 * Returns a copy of the current object after mutating.
	 * Each character has a 1/L chance of being mutated to another random character
	 * where L = length of the character array.
	 */
	public Individual mutate(){
		Random r = new Random();
		
		/* Create copy of characters array for new object */
		char[] charactersCopy = new char[characters.length];
		System.arraycopy(characters, 0, charactersCopy, 0, characters.length);
		
		/* Loop through every character mutating if necessary */
		for(int i=0; i<charactersCopy.length; i++){
			if(r.nextInt(charactersCopy.length) == 0){
				/* Replace character at current position with a new random character from the alphabet */
				charactersCopy[i] = alphabet.charAt(r.nextInt(alphabet.length()));
			}
		}
		return new Individual(charactersCopy);
	}
	
	/**
	 * Calculate the fitness of this individual by comparing characters to a target string.
	 * 
	 * @return Fitness score.
	 */
	public int calculateFitness(){
		int fitness = 0;	
		for(int i=0; i<targetString.length(); i++){
			if(targetString.charAt(i) == characters[i])
				fitness++;
		}
		return fitness;
	}
	
	
	public String toString(){
		String returnString = "";
		for(int i=0; i<characters.length; i++){
			returnString += characters[i];
		}
		return returnString;
	}
	

}
