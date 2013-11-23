package model.generate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import view.Parameters;

public class SkewedStrategy extends GenerationStrategy{


	public SkewedStrategy(Parameters param) {
		super(param);
	}

	public int[] GeneratePopulation(){
		Random rand = new Random();
		ArrayList<Integer> data = new ArrayList<Integer>();
		
		int i;
		for (i = 0; i < populationSize/2; i++) {
			data.add(lowerBound + rand.nextInt(upperBound - lowerBound + 1));
		}
		if(rand.nextBoolean()) {
			System.out.println("1st half of bounds");
			for(; i < populationSize; i++)
				data.add(lowerBound + rand.nextInt( (upperBound - lowerBound)/2 + 1));
		}
		else {
			System.out.println("2nd half of bounds");
			for(; i < populationSize; i++)
				data.add(lowerBound + (upperBound - lowerBound)/2 + rand.nextInt( (upperBound - lowerBound)/2 + 1));
		}
		Collections.sort(data);
		
		int[] data2 = new int[data.size()];
		for(int j = 0; j < data.size(); j++) {
			data2[j] = data.get(j);
			System.out.println(data2[j]);
		}
		return data2;
	}
}
