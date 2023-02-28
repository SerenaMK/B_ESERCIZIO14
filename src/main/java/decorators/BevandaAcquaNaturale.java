package decorators;

import prodotti.Prodotto;

public class BevandaAcquaNaturale extends AggiuntaDecorator {
	
	public BevandaAcquaNaturale(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

	@Override
	public String getNome() {
		return prodotto.getNome() + " Acqua naturale";
	}

	@Override
	public double getPrezzo() {
		return prodotto.getPrezzo();
	}

	@Override
	public void setNome(String s) {
		prodotto.setNome(s);
	}
	
	@Override
	public String getSoloNome() {
		return prodotto.getNome();
	}

}
