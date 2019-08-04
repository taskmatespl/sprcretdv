package in.crtdvtspl.tsplcrt.Controller;

import com.mongodb.Mongo;
import in.crtdvtspl.tsplcrt.Srvice.SrvcUsrs;
import in.crtdvtspl.tsplcrt.model.Usrs;
import in.crtdvtspl.tsplcrt.repository.UsrsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lgn")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MyController {
    private final SrvcUsrs usrv;

    @Autowired
    MyController(SrvcUsrs usrv) {
        this.usrv = usrv;
    }

    @RequestMapping(value = "/sanja", method = RequestMethod.GET)
    ResponseEntity<String> getUsrDtls() {
        List<Usrs> Usr = usrv.findAll();

        if (Usr.size() > 0) {
            String ss;
            ss = Usr.get(0).getUsr();
            ss += Usr.get(0).getPsw();
            ss += Usr.get(0).getId();
            return ResponseEntity.ok(ss);
        }

        //usrv.save(new Usrs("Sanjay", "Gupta"));

        return ResponseEntity.ok("Sanjay");
    }

    @RequestMapping(value = "/lgn/{crdtnls}", method = RequestMethod.GET)
    ResponseEntity<Usrs> getMydts(@PathVariable("crdtnls") String crdt) {
        if (crdt != null && crdt.length()>1){


            String [] s = crdt.split("\\~");
            if (s !=null && s.length==2){
                List<Usrs> Usr = usrv.findAllByUsrEquals(s[0]);
                if (Usr.size() > 0) {
                    String ss;
                    ss = Usr.get(0).getPsw();
                    if (ss.equals(s[1])){
                        return ResponseEntity.ok(Usr.get(0));
                    }
                    Usr.get(0).setUsr("");
                    Usr.get(0).setPsw("");
                    return ResponseEntity.ok(Usr.get(0));

                }

            }


        }
        Usrs Usr = new Usrs("", "");
        return ResponseEntity.ok(Usr);
    }

    @RequestMapping(value = "/sv/{crdtnls}", method = RequestMethod.GET)
    ResponseEntity<String> svData(@PathVariable("crdtnls") String crdt) {
        if (crdt !=null){
            if (crdt.indexOf("u")==0){
                crdt = crdt.substring(1);
                String [] s = crdt.split("\\~");
                Usrs rs = new Usrs(s[0],s[1]);
                String sa= usrv.SaveUsr(rs);
                return ResponseEntity.ok(sa);
            }
        }


        return ResponseEntity.ok("failed");
    }
}
