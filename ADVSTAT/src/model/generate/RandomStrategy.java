package model.generate;

import java.util.ArrayList;
import java.util.Random;

import view.Parameters;

public class RandomStrategy extends GenerationStrategy{

	public RandomStrategy(Parameters param) {
		super(param);
	}

	public double[] GeneratePopulation(){
		Random rand = new Random();
		double[] data = new double[populationSize];
		for(int i = 0; i < populationSize; i++)
			data[i] = (double)lowerBound + rand.nextInt(upperBound - lowerBound + 1);
		
		return data;
		
	}
}
