package configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

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
import prodotti.Altro;
import prodotti.Bevanda;
import prodotti.Pizza;
import prodotti.Prodotto;

@Configuration
public class ConfigurationProdotto {
	
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
