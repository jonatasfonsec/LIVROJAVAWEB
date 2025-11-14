package br.com.javaparaweb.financeiro.usuario;

import java.util.List;

import br.com.javaparaweb.financeiro.util.DAOFactory;

public class UsuarioRN {
	
	/*Para cada classe RN, alem do nome, eh exigido a existencia 
	 * de uma propriedade para cada DAO que for necessaria para a classe.
	 * E a instanciacao dessa propriedade utilizando DAOFactory no construtor da classe.
	 * Ou seja, a instancia usuarioDAO tera as configuracoes carregadas do banco
	 * para sua utilizacao
	*/
	private UsuarioDAO usuarioDAO;		
	public UsuarioRN() {
		this.usuarioDAO = DAOFactory.criarUsuarioDAO();
	}
	
	
	/* Metodo que serve para carregar uma unica instancia de um usuario
	 * com base em seu codigo. Ou seja, quando invocado, e atribuido um codigo
	 * de usuario, este ira carregar o respectivo usuario no banco.
	 * */
	public Usuario carregar(Integer codigo) {
		return this.usuarioDAO.carregar(codigo);
	}
	
	/* Metodo que faz o repasse para o mesmo metodo da classeDAO.
	 * Seu objetivo e carregar as informacoes do usuario logo apos o login.
	 * */
	public Usuario buscarPorLogin(String login) {
		return this.usuarioDAO.buscarPorLogin(login);
	}
	
	
	/* Este metodo redireciona para o metodoDAO salvar em caso de novos usuarios
	 * ou atualizar para usuarios existentes.
	 * */
	public void salvar(Usuario usuario) {
		Integer codigo = usuario.getCodigo();
		if (codigo == null || codigo == 0) {
			this.usuarioDAO.salvar(usuario);
		}else {
			this.usuarioDAO.atualizar(usuario);
		}
	}
	
	
	/* Esse metodo tambem redireciona para o metodoDAO excluir, futuramente
	 * sera implementado uma validacao para nao permitir a exclusao de usuarios
	 * administradores do sistema.
	 * */
	public void excluir(Usuario usuario) {
		this.usuarioDAO.excluir(usuario);
	}
	
	
	/*Metodo que fornecera uma lista com todos os usuarios do banco de dados.
	 * 
	 * */
	public List<Usuario> listar() {
		return this.usuarioDAO.listar();
	}
}
