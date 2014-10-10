package uk.co.alexjking.ga.crossover;

import java.util.Random;


/**
 * Class which acts as a steady state Genetic Algorithm
 * with tournament selection and crossover.
 * 
 * It picks two individuals at random, takes the fittest individual
 * to create a parent. This is repeated to make a second parent.
 * 
 * A child is created by taking both parents, applying the crossover
 * function to them to create a new individual and then mutating this
 * result.
 * 
 * Another two individuals are chosen at random and the child 
 * replaces the least fit of these two individuals.
 * 
 * @author Alex King
 *
 */
public class GAWithCrossover {
	
	Individual[] population;
	int debug = 0; //set debug = 1 for printouts

	public static void main(String[] args){
		GAWithCrossover ga = new GAWithCrossover(1);
		ga.start(500);
	}
	
	public GAWithCrossover(){}
	
	/**
	 * Set debug = 1 to view printouts.
	 * @param debug
	 */
	public GAWithCrossover(int debug){
		this.debug = debug;
	}
	
	/**
	 * Starts the GA.
	 * 
	 * @param populationSize
	 * @return Number of mutations before maximum fitness achieved.
	 */
	public int start(int populationSize){
		initPopulation(populationSize);
		int fitness = 0;
		int mutationCounter = 0;
		Random random = new Random();
	
		while(fitness < Individual.targetString.length()){
			
			/* Choose 1st parent */
			Individual parentA = population[random.nextInt(populationSize)];
			Individual parentB = population[random.nextInt(populationSize)];
			Individual firstParent = null;
			if(parentA.calculateFitness() > parentB.calculateFitness()){
				firstParent = parentA;
			}else{
				firstParent = parentB;
			}
			/* Choose 2nd parent */
			parentA = population[random.nextInt(populationSize)];
			parentB = population[random.nextInt(populationSize)];
			Individual secondParent = null;
			if(parentA.calculateFitness() > parentB.calculateFitness()){
				secondParent = parentA;
			}else{
				secondParent = parentB;
			}
			
			/* Create child */
			Individual crossover = crossover(firstParent, secondParent);
			Individual child = crossover.mutate();
			
			/* Choose an individual to be replaced by child */
			int aIndex = random.nextInt(populationSize);
			int bIndex = random.nextInt(populationSize);
			Individual individualA = population[aIndex];
			Individual individualB = population[bIndex];
			if(individualA.calculateFitness() > individualB.calculateFitness()){
				population[bIndex] = child;
			}else{
				population[aIndex] = child;
			}
			
			/* Update maximum fitness value */
			int newFitness = child.calculateFitness();
			if(fitness < newFitness){
				fitness = newFitness;
				if(debug == 1)
					System.out.println(mutationCounter + ": " + child);
			}
			mutationCounter++;

		}
		
		return mutationCounter;
	}
	
	/**
	 * Takes two individuals producing a new individual with some
	 * characters from both of the individuals.
	 * 
	 * @param a First individual.
	 * @param b Second individual.
	 * @return New individual generated from individuals a and b.
	 */
	private Individual crossover(Individual a, Individual b){
		Random random = new Random();
		char[] aCharacters = a.getCharacters();
		char[] bCharacters = b.getCharacters();
		char[] childCharacters = new char[Individual.targetString.length()];
		
		for(int i=0; i<Individual.targetString.length(); i++){
			if(random.nextDouble() < 0.5){
				childCharacters[i] = aCharacters[i];
			}else{
				childCharacters[i] = bCharacters[i];
			}
		}
		
		return new Individual(childCharacters);
	}
	
	/**
	 * Initialises the population
	 * 
	 * @param populationNumber
	 */
	private void initPopulation(int populationNumber){
		population = new Individual[populationNumber];
		for(int i=0; i<populationNumber; i++){
			population [i] = new Individual();
		}
	}

}
