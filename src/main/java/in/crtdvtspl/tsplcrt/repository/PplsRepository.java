package in.crtdvtspl.tsplcrt.repository;

import in.crtdvtspl.tsplcrt.model.Ppls;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PplsRepository extends MongoRepository<Ppls, String> {
    List<Ppls> findPplsByTyprEquals(Integer typr, Sort srt, PageRequest pg);
  //  List<Ppls> findPplsByNmaContainsAndTyprEquals(String nme, Integer typr);
   // List<Ppls> findPplsByMobContainsAndTyprEquals(String mob, Integer typr);
//    List<Ppls> findPplsByMobEqualsAndTyprEquals(String mob, Integer typr);



}
