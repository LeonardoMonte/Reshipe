package testes;

import java.util.ArrayList;
import java.util.List;

import beans.Receita;
import dados.GerenReceitas;
import dados.Reporeceitas;
import exceptions.Objectnotfound;
import exceptions.Objetojaexiste;

public class testearrays {

	
	private ArrayList<String> ingredientes;
	
	
	public testearrays ()
	{
		this.ingredientes = new ArrayList<>();
	}
	
	public void addIngre(String ing)
	{
		this.ingredientes.add(ing);
	}
	
	public void removeIngre(String ing) 
	{
			this.ingredientes.remove(ing);
	
	}
	
	public ArrayList<String> listar()
	{
		return this.ingredientes;
	}
	
	public static void main(String args[])
	{
		
		
        boolean espaco = " ".matches("\\d");
        System.out.println("Possui espaço? "+espaco);
		
		
	
		
	
		
		
		
		
	}
	
}
