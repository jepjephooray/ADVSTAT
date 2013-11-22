package model.generate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import view.Parameters;

public class BimodalStrategy extends GenerationStrategy{


	public BimodalStrategy(Parameters param) {
		super(param);
	}

	public double[] Generate(){
		
		double data[] = new double[populationSize];
		double temp[] = null;
		int central = 10;
		for (int i = 0; i < populationSize; i++) {
			if(i < populationSize/2) {
				temp = generateRandom(central, lowerBound, (lowerBound + upperBound)/2);
				data[i] = (int)getMean(temp);
				System.out.print("first: ");
			}
			else {
				temp = generateRandom(central, lowerBound, upperBound);
				data[i] = (int)getMean(temp);
				System.out.print("2nd: ");
			}
			
			System.out.println(data[i]);
		}
		
		ArrayList<Double> dobol = new ArrayList<Double>();
		for (int i = 0; i < data.length; i++) {
			dobol.add(data[i]);
		}
		Collections.sort(dobol);
		
		for (int i = 0; i < dobol.size(); i++) {
			data[i] = dobol.get(i);
			System.out.println(data[i]);
		}
		/*
		double firsthalfdata[] = new double[populationSize/2];
		for (int i = 0; i < firsthalfdata.length; i++) {
			firsthalfdata[i] = data[i];
		}
		System.out.println("mean of first: " + getMean(firsthalfdata));
		double secondhalfdata[] = new double[populationSize/2];
		for (int i = 0; i < populationSize; i++) {
			if(i > populationSize/2) {
				for (int j = 0; j < secondhalfdata.length; j++) {
					secondhalfdata[j] = data[i];
					i++;
					if(i >= populationSize)
						break;
				}
				break;
			}
		}
		System.out.println("mean of second: " + getMean(secondhalfdata));
		*/
		
		return null;
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
			data[i] = (double)lowerBound + /*rand.nextInt(upperBound - lowerBound)*/ rand.nextDouble() * (upperBound - lowerBound);
		
		return data;
	}
}
