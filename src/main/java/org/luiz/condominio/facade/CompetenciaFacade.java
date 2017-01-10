/**
 * 
 */
package org.luiz.condominio.facade;

import org.luiz.condominio.dao.CompetenciaDAO;
import org.luiz.condominio.facade.generic.GenericFacade;
import org.luiz.condominio.vo.Competencia;

/**
 * @author luizantonioalmeida
 *
 */
public class CompetenciaFacade extends GenericFacade<Competencia> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1592388971450585648L;
	private static CompetenciaFacade service;
	private CompetenciaDAO<Competencia> dao; 

	public static CompetenciaFacade getInstance() {
		if (service == null){
			service = new CompetenciaFacade();
		}
		return service;
	}

	@Override
	protected CompetenciaDAO<Competencia> getDAO() {
		if (dao == null){
			dao = new CompetenciaDAO<Competencia>(getEm());
		}
		
		return dao;
	}
	
	public Competencia findById(Long id) {
		Competencia result = getDAO().findById(id);
		return result;
	}
}
