package org.luiz.condominio.view.page;

import org.luiz.condominio.vo.Usuario;
import org.apache.wicket.markup.html.WebPage;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.hbm2ddl.SchemaExport.Action;
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
		
		geraTabelas();
		
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

	private void geraTabelas(){
	    //AnnotationConfiguration cfg = new AnnotationConfiguration(); //deprecated
	    Configuration cfg = new Configuration();
	    //Entidades do modelo sendo adicionadas na configuração
	    cfg.addAnnotatedClass(Usuario.class);
	        
	    SchemaExport schemaExport = new SchemaExport();
	    schemaExport.<b>create</b>(true, true);
	}
	
}
