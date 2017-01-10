/**
 * 
 */
package org.luiz.condominio.facade;

import org.luiz.condominio.dao.TipoConsumoDAO;
import org.luiz.condominio.facade.generic.GenericFacade;
import org.luiz.condominio.vo.TipoConsumo;

/**
 * @author luizantonioalmeida
 *
 */
public class TipoConsumoFacade extends GenericFacade<TipoConsumo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1592388971450585648L;
	private static TipoConsumoFacade service;
	private TipoConsumoDAO<TipoConsumo> dao; 

	public static TipoConsumoFacade getInstance() {
		if (service == null){
			service = new TipoConsumoFacade();
		}
		return service;
	}

	@Override
	protected TipoConsumoDAO<TipoConsumo> getDAO() {
		if (dao == null){
			dao = new TipoConsumoDAO<TipoConsumo>(getEm());
		}
		
		return dao;
	}
	
	public TipoConsumo findById(Long id) {
		TipoConsumo result = getDAO().findById(id);
		return result;
	}
}
