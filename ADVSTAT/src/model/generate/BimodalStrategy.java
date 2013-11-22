package model.generate;

import java.util.ArrayList;
import java.util.Random;

import view.Parameters;

public class BimodalStrategy extends GenerationStrategy{


	public BimodalStrategy(Parameters param) {
		super(param);
	}

	public double[] Generate(){
		
		double data[] = new double[populationSize];
		double temp[] = null;
		for (int i = 0; i < populationSize; i++) {
			if(i < populationSize/2) {
				temp = generateRandom(lowerBound, (lowerBound + upperBound)/2);
				data[i] = getMean(temp);
				System.out.print("first: ");
			}
			else {
				temp = generateRandom((lowerBound + upperBound)/2, upperBound);
				data[i] = getMean(temp);
				System.out.print("2nd: ");
			}
			
			System.out.println(data[i]);
		}
		
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

		
		return null;
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
