package org.sapient.ruleengine.utils;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSessionConfiguration;
import org.kie.internal.builder.conf.RuleEngineOption;

public class KieContainerProvider 
{
	private static KieContainer kContainer;
	
	public static KieContainer createKieContainer()
	{
		if(kContainer == null)
		{
	        KieServices ks = KieServices.Factory.get();
		    KieSessionConfiguration configuration = ks.newKieSessionConfiguration();
		    configuration.setProperty(RuleEngineOption.PROPERTY_NAME, RuleEngineOption.RETEOO.name());
		    kContainer = ks.getKieClasspathContainer();
		}
		return kContainer;
	}
}
