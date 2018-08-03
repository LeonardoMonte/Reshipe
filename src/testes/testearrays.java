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
//		
//		
//		
//	
//		int cont = 0;
//		boolean resultado = true;
//		
//		
//		
//		
//		
//		
//		for(int y = 0 ; y < teste.listarReceitasNormalizadas().size() ; y++)
//		{
//			cont = 0;
//			for(int x = 0 ; x < teste.listarReceitasNormalizadas().get(y).getIngredientes().size() ; x++ )
//			{
//				if(teste.listarReceitasNormalizadas().get(y).getIngredientes().get(x) == 1)
//					{
//						cont++;
//						
//					}
//				
//			}
//			
//			if(cont != Reporeceitas.getInstancia().listarReceitas().get(y).listarIngredientes().size())
//			{
//				System.out.println("Posicao cm erro" + y );
//				System.out.println(cont);
//				System.out.println(Reporeceitas.getInstancia().listarReceitas().get(y).listarIngredientes().size());
//				System.out.println();
//			}
//			
//
////
////			
////			
////		
////			
//		}
//
//		System.out.println(Reporeceitas.getInstancia().listarReceitas().get(17));
//		System.out.println();
//		System.out.println(teste.listarReceitasNormalizadas().get(17));
//		System.out.println(teste.listarReceitasNormalizadas().get(18));
//		System.out.println();
//		System.out.println(teste.listarIngredientesCadastrados());
//		
//	System.out.println(resultado);
////
////		System.out.println(Reporeceitas.getInstancia().listarReceitas().get(2).getNome().equals(teste.listarReceitasNormalizadas().get(2)
////				.getNome()));
////		
////		System.out.println(cont);
////		System.out.println(Reporeceitas.getInstancia().listarReceitas().get(2).listarIngredientes().size());
////		
////		System.out.println();
////		System.out.println(teste.listarIngredientesCadastrados());
//	//	System.out.println(teste.listarReceitasNormalizadas());
//		
//		
//		ArrayList<Integer> posicoes15 = new ArrayList<>();
//		ArrayList<Integer> posicoes17 = new ArrayList<>();
//		ArrayList<Integer> posicoes39 = new ArrayList<>();
//		ArrayList<Integer> posicoes80 = new ArrayList<>();
//
//		for(int x = 0 ; x < teste.listarReceitasNormalizadas().get(15).getIngredientes().size() ; x++ )
//		{
//			if(teste.listarReceitasNormalizadas().get(15).getIngredientes().get(x) == 1)
//				{
//					cont++;
//					posicoes15.add(x);
//					
//				}
//			
//		}
//		for(int x = 0 ; x < teste.listarReceitasNormalizadas().get(17).getIngredientes().size() ; x++ )
//		{
//			if(teste.listarReceitasNormalizadas().get(17).getIngredientes().get(x) == 1)
//				{
//					cont++;
//					posicoes17.add(x);
//					
//				}
//			
//		}
//		for(int x = 0 ; x < teste.listarReceitasNormalizadas().get(39).getIngredientes().size() ; x++ )
//		{
//			if(teste.listarReceitasNormalizadas().get(39).getIngredientes().get(x) == 1)
//				{
//					cont++;
//					posicoes39.add(x);
//					
//				}
//			
//		}
//		for(int x = 0 ; x < teste.listarReceitasNormalizadas().get(80).getIngredientes().size() ; x++ )
//		{
//			if(teste.listarReceitasNormalizadas().get(80).getIngredientes().get(x) == 1)
//				{
//					cont++;
//					posicoes80.add(x);
//					
//				}
//			
//		}
//		
//		System.out.println(posicoes15);
//		System.out.println(posicoes17);
//		System.out.println(posicoes39);
//		System.out.println(posicoes80);
//		
//		System.out.println(teste.listarIngredientesCadastrados().get(257));
	
		
		ArrayList<String> ingre = new ArrayList<>();
//		ingre.add("tomate");
/*		ingre.add("ovos");
		ingre.add("ovos");
		
		ingre.add("acucar");
		ingre.add("leite condensado");
//		ingre.add("acucar demerara");
//		ingre.add("emilia");
	//	ingre.add("leonardo");
		ingre.add("manteiga");
		

		ingre.add("ovos");
		ingre.add("queijo cheddar");
		ingre.add("sal");
		ingre.add("pimenta-do-reino");
		ingre.add("manjericao");
		ingre.add("farinha de trigo");
	
				ingre.add("ovos");
		ingre.add("trigo");
		ingre.add("manteiga");
		ingre.add("queijo ralado");
		*/
		ingre.add("leite condensado");
		ingre.add("ovos");
		ingre.add("raspas de laranja");
		ingre.add("acucar");
		
		
	

		System.out.println(ingre);
		KNN.getInstancia().knnOut(ingre,20);
//		System.out.println(KNN.getInstancia().listarReceitasNormalizadas().get(102).getIngredientes());
//		
//		System.out.println(KNN.getInstancia().listarIngredientesCadastrados().size());
//		System.out.println(KNN.getInstancia().listarIngredientesCadastrados());
		
		

		
		
		
		
		
	}
	
}
