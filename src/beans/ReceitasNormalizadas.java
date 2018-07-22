package beans;

import java.util.ArrayList;

public class ReceitasNormalizadas {
	
	private String nome;
	private ArrayList<Integer> ingredientes;
	
	
	@Override
	public String toString() {
		return "ReceitasNormalizadas [nome=" + nome + ", ingredientes=" + ingredientes + "]  \n";
	}

	public ReceitasNormalizadas()
	{
		this.ingredientes = new ArrayList<>();
	}
	
	public ReceitasNormalizadas(String nome)
	{
		this.nome = nome;
		this.ingredientes = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Integer> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(ArrayList<Integer> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	public void addIngre(int ing)
	{
		this.ingredientes.add(ing);
		
	}
	
	public void removeIngre(int ing) 
	{
			this.removeIngre(ing);
	
	}
}
