package com.kinalfy.models.idao;
import com.kinalfy.models.domain.Album;
import java.util.List;

public interface IAlbumDAO {

        
    public List<Album> getAll();
    
    public int add(Album album);

    
    public int update(Album album);

    
    public int delete(Album album);
    
    
}
