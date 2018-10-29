package hss.water.poc_archive;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PocDocumentsRepository extends JpaRepository<PocDocument, Long> {


    @Query("select d from PocDocument d where d.lastName = :lastName and d.taxId = :taxId")
    List<PocDocument> findBylastNameAndTaxId(@Param("lastName") String lastName, @Param("taxId") String taxId);
}