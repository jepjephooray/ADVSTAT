package model;

public class PopulationDataEntry {
	float data, relativeFrequency;
	int frequency;
	
	public PopulationDataEntry(float data, float relativeFrequency, int frequency) {
		this.data = data;
		this.relativeFrequency = relativeFrequency;
		this.frequency = frequency;
	}

	public float getData() {
		return data;
	}

	public void setData(float data) {
		this.data = data;
	}

	public float getRelativeFrequency() {
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
