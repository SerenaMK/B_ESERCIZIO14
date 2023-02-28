package main;

import java.time.LocalTime;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import configurations.ConfigurationProdotto;
import decorators.AggiuntaDecorator;
import decorators.AggiuntaFunghiDecorator;
import decorators.AggiuntaProsciuttoDecorator;
import decorators.AggiuntaSalaminoDecorator;
import decorators.AltroRotellaTagliaPizza;
import decorators.BevandaAcquaFrizzante;
import decorators.BevandaAcquaNaturale;
import decorators.BevandaAranciata;
import decorators.BevandaCocaCola;
import enums.StatoOrdine;
import enums.StatoTavolo;
import ordini.Ordine;
import ordini.Tavolo;
import prodotti.Altro;
import prodotti.Bevanda;
import prodotti.Pizza;
import prodotti.Prodotto;

@SpringBootApplication
public class GodfathersPizza {

	static ArrayList<Prodotto> menu = new ArrayList<Prodotto>();

	public static void main(String[] args) {
		SpringApplication.run(GodfathersPizza.class, args);
		/////////////////////////////////////////////////////

//		addProdottoToMenu("margherita");
//		addProdottoToMenu("hawaii");
//		addProdottoToMenu("prosciuttoFunghi");
//		addProdottoToMenu("salamino");
//		
//		addProdottoToMenu("acquaNaturale");
//		addProdottoToMenu("acquaFrizzante");
//		addProdottoToMenu("cocaCola");
//		addProdottoToMenu("aranciata");
//		addProdottoToMenu("sprite");
//		
//		addProdottoToMenu("cartone");
//		addProdottoToMenu("rotella");
//		
//		getMenu(menu);

		/////////////////////////////////////////////////////

		Tavolo t1 = newTavolo(1, 6, StatoTavolo.LIBERO);
		Tavolo t2 = newTavolo(2, 4, StatoTavolo.LIBERO);
		Tavolo t3 = newTavolo(3, 2, StatoTavolo.LIBERO);
		Tavolo t4 = newTavolo(4, 10, StatoTavolo.LIBERO);

		/////////////////////////////////////////////////////

		Ordine o1 = newOrdine(1, t1, StatoOrdine.INCORSO, 4, LocalTime.of(19, 20));

		/*
		 * I 4 clienti al tavolo 1 hanno ordinato:
		 * 1 pizza salamino piccante, 1 pizza prosciutto e funghi, 1 pizza hawaii, 1 pizza salamino + prosciutto + funghi
		 * 2 acqua naturale, 1 acqua frizzante, 1 aranciata
		 * 1 rotella taglia pizza
		 */


		o1.addProdotto(getProdotto("salamino"));
		o1.addProdotto(getProdotto("prosciuttoFunghi"));
		o1.addProdotto(getProdotto("hawaii"));
		o1.addProdotto(new AggiuntaSalaminoDecorator(new AggiuntaProsciuttoDecorator(new AggiuntaFunghiDecorator(new Pizza()))));

		o1.addProdotto(new BevandaAcquaNaturale(new Bevanda()));
		o1.addProdotto(new BevandaAcquaNaturale(new Bevanda()));
		o1.addProdotto(new BevandaAcquaFrizzante(new Bevanda()));
		o1.addProdotto(new BevandaAranciata(new Bevanda()));
		
		o1.addProdotto(new AltroRotellaTagliaPizza(new Altro()));

		// Conto
		o1.getConto();

	}

	public static Prodotto getProdotto(String bean) {
		AnnotationConfigApplicationContext appCtx = new AnnotationConfigApplicationContext(ConfigurationProdotto.class);
		Prodotto p = (Prodotto) appCtx.getBean(bean);
		((AnnotationConfigApplicationContext) appCtx).close();
		return p;
	}

	public static void addProdottoToMenu(String bean) {
		AnnotationConfigApplicationContext appCtx = new AnnotationConfigApplicationContext(ConfigurationProdotto.class);

		Prodotto p = (Prodotto) appCtx.getBean(bean);

		// Aggiungo al menu
		menu.add(p);

		((AnnotationConfigApplicationContext) appCtx).close();
	}

	public static void getMenu(ArrayList<Prodotto> menu) {
		System.out.println("\n+--------------------------MENU'-----------------------------+");

		System.out.println("\n+-------------- PIZZE ----------------+");
		for (Prodotto prodotto : menu) {
			if (prodotto.getSoloNome().contains("Pizza")) {
				System.out.format("%-30s %8s", prodotto.getSoloNome().substring(6, prodotto.getSoloNome().length()),
						String.format("%.2f", prodotto.getPrezzo()) + " €\n");
			}
		}

		System.out.println("\n+-------------- BEVANDE --------------+");
		for (Prodotto prodotto : menu) {
			if (prodotto.getNome().contains("Bevanda")) {
				System.out.format("%-30s %8s", prodotto.getNome().substring(8, prodotto.getNome().length()),
						String.format("%.2f", prodotto.getPrezzo()) + " €\n");
			}
		}

		System.out.println("\n+-------------- ALTRO ----------------+");
		for (Prodotto prodotto : menu) {
			if (prodotto.getNome().contains("Altro")) {
				System.out.format("%-30s %8s", prodotto.getNome().substring(7, prodotto.getNome().length()),
						String.format("%.2f", prodotto.getPrezzo()) + " €\n");
			}
		}
		System.out.println("\nN.B.: Gli articoli nella categoria Altro sfoggiano tutti il logo di Godfather's Pizza.");
	}

	public static void lineBreak() {
		System.out.println("-------------------------------------------------------------\n");
	}

	public static Tavolo newTavolo(int id, int maxCoperti, StatoTavolo stato) {
		Tavolo t = new Tavolo(id, maxCoperti, stato);
		return t;
	}

	public static Ordine newOrdine(int numeroOrdine, Tavolo tavolo, StatoOrdine stato, int numeroCoperti,
			LocalTime oraAcquisizione) {
		Ordine o = new Ordine(numeroOrdine, tavolo, stato, numeroCoperti, oraAcquisizione);
		return o;
	}
	


}
