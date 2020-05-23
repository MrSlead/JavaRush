package javaCollections.level_2.ServiceLocator.service.impl;

import javaCollections.level_2.ServiceLocator.service.Service;

public class JMSServiceImpl implements Service {

	@Override
	public void execute() {
		System.out.println("Executing the JMSService");
	}

	@Override
	public String getName() {
		return "JMSService";
	}

}