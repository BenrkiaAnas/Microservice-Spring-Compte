package org.sid.compteservice.entities;

import org.sid.compteservice.enums.TypeCompte;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p2", types = Compte.class)
public interface CompteProj2 {
    public double getSolde();
    public TypeCompte getType();

}
