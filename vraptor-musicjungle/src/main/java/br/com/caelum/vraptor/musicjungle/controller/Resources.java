package br.com.caelum.vraptor.musicjungle.controller;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
 
/**
 * Classe responsável por disponibilizar no CDI componentes do EJB.
 * 
 * @author Otávio Scherer Garcia
 */
@Dependent
public class Resources {
 
	/**
	 * Disponibiliza um {@link SessionContext}.
	 */
	@Produces
	@Resource(mappedName = "java:comp/EJBContext")
	protected SessionContext sessionContext;
 
	/**
	 * Disponibiliza um {@link EntityManager}.
	 */
	@Produces
	@PersistenceContext
	protected EntityManager em;
}