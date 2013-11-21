package model;

import java.util.ArrayList;

import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

import view.Parameters;

import model.generate.GenerationStrategy;


public class Population {
	private double[] data;
	private ArrayList<Sample> listOfSamples;
	private int sampleSize;
	private int populationSize;
	private int upperBound;
	private int lowerBound;
	
	public Population(GenerationStrategy strategy, Parameters param) {
		data = strategy.Generate();
		listOfSamples = new ArrayList<Sample>();
		populationSize = param.getBigN();
		sampleSize = param.getSmallN();
		upperBound = param.getU();
		lowerBound = param.getL();
	
		/**
		 * Generates all the possible combinations
		 */
		if(data == null || data.length == 0){
			System.err.println("Invalid: No data from the population.");
			return;
		}
		
		ArrayList<Double> dataList = new ArrayList<Double>();
		for (int i = 0; i < data.length; i++) {
			dataList.add(data[i]);
		}
		
		ICombinatoricsVector<Double> initialVector = Factory.createVector(dataList); 
		Generator<Double> generator = Factory.createPermutationWithRepetitionGenerator(initialVector, sampleSize);
		
		for(ICombinatoricsVector<Double> permutation : generator) {
			System.out.println(permutation);
			listOfSamples.add(new Sample(sampleSize, permutation));
		}
		
		
		
	}

	public double[] getData() {
		return data;
	}

	public void setData(double[] data) {
		this.data = data;
	}
}
