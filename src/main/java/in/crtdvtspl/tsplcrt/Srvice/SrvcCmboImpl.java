package in.crtdvtspl.tsplcrt.Srvice;

import in.crtdvtspl.tsplcrt.model.Cmbo;
import in.crtdvtspl.tsplcrt.repository.CmboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;
import java.util.List;

@Service
public class SrvcCmboImpl implements  SrvcCmbo {
    private  final CmboRepository cmbRep;
    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    SrvcCmboImpl(CmboRepository cmbRepo){
        this.cmbRep = cmbRepo;
    }

    @Override
    public List<Cmbo> findCmboByTyprEquals(Integer typr, PageRequest pg){
        Query qr = new Query();
        qr.fields().include("_Id");
        qr.fields().include("txt");
        qr.addCriteria(Criteria.where("typr").is(1));
        qr.addCriteria(Criteria.where("del").is(0));
        qr.addCriteria(Criteria.where("cmp").is(1));
        List<Cmbo> cbl = cmbRep.findCmboByTyprEquals(typr, pg);

        return cbl;
    }
    public  List<Cmbo> findBy(Query qr){

        List<Cmbo> cbl = cmbRep.findBy(qr);
        return cbl;
    }

    public List<Cmbo> findByTyprEqualsAndTxtStartingWith(Integer typr, String fltr){
        List<Cmbo> cbl = cmbRep.findByTyprEqualsAndTxtStartingWith(typr, fltr);
        return  cbl;
    }

    public List<Cmbo> findByTyprEqualsAndTxtContains(Integer typr, String fltr){
        List<Cmbo> cbl = cmbRep.findByTyprEqualsAndTxtStartingWith(typr, fltr);
        return  cbl;
    }

    public List<Cmbo> findByTyprEqualsAndTxtIsContaining(Integer typr, String fltr){
        List<Cmbo> cbl = cmbRep.findByTyprEqualsAndTxtStartingWith(typr, fltr);

        return  cbl;
    }

}
