package fr.pizzeria.service;

import static org.junit.Assert.fail;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.pizzeria.exception.UpdateException;

public class ModifierPizzaServiceTest {

	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Test
	public void testExecuteUC() throws UpdateException {

		// creation du mock
		//PizzaDao mock = Mockito.mock(PizzaDao.class);

		// Mockito.when(mock.findAllPizzas()).thenReturn(new
		// ArrayList<Pizza>());
		//Mockito.when(mock.findAll()).thenReturn(null);

		//mock.findAll();
		// systemInMock.provideLines("PEP", "Ma Pizza", "45.0", "Viande");

		// ServicePizzaMenu spm = new ServicePizzaMenu() {
		//
		// @Override
		// public void executeUC() throws PizzaException {
		//
		// }
		// };
		//
		// ServicePizzaMenu.setScanner(ServicePizzaMenu.getScanner());
		// PizzaDao.getInstance().updatePizza(ServicePizzaMenu.getScanner().nextLine(),
		// spm.editPizza());

		// v�rifier que l'objet � bien �t� mofifi�

	}

	@Test
	public void testServicePizzaModifier() {
		fail("Not yet implemented");
	}

}
