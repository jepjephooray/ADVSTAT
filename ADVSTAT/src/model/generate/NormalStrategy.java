package model.generate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import view.Parameters;

public class NormalStrategy extends GenerationStrategy{


	public NormalStrategy(Parameters param) {
		super(param);
	}
	
	

	public int[] GeneratePopulation(){
		//Random rand = new Random();
		ArrayList<Integer> data = new ArrayList<Integer>();
		int[] temp = null;

		
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
		
		int[] data2 = new int[data.size()];
		for (int i = 0; i < data.size(); i++) {
			data2[i] = data.get(i);
		}
		
		return temp;
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
	
	private int[] generateRandom(int central, int lowerBound, int upperBound) {
		Random rand = new Random();
		int[] data = new int[central];
		for(int i = 0; i < central; i++)
			data[i] = lowerBound + rand.nextInt(upperBound - lowerBound + 1) /*rand.nextDouble() * (upperBound - lowerBound) */ ;
		
		return data;
	}
	
}

