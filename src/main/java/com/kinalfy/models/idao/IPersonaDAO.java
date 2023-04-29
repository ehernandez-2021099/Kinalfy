package com.kinalfy.models.idao;

import com.kinalfy.models.domain.Persona;
import java.util.List;


public interface IPersonaDAO {
     public List<Persona> getAll();
    
    public int add(Persona persona);

    
    public int update(Persona persona);

    
    public int delete(Persona persona);
}
