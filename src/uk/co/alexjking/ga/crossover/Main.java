package uk.co.alexjking.ga.crossover;

public class Main {
	
	Individual[] population;
	
	public static void main(String[] args){
		Main main = new Main();
		main.createPopulation(10);
		main.printPopulation();
	}
	
	/**
	 * Creates a population of Individual objects.
	 * @param populationNumber
	 */
	public void createPopulation(int populationNumber){
		population = new Individual[populationNumber];
		for(int i=0; i<populationNumber; i++){
			population [i] = new Individual();
		}
	}
	
	/**
	 * Prints the population to system.out.
	 */
	public void printPopulation(){
		for(int i=0; i< population.length; i++){
			System.out.println(i + ": " + population[i] + " fit= " + calculateFitness(population[i]));
		}
	}
	
	/**
	 * Calculate the fitness of a particular char array by comparing to 'methinks it is like a weasel'.
	 * 
	 * @param individual Individual we are calculating the fitness for.
	 * @return Fitness score.
	 */
	private int calculateFitness(Individual individual){
		String targetCharacters = "methinks its like a weasel";
		char[] comparisonCharacters = individual.getCharacters();
		int fitness = 0;
		
		for(int i=0; i<targetCharacters.length(); i++){
			if(targetCharacters.charAt(i) == comparisonCharacters[i])
				fitness++;
		}
		return fitness;
	}
	
	
}
