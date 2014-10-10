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
			System.out.println(i + ": " + population[i]);
		}
	}
	
}
