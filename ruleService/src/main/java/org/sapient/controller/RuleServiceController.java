package org.sapient.controller;

import java.util.Collection;

import javax.annotation.PostConstruct;

import org.sapient.loader.DataLoader;
import org.sapient.loader.RuleGroupLoader;
import org.sapient.model.criteria.DataCriteriaFactory;
import org.sapient.rule.RuleGroup;
import org.sapient.ruleengine.alarm.core.AlarmEvent;
import org.sapient.ruleengine.alarm.core.AlarmEventObserver;
import org.sapient.ruleengine.alarm.core.Topic;
import org.sapient.service.AlertGenerator;
import org.sapient.service.RuleEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.model.Fact;

/**
 * 
 * @author hgaur2
 *
 */
@RestController
public class RuleServiceController {

	@Autowired
	@Qualifier("ruleGroupLoader")
	private RuleGroupLoader ruleGroupLoader;

	@Autowired
	@Qualifier("dataLoader")
	private DataLoader dataLoader;

	@Autowired
	@Qualifier("ruleEngineService")
	private RuleEngineService ruleEngineService;

	@Autowired
	@Qualifier("alertGenerator")
	private AlertGenerator alertGenerator;

	@Autowired
	private DataCriteriaFactory dataCriteriaFactory;
	
	@RequestMapping(method = RequestMethod.GET, value = "/{fact}/runRule")
	public @ResponseBody Collection<? extends Fact> runRule(@PathVariable String fact) {
		return start(fact);
	}

	public Collection<? extends Fact> start(String fact) {

		Collection<? extends Fact> facts = dataLoader.getData(dataCriteriaFactory.getDataCriteria(fact));

		Collection<RuleGroup> ruleGroup = ruleGroupLoader.getRuleGroup();

		ruleEngineService.runRules(facts, ruleGroup);
		return facts;

	}

	@PostConstruct
	public void init() {
		ruleEngineService.registerEventListener(new AlarmEventObserver<AlarmEvent>() {

			@Override
			public Topic getTopic() {
				// TODO Auto-generated method stub
				return Topic.WASH_TRADE_EVENT;
			}

			@Override
			public void notify(AlarmEvent alarmEvent) {
				// TODO Auto-generated method stub
				alertGenerator.generateAlert(alarmEvent);
			}
		});

	}

}
