package org.sapient.ruleengine.drools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.api.runtime.rule.AgendaFilter;
import org.sapient.ruleengine.utils.CommonUtils;

public class DroolsManager 
{
	private static final String DEFAULT_SESSION = "baseKSession-rules";
	private KieContainer kieContainer;

	public DroolsManager()
	{
		//TODO:
		getKieContainer();
	}
	
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
	
	public int fireAllRules(KieSession session, AgendaFilter agendaFilter)
	{
		return session.fireAllRules(agendaFilter);
	}

	public void disposeSession(KieSession kieSession) 
	{
		kieSession.dispose();
	}
	
	public KieSession createKieSession(String packageName)
	{
		try
		{
			KieServices kieServices = KieServices.Factory.get();
			KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
			List<File> files = new ArrayList<>();
			CommonUtils.listFilesForFolder(new File(packageName), files);
			int i = 0;
			for (File file : files) 
			{
				FileInputStream fis = new FileInputStream(file);
				kieFileSystem.write( "src/main/resources/"+i+++".xls",
						kieServices.getResources().newInputStreamResource( fis ) );
			}
			kieServices.newKieBuilder(kieFileSystem).buildAll();
			KieContainer kieContainer = kieServices.newKieContainer( kieServices.getRepository().getDefaultReleaseId() );
			KieSession kSession = kieContainer.newKieSession();
			return kSession;
		}
		catch(FileNotFoundException exception)
		{
			throw new RuntimeException("Problem in session creation problem=", exception);
		}
	}
	
}
