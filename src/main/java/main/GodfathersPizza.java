package main;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import configurations.ConfigurationProdotto;
import decorators.AggiuntaFunghiDecorator;
import decorators.AggiuntaProsciuttoDecorator;
import decorators.BevandaAcquaNaturale;
import decorators.BevandaCocaCola;
import prodotti.Bevanda;
import prodotti.Pizza;
import prodotti.Prodotto;

@SpringBootApplication
public class GodfathersPizza {

	static ArrayList<Prodotto> menu = new ArrayList<Prodotto>();
	
	public static void main(String[] args) {
		SpringApplication.run(GodfathersPizza.class, args);
		/////////////////////////////////////////////////////
		
		addProdotto("margherita");
		addProdotto("hawaii");
		addProdotto("prosciuttoFunghi");
		addProdotto("salamino");
		
		addProdotto("acquaNaturale");
		addProdotto("acquaFrizzante");
		addProdotto("cocaCola");
		addProdotto("aranciata");
		addProdotto("sprite");
		
		addProdotto("cartone");
		addProdotto("rotella");
		
		/////////////////////////////////////////////////////
		
		getMenu(menu);
		
	}
	
	public static void addProdotto(String bean) {
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
				System.out.format("%-30s %8s", prodotto.getSoloNome().substring(6, prodotto.getSoloNome().length()), String.format("%.2f", prodotto.getPrezzo()) + " €\n");
			}
		}
		
		System.out.println("\n+-------------- BEVANDE --------------+");
		for (Prodotto prodotto : menu) {
			if (prodotto.getNome().contains("Bevanda")) {
				System.out.format("%-30s %8s", prodotto.getNome().substring(8, prodotto.getNome().length()), String.format("%.2f", prodotto.getPrezzo()) + " €\n");
			}
		}
		
		System.out.println("\n+-------------- ALTRO ----------------+");
		for (Prodotto prodotto : menu) {
			if (prodotto.getNome().contains("Altro")) {
				System.out.format("%-30s %8s", prodotto.getNome().substring(7, prodotto.getNome().length()), String.format("%.2f", prodotto.getPrezzo()) + " €\n");
			}
		}
		System.out.println("\nN.B.: Gli articoli nella categoria Altro sfoggiano tutti il logo di Godfather's Pizza.");
	}
	
	public static void lineBreak() {
		System.out.println("-------------------------------------------------------------\n");
	}
	

}
