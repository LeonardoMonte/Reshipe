package algoritmosIA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import beans.ReceitasNormalizadas;
import dados.Reporeceitas;

public class KNN {

	private ArrayList<String> comparador;
	private ArrayList<ReceitasNormalizadas> receitasNorm;
	
	public KNN()
	{
		
		this.comparador = this.construtor();
		this.receitasNorm = this.construtorReceitasNorm();
	}
	
	public ArrayList<String> listarIngredientesCadastrados()
	{
		return this.comparador;
	}
	
	public ArrayList<ReceitasNormalizadas> listarReceitasNormalizadas()
	{
		return this.receitasNorm;
	}
	
	public ArrayList<ReceitasNormalizadas> construtorReceitasNorm()
	{
		ArrayList<ReceitasNormalizadas> rec = this.geradorReceitarNorm();
		
		for(int x = 0 ; x < Reporeceitas.getInstancia().listarReceitas().size() ; x++)
		{
			for(int y = 0 ; y < Reporeceitas.getInstancia().listarReceitas().get(x).listarIngredientes().size() ; y++ )
			{
				
				int local = this.listarIngredientesCadastrados().indexOf(Reporeceitas.getInstancia()
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
