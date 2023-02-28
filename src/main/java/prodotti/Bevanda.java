package prodotti;

public class Bevanda extends Prodotto {
	
	public Bevanda () {
		nome = "Bevanda";
	}

	@Override
	public double getPrezzo() {
		return 2.00;
	}

}
