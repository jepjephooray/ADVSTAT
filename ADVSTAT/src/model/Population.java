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
	
	public Population(GenerationStrategy strategy, Parameters param) {
		/**
		 * This method does the majority of generation 
		 * of data in the population 
		 */
		data = strategy.GeneratePopulation();
		listOfSamples = new ArrayList<Sample>();
		sampleSize = param.getSmallN();
	
		if(data == null || data.length == 0){
			System.err.println("Invalid: No data from the population.");
			return;
		}
		
		/**
		 * This part begins finding all the possible samples.
		 * This is used for the sampling distribution
		 */
		ArrayList<Integer> dataList = strategy.FindAllSamplePermutations();
		ICombinatoricsVector<Integer> initialVector = Factory.createVector(dataList); 
		Generator<Integer> generator = Factory.createPermutationWithRepetitionGenerator(initialVector, sampleSize);
		
		for(ICombinatoricsVector<Integer> permutation : generator) {
			Sample s = new Sample(sampleSize, permutation);
			listOfSamples.add(s);
		}
	}

	public ArrayList<Sample> getListOfSamples() {
		return listOfSamples;
	}

	public double[] getData() {
		return data;
	}
}
