package decorators;

import prodotti.Prodotto;

public class AltroRotellaTagliaPizza extends AggiuntaDecorator {
	
	public AltroRotellaTagliaPizza(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

	@Override
	public String getNome() {
		return prodotto.getNome() + "Rotella taglia pizza";
	}

	@Override
	public double getPrezzo() {
		return prodotto.getPrezzo() + 9.00;
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
