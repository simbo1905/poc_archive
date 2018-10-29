package hss.water.poc_archive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PocDocumentResource {
    @Autowired
    private PocDocumentsRepository pocDocumentsRepository;

    @GetMapping("/documents")
    public List<PocDocument> allDocuments() {
        return pocDocumentsRepository.findAll();
    }

    @GetMapping("/document/{id}")
    public PocDocument retrieveDocument(@PathVariable long id) {
        Optional<PocDocument> student = pocDocumentsRepository.findById(id);

        if (!student.isPresent())
            throw new PocDocumentsNotFoundException("id-" + id);

        return student.get();
    }

    @GetMapping("/search")
    public List<PocDocument> findDocumentByLastnameAndTaxId(@RequestParam("lastName") String lastName,
                                                      @RequestParam("taxId") String taxId) {
        return pocDocumentsRepository.findBylastNameAndTaxId(lastName, taxId);
    }
}
