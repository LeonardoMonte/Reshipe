package beans;

import java.io.Serializable;
import java.util.ArrayList;

import dados.Reporeceitas;


public class Receita implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7923885572428766212L;
	private String nome;
	private ArrayList<String> ingredientes;
	
	
	public Receita (String nome)
	{
		this.nome = nome;
		this.ingredientes = new ArrayList<>();
	}
	
	public String getNome()
	{
		return this.nome;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public void addIngre(String ing)
	{
		this.ingredientes.add(ing);
		
	}
	
	public void removeIngre(String ing) 
	{
			this.removeIngre(ing);
	
	}
	
	public ArrayList<String> listar()
	{
		return this.ingredientes;
	}

	@Override
	public String toString() {
		return "Receita [nome=" + nome + ", ingredientes=" + ingredientes + "]\n\n";
	}
	
	
	
	
	
	
	
	 
	
}
