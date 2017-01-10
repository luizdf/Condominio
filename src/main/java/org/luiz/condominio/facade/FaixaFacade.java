/**
 * 
 */
package org.luiz.condominio.facade;

import org.luiz.condominio.dao.FaixaDAO;
import org.luiz.condominio.facade.generic.GenericFacade;
import org.luiz.condominio.vo.Faixa;

/**
 * @author luizantonioalmeida
 *
 */
public class FaixaFacade extends GenericFacade<Faixa> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1592388971450585648L;
	private static FaixaFacade service;
	private FaixaDAO<Faixa> dao; 

	public static FaixaFacade getInstance() {
		if (service == null){
			service = new FaixaFacade();
		}
		return service;
	}

	@Override
	protected FaixaDAO<Faixa> getDAO() {
		if (dao == null){
			dao = new FaixaDAO<Faixa>(getEm());
		}
		
		return dao;
	}
	
	public Faixa findById(Long id) {
		Faixa result = getDAO().findById(id);
		return result;
	}
}
