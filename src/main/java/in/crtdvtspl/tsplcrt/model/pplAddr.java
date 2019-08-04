package in.crtdvtspl.tsplcrt.model;

public class pplAddr {
    private String addrtypid;
    private String addrtyp;
    private String addra;
    private String addrb;
    private String addrc;
    private String ctyid;
    private String cty;
    private String pnc;
    private String phn;
    private Integer tmopn;
    private Integer tmcls;
    private double lngtd;
    private double latr;


    public pplAddr( String addrtypid,
            String addrtyp,  String addra, String addrb,  String addrc, String ctyid, String cty,String pnc, String phn, Integer tmopn,Integer tmcls,double lngtd, double latr){
        this.addrtypid = addrtypid;
        this.addrtyp = addrtyp;
        this.addra = addra;
        this.addrb = addrb;
        this.addrc = addrc;
        this.ctyid = ctyid;
        this.cty = cty;
        this.pnc = pnc;
        this.phn = phn;
        this.tmopn = tmopn;
        this.tmcls = tmcls;
        this.lngtd = lngtd;
        this.latr = latr;

    }

    public double getLatr() {
        return latr;
    }

    public double getLngtd() {
        return lngtd;
    }

    public Integer getTmcls() {
        return tmcls;
    }

    public Integer getTmopn() {
        return tmopn;
    }

    public String getAddra() {
        return addra;
    }

    public String getAddrb() {
        return addrb;
    }

    public String getAddrc() {
        return addrc;
    }

    public String getAddrtyp() {
        return addrtyp;
    }

    public String getAddrtypid() {
        return addrtypid;
    }

    public String getCty() {
        return cty;
    }

    public String getCtyid() {
        return ctyid;
    }

    public String getPhn() {
        return phn;
    }

    public String getPnc() {
        return pnc;
    }

    public void setAddra(String addra) {
        this.addra = addra;
    }

    public void setAddrb(String addrb) {
        this.addrb = addrb;
    }

    public void setAddrc(String addrc) {
        this.addrc = addrc;
    }

    public void setAddrtyp(String addrtyp) {
        this.addrtyp = addrtyp;
    }

    public void setAddrtypid(String addrtypid) {
        this.addrtypid = addrtypid;
    }

    public void setCty(String cty) {
        this.cty = cty;
    }

    public void setCtyid(String ctyid) {
        this.ctyid = ctyid;
    }

    public void setLatr(double latr) {
        this.latr = latr;
    }

    public void setLngtd(double lngtd) {
        this.lngtd = lngtd;
    }

    public void setPhn(String phn) {
        this.phn = phn;
    }

    public void setPnc(String pnc) {
        this.pnc = pnc;
    }

    public void setTmcls(Integer tmcls) {
        this.tmcls = tmcls;
    }

    public void setTmopn(Integer tmopn) {
        this.tmopn = tmopn;
    }
}
