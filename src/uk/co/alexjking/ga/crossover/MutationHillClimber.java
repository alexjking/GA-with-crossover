package uk.co.alexjking.ga.crossover;


/**
 * Hill climber which mutates the individual to get closer to the
 * target string.
 * 
 * Running this class prints out the string each time it mutates to a higher fitness
 * with the total mutation count.
 * 
 * @author Alex King
 *
 */
public class MutationHillClimber {
	
	public static void main(String[] args){
		MutationHillClimber hillClimber = new MutationHillClimber();
		hillClimber.start();
	}

	/**
	 * Starts the hill climber.
	 */
	public void start(){
		Individual ind = new Individual();
		int counter = 0;
		
		/* Mutate whilst individual isn't at maximum fitness. */
		while(ind.calculateFitness() < Individual.targetString.length()){
			Individual mutatedInd = ind.mutate();

			// keep mutated individual if it has a higher fitness
			if(mutatedInd.calculateFitness() > ind.calculateFitness()){
				ind = mutatedInd;
				System.out.println(counter + ": " + ind);
			}
			
			counter++;
		}
	}
}
