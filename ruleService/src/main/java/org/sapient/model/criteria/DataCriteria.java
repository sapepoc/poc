package org.sapient.model.criteria;

public class DataCriteria<V> {

	private final Class<V> to;
	private final String systemName;
	private final String styleSheet;

	public DataCriteria(Class<V> to, String systemName, String styleSheet) {
		// TODO Auto-generated constructor stub
		this.to = to;
		this.systemName = systemName;
		this.styleSheet = styleSheet;
	}

	public Class<V> getTo() {
		return to;
	}

	public String getSystemName() {
		return systemName;
	}

	public String getStyleSheet() {
		return styleSheet;
	}

}
