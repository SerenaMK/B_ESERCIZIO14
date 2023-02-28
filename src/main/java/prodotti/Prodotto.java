package prodotti;

// Non ho usato annotations come @AllArgsConstructor perché andavano in conflitto con i Decorators come mostrati sul sito
public abstract class Prodotto {
	
	String nome;
	
	public String getNome() {
		return this.nome;
	}
	
	public String getSoloNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public abstract double getPrezzo();
	

}
