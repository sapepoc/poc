package org.sapient.loader;

import java.util.Collection;

import org.sapient.model.criteria.DataCriteria;

public interface DataLoader {

	public <V> Collection<V> getData(DataCriteria<V> criteria);
}
