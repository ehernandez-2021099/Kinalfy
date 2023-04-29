package com.kinalfy.models.idao;

import com.kinalfy.models.domain.Cancion;
import java.util.List;


public interface ICancionDAO {
    
    
    public List<Cancion> getAll();
    
    public int add(Cancion cancion);

    
    public int update(Cancion cancion);

    
    public int delete(Cancion cancion);
    
    
}
