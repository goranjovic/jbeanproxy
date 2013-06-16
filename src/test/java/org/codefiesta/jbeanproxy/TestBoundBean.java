package org.codefiesta.jbeanproxy;

import org.codefiesta.jbeanproxy.boundbean.BoundBeanFactory;
import org.codefiesta.jbeanproxy.helpers.DummyPropertyChangeListener;
import org.codefiesta.jbeanproxy.helpers.Person;
import org.codefiesta.jbeanproxy.helpers.PersonImpl;
import org.junit.Test;

public class TestBoundBean {
	
	@Test
	public void testBoundBean(){
		
		Person real = new PersonImpl();
		real.setFirstName("Chuck");
		real.setLastName("Norris");
		
		BoundBeanFactory factory = new BoundBeanFactory();
		factory.setBoundProperties(new String[]{"firstName", "lastName"	});
		factory.setPropertyChangeListener(new DummyPropertyChangeListener());
		
		Person proxy = factory.createWrapperProxy(real, Person.class);
		
		proxy.setFirstName("Someone");
		proxy.setLastName("Else");
		
		
	}

}
