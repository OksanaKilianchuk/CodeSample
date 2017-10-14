package freeLancers.online.repository.impl;

import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Yurii on 20.01.2017.
 */
public class AbstractRepositoryImpl {

    @PersistenceContext(unitName = "gradeberryEntityManager")
    @Qualifier(value = "gradeberryEntityManager")
    private EntityManager em;

    EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
