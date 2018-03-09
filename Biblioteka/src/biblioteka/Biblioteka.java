package biblioteka;

import java.util.LinkedList;

import javax.management.RuntimeErrorException;

import biblioteka.interfejs.BibliotekaInterfejs;

public class Biblioteka implements BibliotekaInterfejs{

	private LinkedList<Knjiga>knjige=new LinkedList<Knjiga>();
	
	
	@Override
	public void dodajKnjigu(Knjiga k) {
		if(k==null||knjige.contains(k))
			throw new RuntimeException("knjiga je null ili vec postoji");
		knjige.add(k);
		
	}

	@Override
	public void obrisiKnjigu(Knjiga k) {
		if(k==null||!knjige.contains(k))
			throw new RuntimeException("knjiga je null ili ne postoji");
		knjige.remove(k);
		
	}

	@Override
	public LinkedList<Knjiga> vratiSveKnjige() {
		return knjige;
	}

	@Override
	public LinkedList<Knjiga> pronadjiKnjigu(Autor autor, String naslov, String izdavac) {
		if(naslov==null)
			throw new RuntimeException("morate uneti naslov");
		
		LinkedList<Knjiga>novaLista= new LinkedList<Knjiga>();
		for(int i=0;i<knjige.size();i++) {
			if(knjige.get(i).getNaslov().contains(naslov))
			novaLista.add(knjige.get(i));
			
		}
		return novaLista;
	}

}
