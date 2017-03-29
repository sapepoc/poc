package org.sapient.ruleengine;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.sapient.ruleengine.alarm.core.AlarmEvent;
import org.sapient.ruleengine.alarm.core.AlarmEventObserver;
import org.sapient.ruleengine.rules.RuleMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RuleEnginServiceImpl implements RuleEnginService
{
	private RuleEnginFactory ruleEnginFactory;
	private static final String PROPERTY_FILE_NAME = "application.properties";
	private RuleEngin ruleEngin;
	private List<RuleData> ruleDatas;
	
	@Autowired
	public RuleEnginServiceImpl(RuleEnginFactory ruleEnginFactory)
	{
		this.ruleEnginFactory = ruleEnginFactory;
		this.ruleDatas = new ArrayList<>();
		init();
	}

	private void init()
	{
		try 
		{
			Properties properties = readPropertiesFile(PROPERTY_FILE_NAME);
			String ruleEnginType = properties.getProperty("rule.engin.type");
			RuleEnginType enginType = RuleEnginType.valueOf(ruleEnginType);
			ruleEngin = ruleEnginFactory.createRuleEngin(enginType);
			
			for (RuleMapping ruleMapping : RuleMapping.values()) 
			{
				ruleDatas.add(new RuleData(ruleMapping.getRuleName(), properties.getProperty(ruleMapping.getRuleName())));
			}
		} 
		catch (Exception e) 
		{
			throw new RuntimeException("Problem in RuleEnginService initilization, problem:"+ e);
		}
	}
	
	public <T> void applyRule(List<T> entities)
	{
		ruleEngin.fireRules(entities, ruleDatas);
	}

	@Override
	public void register(AlarmEventObserver<AlarmEvent> alarmEventObserver) 
	{
		ruleEngin.registerEventListener(alarmEventObserver);
	}
	
	private Properties readPropertiesFile(String fileName) throws IOException
	{
		ClassLoader classLoader = getClass().getClassLoader();
		Properties props = new Properties();
		try(InputStream resourceStream = classLoader.getResourceAsStream("application.properties")) 
		{
		    props.load(resourceStream);
		}
		return props;
	}
}
