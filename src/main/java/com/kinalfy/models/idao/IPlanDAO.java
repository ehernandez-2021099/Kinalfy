package com.kinalfy.models.idao;

import com.kinalfy.models.domain.Planes;
import java.util.List;


public interface IPlanDAO {
     public List<Planes> getAll();
    
    public int add(Planes planes);

    
    public int update(Planes planes);

    
    public int delete(Planes planes);
}
