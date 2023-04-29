package com.kinalfy.models.idao;

import com.kinalfy.models.domain.InformacionArtista;
import java.util.List;


public interface IInformacionArtistaDAO {
     public List<InformacionArtista> getAll();
    
    public int add(InformacionArtista informacion);

    
    public int update(InformacionArtista informacion);

    
    public int delete(InformacionArtista informacion);
}
