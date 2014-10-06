package uk.co.alexjking.ga.crossover;

import java.util.Random;

/**
 * Models a string of random characters which can then mutate to model a genetic algorithm.
 * 
 * @author Alex King
 *
 */
public class Individual {
	private char[] characters;
	
	public Individual(){
		initCharacters(28);
	}
	
	/**
	 * Initialises the char array with random lower case letters or a space.
	 * @param numCharacters The length of the character array
	 */
	private void initCharacters(int numCharacters){
		characters = new char[numCharacters];
		
		Random r = new Random();
		String alphabet = "abcdefghijklmnopqrstuvwxyz ";
		
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
	

}
