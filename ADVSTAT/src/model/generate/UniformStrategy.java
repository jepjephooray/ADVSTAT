package model.generate;

import java.util.Random;

import org.jfree.data.category.DefaultCategoryDataset;

import view.Parameters;

public class UniformStrategy extends GenerationStrategy{

	public UniformStrategy(Parameters param) {
		super(param);
	}
	
	public int[] GeneratePopulation() {
		int[] data = new int[populationSize];
		int adder = 0;
		for (int i = 0; i < populationSize; i++) {
			data[i] = lowerBound + adder;
			adder++;
			if(lowerBound + adder > upperBound)
				adder = 0;
			System.out.println(data[i]);
		}
		return data;
	}
	
}
