import java.io.Serializable;
import java.time.LocalDate;
/**
 * 
 * @author Chiappini Luca
 * La classe donatore serve per creare un Donatore
 * @param numeroDiTessera acquisisce il numero di tessera del donatore
 * @param cognome acquisisce il cognome del donatore
 * @param nome acquisisce il nome del donatore
 * @param dataDiNascita acquisisce la data di nascita del donatore
 * @param donazioniEffettuate acquisisce il numer odi donazioni effettuate del donatore
 *
 */
public class Donatore implements Serializable
{
	private int numeroDiTessera;
	private String cognome;
	private String nome;
	private LocalDate dataDiNascita;
	private int donazioniEfettuate;
	
	/**
	 * costruttore della classe Donatore
	 */
	
	public Donatore(int numeroDiTessera,String cognome,String nome,LocalDate dataDiNascita,int donazioniEfettuate )
	{
		setNumeroDiTessera(numeroDiTessera);
		setCognome(cognome);
		setNome(nome);
		setDataDiNascita(dataDiNascita);
		setDonazioniEfettuate(donazioniEfettuate);
	}
	
	/**
	 * 
	 * costruttore di coppia della classe Donatore
	 * 
	 */
	
	public Donatore(Donatore d) 
	{
		setNumeroDiTessera(d.getNumeroDiTessera());
		setCognome(d.getCognome());
		setNome(d.getNome());
		setDataDiNascita(d.getDataDiNascita());
		setDonazioniEfettuate(d.getDonazioniEfettuate());
	}
	
	/**
	 * 
	 * getter e setter dei parametri della classe ordinatore
	 * 
	 */
	
	public int getNumeroDiTessera() 
	{
		return numeroDiTessera;
	}
	public void setNumeroDiTessera(int numeroDiTessera) 
	{
		this.numeroDiTessera = numeroDiTessera;
	}
	public String getCognome() 
	{
		return cognome;
	}
	public void setCognome(String cognome) 
	{
		this.cognome = cognome;
	}
	public String getNome() 
	{
		return nome;
	}
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	
	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public int getDonazioniEfettuate() 
	{
		return donazioniEfettuate;
	}
	public void setDonazioniEfettuate(int donazioniEfettuate) 
	{
		this.donazioniEfettuate = donazioniEfettuate;
	}
	
	/**
	 * serve per restituire i dati del donatore in una Stringa
	 * @return String
	 */
	
	public String toString()
	{
		return (+getNumeroDiTessera()+": "+getNome()+" "+getCognome()+" "+getDataDiNascita()+" --> "+getDonazioniEfettuate());
	}
	
}
