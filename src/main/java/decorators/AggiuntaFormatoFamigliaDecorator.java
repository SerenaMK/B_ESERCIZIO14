package decorators;

import prodotti.Prodotto;

public class AggiuntaFormatoFamigliaDecorator extends AggiuntaDecorator {
	
	public AggiuntaFormatoFamigliaDecorator(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

	@Override
	public String getNome() {
		return prodotto.getNome() + " + Formato Famiglia";
	}

	@Override
	public double getPrezzo() {
		return prodotto.getPrezzo() + 4.20;
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
