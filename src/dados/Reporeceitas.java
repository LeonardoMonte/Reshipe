package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

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
	
	
	private static Reporeceitas load(){
		Reporeceitas repReceitas =  null;

		File arquivoReceita = new File("RepoReceitas.dat");

		FileInputStream fInput = null;
		ObjectInputStream oInput = null;

		try{
			fInput = new FileInputStream(arquivoReceita);
			oInput = new ObjectInputStream(fInput);
			
			Object o = oInput.readObject();

			repReceitas = (Reporeceitas) o;

		}catch(Exception e){
			repReceitas = new Reporeceitas();
		}finally{
			if (oInput != null){
				try{
					oInput.close();
				}catch(IOException e){
					System.out.println("Não foi possível fechar o arquivo!");
					e.printStackTrace();
				}
			}
		}

		return repReceitas;
	}


	public void save(){
		if(instancia == null){
			return;
		}

		File arquivoReceitas = new File("RepoReceitas.dat");
		FileOutputStream fOutput =  null;
		ObjectOutputStream oOutput = null;

		try{
			if(!arquivoReceitas.exists())
				arquivoReceitas.createNewFile();

			fOutput = new FileOutputStream(arquivoReceitas);
			oOutput = new ObjectOutputStream(fOutput);
			oOutput.writeObject(instancia);

		}catch(Exception e){
			e.printStackTrace();

		}finally{
			if(oOutput != null){
				try{

					oOutput.close();

				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
	
	
}
