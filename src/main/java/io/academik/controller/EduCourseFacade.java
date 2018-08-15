/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.academik.controller;

import io.academik.model.EduCourse;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author david
 */
@Stateless
public class EduCourseFacade extends AbstractFacade<EduCourse> {

    @PersistenceContext(unitName = "registrator_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EduCourseFacade() {
        super(EduCourse.class);
    }
    
}
