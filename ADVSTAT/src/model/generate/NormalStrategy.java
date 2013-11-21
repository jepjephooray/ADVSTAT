package model.generate;

import java.util.ArrayList;
import java.util.Random;

import view.Parameters;

public class NormalStrategy extends GenerationStrategy{


	public NormalStrategy(Parameters param) {
		super(param);
	}

	public ArrayList<Double> Generate(){
		Random rand = new Random();
		ArrayList<Double> data = new ArrayList<Double>();
		for(int i = 0; i < populationSize; i++)
			data.add(lowerBound + rand.nextDouble() * (upperBound - lowerBound));
		
		return data;
		
	}
}
