package decorators;

import prodotti.Prodotto;

public abstract class AggiuntaDecorator extends Prodotto {

	protected Prodotto prodotto;

	@Override
	public abstract String getNome();
	
	@Override
	public abstract String getSoloNome();
	
	@Override
	public abstract void setNome(String nome); 

}
