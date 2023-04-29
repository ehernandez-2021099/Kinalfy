package com.kinalfy.models.idao;

import com.kinalfy.models.domain.ListaReproduccion;
import java.util.List;


public interface IListaReproduccionDAO {
     public List<ListaReproduccion> getAll();
    
    public int add(ListaReproduccion lista);

    
    public int update(ListaReproduccion lista);

    
    public int delete(ListaReproduccion lista);
}
