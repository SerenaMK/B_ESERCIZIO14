package decorators;

import prodotti.Prodotto;

public class AggiuntaSalaminoDecorator extends AggiuntaDecorator {
	
	public AggiuntaSalaminoDecorator(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

	@Override
	public String getNome() {
		return prodotto.getNome() + " + salamino piccante";
	}

	@Override
	public double getPrezzo() {
		return prodotto.getPrezzo() + 0.20;
	}

	@Override
	public void setNome(String s) {
		prodotto.setNome(s);
	}
	
	@Override
	public String getSoloNome() {
		return prodotto.getSoloNome();
	}

}
