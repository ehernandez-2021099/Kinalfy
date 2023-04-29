package com.kinalfy.models.idao;

import com.kinalfy.models.domain.Genero;
import java.util.List;


public interface IGeneroDAO {
    
 public List<Genero> getAll();
    
    public int add(Genero genero);

    
    public int update(Genero genero);

    
    public int delete(Genero genero);
    
}
