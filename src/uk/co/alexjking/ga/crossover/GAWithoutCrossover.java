package uk.co.alexjking.ga.crossover;

import java.util.Random;

/**
 * Class which acts as a steady state Genetic Algorithm
 * with tournament selection.
 * 
 * It picks two individuals at random, takes the fittest individual
 * and mutates it to create a child.
 * Another two individuals are chosen at random and the child 
 * replaces the least fit of these two individuals.
 * 
 * 
 * @author Alex King
 *
 */
public class GAWithoutCrossover {
	
	Individual[] population;
	

	public static void main(String[] args){
		GAWithoutCrossover ga = new GAWithoutCrossover();
		ga.start(500);
	}
	
	/**
	 * Start the GA.
	 */
	public void start(int populationSize){
		initPopulation(populationSize);
		int fitness = 0;
		int mutationCounter = 0;
		Random random = new Random();
	
		while(fitness < Individual.targetString.length()){
			
			/* Choose parent */
			Individual parentA = population[random.nextInt(populationSize)];
			Individual parentB = population[random.nextInt(populationSize)];
			Individual parent = null;
			
			if(parentA.calculateFitness() > parentB.calculateFitness()){
				parent = parentA;
			}else{
				parent = parentB;
			}
			
			/* Create child */
			Individual child = parent.mutate();
			
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
				System.out.println(mutationCounter + ": " + child);
			}
			mutationCounter++;
			
		}
		
	}
	
	
	/**
	 * Initialises the population
	 * 
	 * @param populationNumber
	 */
	public void initPopulation(int populationNumber){
		population = new Individual[populationNumber];
		for(int i=0; i<populationNumber; i++){
			population [i] = new Individual();
		}
	}
}
