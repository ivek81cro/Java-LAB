//progr. args: -62+23*35-56/2

package hr.vsite.java;

import java.util.Stack;

public class calculator
{
	public static void izracunBezPrioriteta(String args)
	{
		int broj=0, rezultat=0;
		char operator=0;
		for(int j=0;j<args.length();j++)
		{
			if(Character.isDigit(args.charAt(j)))
			{
				broj+=Character.getNumericValue(args.charAt(j));
				if(args.length()-1 != j)
				{
					if(Character.isDigit(args.charAt(j+1)))
					{
						broj*=10;
						continue;
					}
					else
					{
						operator=args.charAt(j+1);
						continue;
					}
				}
			}
			else
			{
				if(!Character.isDigit(args.charAt(j+1)))
					break;
			}

			if(operator=='+')
				rezultat+=broj;
			else if(operator=='-')
				rezultat-=broj;
			else if(operator=='*')
				rezultat*=broj;
			else if(operator=='/')
				rezultat/=broj;
			else
			{
				System.out.println("Izraz ne odgovara");
				break;
			}
			broj=0;
		}
		if(rezultat!=0)
			System.out.println("Rezultat:"+rezultat);
		//provjera ostatka izraza tokom izracuna
		else
			System.out.println("Nepravilan izraz");
	}

	public static void izracunSaPrioritetom(String args)
	{
		int broj=0, rezultat=0;
		char operator='+';
		if(args.charAt(0)=='-')
			operator='-';
		Stack<Integer> spremnik=new Stack<>();
		for(int j=0;j<args.length();j++)
		{
			//dobiti broj ako je viseznamenkasti ili opertator
			if(Character.isDigit(args.charAt(j)))
			{
				broj+=Character.getNumericValue(args.charAt(j));
				if(args.length()-1 != j)
				{
					if(Character.isDigit(args.charAt(j+1)))
					{
						broj*=10;
						continue;
					}
				}
			}
			else {
				if (!Character.isDigit(args.charAt(j + 1))) {
					System.out.println("Izraz ne odgovara");
					return;
				}
				operator = args.charAt(j);
				continue;
			}

			if(operator=='+')
				spremnik.push(broj);
			else if(operator=='-')
			{
				if (j == 0)
					continue;
				spremnik.push(broj*(-1));
			}
			else if(operator=='*')
				rezultat+=broj*spremnik.pop();
			else if(operator=='/')
				rezultat+=spremnik.pop()/2;
			else
			{
				System.out.println("Izraz ne odgovara");
				break;
			}
			broj=0;
		}
		while(!spremnik.empty())
		{
			rezultat+=spremnik.pop();
		}
		if(rezultat!=0)
			System.out.println("Rezultat-prioritet:"+rezultat);
			//provjera ostatka izraza tokom izracuna
		else
			System.out.println("Nepravilan izraz");
	}

	public static void main(String[] args) 
	{
		for (int i=0; i<args.length; ++i) {
			//Ispis charova argumenta redom
			System.out.println("--------------------------------");
			System.out.println("Izraz - po indeksima:");
			for (int j = 0; j < args[i].length(); ++j) {
				System.out.println("[" + j + "]:" + args[i].charAt(j));
			}
			//Izracun argumenata
			//Provjera izraza->pocetak,kraj
			if ((!Character.isDigit(args[i].charAt(args[i].length() - 1)) ||
					!Character.isDigit(args[i].charAt(0))) && args[i].charAt(0) != '-') {
				System.out.println("Nepravilan izraz");
				continue;
			}
			//izracun bez prioriteta
			izracunBezPrioriteta(args[i]);
			//izracun sa prioritetom
			izracunSaPrioritetom(args[i]);
		}
	}
}
