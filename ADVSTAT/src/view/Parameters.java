package view;

import model.Model.GenerationType;

public class Parameters {
	private int n;
	private int N;
	private int u;
	private int l;
	
	private GenerationType type;
	
	public Parameters(int n, int N, int u, int l, GenerationType type) {
		super();
		this.n = n;
		this.N = N;
		this.u = u;
		this.l = l;
		this.type = type;
	}
	
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
	public GenerationType getType() {
		return type;
	}

}
