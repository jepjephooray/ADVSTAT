package model;

public class PopulationDataEntry {
	double data, relativeFrequency;
	int frequency;
	
	public PopulationDataEntry(double data, double relativeFrequency, int frequency) {
		this.data = data;
		this.relativeFrequency = relativeFrequency;
		this.frequency = frequency;
	}

	public double getData() {
		return data;
	}

	public void setData(float data) {
		this.data = data;
	}

	public double getRelativeFrequency() {
		return relativeFrequency;
	}

	public void setRelativeFrequency(float relativeFrequency) {
		this.relativeFrequency = relativeFrequency;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
}
