package model.generate;

import java.util.ArrayList;
import java.util.Random;

import view.Parameters;

public class NormalStrategy extends GenerationStrategy{


	public NormalStrategy(Parameters param) {
		super(param);
	}

	public double[] Generate(){
		double[] data = new double[populationSize];
		double[] temp = null; 
		int central = 100;
		for(int i = 0; i < populationSize; i++){
			temp = generateRandom(central, lowerBound, upperBound);
			data[i] = getMean(temp);
		}
		return data;
	}
	
	private double getMean(double[] data) {
		double sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return sum / data.length;
	}
	
	private double[] generateRandom(int central, int lowerBound, int upperBound) {
		Random rand = new Random();
		double[] data = new double[populationSize];
		for(int i = 0; i < populationSize; i++)
			data[i] = lowerBound + rand.nextDouble() * (upperBound - lowerBound);
		
		return data;
	}
	
}

