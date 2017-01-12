/**
 * 
 */
package org.luiz.condominio.view.app;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.luiz.condominio.view.page.LoginPage;

/**
 * @author luizantonioalmeida
 *
 */
public class Default extends WebApplication {

	public static void main(String[] args){

	}

	/* (non-Javadoc)
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends Page> getHomePage() {
		//Implementação WEB
		return LoginPage.class;
	}

}
