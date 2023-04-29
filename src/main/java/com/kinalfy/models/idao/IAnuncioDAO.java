package com.kinalfy.models.idao;

import com.kinalfy.models.domain.Anuncios;
import java.util.List;


public interface IAnuncioDAO {
     public List<Anuncios> getAll();
    
    public int add(Anuncios anuncio);

    
    public int update(Anuncios anuncio);

    
    public int delete(Anuncios anuncio);
}
