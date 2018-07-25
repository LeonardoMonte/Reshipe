package algoritmosIA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import beans.Receita;
import beans.ReceitasNormalizadas;
import dados.Reporeceitas;

public class KNN {

	
	private static KNN instancia;
	private ArrayList<String> comparador;
	private ArrayList<ReceitasNormalizadas> receitasNorm;
	
	private KNN()
	{
		
		this.comparador = this.construtor();
		this.receitasNorm = this.construtorReceitasNorm();
	}
	
	public static KNN getInstancia()
	{
		if(instancia == null)
		{
			instancia = new KNN();
		}
		
		return instancia;
	}
	
	public ArrayList<String> listarIngredientesCadastrados()
	{
		return this.comparador;
	}
	
	public ArrayList<ReceitasNormalizadas> listarReceitasNormalizadas()
	{
		return this.receitasNorm;
	}
	
	public ArrayList<Integer> normalizerReceitaRecebida(ArrayList<String> array)
	{
		ArrayList<Integer> retorno = new ArrayList<>();
		
		for(int x = 0 ; x < this.comparador.size() ; x++)
		{
			retorno.add(0);
		}
		
		for(int x = 0 ; x < array.size() ; x++)
		{
			int local = this.comparador.indexOf(array.get(x));
			retorno.set(local, 1);
		}
		
		return retorno;
	}
	
	
	public void knnOut(ArrayList<String> array , int k)
	{
		ArrayList<Receita> r = this.knn(array, k);
		
		
		System.out.println("Receitas possiveis:");
		for(int x = 0 ; x < k ; x++)
		{
			System.out.println("1 - " + r.get(x).getNome());
		}
		
	}
	
	
	 public ArrayList<Receita> knn(ArrayList<String> array, int k)
	 {
		 ArrayList<Receita> rec = new ArrayList<>();
		 ArrayList<Integer> receitaRecebida = this.normalizerReceitaRecebida(array);
		 ArrayList<Receita> distancias = Reporeceitas.getInstancia().listarReceitas();
		 double dist = 0;
		 
		 System.out.println(receitaRecebida);
		 	 
		 for(int x = 0 ; x < this.receitasNorm.size() ; x++)
		 {	  
			 for(int y = 0 ; y < this.comparador.size() ; y++)
			 {			 
				double local = this.receitasNorm.get(x).getIngredientes().get(y) - receitaRecebida.get(y);
				dist += Math.pow(local, 2);
			 }
			 
			 dist = Math.sqrt(dist);
			 
			 System.out.println(dist);
			 
			 distancias.get(x).setDistancia(dist);		
			 dist = 0;
		 }
		 
		 
		 int menor = 0;
		 System.out.println(distancias.size());
		 
		
		 
		 for(int x = 0 ; x < k ; x++)
		 {
			 menor = 0;
			 
			 for(int y = 0 ; y < distancias.size(); y++)
			 {			 
				 if(distancias.get(menor).getDistancia() >= distancias.get(y).getDistancia())
				 {
					 menor = y;
				 }

			 }
			 
			System.out.println(menor);
			System.out.println("DISTANCIA DO MENOR: " + distancias.get(menor).getDistancia());
			rec.add(distancias.get(menor));	
			distancias.remove(menor);
			 
		 }
		 
		 
		 return rec;
	 }
	
	
	public ArrayList<ReceitasNormalizadas> construtorReceitasNorm()
	{
		ArrayList<ReceitasNormalizadas> rec = this.geradorReceitarNorm();
		
		for(int x = 0 ; x < Reporeceitas.getInstancia().listarReceitas().size() ; x++)
		{
			for(int y = 0 ; y < Reporeceitas.getInstancia().listarReceitas().get(x).listarIngredientes().size() ; y++ )
			{
				
				int local = this.comparador.indexOf(Reporeceitas.getInstancia()
						.listarReceitas().get(x).listarIngredientes().get(y));
			//	System.out.println(Reporeceitas.getInstancia().listarReceitas().get(x).listarIngredientes().get(y) + " " + x);
				//System.out.println("ESTOU AQUIIII");
				//System.out.println(local);
				rec.get(x).getIngredientes().set(local, 1);
				
			}
		}
		
		
		return rec;
	}
	
	
	public ArrayList<ReceitasNormalizadas> geradorReceitarNorm()
	{
		ArrayList<ReceitasNormalizadas> rec = new ArrayList<>();
		
		// TRANSFORMANDO O ARRAY DE INGREDIENTES EM UM ARRAY DE 0 COM O TAMANHO DO ARRAY DE INGREDIENTES TOTAL E ADICIONANDO O NOME
		for(int x = 0 ; x < Reporeceitas.getInstancia().listarReceitas().size() ; x++ )
		{
			ReceitasNormalizadas r = new ReceitasNormalizadas(Reporeceitas.getInstancia().listarReceitas().get(x).getNome());
			
			rec.add(r);
			
			for(int y = 0 ; y < this.comparador.size() ; y++)
			{
				rec.get(x).addIngre(0);
			}
			
		}
		
		
		
		
		return rec;
	}
	

	
	public ArrayList<String> construtor()
	{
		ArrayList<String> retorno = new ArrayList<>();
		
		for(int x = 0 ; x < Reporeceitas.getInstancia().listarReceitas().size() ; x++)
		{
			for(int y = 0 ; y < Reporeceitas.getInstancia().listarReceitas().get(x).listarIngredientes().size() ; y++)
			{
				if(!retorno.contains( Reporeceitas.getInstancia().listarReceitas().get(x).listarIngredientes().get(y)))
				{
					retorno.add(Reporeceitas.getInstancia().listarReceitas().get(x).listarIngredientes().get(y));
				}
			}
		}
		
		Collections.sort(retorno);
		return retorno;
	}
	
	
	
	
	
	
	
	
}
