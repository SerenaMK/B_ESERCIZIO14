package decorators;

import prodotti.Prodotto;

public class AltroCartoneLogo extends AggiuntaDecorator {
	
	public AltroCartoneLogo(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

	@Override
	public String getNome() {
		return prodotto.getNome() + "Cartone porta pizza";
	}

	@Override
	public double getPrezzo() {
		return prodotto.getPrezzo() + 0.10;
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
