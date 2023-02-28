package decorators;

import prodotti.Prodotto;

public class BevandaSprite extends AggiuntaDecorator {
	
	public BevandaSprite(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

	@Override
	public String getNome() {
		return prodotto.getNome() + " Sprite";
	}

	@Override
	public double getPrezzo() {
		return prodotto.getPrezzo() + 0.50;
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
