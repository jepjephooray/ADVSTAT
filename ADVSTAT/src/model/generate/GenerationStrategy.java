package model.generate;

import java.util.ArrayList;

import view.Parameters;

public abstract class GenerationStrategy {
	protected int sampleSize;
	protected int populationSize;
	protected int upperBound;
	protected int lowerBound;
	public GenerationStrategy(Parameters param) {
		super();
		populationSize = param.getBigN();
		sampleSize = param.getSmallN();
		upperBound = param.getU();
		lowerBound = param.getL();
	}
	public abstract double[] GeneratePopulation();
	
	/**
	 * WRONG WRONG WRONG
	 * This should return an array list of integers which 
	 * contains all the possible values of the population.
	 * @return
	 */
	public ArrayList<Integer> FindAllSamplePermutations(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		/*
		 * Pseudocode!
		 * For loop through each element in the population
		 * 		current value = X
		 * 			if (X is not yet in the list) add X to list
		 */
		
		
		return list;
	}
	
	public double[] FindAllPermutations(){
		double[] data = new double[(upperBound-lowerBound+1)];
		for (int i = lowerBound; i <= upperBound; i++){
			data[i-lowerBound] = i;
		}
		return data;
	}
}
