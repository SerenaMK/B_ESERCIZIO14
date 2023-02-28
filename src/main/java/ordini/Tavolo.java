package ordini;

import enums.StatoTavolo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Tavolo {
	
	private int id;
	private int maxCoperti;
	private StatoTavolo stato;

}
