package ticketmachine;

public class Main {

	public static void main(String[] args) {
		TicketMachine machine = new TicketMachine(40);
		System.out.println("L'utilisateur insère 60 centimes");
		machine.insertMoney(60);
		System.out.println("L'utilisateur appuie sur 'Impression ticket'");
		machine.printTicket();
	}
}
