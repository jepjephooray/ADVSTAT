package model;

import java.util.ArrayList;

import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

import view.Parameters;

import model.generate.GenerationStrategy;


public class Population {
	private int[] data;
	private ArrayList<Sample> listOfSamples;
	private int sampleSize;
	private GenerationStrategy strategy;
	
	public Population(GenerationStrategy strategy, Parameters param) {
		/**
		 * This method does the majority of generation 
		 * of data in the population 
		 */
		this.strategy = strategy;
		data = strategy.GeneratePopulation();
		listOfSamples = new ArrayList<Sample>();
		Initialize(param);
	
		if(data == null || data.length == 0){
			System.err.println("Invalid: No data from the population.");
			return;
		}
		
		
	}
	
	public void Initialize(Parameters param){
		/**
		 * This part begins finding all the possible samples.
		 * This is used for the sampling distribution
		 */
		sampleSize = param.getSmallN();
		strategy.setSampleSize(sampleSize);
		
		ArrayList<Integer> dataList = strategy.FindAllSamplePermutations(data);
		ICombinatoricsVector<Integer> initialVector = Factory.createVector(dataList); 
		Generator<Integer> generator = Factory.createPermutationWithRepetitionGenerator(initialVector, sampleSize);
		
		listOfSamples = new ArrayList<Sample>();
		for(ICombinatoricsVector<Integer> permutation : generator) {
			Sample s = new Sample(sampleSize, permutation);
			listOfSamples.add(s);
		}
	}

	public ArrayList<Sample> getListOfSamples() {
		return listOfSamples;
	}

	public int[] getData() {
		return data;
	}
}
