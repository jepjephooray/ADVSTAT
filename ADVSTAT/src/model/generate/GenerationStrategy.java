package model.generate;

import java.util.ArrayList;

import view.Parameters;

public abstract class GenerationStrategy {
	protected int sampleSize;
	protected int populationSize;
	protected int upperBound;
	protected int lowerBound;
	public GenerationStrategy(Parameters param) {
		super();
		populationSize = param.getBigN();
		sampleSize = param.getSmallN();
		upperBound = param.getU();
		lowerBound = param.getL();
	}
	public abstract ArrayList<Double> Generate();
}
