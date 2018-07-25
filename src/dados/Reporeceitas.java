package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import beans.Receita;
import exceptions.Objectnotfound;
import exceptions.Objetojaexiste;

public class Reporeceitas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5731208913884515422L;
	private static Reporeceitas instancia;
	private ArrayList<Receita> receitas;
	
	
	private Reporeceitas()
	{
		this.receitas = new ArrayList<>();
	}
	
	public static Reporeceitas getInstancia()
	{
		if(instancia == null)
		{
			instancia = Reporeceitas.load();
		}
		
		return instancia;
	}
	
	public void cadastrarReceita(Receita r) throws  Objetojaexiste
	{
		boolean result = this.existe(r.getNome());
		
		if(result == true)
		{
			throw new Objetojaexiste(r.getNome());
		}
		else
		{
			this.receitas.add(r);
		}
		
		
		

	}
	
	public void removerReceita(String nome) throws Objectnotfound
	{
		Receita r = this.buscarReceita(nome);
		this.receitas.remove(r);
		
	}
	
	public Receita buscarReceita(String nome) throws Objectnotfound
	{
		Receita resultado = null;
		
		int i = this.procurarIndice(nome);
		resultado = this.receitas.get(i);
		return resultado;
		
	}
	
	public int procurarIndice(String nome) throws Objectnotfound
	{	
		int cont = -1;
		
		for(int x = 0 ; x < this.receitas.size() ; x++)
		{
			if(this.receitas.get(x).getNome().equals(nome))
			{
				cont = x;
			}
		}
		
		if(cont < 0)
		{
			throw new Objectnotfound(nome);
		}
				
		return cont;
	}
	
	public boolean existe(String nome)
	{
		boolean resultado = false;
		
		for(int x = 0 ; x < this.receitas.size() ; x++)
		{
			if(this.receitas.get(x).getNome().equals(nome))
			{
				resultado = true;
			}
		}
		
		return resultado;
		

	}
	
	public ArrayList<Receita> listarReceitas()
	{
		return this.receitas;
	}
	
	
	
	@SuppressWarnings("resource")
	private static Reporeceitas load(){

		Reporeceitas rep = new Reporeceitas();
		int contNome = 0;
		Receita r = null;
		
		try {
			Scanner sc = new Scanner(new FileReader("C://Users//leopk//Desktop//weka files IA//reshipejavafile3.txt"))
					.useDelimiter("\\,");
			
			
			while(sc.hasNextLine())
			{
				String line = sc.nextLine();
				Scanner lnsc = new Scanner(line).useDelimiter("\\,");
				
				while(lnsc.hasNext())
				{
					if(contNome == 0)
					{
						r = new Receita(lnsc.next());
						contNome++;
					}
					else
					{
						r.addIngre(lnsc.next().toLowerCase());
					}
				
			}
				
				lnsc.close();
				contNome = 0;
				try {
					rep.cadastrarReceita(r);
				} catch (Objetojaexiste e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
							
			}
			
			
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rep;
	}
	
}
