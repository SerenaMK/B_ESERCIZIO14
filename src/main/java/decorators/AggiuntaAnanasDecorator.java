package decorators;

import prodotti.Prodotto;

public class AggiuntaAnanasDecorator extends AggiuntaDecorator {
	
	public AggiuntaAnanasDecorator(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

	@Override
	public String getNome() {
		return prodotto.getNome() + " + ananas";
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
