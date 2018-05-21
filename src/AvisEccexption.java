
public class AvisEccexption extends Exception 
{
	public String messaggio;
	
	public AvisEccexption(String messaggio)
	{
		this.messaggio=messaggio;
	}
	
	public String toString()
	{
		return messaggio;
	}
	
}
