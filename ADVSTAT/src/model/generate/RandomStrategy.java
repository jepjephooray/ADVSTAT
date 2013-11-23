package model.generate;

import java.util.Random;

import view.Parameters;

public class RandomStrategy extends GenerationStrategy{

	public RandomStrategy(Parameters param) {
		super(param);
	}

	public double[] GeneratePopulation(){
		return generateRandom(populationSize, lowerBound, upperBound);
	}

	/**
	 * Generates random numbers between the lower bound and the upper bound.
	 * @param amount
	 * @param lowerBound
	 * @param upperBound
	 * @return
	 */
	private double[] generateRandom(int amount, int lowerBound, int upperBound) {
		Random rand = new Random();
		double[] data = new double[amount];
		for(int i = 0; i < amount; i++)
			data[i] = (double)lowerBound + rand.nextInt(upperBound - lowerBound + 1);
		
		return data;
	}
}
