package fr.pizzeria.service;

import static org.junit.Assert.assertTrue;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class ServicePizzaMenuTest {

	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Test
	public void testEditPizza() throws UpdatePizzaException {
		systemInMock.provideLines("KKK", "Ma Pizza", "45.0", "Viande");

		ServicePizzaMenu.setScanner(ServicePizzaMenu.getScanner());
		ServicePizzaMenu spm = new ServicePizzaMenu() {
			@Override
			public void executeUC() throws PizzaException {}
		};

		assertTrue(spm.editPizza() instanceof Pizza);
	}

	@Test
	public void testGetScanner() {
		assertTrue(ServicePizzaMenu.getScanner() instanceof Scanner);
	}

	@Test
	public void testSetScanner() {
		ServicePizzaMenu.setScanner(new Scanner(System.in));
		assertTrue(ServicePizzaMenu.getScanner() instanceof Scanner);
	}

}
