package fr.pizzeria.service;

import static org.junit.Assert.fail;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.mockito.Mockito;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.UpdatePizzaException;

public class ServicePizzaModifierTest {

	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Test
	public void testExecuteUC() throws UpdatePizzaException{
		
		// creation du mock
		IPizzaDao mock = Mockito.mock(IPizzaDao.class);
		
		// Mockito.when(mock.findAllPizzas()).thenReturn(new ArrayList<Pizza>());
		Mockito.when(mock.findAllPizzas()).thenReturn(null);

		mock.findAllPizzas();
		//systemInMock.provideLines("PEP", "Ma Pizza", "45.0", "Viande");

//		ServicePizzaMenu spm = new ServicePizzaMenu() {
//
//			@Override
//			public void executeUC() throws PizzaException {
//
//			}
//		};
//
//		ServicePizzaMenu.setScanner(ServicePizzaMenu.getScanner());
//		PizzaDao.getInstance().updatePizza(ServicePizzaMenu.getScanner().nextLine(), spm.editPizza());
		
		// vérifier que l'objet à bien été mofifié
		
	}

	@Test
	public void testServicePizzaModifier() {
		fail("Not yet implemented");
	}

}
