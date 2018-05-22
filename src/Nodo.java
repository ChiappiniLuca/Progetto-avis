import java.io.Serializable;

/**
 * 
 * @author Chiappini Luca
 *la classe Nodo serve per creare un nodo della lista il quale conterrà  
 *i parametri del Donatore e il reference al nodo successivo
 * @param info contiene il reference ad un oggetto che contiene le informazioni sugli elementi della lista(in questo caso a un donatore)
 * @param Link reference all elemento successivo della lista (quindi al nodo successivo)
 */
public class Nodo implements Serializable
{
	private Donatore info;
	private Nodo link;
	
	/**
	 * costruttore della classe nodo
	 */
	
	public Nodo(Donatore donatore)
	{
		setInfo(donatore);
		link=null;
	}
	
	/**
	 * costruttore di coppia della classe Donatore
	 */
	
	public Nodo()
	{
		info=null;
		link=null;
	}
	
	/**
	 * getter e setter della classe Donatore
	 */
	
	public Donatore getInfo() 
	{
		return info;
	}

	public void setInfo(Donatore info) 
	{
		this.info =new Donatore (info);
	}

	public Nodo getLink() 
	{
		return link;
	}

	public void setLink(Nodo link) 
	{
		this.link = link;
	}
}
