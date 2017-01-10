/**
 * 
 */
package org.luiz.condominio.view.page;

import org.luiz.condominio.view.form.FormCadUsuario;

/**
 * @author luizantonioalmeida
 *
 */
public class UsuarioPage extends BasePage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioPage(){
		super();
		FormCadUsuario formCadUsuario = new FormCadUsuario(getUsuario());
		add(formCadUsuario);
	}
}
