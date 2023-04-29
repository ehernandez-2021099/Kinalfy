package com.kinalfy.models.idao;

import com.kinalfy.models.domain.Artista;
import com.kinalfy.models.domain.AsignacionGeneroArtista;
import java.util.List;

public interface IAsignacionGeneroArtistaDAO {
     public List<AsignacionGeneroArtista> getAll();
    
    public int add(AsignacionGeneroArtista aga);

    
    public int update(AsignacionGeneroArtista aga);

    
    public int delete(AsignacionGeneroArtista aga);
}
