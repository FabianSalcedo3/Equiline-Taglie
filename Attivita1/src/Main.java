import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
//		1. Dato un array con le taglie dei prodotti mischiate 
//		(es. S, 43, XL, 40, 44, M, 12, IT 35, IT 43, FR 12, UK 50, XXL, IT 50…),
//		Puoi scrivere un algoritmo per ordinarle in un modo sensato? Puoi spiegarci l’algoritmo che hai 
//		scritto e la logica pensata?

		String[] taglie = { "S", "43", "XL", "40", "44", "M", "12", "IT 35", "IT 43", "FR 12", "UK 50", "XXL", "IT 50",
				"40" };
		
		//Testo soluzione 1
		List<String> taglieOrdinate = taglieSort(taglie);
		for (String taglia : taglieOrdinate) {
			System.out.println(taglia);
		}
		
		//Testo soluzione 2
		taglieSort2(taglie);
	}

	
	
	// Soluzione 1
	//Le taglie sono un numero finito di stringhe, creo quindi una legenda con le taglie messe nell'ordine da me stabilito e lo metto a confronto con l'array un ingresso
	public static List<String> taglieSort(String[] taglie) {
		List<String> mappaTaglie = Arrays.asList("XS", "S", "M", "L", "XL", "XXL", "12", "40", "41", "42", "43", "44",
				"FR 12", "IT 35", "IT 40", "IT 43", "IT 50", "UK 50");
		Comparator<String> ordineTaglie = Comparator.comparingInt(mappaTaglie::indexOf);
		List<String> taglieAsList = Arrays.asList(taglie);
		taglieAsList.sort(ordineTaglie);
		return taglieAsList;
	}

	// Soluzione 2
	//Creo piu legende. Categorizzo ogni taglia dell'array e la smisto nelle apposite liste che verranno, al termine dell'iterazione array, sortate secondo la legenda
	static List<String> taglieMaglie = new ArrayList<String>();
	static List<String> taglieIta = new ArrayList<String>();
	static List<String> taglieFra= new ArrayList<String>();
	static List<String> taglieUk= new ArrayList<String>();
	static List<String> tagliePantaloni = new ArrayList<String>();
	static List<String> taglieScarpeUSA = new ArrayList<String>();
	static final List<String> mappaTaglieMaglie = Arrays.asList("XS", "S", "M", "L", "XL", "XXL");
	static final List<String> mappaTaglieIta = Arrays.asList("IT 35", "IT 40", "IT 41", "IT 42", "IT 43", "IT 50");
	static final List<String> mappaTaglieFra = Arrays.asList("FR 12", "FR 13");
	static final List<String> mappaTaglieUk = Arrays.asList("UK 49", "UK 50");
	static final List<String> mappaTagliePantaloni = Arrays.asList("40", "41", "42", "43", "44");
	static final List<String> mappaTaglieScarpeUSA = Arrays.asList("8", "9", "10", "11", "12");

	
	public static void taglieSort2(String[] taglie) {
		for (int i = 0; i < taglie.length; i++) {
			if (taglie[i].charAt(0) == 'X' || taglie[i].charAt(0) == 'S' || taglie[i].charAt(0) == 'M'
					|| taglie[i].charAt(0) == 'L') {
				taglieMaglie.add(taglie[i]);
			}
			if (taglie[i].charAt(0) == 'I') {
				taglieIta.add(taglie[i]);
			}
			if (taglie[i].charAt(0) == 'F') {
				taglieFra.add(taglie[i]);
			}
			if (taglie[i].charAt(0) == 'U') {
				taglieUk.add(taglie[i]);
			}
			if (isNumber(taglie[i]) > 30) {
				tagliePantaloni.add(taglie[i]);
			}
			if (isNumber(taglie[i]) < 30 && isNumber(taglie[i]) != -1) {
				taglieScarpeUSA.add(taglie[i]);
			}
		}

		Comparator<String> ordineTaglieMaglie = Comparator.comparingInt(mappaTaglieMaglie::indexOf);
		Comparator<String> ordineTaglieIta = Comparator.comparingInt(mappaTaglieIta::indexOf);
		Comparator<String> ordineTaglieFra = Comparator.comparingInt(mappaTaglieFra::indexOf);
		Comparator<String> ordineTaglieUk = Comparator.comparingInt(mappaTaglieUk::indexOf);
		Comparator<String> ordineTagliePantaloni = Comparator.comparingInt(mappaTagliePantaloni::indexOf);
		Comparator<String> ordineTaglieScarpeUSA = Comparator.comparingInt(mappaTaglieScarpeUSA::indexOf);
		
		if (taglieMaglie != null) {
			taglieMaglie.sort(ordineTaglieMaglie);
			taglieMaglie.forEach(taglia -> System.out.println(taglia));
		}
		if (taglieIta != null) {
			taglieIta.sort(ordineTaglieIta);
			taglieIta.forEach(taglia -> System.out.println(taglia));
		}
		if (taglieFra != null) {
			taglieFra.sort(ordineTaglieFra);
			taglieFra.forEach(taglia -> System.out.println(taglia));
		}
		if (taglieUk != null) {
			taglieUk.sort(ordineTaglieUk);
			taglieUk.forEach(taglia -> System.out.println(taglia));
		}
		if (tagliePantaloni != null) {
			tagliePantaloni.sort(ordineTagliePantaloni);
			tagliePantaloni.forEach(taglia -> System.out.println(taglia));
		}
		if (taglieScarpeUSA != null) {
			taglieScarpeUSA.sort(ordineTaglieScarpeUSA);
			taglieScarpeUSA.forEach(taglia -> System.out.println(taglia));
		}

	}

	public static int isNumber(String tagliaAsString) {
		try {
			int taglia = Integer.parseInt(tagliaAsString);
			return taglia;
		} catch (NumberFormatException n) {
			return -1;
		}
	}

}
