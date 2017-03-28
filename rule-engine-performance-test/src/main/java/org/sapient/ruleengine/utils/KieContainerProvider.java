package org.sapient.ruleengine.utils;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.definition.KiePackage;
import org.kie.api.definition.rule.Rule;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.Match;

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
	
	public static void main(String[] args)
	{
		KieContainer kieContainer = createKieContainer();
		
		for (String kieBaseName : kieContainer.getKieBaseNames()) 
		{
			System.out.println("kieBaseName="+ kieBaseName);
			KieBase kieBase = kieContainer.getKieBase(kieBaseName);
			KieSession kieSession = kieBase.newKieSession();
			System.out.println("kieSession="+ kieSession);
			for (KiePackage kiePackage : kieBase.getKiePackages()) 
			{
				for (Rule rule : kiePackage.getRules()) 
				{
					System.out.println("ruleName="+ rule.getName() + " ,rulePackage="+ rule.getPackageName());
				}
			}
		}
		
		KieSession kieSession = kieContainer.newKieSession("ksession-rules");
		kieSession.insert(new String("Om"));
		kieSession.fireAllRules(new AgendaFilter()
		{
			@Override
			public boolean accept(Match match)
			{
				System.out.println("Rule name="+match.getRule().getName());
				return true;
			}
		});
	}
}
