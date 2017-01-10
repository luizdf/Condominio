/**
 * 
 */
package org.luiz.condominio.facade;

import org.luiz.condominio.dao.EstadoDAO;
import org.luiz.condominio.facade.generic.GenericFacade;
import org.luiz.condominio.vo.Estado;

/**
 * @author luizantonioalmeida
 *
 */
public class EstadoFacade extends GenericFacade<Estado> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1592388971450585648L;
	private static EstadoFacade service;
	private EstadoDAO<Estado> dao; 

	public static EstadoFacade getInstance() {
		if (service == null){
			service = new EstadoFacade();
		}
		return service;
	}

	@Override
	protected EstadoDAO<Estado> getDAO() {
		if (dao == null){
			dao = new EstadoDAO<Estado>(getEm());
		}
		
		return dao;
	}
	
	public Estado findById(Long id) {
		Estado result = getDAO().findById(id);
		return result;
	}

	public Estado findBySigla(String sigla) {
		Estado result = getDAO().findBySigla(sigla);
		return result;
	}
}
