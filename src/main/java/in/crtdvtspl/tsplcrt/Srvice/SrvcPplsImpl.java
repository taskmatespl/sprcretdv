package in.crtdvtspl.tsplcrt.Srvice;

import in.crtdvtspl.tsplcrt.model.Ppls;
import in.crtdvtspl.tsplcrt.repository.PplsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SrvcPplsImpl implements SrvcPpls {
    private final PplsRepository pplRep;
    @Autowired
    SrvcPplsImpl(PplsRepository pplRep){
        this.pplRep = pplRep;
    }

    @Override
    public List<Ppls> findPplsByTyprEquals(Integer typr, Sort srt, PageRequest pg){
       List<Ppls> ppl =  this.pplRep.findPplsByTyprEquals(typr,srt,pg);
       return ppl;
    }
    @Override
    public Ppls savePppl(Ppls psl){
        Ppls pasl = this.pplRep.save(psl);
        return  pasl;
    }

}
