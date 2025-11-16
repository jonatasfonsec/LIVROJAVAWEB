package br.com.javaparaweb.financeiro.web;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.javaparaweb.financeiro.usuario.Usuario;
import br.com.javaparaweb.financeiro.usuario.UsuarioRN;

@ManagedBean(name = "usuarioBean")
@RequestScoped
public class UsuarioBean {
	private Usuario usuario = new Usuario();
	private String confirmarSenha;

	/**Metodo que cria uma nova instancia de usuaria e define como ativo.
	 * @return /publico/usuario - Retorna a pagina usuario.xhtml da pasta publico.
	 * */
	public String novo() {
		this.usuario = new Usuario();
		this.usuario.setAtivo(true);
		return "/publico/usuario";
	}

	
	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();

		String senha = this.usuario.getSenha();
		if (!senha.equals(this.confirmarSenha)) {
			FacesMessage facesMessage = new FacesMessage("A senha nao foi confirmada corretamente");
			context.addMessage(null, facesMessage);
			return null;
		}
		/*No caso da senha estiver correta, o usuario sera salvo no BD
		 * e a tela de usuario sucesso sera exibida.
		 * */
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(this.usuario);
		return "usuariosucesso";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}
}
