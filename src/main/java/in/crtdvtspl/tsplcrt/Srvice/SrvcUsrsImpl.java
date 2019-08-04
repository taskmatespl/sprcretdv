package in.crtdvtspl.tsplcrt.Srvice;

import com.mongodb.ClientSessionOptions;
import com.mongodb.MongoClient;
import com.mongodb.async.client.MongoClientSettings;
import com.mongodb.reactivestreams.client.*;
import in.crtdvtspl.tsplcrt.model.Usrs;
import in.crtdvtspl.tsplcrt.repository.UsrsRepository;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.query.MongoQueryMethod;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SrvcUsrsImpl implements SrvcUsrs {
    private  final UsrsRepository usRep;

    @Autowired
    SrvcUsrsImpl(UsrsRepository usRep){
        this.usRep = usRep;

    }

    @Override
    public List<Usrs> findAll() {
        List<Usrs> todoEntries = usRep.findAll();
        return todoEntries;
    }
    @Override
    public List<Usrs>  findAllByUsrEquals(String ss){
        List<Usrs> todoEntries = usRep.findAllByUsrEquals(ss);
        return todoEntries;
    }

    public String SaveUsr(Usrs usr){
        usRep.save(usr);
        return usr.getId();

    }

}
