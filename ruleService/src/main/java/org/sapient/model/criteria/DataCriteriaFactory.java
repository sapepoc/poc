package org.sapient.model.criteria;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.sapient.model.Trade;
import org.springframework.stereotype.Component;

import com.sample.model.Fact;

/**
 * 
 * @author hgaur2
 *
 */
@Component
public class DataCriteriaFactory {

	private Map<String, DataCriteria<? extends Fact>> criteriaMap = new HashMap<>();

	public DataCriteria<? extends Fact> getDataCriteria(String system) {
		DataCriteria<? extends Fact> criteria =criteriaMap.get(system);
		if(null==criteria){
			throw new RuntimeException("No system found for system : " + system);
		}
		return criteriaMap.get(system);
	}

	@PostConstruct
	public void init() {
		criteriaMap.put("trade", new DataCriteria<Trade>(Trade.class, "fx", "data/trade.xsl"));
	}
}
