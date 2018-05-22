import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class MainClass {

	public static void main(String[] args) 
	{
		FileWriter fileDonazioni;
		BufferedWriter writerDonazioni = null;
		FileWriter fileDonatori;
		BufferedWriter writer = null;
		try {
			fileDonazioni=new FileWriter("DonazioniEffettuate.txt");
			writerDonazioni = new BufferedWriter(fileDonazioni);
			fileDonatori=new FileWriter("DonatoriEliminati.txt");
			writer = new BufferedWriter(fileDonatori);
		}
		catch (IOException e2) 
		{
			System.out.println("errore file");
			e2.printStackTrace();
		}

		LocalDate data1= LocalDate.of(1971, 5 , 12);
		LocalDate data2= LocalDate.of(1981, 4 , 12);
		LocalDate data3= LocalDate.of(1991, 3 , 12);
		LocalDate data4= LocalDate.of(1991, 1 , 12);
		LocalDate data5= LocalDate.of(2001, 2 , 12);
		Avis a1= new Avis();
		Donatore d1=new Donatore(1,"C", "Peppino",data1,20);
		Donatore d2=new Donatore(2,"D", "Renzo",data5,13);
		Donatore d3=new Donatore(3,"A", "Paolo",data3,2);
		Donatore d4=new Donatore(4,"B", "Marco",data2,8);
		Donatore d5=new Donatore(5,"E", "Carlo",data4,11);
		a1.push(d1);
		a1.push(d2);
		a1.push(d5);
		a1.push(d4);
		a1.push(d3);
		
		InputStreamReader input  = new InputStreamReader(System.in);
		BufferedReader reader= new BufferedReader(input);
		int rigaLetta = 0;
		
		try {
			System.out.println("inserisci il numero della tessera da eliminare: ");
			rigaLetta=Integer.parseInt(reader.readLine());
		} 
		catch (IOException e1) 
		{
			System.out.println("input non valido");
		}
		
		try 
		{
			a1.eliminaDonatoreConTessera(rigaLetta,writer);
			//a1.eliminaDonatoreConTessera(rigaLetta+1,writer);
		} 
		catch (AvisEccexption | IOException e) 
		{
			System.out.println(e.toString());
		}
		
		try {
			System.out.println("inserisci il numero della tessera del donatore: ");
			rigaLetta=Integer.parseInt(reader.readLine());
		} 
		catch (IOException e1) 
		{
			System.out.println("input non valido");
		}
		
		try 
		{
			a1.donazioneDelDonatore(rigaLetta, writerDonazioni);
			System.out.println("il donatore "+rigaLetta+" ha effettuato una donazione");
			System.out.println("\n");
		} 
		catch (AvisEccexption | IOException e1) 
		{
			System.out.println(e1.toString());
			e1.printStackTrace();
		}
		
		try 
		{
			a1.stampaAvis();
			a1.visualizzaAlfabetico();
			System.out.println("\n");
			a1.stampaAvis();
			System.out.println("\n");
			a1.visualizzaDonazioniSuperioriA(10);
			System.out.println("\n");
			a1.visualizzaPerAnzianità();
			a1.stampaAvis();
		}
		catch (AvisEccexption | IOException e1) 
		{
			System.out.println("stampa errata");
			e1.printStackTrace();
		}
		try 
		{
			writerDonazioni.close();
			writer.close();
		} 
		catch (IOException e) 
		{
			System.out.println("errore file");
			e.printStackTrace();
		}
		System.out.println(a1.toString());
		
		FileOutputStream db;
		try 
		{
			db = new FileOutputStream("dataBase.bin");
			ObjectOutputStream writerSerial=new ObjectOutputStream(db);
			a1.serializza(writerSerial);
			db.close();
		} 
		catch (IOException | AvisEccexption e) 
		{
			System.out.println("errore col file di dataBase");
			e.printStackTrace();
		}
		
	}
	
}
