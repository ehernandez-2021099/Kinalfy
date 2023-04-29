package com.kinalfy.models.idao;

import com.kinalfy.models.domain.Usuario;
import java.util.List;

public interface IUsuariosDAO {
     public List<Usuario> getAll();
    
    public int add(Usuario usuario);

    
    public int update(Usuario usuario);

    
    public int delete(Usuario usuario);
}
