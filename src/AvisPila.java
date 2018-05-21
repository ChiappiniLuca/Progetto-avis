
public class AvisPila 
{	
	private Nodo head;
	private int elementi;
	
	public AvisPila()
	{
		head=null;
		elementi=0;
	}
	
	public int getElementi()
	{
		return elementi;
	}
	
	private Nodo creaNodo(Donatore donatore, Nodo link)
	{
		Nodo nodo=new Nodo(donatore);
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
	
	public void push(Donatore donatore)
	{
		Nodo p=creaNodo(donatore,head);
		head=p;
		elementi++;
	}
	
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
}
