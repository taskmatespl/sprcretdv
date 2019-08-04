package in.crtdvtspl.tsplcrt.Controller;

import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import in.crtdvtspl.tsplcrt.Srvice.SrvcCmbo;
import in.crtdvtspl.tsplcrt.model.Cmbo;
import io.micrometer.core.instrument.Tags;
import jdk.nashorn.internal.runtime.regexp.RegExp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static java.lang.String.join;

@RestController
@RequestMapping("/cmb")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ComboController {

    private final SrvcCmbo srvCmbo;
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    ComboController(SrvcCmbo srvCmbo) {
        this.srvCmbo = srvCmbo;
    }

    @RequestMapping(value = "/gtcmb/{typr}", method = RequestMethod.GET)
    ResponseEntity<List<Cmbo>> getcmbtypr(@PathVariable("typr") String typr) {
        //@PathVariable("typr") String typr

        if (typr == null) {
            return ResponseEntity.ok(null);
        } else if (typr.length() == 0) {
            return ResponseEntity.ok(null);
        }
        String[] dts = typr.split(("\\~"));
        Integer ty = Integer.parseInt(dts[0]);
        Integer strt = 0;
        Integer endt = 0;

        if (dts.length > 2) {
            strt = Integer.parseInt(dts[1]);
            endt = Integer.parseInt(dts[2]);
        } else if (dts.length == 2) {
            strt = Integer.parseInt(dts[1]);
            endt = 30;
        }

        PageRequest pg = new PageRequest(strt, endt, new Sort(Sort.Direction.DESC, "txt"));
        List<Cmbo> Usr = srvCmbo.findCmboByTyprEquals(ty, pg);
        return ResponseEntity.ok(Usr);
        //usrv.save(new Usrs("Sanjay", "Gupta"));


    }

    @RequestMapping(value = "/gtcmbf/{typrf}", method = RequestMethod.GET)
    ResponseEntity<List<Cmbo>> getcmbFld(@PathVariable("typrf") String typrF) {
        if (typrF == null || typrF.length() == 0) {
            return ResponseEntity.ok((null));
        }
        String[] dts = typrF.split(("\\~"));
        Integer ty = Integer.parseInt(dts[0]);
        String fltr = "";
        if (dts.length > 1) {
            fltr = dts[1];
        } else {
            return ResponseEntity.ok((null));
        }

        List<Cmbo> Usr = srvCmbo.findByTyprEqualsAndTxtContains(ty,fltr);

        //List<Cmbo> Usr = srvCmbo.findByTyprEqualsAndTxtStartingWith(ty, fl);
        return ResponseEntity.ok(Usr);


    }

    @RequestMapping(value = "/gtcmbfs/{typrf}", method = RequestMethod.GET)
    ResponseEntity<List<Cmbo>> getcmbFldCnts(@PathVariable("typrf") String typrF) {
        if (typrF == null || typrF.length() == 0) {
            return ResponseEntity.ok((null));
        }
        String[] dts = typrF.split(("\\~"));
        Integer ty = Integer.parseInt(dts[0]);
        String fltr = "";
        if (dts.length > 1) {
            fltr = dts[1];
        } else {
            return ResponseEntity.ok((null));
        }
        /*
        BasicQuery br = new BasicQuery("{ usr : 'Sanjay',  psw : 'A'}");
        br.fields().exclude("id");
        mongoTemplate.find(br, Cmbo.class).size();
        */

        Query qr = new Query(Criteria.where("txt").regex(fltr));

        List<Cmbo> cm;
       cm= mongoTemplate.find(qr, Cmbo.class);

        List<Cmbo> Usr = srvCmbo.findByTyprEqualsAndTxtContains(ty,fltr);
        return ResponseEntity.ok(Usr);


    }
}
