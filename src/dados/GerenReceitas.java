package dados;

import java.util.ArrayList;

import beans.Receita;
import exceptions.Objectnotfound;
import exceptions.Objetojaexiste;

public class GerenReceitas {

	private static GerenReceitas instancia;

	private Reporeceitas repositorio;



	private GerenReceitas() {

		this.repositorio = Reporeceitas.getInstancia();

	}



	public static GerenReceitas getInstancia(){

		

		if(instancia == null){

			instancia = new GerenReceitas();

		}

		return instancia;

	}
	
	
	public void cadastrarReceita(Receita r) throws Objetojaexiste
	{
		this.repositorio.cadastrarReceita(r);
		this.repositorio.save();
	}
	
	public void removerReceita(String nome) throws Objectnotfound
	{
		this.repositorio.removerReceita(nome);
		this.repositorio.save();
	}
	
	public ArrayList<Receita> listar()
	{
		return this.repositorio.listarReceitas();
	}
}
