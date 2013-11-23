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
	 * This is flawed. The sample permutations should not be from
	 * the list of all possible values but from the generated 
	 * population itself. 
	 * @return
	 */
	public double[] FindAllSamplePermutations(){
		ArrayList<Double> list = new ArrayList<Double>();
		
		/*
		 * This is incorrect -- should return data[] which
		 * contains all the possible values from the population
		 */
		double[] data = new double[(upperBound-lowerBound+1)];
		for (int i = lowerBound; i <= upperBound; i++){
			data[i-lowerBound] = i;
		}
		return data;
	}
	
	public double[] FindAllPermutations(){
		double[] data = new double[(upperBound-lowerBound+1)];
		for (int i = lowerBound; i <= upperBound; i++){
			data[i-lowerBound] = i;
		}
		return data;
	}
}
