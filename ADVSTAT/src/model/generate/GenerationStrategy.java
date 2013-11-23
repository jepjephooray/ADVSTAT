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
	
	public double[] FindAllSamplePermutations(){
		double[] data = new double[(upperBound-lowerBound+1)];
		for (int i = lowerBound; i <= upperBound; i++){
			data[i-lowerBound] = i;
		}
		return data;
	}
}
