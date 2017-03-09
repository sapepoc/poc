package org.sapient.paserapp.jms.entity.consumer;
import org.sapient.entites.user.Users;
import org.sapient.entites.user.Users.User;
import org.sapient.paserapp.common.EntitySender;
import org.sapient.paserapp.utils.XmlToObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;


//@Component
//Disabled: Not used
public class XmlEntityReceiver 
{
	@Autowired
	private EntitySender<Users> entitySender;
	
    @JmsListener(destination = "${inbound.endpoint}")
    public void processTransactionEntity(String entity)
    {
        System.out.println("Received <" + entity + ">");
    }
    
    @JmsListener(destination = "${inbound.entity.xml.user.endpoint}")
    public void processUserEntity(String entity)
    {
        Users users = XmlToObject.loadEntityFromString(entity, Users.class);
        for (User user : users.getUser()) 
        {
			
        	System.out.println("FirstName="+ user.getFirstName() + " , lastName="+ user.getLastName());
		}
        
        entitySender.sendMessage("jms:INSTANCE_USER_ENTITY", users);
    }
}