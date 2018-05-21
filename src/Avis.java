import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author Chiappini Luca
 * @param head refernce che punta al primo nodo
 * @param elementi numero di elementi della lista
 */

public class Avis 
{	
	private Nodo head;
	private int elementi;
	
	/**
	 * costruttore della classe avis
	 */
	
	public Avis()
	{
		head=null;
		elementi=0;
	}
	
	/**
	 * costruttore di coppia della classe Donatore
	 */
	
	public int getElementi()
	{
		return elementi;
	}
	
	/**
	 * serve per creare un Nodo che contiene un donatore e il reference al Nodo successivo
	 */
	
	private Nodo creaNodo(Donatore donatore, Nodo link)
	{
		Nodo nodo=new Nodo(donatore);
		nodo.setLink(link);
		return nodo;
	}
	
	/**
	 * serve per far puntare il reference ad una posizione stabilita dall' utente
	 */
	
	private Nodo getLinkPosizione(int posizione) throws AvisEccexption
	{
		if (elementi==0)
			throw new AvisEccexption("Lista vuota");
		if (posizione<=0)
			throw new AvisEccexption("posizione non valida");
		else if(posizione>elementi)
			throw new AvisEccexption("posizione non valida");
		
		Nodo p=head;		
		int n=1;
		while(p.getLink()!=null && n<posizione)
		{
			p=p.getLink();
			n++;
		}
		return p;
	}
	
	public String toString()
	{
		String risultato="Head";
		if (elementi==0)
			return risultato;
		Nodo p=head;
		while (p!=null)
		{
			risultato+="-->"+p.getInfo().getNome();
			p=p.getLink();
		}
		return risultato;
	}
	
	/**
	 * serve per inserire nella lista un donatore
	 */
	
	public void push(Donatore donatore)
	{
		Nodo p=creaNodo(donatore,head);
		head=p;
		elementi++;
	}
	
	/**
	 * serve per estrarre nella lista un donatore
	 */
	
	public Donatore pop() throws AvisEccexption
	{
		if (elementi==0)
			throw new AvisEccexption("Lista vouta");
		Donatore Donatore;
		Donatore=new Donatore(head.getInfo());
		head=head.getLink();
		elementi--;
		return Donatore;
	}
	
	/**
	 * serve per inserire in testa alla lista un donatore
	 */
	
	public void inserisciInTesta(Donatore donatore)
	{
		Nodo p=creaNodo(donatore,head);
		head=p;
		elementi++;
	}
	
	/**
	 * serve per inserire in coda alla lista un donatore
	 */
	
	public void InserisciInCoda(Donatore donatore) throws AvisEccexption 
	{
		if(elementi==0)
		{
			inserisciInTesta(donatore);
			return;
		}
		Nodo pn=creaNodo(donatore,null);
		Nodo p=getLinkPosizione(elementi);
		p.setLink(pn);
		elementi++;
	}
	
	/**
	 * serve per eliminare in testa alla lista un donatore
	 */

	public void eliminaInTesta() throws AvisEccexption
	{
		if (elementi==0)
			throw new AvisEccexption("Lista vouta");		
		head=head.getLink();
		elementi--;
	}
	
	/**
	 * serve per eliminare in coda alla lista un donatore
	 */
	
	public void eliminaInCoda() throws AvisEccexption
	{
		if (elementi==0)
			throw new AvisEccexption("Lista vouta");	
		if (elementi==1)
		{
			eliminaInTesta();
			return;
		}
		
		Nodo penultimo=getLinkPosizione(elementi-1);
		penultimo.setLink(null);
		elementi--;
	}
	
	/**
	 * serve per eliminare un donatore della lista con il numero di tessera inserita dall utente
	 */
	
	public void eliminaDonatoreConTessera(int tessera,BufferedWriter writer) throws AvisEccexption, IOException
	{
		int trovato=0;
		int posizione=1;
		while (trovato==0)
		{
			Nodo p=getLinkPosizione(posizione);
			if(p.getInfo().getNumeroDiTessera()==tessera)
			{
				trovato++;
				eliminaInPosizioneWriter(posizione, writer);
			}
			else
			{
			posizione++;
			if (posizione<=0 || posizione>elementi)
				throw new AvisEccexption("Tessera non trovata");
			}
		}
	}
	
	/**
	 * serve per inserire un donatore in una posizione scelta dall utente
	 */
	
	void inserisciInPosizione(Donatore donatore, int posizione) throws AvisEccexption 
	{
		if(posizione==elementi+1)
		{
			InserisciInCoda(donatore);
			return;
		}
		if (posizione<=0 || posizione>elementi+1)
			throw new AvisEccexption("Posizione non valida");
		if (posizione==1)
		{
			inserisciInTesta(donatore);
			return;
		}
		Nodo pn=creaNodo(donatore,getLinkPosizione(posizione));
		Nodo precedente=getLinkPosizione(posizione-1);
		precedente.setLink(pn);
		elementi++;
	}
	
	/**
	 * serve per eliminare un donatore in una posizione scelta dall utente e scrivere i dati del donatore in un file di testo
	 */
	
	public void eliminaInPosizioneWriter(int posizione, BufferedWriter writer) throws AvisEccexption, IOException 
	{
			if (elementi==0)
				throw new AvisEccexption("Lista vouta");
			if (posizione<=0 || posizione>elementi)
				throw new AvisEccexption("Posizione non valida");
			Nodo p=getLinkPosizione(posizione);
			writer.write(p.getInfo().toString());
			writer.newLine();
			
			if (posizione==1)
			{
				eliminaInTesta();
				return;
			}
			
			if(posizione==elementi)
			{
				eliminaInCoda();
				return;
			}
			
			Nodo precedente=getLinkPosizione(posizione-1);
			precedente.setLink(p.getLink());
			elementi--;
	}

	/**
	 * serve per eliminare un donatore in una posizione scelta dall utente
	 */
	
	public void eliminaInPosizione(int posizione) throws AvisEccexption
	{
			if (elementi==0)
				throw new AvisEccexption("Lista vouta");
			if (posizione<=0 || posizione>elementi)
				throw new AvisEccexption("Posizione non valida");
			Nodo p=getLinkPosizione(posizione);
			
			if (posizione==1)
			{
				eliminaInTesta();
				return;
			}
			
			if(posizione==elementi)
			{
				eliminaInCoda();
				return;
			}
			
			Nodo precedente=getLinkPosizione(posizione-1);
			precedente.setLink(p.getLink());
			elementi--;
	}
	
	/**
	 * serve per effettuare una donazione da parte di un donatore
	 */
	
	public void donazioneDelDonatore (int tessera, BufferedWriter writer) throws AvisEccexption, IOException
	{
		int d=0;
		int trovato=0;
		int posizione=1;
		while (trovato==0)
		{
			Nodo p=getLinkPosizione(posizione);
			if(p.getInfo().getNumeroDiTessera()==tessera)
			{
				trovato++;
				d=p.getInfo().getDonazioniEfettuate()+1;
				p.getInfo().setDonazioniEfettuate(d);
				writer.write(p.getInfo().toString());
				writer.newLine();
			}
			else
			{
			posizione++;
			if (posizione<=0 || posizione>elementi)
				throw new AvisEccexption("Tessera non trovata");
			}
		}
	}
	
	
	
	private void scambia(int posizione1, int posizione2) throws AvisEccexption, IOException
	{
		Nodo p=getLinkPosizione(posizione1);
		Nodo q=getLinkPosizione(posizione2);
		eliminaInPosizione(posizione1);
		eliminaInPosizione(posizione2-1);
		inserisciInPosizione(q.getInfo(), posizione1);
		inserisciInPosizione(p.getInfo(), posizione2);
	}
	
	public void visualizzaAlfabetico() throws AvisEccexption, IOException
	{
		int posizioneA=1;
		int posizioneB=1;
		while(posizioneA<elementi)
		{
			Nodo a=getLinkPosizione(posizioneA);
			
			posizioneB=posizioneA+1;
			while (posizioneB<=elementi)
			{
				Nodo b=getLinkPosizione(posizioneB);
				if ((a.getInfo().getCognome().compareToIgnoreCase((b.getInfo().getCognome()))>0))
				{
					scambia(posizioneA,posizioneB);
				}
				posizioneB++;
			}
			posizioneA++;
		}
	}

	public void visualizzaaPerAnzianità() throws AvisEccexption, IOException
	{
		int posizioneA=1;
		int posizioneB=1;
		while(posizioneA<elementi)
		{
			Nodo a=getLinkPosizione(posizioneA);
			
			posizioneB=posizioneA+1;
			while (posizioneB<=elementi)
			{
				Nodo b=getLinkPosizione(posizioneB);
				//if ((a.getInfo().getDataDiNascita().compareToIgnoreCase((b.getInfo().getDataDiNascita()))>0))
				{
					scambia(posizioneA,posizioneB);
				}
				posizioneB++;
			}
			posizioneA++;
		}
	}
	
	/**
	 * serve visualizzare tutti i dati di un donatore 
	 */
	
	public void stampaAvis() throws AvisEccexption
	{
		int posizione=1;
		while(posizione<=elementi)
		{
			Nodo p=getLinkPosizione(posizione);
			System.out.println(p.getInfo().toString());
			posizione++;
		}
	}
	
	/**
	 * serve per visualizzare tutti i donatori che hanno fatto delle donazioni superiori a 10
	 */
	
	public void visualizzaDonazioniSuperioriA(int donazioni) throws AvisEccexption
	{
		int posizione=1;
		while(posizione<=elementi)
		{
			Nodo p=getLinkPosizione(posizione);
			if(p.getInfo().getDonazioniEfettuate()>donazioni)
				System.out.println(p.getInfo().toString());
			posizione++;
		}
		
	}
	
}
