/**
 * 
 */
package org.luiz.condominio.facade;

import org.luiz.condominio.dao.TarifaDAO;
import org.luiz.condominio.facade.generic.GenericFacade;
import org.luiz.condominio.vo.Tarifa;

/**
 * @author luizantonioalmeida
 *
 */
public class TarifaFacade extends GenericFacade<Tarifa> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1592388971450585648L;
	private static TarifaFacade service;
	private TarifaDAO<Tarifa> dao; 

	public static TarifaFacade getInstance() {
		if (service == null){
			service = new TarifaFacade();
		}
		return service;
	}

	@Override
	protected TarifaDAO<Tarifa> getDAO() {
		if (dao == null){
			dao = new TarifaDAO<Tarifa>(getEm());
		}
		
		return dao;
	}
	
	public Tarifa findById(Long id) {
		Tarifa result = getDAO().findById(id);
		return result;
	}
}
