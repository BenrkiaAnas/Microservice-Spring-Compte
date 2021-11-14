package org.sid.compteservice.service;

public interface CompteService{
    public void virement(Long codeSource,Long codeDestination, double montant);

}
