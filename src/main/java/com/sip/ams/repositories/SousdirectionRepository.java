package com.sip.ams.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sip.ams.entities.Sousdirection;




@Repository
public interface SousdirectionRepository extends CrudRepository <Sousdirection, Long> {
	

	/*  exemple 1 d'une requete avec parametre   */

	@Query ( "FROM Sousdirection s WHERE s.etat = ?1 and s.CodeSousdirection=?2" )
	List < Sousdirection > findSousDirectionByEtatAndCode1 ( int  etat, int code );



/*  exemple 2 d'une requete avec parametre   */
@Query(value = "SELECT * FROM Sousdirection s WHERE s.etat = :etat and s.CodeSousdirection = :code", 
nativeQuery = true)
List < Sousdirection >findSousDirectionByEtatAndCode(
@Param("etat") int etat, @Param("code") int code);



/*  exemple  d'une requete avec jointure   */

@Query("SELECT DISTINCT s FROM Sousdirection s INNER JOIN s.direction WHERE s.direction.libele = :libele ORDER BY s.id")
List<Sousdirection> findByLibeleDirection(@Param("libele") String libele);




@Query("SELECT count(*)  FROM Sousdirection s INNER JOIN s.direction WHERE s.direction.libele = :libele ORDER BY s.id")
int countByLibeleDirection(@Param("libele") String libele);


}





