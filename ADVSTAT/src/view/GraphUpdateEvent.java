package view;


public class GraphUpdateEvent {
	private Object src;
	private Parameters parameters;
	private UpdateType type;

	public enum UpdateType {
		Population,
		Sample
	}
	
	public GraphUpdateEvent(Object src, Parameters parameters, UpdateType type) {
		super();
		this.src = src;
		this.parameters = parameters;
		this.type = type;
	}

	public Object getSrc() {
		return src;
	}

	public Parameters getParameters() {
		return parameters;
	}
	
	public UpdateType getType() {
		return type;
	}
}
