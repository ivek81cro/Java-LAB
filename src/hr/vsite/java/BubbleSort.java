package hr.vsite.java;

import java.util.Random;
import java.util.Scanner;

public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// niz brojeva koje treba sortirati
		int[] sequence = new int[100];//sve vrijednosti 0
		
		
		//-------�����1. dio vje�be�����-----------
		// inicijaliziramo niz sa slu�ajnim brojevima od 0 do 255
		//zakomentirajte poziv kada radite 2. dio vje�be
		//initSequence(sequence);//inicijalizira vrijednosti unutar niza
		//-------^^^^^1. dio vje�be^^^^^-----------
		
		
		
		//-------�����2. dio vje�be�����-----------
		//odkomentirajte kada radite 2. dio vje�be
		sequence = initUserSequence();
		//-------^^^^^2. dio vje�be^^^^^-----------
		
		

		sortSequence(sequence);
		printSequence(sequence);
		if (checkSequence(sequence)) {
			System.out.println("Niz je ispravno sortiran!");
		} else {
			System.out.println("Niz nije ispravno sortiran!!!");
		}

	}

	private static int[] initUserSequence() 
	{
		/*
		 * Ovdje treba napisati kod koji �e od korisnika zatra�iti duljinu niza
		 * i elemente niza koji se sortiraju
		 */
		int[] sequence = null;
		int sequenceLength = -1;
		//inicijializacija Scanner objekta koji nam 
		//olak�ava parsiranje toka znakova koji korisnik upisuje
		Scanner s = new Scanner(System.in);
		// ----------����va� kod ide ovdje����--------------
		System.out.println("Unesite duljinu niza:");
		sequenceLength=getNextInt(s);
		sequence=new int[sequenceLength];
		System.out.println("Unesite brojeve niza:");
		for(int i=0;i<sequenceLength;i++)
		{
			sequence[i]=getNextInt(s);
		}
		
		s.close();
		// ----------^^^^va� kod ide ovdje^^^^--------------
		return sequence;
	}

	// metoda koja vra�a slijede�i int
	private static int getNextInt(Scanner s) 
	{
		/*
		 * metode hasNext...() i next...() su blokiraju�e
		 * tj. program �e tu stati ako nije ni�ta upisano
		 * */
		while (true) 
		{
			// ako je upisan int onda se vra�a upisani broj
			if (s.hasNextInt()) 
			{
				return s.nextInt();
			}
			//ako je ne�to drugo upisano onda se to preska�e
			if (s.hasNext()) 
			{
				System.out.println("Morate upisati broj!");
				s.next();
			}
		}
	}

	private static void sortSequence(int[] sequence) {
		/*
		 * U ovoj metodi treba napisati kod koji sortira niz brojeva od najve�eg
		 * do najmanjeg (metodom kako je obja�njeno na lab. vje�bama)
		 */
		
		for(int i=0; i<sequence.length; i++)
		{
			int temp=0;
			for(int j=1; j < (sequence.length-i); j++)
			{  
                if(sequence[j-1] < sequence[j])
                {
                       temp = sequence[j-1];  
                       sequence[j-1] = sequence[j];  
                       sequence[j] = temp;
                       }
			}
		}
	}

	private static void initSequence(int[] sequence) 
	{
		Random r = new Random();
		for (int i = 0; i < sequence.length; i++) 
		{
			sequence[i] = r.nextInt(255);
		}
	}

	private static boolean checkSequence(int[] sequence) 
	{
		for (int i = 0; i < sequence.length - 1; i++) 
		{
			if (sequence[i] < sequence[i + 1]) 
			{
				return false;
			}
		}
		return true;
	}

	private static void printSequence(int[] sequence)
	{
		int numPerRow = 10;
		for (int i = 0; i < sequence.length; i++) 
		{
			System.out.printf("%03d ", sequence[i]);
			
			if ((i + 1) % numPerRow == 0 && i != 0)
				System.out.println();
		}
		System.out.println();
	}

}
