package model.generate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import view.Parameters;

public class NormalStrategy extends GenerationStrategy{


	public NormalStrategy(Parameters param) {
		super(param);
	}

	public double[] Generate(){
		//Random rand = new Random();
		double[] data = new double[populationSize];
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
		for(int i = 0; i < populationSize; i++){
			temp = generateRandom(lowerBound, upperBound);
			data[i] = getMean(temp);
		}
		ArrayList<Double> dobol = new ArrayList<Double>();
		for (int i = 0; i < data.length; i++) {
			dobol.add(data[i]);
		}
		Collections.sort(dobol);
		for (int i = 0; i < dobol.size(); i++) {
			System.out.println(dobol.get(i));
		}
		
		return data;
		
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
	
	private double[] generateRandom(int lowerBound, int upperBound) {
		Random rand = new Random();
		double[] data = new double[populationSize];
		for(int i = 0; i < populationSize; i++)
			data[i] = (double)lowerBound + rand.nextInt(upperBound - lowerBound);
		
		return data;
	}
	
}

