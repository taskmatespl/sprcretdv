package in.crtdvtspl.tsplcrt.Srvice;

import in.crtdvtspl.tsplcrt.model.Ppls;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface SrvcPpls {
    List<Ppls> findPplsByTyprEquals(Integer typr, Sort srt, PageRequest pg);
    Ppls savePppl(Ppls psl);


}
