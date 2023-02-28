package decorators;

import prodotti.Prodotto;

public class AggiuntaFunghiDecorator extends AggiuntaDecorator {
	
	public AggiuntaFunghiDecorator(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

	@Override
	public String getNome() {
		return prodotto.getNome() + " + funghi";
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
