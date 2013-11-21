package model;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;

import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

public class Model {
	
	Population population;
	
	public Model() {
		population = new Population();
	}
	
	public void generatePossibleSamples(int sampleSize) {
		if(population.getData() == null || population.getData().length == 0)
			return;
		population.setSampleSize(sampleSize);
		
		ArrayList<Float> flot = new ArrayList<Float>();
		for(int i = 0; i < population.getData().length; i++)
			flot.add(population.getData()[i]);
		
		ICombinatoricsVector<Float> initialVector = Factory.createVector(flot); 
		Generator<Float> gen = Factory.createMultiCombinationGenerator(initialVector, sampleSize);
		population.setPossibleSamplesSize(gen.getNumberOfGeneratedObjects());
		
		for(ICombinatoricsVector<Float> combination : gen) {
			System.out.println(combination);
			population.getSampleList().add(new Sample(sampleSize, combination));
		}
	}
	
	public void generateFloatData(int lowerBound, int upperBound, int size) {
		if(size <= 0)
			return;
		Random rand = new Random();
		float data[] = new float[size];
		for (int i = 0; i < data.length; i++) 
			data[i] = lowerBound + rand.nextFloat()*(upperBound - lowerBound); // randomize float data with min lowerBound and max upperBound 
		population.setData(data);
		population.setPopulationSize(size);
	}
	
	public void generateIntData(int lowerBound, int upperBound, int size) {
		if(size <= 0)
			return;
		Random rand = new Random();
		float data[] = new float[size];
		for (int i = 0; i < data.length; i++) 
			data[i] = lowerBound + rand.nextInt(upperBound-lowerBound+1); // randomize int data with min lowerBound and max upperBound 
		population.setData(data);
		population.setPopulationSize(size);
	}
	
	public void generatePopulationSize() {
		Random rand = new Random();
		population.setPopulationSize(10 + rand.nextInt(51)); // min size 10, max size 50
	}
	
	public void population_mean_variance() {
		float sum = 0, mean, variance = 0;
		for (int i = 0; i < population.getData().length; i++) 
			sum += population.getData()[i];
		// u
		mean = sum / population.getPopulationSize();
		population.setPopulationMean(mean);
		
		// o
		for (int i = 0; i < population.getData().length; i++) 
			variance = (population.getData()[i] - mean) * (population.getData()[i] - mean);
		population.setPopulationVariance(variance);
		
		System.out.println("mean: " + population.getPopulationMean() + " ; variance: " + population.getPopulationVariance());
	}
	
	public void sampleMean_mean_variance() {
		float sum = 0;
		for (Sample sample : population.getSampleList()) {
			sum += sample.getMean();
		}
		population.setMeanOfSampleMeans(sum / population.getPossibleSamplesSize());
		
		//System.out.println(population.getPopulationVariance() + " / " + population.getSampleSize());
		population.setVarianceOfSampleMeans(population.getPopulationVariance() / population.getSampleSize());
		
		System.out.println("mean of sample means: " + population.getMeanOfSampleMeans() + " ; " + 
				"variance: " + population.getVarianceOfSampleMeans());
	}
	
	public void generatePopulationDistributionTable() {
		ArrayList<PopulationDataEntry> populationDistribution = new ArrayList<PopulationDataEntry>();
		int count = 0;
		for (int i = 0; i < population.getData().length; i++) {
			float data = population.getData()[i];
			if(!hasData(data, populationDistribution)) {
				for (int j = 0; j < population.getData().length; j++) 
					if(data == population.getData()[j])
						count++;
				
				populationDistribution.add(new PopulationDataEntry(data, count / (float)population.getData().length, count));
				count = 0;
			}
		}
		/*
		for (DataEntry dataEntry : populationDistribution) 
			System.out.println(dataEntry.data + " - " + dataEntry.frequency + " - " + dataEntry.relativeFrequency);
		*/
	}
	
	public void generateSamplingDistributionTable() {
		ArrayList<Sample> samplingDistribution = new ArrayList<Sample>();
		int count = 0;
		for(int i = 0; i < population.getSampleList().size(); i++) {
			Sample sample = population.getSampleList().get(i);
			float mean = sample.getMean();
			if(!hasMean(mean, samplingDistribution)) {
				for (int j = 0; j < population.getSampleList().size(); j++) 
					if(mean == population.getSampleList().get(j).getMean())
						count++;
				
				sample.setMeanFrequency(count);
				sample.setMeanRelativeFrequency( count / (float)population.getPossibleSamplesSize() );
				samplingDistribution.add(sample);
				count = 0;
			}
			
		}
		for (Sample sample : samplingDistribution) {
			System.out.println(sample.mean + " - " + sample.meanFrequency + " - " + sample.meanRelativeFrequency);
		}
		
		
	}
	
	private boolean hasMean(float mean, ArrayList<Sample> samplingDistribution) {
		for (Sample sample : samplingDistribution) {
			if(sample.getMean() == mean)
				return true;
		}
		return false;
	}
	
	private boolean hasData(float data, ArrayList<PopulationDataEntry> populationDistribution) {
		for (PopulationDataEntry dataEntry : populationDistribution) {
			if(dataEntry.getData() == data)
				return true;
		}
		return false;
	}

	public Population getPopulation() {
		return population;
	}
}
