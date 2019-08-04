package in.crtdvtspl.tsplcrt.Controller;

import com.sun.scenario.effect.impl.sw.java.JSWPhongLighting_DISTANTPeer;
import in.crtdvtspl.tsplcrt.Srvice.SrvcPpls;
import in.crtdvtspl.tsplcrt.model.Ppls;
import in.crtdvtspl.tsplcrt.model.Usrs;
import in.crtdvtspl.tsplcrt.model.pplAddr;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ppls")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PplsController {
    private final SrvcPpls srvP;
    @Autowired
    MongoTemplate mngTmpl;

    @Autowired
    PplsController(SrvcPpls srvP) {
        this.srvP = srvP;
    }

    @RequestMapping(value = "/lst/{dts}", method = RequestMethod.GET)
    ResponseEntity<List<Ppls>> getPplsList(@PathVariable("dts") String dtls) {
        if (dtls == null) {
            return ResponseEntity.ok(null);
        } else if (dtls.length() == 0) {
            return ResponseEntity.ok(null);
        }
        String[] dts = dtls.split("~");
        Integer typ = 0;
        Sort srt = new Sort(Sort.Direction.ASC);
        PageRequest pg = new PageRequest(0, 50);
        if (dts.length == 3) {
            typ = Integer.parseInt(dts[0]);
            if (dts[1] == "a") {
                srt = new Sort(Sort.Direction.ASC);
            } else {
                srt = new Sort(Sort.Direction.DESC);
            }
            Integer cnt = Integer.parseInt(dts[2]);
            if (cnt == 0) {
                pg = new PageRequest(0, 50);
            } else {
                pg = new PageRequest(cnt, 50);
            }
        }
        List<Ppls> ppl = srvP.findPplsByTyprEquals(typ, srt, pg);
        return ResponseEntity.ok(ppl);
    }

    @RequestMapping(value = "/sv/{dts}", method = RequestMethod.GET)
    ResponseEntity<Ppls> svPPls(@PathVariable("dts") String dts) {
        if (dts == null) {
            return ResponseEntity.ok(null);
        } else if (dts.length() == 0) {
            return ResponseEntity.ok(null);
        }


        dts =dts.replace("^", ".");

        String[] ee = dts.split("zx");
        if (ee.length == 2) {
            String[] mn = ee[0].split("qx");
            String id = mn[0];
            Boolean oldRec = false;
            if (id.length() > 0) {
                oldRec = true;
            }
            List<pplAddr> lpAdr = new ArrayList<>();
            pplAddr pAdr = new pplAddr("", "", "", "", "", "", "", "", "", 0, 0, 0, 0);
            if (ee[1].length() > 0) {
                String[] echA = ee[1].split("ZX");
                if (echA.length == 1) {
                    String[] ze = echA[0].split("qx");
                    if (ze.length>1 && ze[0].length() > 0) {
                        pAdr.setAddrtypid(ze[0]);
                        pAdr.setAddrtyp(ze[1]);
                    }
                    if (ze.length>2 && ze[2].length() > 0) {
                        pAdr.setAddra(ze[2]);
                    }

                    if (ze.length>4 && ze[3].length() > 0) {
                        pAdr.setAddrb(ze[3]);
                    }

                    if (ze.length>5 && ze[4].length() > 0) {
                        pAdr.setAddrc(ze[4]);
                    }

                    if (ze.length>6 &&ze[5].length() > 0) {
                        pAdr.setCtyid(ze[5]);
                        pAdr.setCty(ze[6]);
                    }

                    if (ze.length>7 && ze[7].length() > 0) {
                        pAdr.setPnc(ze[7]);
                    }

                    if (ze.length>8 && ze[8].length() > 0) {
                        pAdr.setPhn(ze[8]);
                    }
                    if ((ze.length>9 && ze[9].length() > 0 && Integer.parseInt(ze[9]) > 0)) {
                        pAdr.setTmopn(Integer.parseInt(ze[9]));
                    }

                    if ((ze.length>10 && ze[10].length() > 0 && Integer.parseInt(ze[10]) > 0)) {
                        pAdr.setTmcls(Integer.parseInt(ze[10]));
                    }

                    if ((ze.length>11 && ze[11].length() > 0 && Double.parseDouble(ze[11]) > 0)) {
                        pAdr.setLngtd(Double.parseDouble(ze[11]));
                    }
                    if ((ze.length>12 && ze[12].length() > 0 && Double.parseDouble(ze[12]) > 0)) {
                        pAdr.setLngtd(Double.parseDouble(ze[12]));
                    }
                    lpAdr.add(pAdr);
                } else {
                    Integer i = 0;
                    while (i < echA.length) {
                        pAdr = new pplAddr("", "", "", "", "", "", "", "", "", 0, 0, 0, 0);
                        String[] ze = echA[i].split("qx");
                        if (ze.length>1 && ze[0].length() > 0) {
                            pAdr.setAddrtypid(ze[0]);
                            pAdr.setAddrtyp(ze[1]);
                        }
                        if (ze.length>2 && ze[2].length() > 0) {
                            pAdr.setAddra(ze[2]);
                        }

                        if (ze.length>4 && ze[3].length() > 0) {
                            pAdr.setAddrb(ze[3]);
                        }

                        if (ze.length>5 && ze[4].length() > 0) {
                            pAdr.setAddrc(ze[4]);
                        }

                        if (ze.length>6 &&ze[5].length() > 0) {
                            pAdr.setCtyid(ze[5]);
                            pAdr.setCty(ze[6]);
                        }

                        if (ze.length>7 && ze[7].length() > 0) {
                            pAdr.setPnc(ze[7]);
                        }

                        if (ze.length>8 && ze[8].length() > 0) {
                            pAdr.setPhn(ze[8]);
                        }
                        if ((ze.length>9 && ze[9].length() > 0 && Integer.parseInt(ze[9]) > 0)) {
                            pAdr.setTmopn(Integer.parseInt(ze[9]));
                        }

                        if ((ze.length>10 && ze[10].length() > 0 && Integer.parseInt(ze[10]) > 0)) {
                            pAdr.setTmcls(Integer.parseInt(ze[10]));
                        }

                        if ((ze.length>11 && ze[11].length() > 0 && Double.parseDouble(ze[11]) > 0)) {
                            pAdr.setLngtd(Double.parseDouble(ze[11]));
                        }
                        if ((ze.length>12 && ze[12].length() > 0 && Double.parseDouble(ze[12]) > 0)) {
                            pAdr.setLngtd(Double.parseDouble(ze[12]));
                        }

                        lpAdr.add(pAdr);
                        i += 1;
                    }
                }
            }
            //Date dtB = Date.parse("19-Apr-2019");


           String idd =  new ObjectId().toString();
            Ppls psp = new Ppls( 1, mn[1], mn[2], mn[3], mn[4], mn[5], mn[6], mn[7], mn[8],mn[9] , Integer.parseInt( mn[10]), mn[11], Integer.parseInt( mn[12]), mn[13], mn[14], "", "", "", lpAdr, idd    );
            //psp = this.srvP.savePppl(psp);
            psp= this.mngTmpl.save(psp,"ppls");
            //String sss = new ObjectId().toString();

            //this.mngTmpl.upsert(new Query(Criteria.where("id").is("12")),new Update().set("nma", "a"),Ppls.class);
            return ResponseEntity.ok(psp);
        }
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/gtcode/{dts}", method = RequestMethod.GET)
    ResponseEntity<Ppls> getCode(@PathVariable("dts") String dts){
        Ppls p = new Ppls(0,"","","","","","","","","",
                0,"",0,"","","","", "",null, "");
        if (dts ==null){
            return ResponseEntity.ok(p);
        } else if (dts.length()==0){
            return ResponseEntity.ok(p);
        }
        Integer fltr = 0;
        if (Integer.parseInt(dts)>0){
            fltr = Integer.parseInt(dts);
        }
        BasicQuery brq = new BasicQuery("{typr : " + fltr + "}");
        brq.with(new Sort(new Sort.Order(Sort.Direction.DESC, "_id")));
        brq.limit(1);
        List<Ppls> ppl = mngTmpl.find(brq, Ppls.class);
        if (ppl==null){
            p.setCde("Dr-1");
            return ResponseEntity.ok(p);
        } else if (ppl.size()==0){
            p.setCde("Dr-1");
            return ResponseEntity.ok(p);
        }

        String cde = ppl.get(0).getCde();

        if (cde==null){
            p.setCde("Dr-1");
            return ResponseEntity.ok(p);
        } else if (cde.length()==0){
            p.setCde("Dr-1");
            return ResponseEntity.ok(p);
        } else {
            String [] cd = cde.split("\\-");
            Integer nwCd =Integer.parseInt(cd[1])+1;
            cde = "Dr-" + nwCd;
            p.setCde(cde);
            return  ResponseEntity.ok(p);
        }

    }
}
