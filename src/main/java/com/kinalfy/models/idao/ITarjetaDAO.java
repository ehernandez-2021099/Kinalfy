package com.kinalfy.models.idao;

import com.kinalfy.models.domain.Tarjeta;
import java.util.List;


public interface ITarjetaDAO {
    //LISTAR TODOS LOS REGISTROS
    public List<Tarjeta> getAll();
    
    //INSERTAR UN REGISTRO
    public int add(Tarjeta tarjeta);
    
    //ACTUALIZAR UN REGISTRO
   public int update(Tarjeta tarjeta);
   
   //ELIMINAR UN REGISTRO
   public int delete(Tarjeta tarjeta);
}
