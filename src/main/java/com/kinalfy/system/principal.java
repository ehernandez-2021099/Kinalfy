package com.kinalfy.system;

import com.kinalfy.models.dao.AnuncioDaoImpl;
import com.kinalfy.models.dao.ArtistaDaoImpl;
import com.kinalfy.models.dao.AsignacionAnuncioDaoImpl;
import com.kinalfy.models.dao.AsignacionGeneroArtistaDaoImpl;
import com.kinalfy.models.dao.CancionDaoImpl;
import com.kinalfy.models.dao.InformacionArtistaDaoImpl;
import com.kinalfy.models.dao.ListaReproduccionDaoImpl;
import com.kinalfy.models.dao.PlanDaoImpl;

public class principal {
public static void main(String[] args){
   AsignacionGeneroArtistaDaoImpl est = new AsignacionGeneroArtistaDaoImpl();
        System.out.println(est.getAll());
        
        
    }
}
