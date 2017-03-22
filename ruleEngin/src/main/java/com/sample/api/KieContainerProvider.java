package com.sample.api;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class KieContainerProvider 
{
	private static KieContainer kContainer;
	
	public static KieContainer createKieContainer()
	{
		if(kContainer == null)
		{
	        KieServices ks = KieServices.Factory.get();
		    kContainer = ks.getKieClasspathContainer();
		}
		return kContainer;
	}

	public static KieSession createNewSession(KieContainer kContainer, String kSessionName)
	{
		return kContainer.newKieSession(kSessionName);
	}
}
