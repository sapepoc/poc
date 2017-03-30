package org.sapient.service;

import org.sapient.ruleengine.alarm.core.AlarmEvent;

public interface AlertGenerator {

	public void generateAlert(AlarmEvent event);
}
