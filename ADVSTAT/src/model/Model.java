package model;

import java.text.Bidi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

import model.generate.BimodalStrategy;
import model.generate.GenerationStrategy;
import model.generate.NormalStrategy;
import model.generate.RandomStrategy;
import model.generate.SkewedStrategy;
import model.generate.UniformStrategy;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

import view.Parameters;

public class Model {
	
	public static enum GenerationType {
		Uniform,
		Bimodal,
		Normal,
		Random,
		Skewed
	}
	
	private GenerationType generationType;
	
	Population population;
	
	protected int sampleSize;
	protected int populationSize;
	protected int upperBound;
	protected int lowerBound;
	
	/**
	 * Gets the information from the given parameters and
	 * generates the data and stores it in the population.
	 * 
	 * The type of generation strategy is provided in the 
	 * parameters.
	 * @param param
	 */
	public void Initialize(Parameters param){
		generationType = param.getType();
		
		populationSize = param.getBigN();
		sampleSize = param.getSmallN();
		upperBound = param.getU();
		lowerBound = param.getL();
		
		GenerationStrategy strategy = null;
		switch(generationType){
			case Bimodal:
				strategy = new BimodalStrategy(param);
				break;
			case Normal:
				strategy = new NormalStrategy(param);
				break;
			case Random:
				strategy = new RandomStrategy(param);
				break;
			case Skewed:
				strategy = new SkewedStrategy(param);
				break;
			case Uniform:
				strategy = new UniformStrategy(param);
				break;
			default:
				break;
		}
		population = new Population(strategy, param);
	}
	
/*	
	public ArrayList<Double> generateContinuousNormal(int size, int lower, int upper){
		ArrayList<Double> data = new ArrayList<Double>();
		ArrayList<Double> temp = null; 
		
		for(int i = 0; i < size; i++){
			temp = generateContinuousRandom(central,lower,upper);
			data.add(getMean(temp));
		}
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
		
	}
	
	public void generateContinuousData(int size, int lowerBound, int upperBound) {
		if(size <= 0)
			return;
		Random rand = new Random();
		ArrayList<Double> data = new ArrayList<Double>();
		for (int i = 0; i < size; i++) 
			data.add(lowerBound + rand.nextDouble()*(upperBound - lowerBound)); // randomize float data with min lowerBound and max upperBound 
		population.setData(data);
		population.setPopulationSize(size);
	}
	
	public void generateDiscreteData(int size, int lowerBound, int upperBound) {
		if(size <= 0)
			return;
		Random rand = new Random();
		ArrayList<Double> data = new ArrayList<Double>();
		for (int i = 0; i < size; i++) { 
			data.add(lowerBound + (double)rand.nextInt(upperBound-lowerBound+1)); // randomize int data with min lowerBound and max upperBound 
			System.out.println(data.get(i));
		}
		population.setData(data);
		population.setPopulationSize(size);
	}

	*/ 
	public CategoryDataset getPopulationFrequencyTable() {
		ArrayList<Sample> listOfSamples = population.getListOfSamples();
		HashMap<String, Integer> data = new HashMap<String, Integer>();
		for(Sample currentSample : listOfSamples){
			double mean = currentSample.getMean();
			if (data.containsKey(""+mean)){
				data.put(""+mean, data.get(""+mean) + 1);
			}else{
				data.put(""+mean, 1);
			}
		}
		
		List<String> keys = new ArrayList<String>(data.keySet());
		Collections.sort(keys);
		DefaultCategoryDataset mySeries= new DefaultCategoryDataset();
		for(String key : keys) {
			double d = data.get(key);
			double totalsize = keys.size();
			double probability = d / totalsize;
			mySeries.addValue(probability, "Mean", key);
		}
		
		
		return mySeries;
	}
	
	private ArrayList<Double> primitiveToObject(double[] data) {
		ArrayList<Double> data2 = new ArrayList<Double>();
		if (data != null)
			for (int i = 0; i < data.length; i++) {
				data2.add(new Double(data[i]));
			}
		return data2;
	}
}
