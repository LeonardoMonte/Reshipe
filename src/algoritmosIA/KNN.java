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
			if(local != -1)
			{
				retorno.set(local, 1);
			}
			
		}
		
		return retorno;
	}
	
	public void distanciaEuclidiana( ArrayList<Integer> ReceitaRecebida , ArrayList<Receita> distancia)
	{
		 double dist = 0;
	 	 
		 for(int x = 0 ; x < this.receitasNorm.size() ; x++)
		 {	  
			 dist = 0;
			 for(int y = 0 ; y < this.comparador.size() ; y++)
			 {			 
				double local = this.receitasNorm.get(x).getIngredientes().get(y) - ReceitaRecebida.get(y);
				dist += Math.pow(local, 2);
				local = 0;
			 }
			 
			 dist = Math.sqrt(dist);
			 distancia.get(x).setDistancia(dist);		
			 dist = 0;
		 }
	}
	
	
	public void knnOut(ArrayList<String> array , int k)
	{
		ArrayList<Receita> r = this.knn(array, k);
		
		
		System.out.println("Receitas possiveis:");
		for(int x = 0 ; x < k ; x++)
		{
			System.out.println("--- " + r.get(x).getNome());
			System.out.println(r.get(x).listarIngredientes());
			System.out.println();
		}
		
	}
	
	public void DistanciaMatch(ArrayList<Receita> distancia , ArrayList<Integer> ReceitaRecebida )
	{
		int match = 0;
		
		for(int x = 0 ; x < this.receitasNorm.size();  x++)
		{
			match = 0;
			for(int y = 0; y < this.comparador.size() ; y++)
			{
				if(this.receitasNorm.get(x).getIngredientes().get(y) == 1 && ReceitaRecebida.get(y) == 1)
				{
					match++;
				}
			}
			
			System.out.println(match);
			
			distancia.get(x).setDistancia(match);
		}
		
	}
	
	public void DistanciaPearson(ArrayList<Receita> distancia , ArrayList<Integer> ReceitaRecebida)
	{
		ArrayList<Double> xmedio;
		double ymedio;
		for(int i = 0; i < this.receitasNorm.size(); i++)
		{
			
		
			
		}
	}
	
	public void DistanciaHamming(ArrayList<Receita> distancia , ArrayList<Integer> ReceitaRecebida)
	{
		
		int xor = 0;
		
		for(int x = 0 ; x < this.receitasNorm.size();  x++)
		{
			xor = 0;
			for(int y = 0; y < this.comparador.size() ; y++)
			{
				if(this.receitasNorm.get(x).getIngredientes().get(y) != ReceitaRecebida.get(y))
				{
					xor++;
				}
			}
			
			System.out.println(xor);
			
			distancia.get(x).setDistancia(xor);
		}
	}
	
	public void MaiorDistancia(ArrayList<Receita> rec , int k, ArrayList<Receita> distancias)
	{
		int menor = 0;
		
		 for(int x = 0 ; x < k ; x++)
		 {
			 menor = 0;
			 
			 for(int y = 0 ; y < distancias.size(); y++)
			 {			 
				 if(distancias.get(menor).getDistancia() <= distancias.get(y).getDistancia())
				 {
					 menor = y;
				 }

			 }
			 
			rec.add(distancias.get(menor));	
			distancias.remove(menor);
			 
		 }
	}
	
	public void MenorDistancia(ArrayList<Receita> rec , int k, ArrayList<Receita> distancias)
	{
		int menor = 0;
		
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
			 
			rec.add(distancias.get(menor));	
			distancias.remove(menor);
			 
		 }
	}
	
	
	 public ArrayList<Receita> knn(ArrayList<String> array, int k)
	 {
		 ArrayList<Receita> rec = new ArrayList<>();
		 ArrayList<Integer> receitaRecebida = this.normalizerReceitaRecebida(array);
		 ArrayList<Receita> distancias = Reporeceitas.getInstancia().listarReceitas();
		 
		this.DistanciaMatch(distancias , receitaRecebida);
		 
		this.MaiorDistancia(rec, k, distancias);
		 
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
