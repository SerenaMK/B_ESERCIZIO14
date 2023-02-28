package prodotti;

public class Altro extends Prodotto {
	
	public Altro () {
		nome = "Altro: ";
	}
	
	@Override
	public double getPrezzo() {
		return 0.00;
	}

}
