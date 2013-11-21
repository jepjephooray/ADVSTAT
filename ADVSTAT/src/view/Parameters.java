package view;

public class Parameters {
	private int n;
	private int N;
	private int k;
	
	private int sliderMinimum;
	
	public Parameters(int n, int N, int k, int sliderMinimum, int sliderMaximum) {
		super();
		this.n = n;
		this.N = N;
		this.k = k;
		this.sliderMinimum = sliderMinimum;
		this.sliderMaximum = sliderMaximum;
	}
	
	private int sliderMaximum;
	
	
	public int getSmallN() {
		return n;
	}
	public int getBigN() {
		return N;
	}
	public int getK() {
		return k;
	}
	public int getMinimum() {
		return sliderMinimum;
	}
	public int getMaximum() {
		return sliderMaximum;
	}
}
