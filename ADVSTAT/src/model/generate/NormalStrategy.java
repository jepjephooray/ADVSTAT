package model.generate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import view.Parameters;

public class NormalStrategy extends GenerationStrategy{


	public NormalStrategy(Parameters param) {
		super(param);
	}
	
	

	public double[] GeneratePopulation(){
		//Random rand = new Random();
		ArrayList<Double> data = new ArrayList<Double>();
		double[] temp = null;
		/*
		temp = generateRandom(lowerBound, upperBound);
		double mean = getMean(temp);
		System.out.println("mean: " + mean);
		double variance = getVariance(temp, mean);
		System.out.println("variance: " + variance);
		for (int i = 0; i < data.length; i++) {
			data[i] = mean + rand.nextGaussian() * variance;
			//System.out.println(data[i]);
		}
		*/
		
		
//		int central = 100;
//		for(int i = 0; i < populationSize; i++){
//			
//			data.add(getMean(temp));
//		}
//		
		temp = generateRandom(populationSize, lowerBound, upperBound);
		for(int i = 0; i < populationSize; i++){	
			data.add(temp[i]);
		}
		
		// Collections.sort(data);
		
		double[] data2 = new double[data.size()];
		for (int i = 0; i < data.size(); i++) {
			data2[i] = data.get(i);
		}
		
		return temp;
		
		/*
		double[] data = new double[populationSize];
		double[] temp = null; 
		int central = 100;
		for(int i = 0; i < populationSize; i++){
			temp = generateRandom(central, lowerBound, upperBound);
			data[i] = getMean(temp);
		}
		return data;
		*/
		/*
		double mean = 100;
		double variance = 5;
		double[] data = new double[populationSize];
		Random rand = new Random();
		for (int i = 0; i < data.length; i++) {
			//data[i] = mean + rand.nextGaussian() * variance;
			data[i] = rand.nextGaussian();
			System.out.println(data[i]);
		}
		
		System.out.println("Mean: " + getMean(data));
		return data;
		*/
	}
	
	private double getVariance(double[] temp, double mean) {
		double variance = 0;
		for (int i = 0; i < temp.length; i++) {
			variance += (temp[i] - mean) * (temp[i] - mean);
		}
		return variance / temp.length;
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
		double[] data = new double[central];
		for(int i = 0; i < central; i++)
			data[i] = (double)lowerBound + rand.nextInt(upperBound - lowerBound) /*rand.nextDouble() * (upperBound - lowerBound) */ ;
		
		return data;
	}
	
}

