package com.kinalfy.models.idao;

import com.kinalfy.models.domain.AsignacionAlbumArtista;
import java.util.List;


public interface IAsignacionAlbumArtistaDAO {
     public List<AsignacionAlbumArtista> getAll();
    
    public int add(AsignacionAlbumArtista asignacionAlbumArtista);

    
    public int update(AsignacionAlbumArtista asignacionAlbumArtista);

    
    public int delete(AsignacionAlbumArtista asignacionAlbumArtista);
}
