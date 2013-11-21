package view;


public class GraphUpdateEvent {
	private Object src;
	private Parameters parameters;
	
	public GraphUpdateEvent(Object src, Parameters parameters) {
		super();
		this.src = src;
		this.parameters = parameters;
	}

	public Object getSrc() {
		return src;
	}

	public Parameters getParameters() {
		return parameters;
	}
}
