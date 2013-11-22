package model.generate;

import java.util.Random;

import org.jfree.data.category.DefaultCategoryDataset;

import view.Parameters;

public class UniformStrategy extends GenerationStrategy{

	public UniformStrategy(Parameters param) {
		super(param);
	}
	
	
	public double[] Generate(){
		Random rand = new Random();
		double[] data = new double[populationSize];
		for(int i = 0; i < populationSize; i++)
			data[i] = lowerBound + rand.nextDouble() * (upperBound - lowerBound);
		
		return data;
		
	}
	
	public DefaultCategoryDataset Generate2() {
		Random rand = new Random();
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		
		// generate population data at the start of program (when user enters N, L, and U)
		// generate 
		
		//data.set
		/*
		 * data.setValue( frequency, "Frequency", "Interval")
		 * data.setValue( 5, "Frequency", "5.0-5.5")
		 */
		
		return data;
	}
}
