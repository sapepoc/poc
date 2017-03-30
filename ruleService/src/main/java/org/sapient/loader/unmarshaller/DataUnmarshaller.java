package org.sapient.loader.unmarshaller;

import java.util.Collection;

import org.sapient.model.criteria.DataCriteria;

public interface DataUnmarshaller {

	public <V> Collection<V> unmarshal(DataCriteria<V> dataCriteria, Collection<String> xmls);

	public <V> V unmarshal(DataCriteria<V> dataCriteria, String xmls);

}
