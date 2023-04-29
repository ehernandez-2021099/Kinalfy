package com.kinalfy.models.idao;

import com.kinalfy.models.domain.Artista;
import java.util.List;


public interface IArtistaDAO {
 
    public List<Artista> getAll();
    
    public int add(Artista artista);

    
    public int update(Artista artista);

    
    public int delete(Artista artista);
}
