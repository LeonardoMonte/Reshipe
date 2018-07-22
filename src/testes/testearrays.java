package testes;

import java.lang.annotation.Repeatable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import algoritmosIA.KNN;
import beans.Receita;
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
		
		KNN teste = new KNN();
		int cont = 0;
		boolean resultado = true;
		for(int y = 0 ; y < teste.listarReceitasNormalizadas().size() ; y++)
		{
			cont = 0;
			for(int x = 0 ; x < teste.listarReceitasNormalizadas().get(y).getIngredientes().size() ; x++ )
			{
				if(teste.listarReceitasNormalizadas().get(y).getIngredientes().get(x) == 1)
					{
						cont++;
					}
				
			}
			
			if(cont != Reporeceitas.getInstancia().listarReceitas().get(y).listarIngredientes().size())
			{
				System.out.println("Posicao cm erro" + y );
				System.out.println(cont);
				System.out.println(Reporeceitas.getInstancia().listarReceitas().get(y).listarIngredientes().size());
				System.out.println();
			}
			

			
			
		
			
		}
		
		System.out.println(resultado);
//
//		System.out.println(Reporeceitas.getInstancia().listarReceitas().get(2).getNome().equals(teste.listarReceitasNormalizadas().get(2)
//				.getNome()));
//		
//		System.out.println(cont);
//		System.out.println(Reporeceitas.getInstancia().listarReceitas().get(2).listarIngredientes().size());
//		
//		System.out.println();
//		System.out.println(teste.listarIngredientesCadastrados());
	//	System.out.println(teste.listarReceitasNormalizadas());
		
		
		System.out.println(Reporeceitas.getInstancia().listarReceitas());
		
		

		
		
		
		
		
	}
	
}
