
public class AvisCoda 
{
	private Nodo head;
	private int elementi;
	
	public AvisCoda()
	{
		head=null;
		elementi=0;
	}
	
	public int getElementi()
	{
		return elementi;
	}
	
	private Nodo creaNodo(Donatore persona, Nodo link)
	{
		Nodo nodo=new Nodo(persona);
		nodo.setLink(link);
		return nodo;
	}
	
	private Nodo getLinkPosizione(int posizione) throws AvisEccexption
	{
		if (elementi==0)
			throw new AvisEccexption("Lista vuota");
		if (posizione<=0 || posizione>elementi)
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
	
	public void enqueue(Donatore persona)
	{
		Nodo p=creaNodo(persona,head);
		head=p;
		elementi++;                                                                                           
	}
	
	public Donatore dequeue() throws AvisEccexption
	{
		Donatore Donatore;
		if (elementi==0)
			throw new AvisEccexption("Lista vouta");	
		if (elementi==1)
		{
			Donatore=new Donatore(head.getInfo());
			head=head.getLink();
			elementi--;
			return Donatore;
		}
		Nodo p=getLinkPosizione(elementi);
		Donatore=new Donatore(p.getInfo());
		Nodo penultimo=getLinkPosizione(elementi-1);
		penultimo.setLink(null);
		elementi--;
		return Donatore;
	}
	
}
