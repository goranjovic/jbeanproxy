jbeanproxy
==========

A library that enables quick and easy creation of dynamically generated proxy wrappers 
around Java bean objects which fire an event whenever a setter method has been invoked.

# Example

Here we have a class `PersonImpl` which implements interface `Person`. The class
has two properties: `firstName` and `lastName`. What we want to achieve is to have
an event fire whenever one of the properties has been changed, but without changing the 
existing `PersonImpl` class and without explicitly creating another class. We could have 
a really large number of such classes or the classes may not even be known at the time.

So, what this library does is to generate a wrapper class implementing the same interface
on the fly and redirect all method calls to the original object, except the setter methods
which also have to fire the event.

        //create the original bean
        Person real = new PersonImpl();
		real.setFirstName("Chuck");
		real.setLastName("Norris");
		
		BoundBeanFactory factory = new BoundBeanFactory();
		//state which properties we want to track
		factory.setBoundProperties(new String[]{"firstName", "lastName"	});
		factory.setPropertyChangeListener(new DummyPropertyChangeListener());
		
		//now we get the proxy object
		//all tracked setters invoked on this object
		//will fire the event
		Person proxy = factory.createWrapperProxy(real, Person.class);
		
		//try and see
		proxy.setFirstName("Someone");
		proxy.setLastName("Else");
		
# License

Copyright (C) 2013 Goran Jovic

Distributed under the Eclipse Public License.