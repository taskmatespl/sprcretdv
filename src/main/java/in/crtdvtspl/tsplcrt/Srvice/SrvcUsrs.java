package in.crtdvtspl.tsplcrt.Srvice;

import in.crtdvtspl.tsplcrt.model.Usrs;


import java.util.List;

public interface SrvcUsrs {
    List<Usrs> findAll();
    List<Usrs> findAllByUsrEquals(String ss);
    String SaveUsr(Usrs urs);


}
