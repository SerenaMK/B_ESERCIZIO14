package configurations;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import decorators.AggiuntaAnanasDecorator;
import decorators.AggiuntaFunghiDecorator;
import decorators.AggiuntaProsciuttoDecorator;
import decorators.AggiuntaSalaminoDecorator;
import decorators.AltroCartoneLogo;
import decorators.AltroRotellaTagliaPizza;
import decorators.BevandaAcquaFrizzante;
import decorators.BevandaAcquaNaturale;
import decorators.BevandaAranciata;
import decorators.BevandaCocaCola;
import decorators.BevandaSprite;
import enums.StatoOrdine;
import enums.StatoTavolo;
import ordini.Ordine;
import ordini.Tavolo;
import prodotti.Altro;
import prodotti.Bevanda;
import prodotti.Pizza;
import prodotti.Prodotto;

@Configuration
@PropertySource("classpath:application.properties")
public class ConfigurationProdotto {
	
	///////////////////////////
	@Bean
	@Scope("prototype")
	public Tavolo tavolo(int id, int maxCoperti, StatoTavolo stato) {
		return new Tavolo(id, maxCoperti, stato);
	}
	
	@Bean
	@Scope("prototype")
	public Ordine ordine(int numeroOrdine, Tavolo tavolo, StatoOrdine stato, int numeroCoperti,
			LocalTime oraAcquisizione) {
		Ordine o = new Ordine(numeroOrdine, tavolo, stato, numeroCoperti, oraAcquisizione);
		return o;
	}
	
	////////// PIZZE //////////
	@Bean
	@Scope("prototype")
	public Prodotto margherita() {
		Prodotto p = new Pizza();
		p.setNome("Pizza Margherita");
		return p;
	}
	
	@Bean
	@Scope("prototype")
	public Prodotto hawaii() {
		Prodotto p = new AggiuntaProsciuttoDecorator(new AggiuntaAnanasDecorator(new Pizza()));
		p.setNome("Pizza Hawaii");
		return p;
	}
	
	@Bean
	@Scope("prototype")
	public Prodotto prosciuttoFunghi() {
		Prodotto p = new AggiuntaProsciuttoDecorator(new AggiuntaFunghiDecorator(new Pizza()));
		p.setNome("Pizza Prosciutto e Funghi");
		return p;
	}
	
	@Bean
	@Scope("prototype")
	public Prodotto salamino() {
		Prodotto p = new AggiuntaSalaminoDecorator(new Pizza());
		p.setNome("Pizza Salamino Piccante");
		return p;
	}
	
	////////// BEVANDE //////////
	@Bean
	@Scope("prototype")
	public Prodotto acquaNaturale() {
		return new BevandaAcquaNaturale(new Bevanda());
	}
	
	@Bean
	@Scope("prototype")
	public Prodotto acquaFrizzante() {
		return new BevandaAcquaFrizzante(new Bevanda());
	}
	
	@Bean
	@Scope("prototype")
	public Prodotto cocaCola() {
		return new BevandaCocaCola(new Bevanda());
	}
	
	@Bean
	@Scope("prototype")
	public Prodotto aranciata() {
		return new BevandaAranciata(new Bevanda());
	}
	
	@Bean
	@Scope("prototype")
	public Prodotto sprite() {
		return new BevandaSprite(new Bevanda());
	}
	
	////////// ALTRO //////////
	@Bean
	@Scope("prototype")
	public Prodotto cartone() {
		return new AltroCartoneLogo(new Altro());
	}
	
	@Bean
	@Scope("prototype")
	public Prodotto rotella() {
		return new AltroRotellaTagliaPizza(new Altro());
	}

}
