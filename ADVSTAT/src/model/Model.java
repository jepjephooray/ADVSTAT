package model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

public class Model {
	
	Population population;
	int central = 100;
	
	public Model() {
		population = new Population();
	}
	
	public ArrayList<Double> generateContinuousNormal(int size, int lower, int upper){
		ArrayList<Double> data = new ArrayList<Double>();
		ArrayList<Double> temp = null; 
		
		for(int i = 0; i < size; i++){
			temp = generateContinuousRandom(central,lower,upper);
			data.add(getMean(temp));
		}
		return data;
	}
	
	
	public ArrayList<Double> generateContinuousRandom(int size, int lower, int upper){
		Random rand = new Random();
		ArrayList<Double> data = new ArrayList<Double>();
		for(int i = 0; i < size; i++)
			data.add(lower + rand.nextDouble() * (upper - lower));
		
		return data;
		
	}
	
	public ArrayList<Integer> generateDiscreteRandom(int size, int lower, int upper){
		Random rand = new Random();
		ArrayList<Integer> data = new ArrayList<Integer>();
		for(int i = 0; i < size; i++)
			data.add(lower + rand.nextInt(upper+1));
		return data;
		
	}
	
	public double getMean(ArrayList<Double> data){
		double sum = 0;
		for(int i = 0; i < data.size(); i++)
			sum += data.get(i);
		return sum / data.size();
	}
	
	public void generatePossibleSamples(int sampleSize) {
		if(population.getData() == null || population.getData().length == 0)
			return;
		population.setSampleSize(sampleSize);
		
		ArrayList<Double> flot = new ArrayList<Double>();
		for(int i = 0; i < population.getData().length; i++)
			flot.add(population.getData()[i]);
		
		ICombinatoricsVector<Double> initialVector = Factory.createVector(flot); 
		Generator<Double> gen = Factory.createMultiCombinationGenerator(initialVector, sampleSize);
		population.setPossibleSamplesSize(gen.getNumberOfGeneratedObjects());
		
		for(ICombinatoricsVector<Double> combination : gen) {
			System.out.println(combination);
			population.getSampleList().add(new Sample(sampleSize, combination));
		}
	}
	
	public void generateContinuousData(int lowerBound, int upperBound, int size) {
		if(size <= 0)
			return;
		Random rand = new Random();
		double data[] = new double[size];
		for (int i = 0; i < data.length; i++) 
			data[i] = lowerBound + rand.nextFloat()*(upperBound - lowerBound); // randomize float data with min lowerBound and max upperBound 
		population.setData(data);
		population.setPopulationSize(size);
	}
	
	public void generateDiscreteData(int lowerBound, int upperBound, int size) {
		if(size <= 0)
			return;
		Random rand = new Random();
		double data[] = new double[size];
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
		double sum = 0, mean, variance = 0;
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
		double sum = 0;
		for (Sample sample : population.getSampleList()) {
			sum += sample.getMean();
		}
		population.setMeanOfSampleMeans(sum / population.getPossibleSamplesSize());
		
		//System.out.println(population.getPopulationVariance() + " / " + population.getSampleSize());
		population.setVarianceOfSampleMeans(population.getPopulationVariance() / population.getSampleSize());
		
		System.out.println("mean of sample means: " + population.getMeanOfSampleMeans() + " ; " + 
				"variance: " + population.getVarianceOfSampleMeans());
	}
	
	public Hashtable<String, Integer> getFrequencyTable() {
		Hashtable<String, Integer> frequencyTable = new Hashtable<String, Integer>();
		
		for (int i = 0; i < population.getData().length; i++) {
			String key = Double.toString(population.getData()[i]);
			Integer value = (frequencyTable.containsKey(key) ? frequencyTable.get(key) + 1 : 1);
			frequencyTable.put(key, value);
		}
		
		return frequencyTable;
	}
	
	public void generatePopulationDistributionTable() {
		ArrayList<PopulationDataEntry> populationDistribution = new ArrayList<PopulationDataEntry>();
		int count = 0;
		for (int i = 0; i < population.getData().length; i++) {
			double data = population.getData()[i];
			if(!hasData(data, populationDistribution)) {
				for (int j = 0; j < population.getData().length; j++) 
					if(data == population.getData()[j])
						count++;
				
				populationDistribution.add(new PopulationDataEntry(data, count / (double)population.getData().length, count));
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
			double mean = sample.getMean();
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
	
	private boolean hasMean(double mean, ArrayList<Sample> samplingDistribution) {
		for (Sample sample : samplingDistribution) {
			if(sample.getMean() == mean)
				return true;
		}
		return false;
	}
	
	private boolean hasData(double data, ArrayList<PopulationDataEntry> populationDistribution) {
		for (PopulationDataEntry dataEntry : populationDistribution) {
			if(dataEntry.getData() == data)
				return true;
		}
		return false;
	}

	public Population getPopulation() {
		return population;
	}
	
	public void setPopulationSize(int size) {
		population.setPopulationSize(size);
	}
	
	public void setSampleSize(int size) {
		population.setSampleSize(size);
	}
}
