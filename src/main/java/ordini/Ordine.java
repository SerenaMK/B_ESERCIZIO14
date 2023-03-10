package ordini;

import java.time.LocalTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import enums.StatoOrdine;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import prodotti.Prodotto;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Ordine {
	
	private int numeroOrdine;
	private Tavolo tavolo;
	private StatoOrdine stato;
	private int numeroCoperti;
	private LocalTime oraAcquisizione;
	private double totale = 0.00;
	ArrayList<Prodotto> prodottiOrdinati = new ArrayList<Prodotto>();
	@Value("${costo.coperto}")
	String costoCoperto;
	
	public Ordine(int numeroOrdine, Tavolo tavolo, StatoOrdine stato, int numeroCoperti, LocalTime oraAcquisizione) {
		super();
		this.numeroOrdine = numeroOrdine;
		this.tavolo = tavolo;
		this.stato = stato;
		this.numeroCoperti = numeroCoperti;
		this.oraAcquisizione = oraAcquisizione;
	}
	
	public void addProdotto(Prodotto p) {
		this.prodottiOrdinati.add(p);
		this.totale += p.getPrezzo();
	}
	
	public void getConto() {
		double coperto = Double.parseDouble(costoCoperto);
		System.out.println("\n+------------------- CONTO ---------------------+");
		System.out.println("+------------- Ordine " + this.numeroOrdine + " Tavolo " + this.tavolo.getId() + " ---------------+\n");
		for (Prodotto prodotto : prodottiOrdinati) {
			if (prodotto.getSoloNome().contains("Pizza")) {
				if(prodotto.getIsCustom()) {
					System.out.format("%-40s %48s", prodotto.getNome()+"\n", String.format("%.2f", prodotto.getPrezzo()) + " €\n");
				} else {
					System.out.format("%-40s %8s", prodotto.getSoloNome(), String.format("%.2f", prodotto.getPrezzo()) + " €\n");
				}
			} else if (prodotto.getNome().contains("Bevanda")) {
				System.out.format("%-40s %8s", prodotto.getNome().substring(8, prodotto.getNome().length()), String.format("%.2f", prodotto.getPrezzo()) + " €\n");
			} else {
				System.out.format("%-40s %8s", prodotto.getNome().substring(7, prodotto.getNome().length()), String.format("%.2f", prodotto.getPrezzo()) + " €\n");
			}
		}
		System.out.format("%-40s %8s", "Coperto:", String.format("%.2f", coperto) + " €\n");
		System.out.println("");
		System.out.format("%-40s %8s", "Totale:", String.format("%.2f", this.totale + coperto) + " €\n");
		System.out.println("\n+-----------------------------------------------+");
	}


}
