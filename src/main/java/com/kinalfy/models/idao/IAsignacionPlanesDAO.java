package com.kinalfy.models.idao;

import com.kinalfy.models.domain.AsignacionesPlanes;
import java.util.List;


public interface IAsignacionPlanesDAO {
     public List<AsignacionesPlanes> getAll();
    
    public int add(AsignacionesPlanes asignacionP);

    
    public int update(AsignacionesPlanes asignacionP);

    
    public int delete(AsignacionesPlanes asignacionP);
}
