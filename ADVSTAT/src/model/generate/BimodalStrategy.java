package model.generate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import view.Parameters;

public class BimodalStrategy extends GenerationStrategy{


	public BimodalStrategy(Parameters param) {
		super(param);
	}

	public int[] GeneratePopulation(){
		
		ArrayList<Integer> data = new ArrayList<Integer>();
		int temp[] = null;
		int central = 10;
		for (int i = 0; i < populationSize; i++) {
			if(i < populationSize/2) {
				temp = generateRandom(central, lowerBound, (lowerBound + upperBound)/2);
				data.add(getMean(temp));
			}
			else {
				temp = generateRandom(central, lowerBound, upperBound);
				data.add(getMean(temp));
			}
			
		}
		
		Collections.sort(data);
		
		int[] data2 = new int[data.size()];
		for (int i = 0; i < data.size(); i++) {
			data2[i] = data.get(i);
		}
		
		return data2;
	}
	
	private int getMean(int[] data) {
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return sum / data.length;
	}
	
	private int[] generateRandom(int central, int lowerBound, int upperBound) {
		Random rand = new Random();
		int[] data = new int[central];
		for(int i = 0; i < central; i++)
			data[i] = lowerBound + rand.nextInt(upperBound - lowerBound) /*rand.nextDouble() * (upperBound - lowerBound)*/;
		
		return data;
	}
}
