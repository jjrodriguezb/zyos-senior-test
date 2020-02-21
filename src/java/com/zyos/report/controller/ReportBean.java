/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zyos.report.controller;

import com.zyos.report.model.Actor;
import com.zyos.report.model.HibernateUtil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Pruebas
 */
@Named(value = "reportBean")
@SessionScoped
public class ReportBean implements Serializable {

    private List<Actor> actorList;
    /**
     * Creates a new instance of ReportBean
     */
    public ReportBean() {
        init();
    }
    
    private void init(){
        Session ses = HibernateUtil.getSessionFactory().openSession();
        setActorList((List<Actor>) ses.createQuery("From Actor").list());
    }

    /**
     * @return the actorList
     */
    public List<Actor> getActorList() {
        return actorList;
    }

    /**
     * @param actorList the actorList to set
     */
    public void setActorList(List<Actor> actorList) {
        this.actorList = actorList;
    }
    
    
}
