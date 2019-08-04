package in.crtdvtspl.tsplcrt.repository;

import in.crtdvtspl.tsplcrt.model.Usrs;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UsrsRepository extends MongoRepository<Usrs, String> {
    List<Usrs> findAll();
    List<Usrs> findAllByUsrEquals(String ss);


}
