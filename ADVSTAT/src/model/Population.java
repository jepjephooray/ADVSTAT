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
	private double sampleMean;
	private double sampleVariance;
	
	private int populationSize;
	private double mean;
	private double variance;
	private GenerationStrategy strategy;
	
	public Population(GenerationStrategy strategy, Parameters param) {
		/**
		 * This method does the majority of generation 
		 * of data in the population 
		 */
		this.strategy = strategy;
		data = strategy.GeneratePopulation();
		mean = getMean(data);
		variance = getVariance(data, mean);
		populationSize = param.getBigN();
		
		listOfSamples = new ArrayList<Sample>();
		Initialize(param);
	
		if(data == null || data.length == 0){
			System.err.println("Invalid: No data from the population.");
			return;
		}
		
		
	}
	
	private double getVariance(int[] data, double mean) {
		double variance = 0;
		for (int i = 0; i < data.length; i++) {
			variance += (data[i] - mean) * (data[i] - mean);
		}
		return variance / data.length;
	}
	
	private double getVariance(double[] data, double mean) {
		double variance = 0;
		for (int i = 0; i < data.length; i++) {
			variance += (data[i] - mean) * (data[i] - mean);
		}
		return variance / data.length;
	}

	private double getMean(int[] data) {
		double sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return sum / data.length;
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
		Generator<Integer> generator = Factory.createMultiCombinationGenerator(initialVector, sampleSize);
		//Generator<Integer> generator = Factory.createPermutationWithRepetitionGenerator(initialVector, sampleSize);
		
		listOfSamples = new ArrayList<Sample>();
		double totalMean = 0;
		
		for(ICombinatoricsVector<Integer> permutation : generator) {
			Sample s = new Sample(sampleSize, permutation);
			totalMean += s.getMean();
			listOfSamples.add(s);
		}
		
		double[] meanOfSamples = new double[listOfSamples.size()];
		for (int i = 0; i < listOfSamples.size(); i++)
			meanOfSamples[i] = listOfSamples.get(i).getMean();
		
		sampleMean = totalMean / listOfSamples.size();
		sampleVariance = getVariance(meanOfSamples, totalMean); 
	}

	public ArrayList<Sample> getListOfSamples() {
		return listOfSamples;
	}

	public int[] getData() {
		return data;
	}

	public double getVariance() {
		return variance;
	}

	public int getSampleSize() {
		return sampleSize;
	}

	public GenerationStrategy getStrategy() {
		return strategy;
	}

	public int getPopulationSize() {
		return populationSize;
	}

	public double getMean() {
		return mean;
	}

	public double getSampleMean() {
		return sampleMean;
	}

	public double getSampleVariance() {
		return sampleVariance;
	}
}
