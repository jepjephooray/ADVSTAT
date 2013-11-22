package model.generate;

import java.util.Random;

import org.jfree.data.category.DefaultCategoryDataset;

import view.Parameters;

public class UniformStrategy extends GenerationStrategy{

	public UniformStrategy(Parameters param) {
		super(param);
	}
	/*
	public double[] Generate(){
		Random rand = new Random();
		double[] data = new double[populationSize];
		for(int i = 0; i < populationSize; i++) {
			data[i] = (double)lowerBound + rand.nextInt(upperBound - lowerBound + 1);
			System.out.println(data[i]);
		}
		return data;
	}*/
	
	public double[] Generate() {
		double[] data = new double[populationSize];
		int adder = 0;
		for (int i = 0; i < populationSize; i++) {
			data[i] = (double)lowerBound + adder;
			adder++;
			if(lowerBound + adder > upperBound)
				adder = 0;
			System.out.println(data[i]);
		}
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
