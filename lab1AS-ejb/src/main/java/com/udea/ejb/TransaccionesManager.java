/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.ejb;

import com.udea.entity.Transacciones;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jhona
 */
@Stateless
public class TransaccionesManager implements TransaccionesManagerLocal {

    @PersistenceContext(unitName = "com.udea_lab1AS-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    public List<Transacciones> getAllTransactions() {
        Query query = em.createNamedQuery("Transacciones.findAll");
        return query.getResultList();
    }

    @Override
    public Transacciones update(Transacciones transaccion) {
        return em.merge(transaccion); 
    }
    
    

    
}
