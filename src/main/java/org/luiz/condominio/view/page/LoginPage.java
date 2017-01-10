package org.luiz.condominio.view.page;

import org.luiz.condominio.vo.Usuario;
import org.apache.wicket.markup.html.WebPage;
import org.luiz.condominio.delegate.UsuarioDelegate;
import org.luiz.condominio.view.form.FormLogin;

/**
 * @author luizantonioalmeida
 *
 */
public class LoginPage extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginPage() {
		super();
	
	//colocado para logar automaticamente, retirar posteriormente
		FormLogin formLogin = new FormLogin(UsuarioDelegate.getInstance().findByLogin("luizdf.com@gmail.com"));
//		FormLogin formLogin = new FormLogin();
		add(formLogin);
	}

	public LoginPage(Usuario usuario) {
		super();
		FormLogin formLogin = new FormLogin(usuario);
		add(formLogin);
	}

}
