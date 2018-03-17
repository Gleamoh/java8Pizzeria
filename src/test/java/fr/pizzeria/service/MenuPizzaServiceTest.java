package fr.pizzeria.service;

import static org.junit.Assert.assertTrue;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.pizzeria.exception.PizzeriaException;
import fr.pizzeria.exception.UpdateException;
import fr.pizzeria.model.Pizza;

public class MenuPizzaServiceTest {

	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Test
	public void testEditPizza() throws UpdateException {
		systemInMock.provideLines("KKK", "Ma Pizza", "45.0", "Viande");

		MenuPizzaService.setScanner(MenuPizzaService.getScanner());
		MenuPizzaService spm = new MenuPizzaService() {
			@Override
			public void executeUC() throws PizzeriaException {}
		};

		try {
			assertTrue(spm.editPizza() instanceof Pizza);
		} catch (PizzeriaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetScanner() {
		assertTrue(MenuPizzaService.getScanner() instanceof Scanner);
	}

	@Test
	public void testSetScanner() {
		MenuPizzaService.setScanner(new Scanner(System.in));
		assertTrue(MenuPizzaService.getScanner() instanceof Scanner);
	}

}
