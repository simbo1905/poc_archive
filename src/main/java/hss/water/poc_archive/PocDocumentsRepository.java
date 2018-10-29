package hss.water.poc_archive;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PocDocumentsRepository extends JpaRepository<PocDocuments, Long>{

}