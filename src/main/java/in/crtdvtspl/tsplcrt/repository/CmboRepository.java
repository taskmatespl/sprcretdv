package in.crtdvtspl.tsplcrt.repository;

import in.crtdvtspl.tsplcrt.model.Cmbo;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface CmboRepository extends MongoRepository<Cmbo, String> {
    List<Cmbo> findCmboByTyprEquals(Integer typr);
    List<Cmbo> findCmboByTyprEquals(Integer typr, PageRequest pg);
    @org.springframework.data.mongodb.repository.Query
    List<Cmbo> findAllBy(Query qr);
    @org.springframework.data.mongodb.repository.Query
    List<Cmbo> findBy(Query qr);

    List<Cmbo> findByTyprEqualsAndTxtStartingWith(Integer typr, String fltr);
    List<Cmbo> findByTyprEqualsAndTxtContains(Integer typr, String fltr);
    List<Cmbo> findByTyprEqualsAndTxtIsContaining(Integer typr, String fltr);
}
