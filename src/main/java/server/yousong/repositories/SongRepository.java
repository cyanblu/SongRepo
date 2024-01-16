package server.yousong.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import server.yousong.models.Song;

@CrossOrigin
@RepositoryRestResource() //wenn das leergelassen wird, ist die route automatisch das Plural vom wort! (vom Model Song.java selbst?) Bsp: http://localhost:8080/api/songs
public interface SongRepository extends PagingAndSortingRepository<Song, Long> {

}
