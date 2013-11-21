package model;

import java.util.ArrayList;


public class Population {
	
	private int populationSize, sampleSize;
	private long possibleSamplesSize;
	private ArrayList<Double> data;
	private double meanOfSampleMeans, varianceOfSampleMeans;
	private double populationMean, populationVariance;
	private ArrayList<PopulationDataEntry> probabilityDistribution;
	private ArrayList<Sample> sampleList;
	
	public Population() {
		probabilityDistribution = new ArrayList<PopulationDataEntry>();
		sampleList = new ArrayList<Sample>();
		populationSize = 0;
		sampleSize = 0;
		populationMean = 0;
		populationVariance = 0;
		data = new ArrayList<Double>();
	}
	
	public void setData(ArrayList<Double> data) { this.data = data; }
	public ArrayList<Double> getData() { return data; }

	public int getPopulationSize() { return populationSize; }
	public void setPopulationSize(int populationSize) { this.populationSize = populationSize; }

	public int getSampleSize() {return sampleSize;}
	public void setSampleSize(int sampleSize) { this.sampleSize = sampleSize; }

	public double getPopulationMean() { return populationMean; }
	public void setPopulationMean(double populationMean) { this.populationMean = populationMean; }

	public double getPopulationVariance() { return populationVariance; }
	public void setPopulationVariance(double populationVariance) { this.populationVariance = populationVariance; }

	public ArrayList<PopulationDataEntry> getProbabilityDistribution() { return probabilityDistribution; }
	public void setProbabilityDistribution(
			ArrayList<PopulationDataEntry> probabilityDistribution) { this.probabilityDistribution = probabilityDistribution; }

	public ArrayList<Sample> getSampleList() {
		return sampleList;
	}

	public void setSampleList(ArrayList<Sample> sampleList) {
		this.sampleList = sampleList;
	}

	public long getPossibleSamplesSize() {
		return possibleSamplesSize;
	}

	public void setPossibleSamplesSize(long possibleSamplesSize) {
		this.possibleSamplesSize = possibleSamplesSize;
	}

	public double getMeanOfSampleMeans() {
		return meanOfSampleMeans;
	}

	public void setMeanOfSampleMeans(double meanOfSampleMeans) {
		this.meanOfSampleMeans = meanOfSampleMeans;
	}

	public double getVarianceOfSampleMeans() {
		return varianceOfSampleMeans;
	}

	public void setVarianceOfSampleMeans(double varianceOfSampleMeans) {
		this.varianceOfSampleMeans = varianceOfSampleMeans;
	}
	
}
