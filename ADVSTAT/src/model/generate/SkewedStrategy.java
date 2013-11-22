package model.generate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import view.Parameters;

public class SkewedStrategy extends GenerationStrategy{


	public SkewedStrategy(Parameters param) {
		super(param);
	}

	public double[] Generate(){
		Random rand = new Random();
		ArrayList<Double> data = new ArrayList<Double>();
		
		int i;
		for (i = 0; i < populationSize/2; i++) {
			data.add((double)lowerBound + rand.nextInt(upperBound - lowerBound + 1));
		}
		if(rand.nextBoolean()) {
			System.out.println("1st half of bounds");
			for(; i < populationSize; i++)
				data.add((double)lowerBound + rand.nextInt( (upperBound - lowerBound)/2 + 1));
		}
		else {
			System.out.println("2nd half of bounds");
			for(; i < populationSize; i++)
				data.add((double)lowerBound + (upperBound - lowerBound)/2 + rand.nextInt( (upperBound - lowerBound)/2 + 1));
		}
		Collections.sort(data);
		
		double[] data2 = new double[data.size()];
		for(int j = 0; j < data.size(); j++) {
			data2[j] = data.get(j);
			System.out.println(data2[j]);
		}
		return data2;
	}
}
