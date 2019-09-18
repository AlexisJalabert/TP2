package ticketmachine;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TicketMachineTest {
	private static final int PRICE = 50; // Une constante

	private TicketMachine machine; // l'objet à tester

	@Before
	public void setUp() {
		machine = new TicketMachine(PRICE); // On initialise l'objet à tester
	}

	@Test
	// On vérifie que le prix affiché correspond au paramètre passé lors de l'initialisation
	// S1 : le prix affiché correspond à l’initialisation
	public void priceIsCorrectlyInitialized() {
		// Paramètres : message si erreur, valeur attendue, valeur réelle
		assertEquals("Initialisation incorrecte du prix", PRICE, machine.getPrice());
	}

	@Test
	// S2 : la balance change quand on insère de l’argent
	public void insertMoneyChangesBalance() {
		machine.insertMoney(10);
		machine.insertMoney(20);
		assertEquals("La balance n'est pas correctement mise à jour", 10 + 20, machine.getBalance()); // Les montants ont été correctement additionnés               
	}
        
        @Test
        // S3 : on n’imprime pas le ticket si le montant inséré est insuffisant
        public void noPrintTicket() {
            machine.insertMoney(40);
            assertFalse("Le ticket est imprimé alors qu'il ne devrait pas l'être", machine.printTicket());
        }
        
        @Test
        // S4 : on imprime le ticket si le montant inséré est suffisant
        public void printTicketMoney() {
            machine.insertMoney(60);
            assertTrue("Le ticket ne s'est pas imprimé correctement", machine.printTicket());
        }
        
        @Test
        // S5 :Quand on imprime un ticket la balance est décrémentée du prix du ticket
        public void balanceDec() {
            machine.insertMoney(70);
            machine.printTicket();
            assertEquals("La balance n'est pas décrémenter", 70-PRICE, machine.getBalance());
        }
        
        @Test
        // S6 : le montant collecté est mis à jour quand on imprime un ticket (pas avant)
        public void totalCollected() {
            machine.insertMoney(PRICE);
            machine.printTicket();
            assertEquals("Le montant collecté n'est pas ajouté", PRICE, machine.getTotal());
            
        }

}
