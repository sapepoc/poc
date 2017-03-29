package org.sapient.ruleengine.drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.api.runtime.rule.AgendaFilter;

public class DroolsManager 
{
	private static final String DEFAULT_SESSION = "baseKSession-rules";
	private KieContainer kieContainer;

	public DroolsManager(){}
	
	private KieContainer getKieContainer()
	{
		if(kieContainer == null)
		{
			KieServices ks = KieServices.Factory.get();
			kieContainer = ks.getKieClasspathContainer();
		}
		return kieContainer;
	}
	
	public static StatelessKieSession createStatelessSession(KieContainer kieContainer, String sessionName)
	{
		return kieContainer.newStatelessKieSession(sessionName);
	}

	public KieSession createSession()
	{
		return createSession(DEFAULT_SESSION);
	}
	
	public KieSession createSession(String sessionName)
	{
		return getKieContainer().newKieSession(sessionName);
	}
	
	public void insertFacts(KieSession session, Object object)
	{
		session.insert(object);
	}
	
	public void fireAllRules(KieSession session)
	{
		session.fireAllRules();
	}
	
	public void fireAllRules(KieSession session, AgendaFilter agendaFilter)
	{
		session.fireAllRules(agendaFilter);
	}

	public void disposeSession(KieSession kieSession) 
	{
		kieSession.dispose();
	}
	
}
