package in.crtdvtspl.tsplcrt.Srvice;

import in.crtdvtspl.tsplcrt.model.Cmbo;
import io.netty.channel.unix.Limits;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.query.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface SrvcCmbo {
    //List<Cmbo> findCmbos(Query qr);
    List<Cmbo> findBy(Query qr);

    List<Cmbo> findCmboByTyprEquals(Integer typr, PageRequest pg);
   // List<Cmbo> findCmboByTyprEquals(Integer typr, Pageable pg);
   List<Cmbo> findByTyprEqualsAndTxtStartingWith(Integer typr, String fltr);
    List<Cmbo> findByTyprEqualsAndTxtContains(Integer typr, String fltr);
    List<Cmbo> findByTyprEqualsAndTxtIsContaining(Integer typr, String fltr);
}
