package org.sapient.loader.impl;

import java.util.Collection;

import org.sapient.loader.DataLoader;
import org.sapient.loader.proxy.ProxyService;
import org.sapient.loader.unmarshaller.DataUnmarshaller;
import org.sapient.model.criteria.DataCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 
 * @author hgaur2
 *
 */
@Component
@Qualifier("dataLoader")
public class DataLoaderImpl implements DataLoader {

	@Autowired
	ProxyService proxyService;

	@Autowired
	DataUnmarshaller DataUnmarshaller;

	@Override
	public <V> Collection<V> getData(final DataCriteria<V> criteria) {
		return DataUnmarshaller.unmarshal(criteria, proxyService.getXMLs(criteria.getSystemName()));
	}

}
