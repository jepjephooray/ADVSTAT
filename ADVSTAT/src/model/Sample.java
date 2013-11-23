package model;

import java.util.List;

import org.paukov.combinatorics.ICombinatoricsVector;

public class Sample {
	
	ICombinatoricsVector<Integer> data;
	public static int Size;
	int sampleSize, meanFrequency;
	double mean, meanRelativeFrequency;
	
	public Sample(int sampleSize, ICombinatoricsVector<Integer> data) {
		this.data = data;
		this.sampleSize = sampleSize;
		
		meanRelativeFrequency = 0;
		int sum = 0;
		for(int i = 0; i < data.getSize(); i++)
			sum += data.getValue(i);
		mean = (double)sum / data.getSize();
	}
	
	public String toString(){
		String result = "";
		List<Integer> current;
		for (int i = 0; i < data.getSize(); i++){
			result += "double["+i+"] = ";
			current = data.getVector();
			for (Integer d : current)
				result += "["+d.toString()+"]";
			result += "\n";
		}
		result += "mean is: " + mean;
		return result;
	}

	public int getSampleSize() {
		return sampleSize;
	}

	public void setSampleSize(int sampleSize) {
		this.sampleSize = sampleSize;
	}

	public ICombinatoricsVector<Integer> getData() {
		return data;
	}

	public void setData(ICombinatoricsVector<Integer> data) {
		this.data = data;
	}

	public double getMean() {
		return mean;
	}

	public void setMean(float mean) {
		this.mean = mean;
	}

	public double getMeanRelativeFrequency() {
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
