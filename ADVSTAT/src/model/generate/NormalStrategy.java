package model.generate;

import java.util.ArrayList;
import java.util.Random;

import view.Parameters;

public class NormalStrategy extends GenerationStrategy{


	public NormalStrategy(Parameters param) {
		super(param);
	}

	public ArrayList<Double> Generate(){
		ArrayList<Double> data = new ArrayList<Double>();
		ArrayList<Double> temp = null; 
		
		for(int i = 0; i < populationSize; i++){
			//temp = generateRandom(central, lowerBound, upperBound);
			//data.add(getMean(temp));
		}
		return data;
		
	}
}
