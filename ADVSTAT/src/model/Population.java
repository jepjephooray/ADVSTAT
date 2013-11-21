package model;

import java.util.ArrayList;


public class Population {
	
	private int populationSize, sampleSize;
	private long possibleSamplesSize;
	private float data[], meanOfSampleMeans, varianceOfSampleMeans;
	private float populationMean, populationVariance;
	private ArrayList<PopulationDataEntry> probabilityDistribution;
	private ArrayList<Sample> sampleList;
	
	public Population() {
		probabilityDistribution = new ArrayList<PopulationDataEntry>();
		sampleList = new ArrayList<Sample>();
		populationSize = 0;
		sampleSize = 0;
		populationMean = 0;
		populationVariance = 0;
		data = null;
	}
	
	public void setData(float data[]) { this.data = data; }
	public float[] getData() { return data; }

	public int getPopulationSize() { return populationSize; }
	public void setPopulationSize(int populationSize) { this.populationSize = populationSize; }

	public int getSampleSize() {return sampleSize;}
	public void setSampleSize(int sampleSize) { this.sampleSize = sampleSize; }

	public float getPopulationMean() { return populationMean; }
	public void setPopulationMean(float populationMean) { this.populationMean = populationMean; }

	public float getPopulationVariance() { return populationVariance; }
	public void setPopulationVariance(float populationVariance) { this.populationVariance = populationVariance; }

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

	public float getMeanOfSampleMeans() {
		return meanOfSampleMeans;
	}

	public void setMeanOfSampleMeans(float meanOfSampleMeans) {
		this.meanOfSampleMeans = meanOfSampleMeans;
	}

	public float getVarianceOfSampleMeans() {
		return varianceOfSampleMeans;
	}

	public void setVarianceOfSampleMeans(float varianceOfSampleMeans) {
		this.varianceOfSampleMeans = varianceOfSampleMeans;
	}
	
}
