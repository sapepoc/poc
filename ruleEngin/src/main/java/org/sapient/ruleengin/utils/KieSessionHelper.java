package org.sapient.ruleengin.utils;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

public class KieSessionHelper 
{
	private KieSessionHelper(){}
	
	public static StatelessKieSession createStatelessSession(KieContainer kieContainer, String sessionName)
	{
		return kieContainer.newStatelessKieSession(sessionName);
	}
}
