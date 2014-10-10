package uk.co.alexjking.ga.crossover;

public class Main {
	
	Individual[] population;
	
	public static void main(String[] args){
		Main main = new Main();
		main.compareGA(1, 5000);
	}
	
	/**
	 * Function which runs genetic algorithm with and without crossover.
	 * 
	 * This prints the average number of evaluations before reaching 
	 * maximum fitness.
	 */
	public void compareGA(int iterations, int populationSize){
		GAWithoutCrossover ga = new GAWithoutCrossover();
		GAWithCrossover gaCrossover = new GAWithCrossover();
		
		double gaAverage = 0.0;
		double crossoverAverage = 0.0;
		for(int i=0; i<iterations; i++){
			gaAverage += ga.start(populationSize);
			crossoverAverage += gaCrossover.start(populationSize);
		}
		
		gaAverage /= iterations;
		crossoverAverage/= iterations;
		
		System.out.println("GA average = " + gaAverage);
		System.out.println("Crossover average = " + crossoverAverage);

		 
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
