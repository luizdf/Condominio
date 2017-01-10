/**
 * 
 */
package org.luiz.condominio.facade;

import org.luiz.condominio.dao.EmpreendimentoDAO;
import org.luiz.condominio.facade.generic.GenericFacade;
import org.luiz.condominio.vo.Empreendimento;

/**
 * @author luizantonioalmeida
 *
 */
public class EmpreendimentoFacade extends GenericFacade<Empreendimento> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1592388971450585648L;
	private static EmpreendimentoFacade service;
	private EmpreendimentoDAO<Empreendimento> dao; 

	public static EmpreendimentoFacade getInstance() {
		if (service == null){
			service = new EmpreendimentoFacade();
		}
		return service;
	}

	@Override
	protected EmpreendimentoDAO<Empreendimento> getDAO() {
		if (dao == null){
			dao = new EmpreendimentoDAO<Empreendimento>(getEm());
		}
		
		return dao;
	}
	
	public Empreendimento findById(Long id) {
		Empreendimento result = getDAO().findById(id);
		return result;
	}
}
