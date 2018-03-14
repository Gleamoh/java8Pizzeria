package fr.pizzeria.service;

import static org.junit.Assert.fail;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

public class ServicePizzaAjouterTest {

	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Test
	public void testExecuteUC() {
		
	}

	@Test
	public void testServicePizzaAjouter() {
		fail("Not yet implemented");
	}

}
