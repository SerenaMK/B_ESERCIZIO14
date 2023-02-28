package prodotti;

public class Pizza extends Prodotto {
	
	public Pizza () {
		nome = "Pizza Margherita (pomodoro, mozzarella)";
	}

	@Override
	public double getPrezzo() {
		return 7.00;
	}

}
