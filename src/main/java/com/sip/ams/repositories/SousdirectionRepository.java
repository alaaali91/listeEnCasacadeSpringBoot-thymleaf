package com.sip.ams.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sip.ams.entities.Sousdirection;




@Repository
public interface SousdirectionRepository extends CrudRepository <Sousdirection, Long> {
	








@Query(value = "SELECT * FROM Sousdirection s WHERE s.etat = :etat and s.CodeSousdirection = :code", 
nativeQuery = true)
List < Sousdirection >findSousDirectionByEtatAndCode(
@Param("etat") int etat, @Param("code") int code);

}
