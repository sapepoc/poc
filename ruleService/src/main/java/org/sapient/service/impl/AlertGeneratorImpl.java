package org.sapient.service.impl;

import org.sapient.ruleengine.alarm.core.AlarmEvent;
import org.sapient.service.AlertGenerator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("alertGenerator")
public class AlertGeneratorImpl implements AlertGenerator {

	@Override
	public void generateAlert(AlarmEvent event) {
		// TODO Auto-generated method stub
		System.out.println("Got an event for the event "+ event);

	}

}
