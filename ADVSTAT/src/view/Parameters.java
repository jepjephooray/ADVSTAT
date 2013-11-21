package view;

import model.Model.GenerationType;

public class Parameters {
	private int n;
	private int N;
	private int u;
	private int l;
	
	private GenerationType type;
	
	private int sliderMinimum;
	
	public Parameters(int n, int N, int u, int l, int sliderMinimum, int sliderMaximum, GenerationType type) {
		super();
		this.n = n;
		this.N = N;
		this.u = u;
		this.l = l;
		this.sliderMinimum = sliderMinimum;
		this.sliderMaximum = sliderMaximum;
		this.type = type;
	}
	
	private int sliderMaximum;
	
	
	public int getSmallN() {
		return n;
	}
	public int getBigN() {
		return N;
	}
	
	public int getU() {
		return u;
	}
	public void setU(int u) {
		this.u = u;
	}
	public int getL() {
		return l;
	}
	public void setL(int l) {
		this.l = l;
	}
	public int getMinimum() {
		return sliderMinimum;
	}
	public int getMaximum() {
		return sliderMaximum;
	}
	public GenerationType getType() {
		return type;
	}

}
