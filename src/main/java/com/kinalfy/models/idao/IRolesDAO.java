package com.kinalfy.models.idao;

import com.kinalfy.models.domain.Roles;
import java.util.List;


public interface IRolesDAO {
     public List<Roles> getAll();
    
    public int add(Roles rol);

    
    public int update(Roles rol);

    
    public int delete(Roles rol);
}
