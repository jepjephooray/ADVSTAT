package model;

import org.paukov.combinatorics.ICombinatoricsVector;

public class Sample {
	
	ICombinatoricsVector<Double> data;
	int sampleSize, meanFrequency;
	float mean, meanRelativeFrequency;
	
	public Sample(int sampleSize, ICombinatoricsVector<Double> data) {
		this.data = data;
		this.sampleSize = sampleSize;
		meanRelativeFrequency = 0;
		int sum = 0;
		for(int i = 0; i < data.getSize(); i++)
			sum += data.getValue(i);
		mean = (float)sum / data.getSize();
		System.out.println("mean: "+ mean + "\n");
	}

	public int getSampleSize() {
		return sampleSize;
	}

	public void setSampleSize(int sampleSize) {
		this.sampleSize = sampleSize;
	}

	public ICombinatoricsVector<Double> getData() {
		return data;
	}

	public void setData(ICombinatoricsVector<Double> data) {
		this.data = data;
	}

	public float getMean() {
		return mean;
	}

	public void setMean(float mean) {
		this.mean = mean;
	}

	public float getMeanRelativeFrequency() {
		return meanRelativeFrequency;
	}

	public void setMeanRelativeFrequency(float relativeFrequency) {
		this.meanRelativeFrequency = relativeFrequency;
	}

	public int getMeanFrequency() {
		return meanFrequency;
	}

	public void setMeanFrequency(int frequency) {
		this.meanFrequency = frequency;
	}
}
