package in.crtdvtspl.tsplcrt;

import com.mongodb.Mongo;
import in.crtdvtspl.tsplcrt.model.Usrs;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import javax.validation.constraints.NotNull;

public class cmn {
    @NotNull
    Usrs createUsr(String  dta ){
        MongoTemplate mgt;
        Query qt = new Query(Criteria.where("usrs").is("sanjay"));


        String[] s = dta.split("\\~");
        Usrs ur = new Usrs(s[0], s[1]);
        return ur;
    }

}
