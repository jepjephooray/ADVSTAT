package model;

import java.util.ArrayList;

import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

import view.Parameters;

import model.generate.GenerationStrategy;


public class Population {
	private ArrayList<Double> data;
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
		if(data == null || data.size() == 0){
			System.err.println("Invalid: No data from the population.");
			return;
		}
		
		ICombinatoricsVector<Double> initialVector = Factory.createVector(data); 
		Generator<Double> generator = Factory.createMultiCombinationGenerator(initialVector, sampleSize);
		
		for(ICombinatoricsVector<Double> combination : generator) {
			System.out.println(combination);
			listOfSamples.add(new Sample(sampleSize, combination));
		}
	}

	public ArrayList<Double> getData() {
		return data;
	}

	public void setData(ArrayList<Double> data) {
		this.data = data;
	}
}
