package decorators;

import prodotti.Prodotto;

public class BevandaAcquaFrizzante extends AggiuntaDecorator {
	
	public BevandaAcquaFrizzante(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

	@Override
	public String getNome() {
		return prodotto.getNome() + " Acqua frizzante";
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
