package com.findzero.ejb.repository;

import java.lang.reflect.Field;
import javax.annotation.PostConstruct;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 * Classe usada para injetar o <code>DAO</code> nos atributos dos EJBs.
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class InjectRepository {
  /**
   * Construtor.
   */
  public InjectRepository() {
  }

  /**
   * EntityManager será repassando ao <code>DAO</code>.
   */
  @PersistenceContext(unitName = "findzeropu",type=PersistenceContextType.EXTENDED)
  private EntityManager entityManager;

  /**
   * Este método é usado após o EJB ser criado, e dentro do EJB procura os <code>DAO</code>s que precisa instanciar.
   * @param invocationContext - Alvo que será adicionado o <code>DAO</code>.
   * @throws Exception - Exceção lançada caso ocorra algum problema quando
   * adicionar o <code>DAO</code>.
  */
  @PostConstruct
  public void postConstruct(final InvocationContext invocationContext) throws Exception {
    //Pega o alvo
    Object target = invocationContext.getTarget();
    //Pega a classe alvo.    
	Class classe = target.getClass();
    //Procura os atributos da classe.
    Field[] fields = classe.getDeclaredFields();
    //Verifica se algum dos campos da classe possui o DAOAnnotation.
    for (Field field : fields) {      
      if (field.isAnnotationPresent(RepositoryAnnotation.class)) {
        /* Quando encontrar algum atributo, com DAOAnnotation, gera uma instancia do DAO.*/    	
        this.injectRepository(field, target, this.entityManager);
      }
    }
  }

  /**
   * Método usado para gerar uma instancia do <code>DAO</code> e atribui-la ao atributo.
   *
   * @param field - Atributo que vai receber o <code>DAO</code>.
   * @param target - Classe alvo.
   * @param entityManager - <code>EntityManager</code> que será usado na instância do <code>DAO</code>.
   * @throws Exception - Exceção lançada caso ocorra algum problema quando adicionar o <code>DAO</code>.
   */
  private void injectRepository(final Field field, final Object target, final
    EntityManager entityManager) throws Exception {
    //Pega a classe do DAO que sera instanciado.
    Class clazz = field.getType();
    //Gera uma instancia do DAO.
    RepositoryBase dao = RepositoryFactory.instanciarDAO(entityManager, clazz);    
    //Verifica se o atributo esta acessível.
    boolean acessivel = field.isAccessible();
    //Se o atributo nao e acessível, deixa ele como acessível.
    if (!acessivel) {
      field.setAccessible(true);
    }
    //Seta o DAO no atributo.
    field.set(target, dao);
    //Se o atributo nao e acessivel, volta ao valor original.
    if (!acessivel) {
      field.setAccessible(acessivel);
    }
  }
}