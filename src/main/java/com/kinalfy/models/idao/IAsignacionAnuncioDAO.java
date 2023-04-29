package com.kinalfy.models.idao;

import com.kinalfy.models.domain.AsignacionAnuncios;
import java.util.List;


public interface IAsignacionAnuncioDAO {
     public List<AsignacionAnuncios> getAll();
    
    public int add(AsignacionAnuncios asignacionAnuncio);

    
    public int update(AsignacionAnuncios asignacionAnuncio);

    
    public int delete(AsignacionAnuncios asignacionAnuncio);
}
