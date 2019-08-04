package in.crtdvtspl.tsplcrt.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Document(collection = "ppls")
public class Ppls {
    @Id
    private String id;
    private Integer typr;
    private String nma;
    private String nmb;
    private String nmc;
    private String cde;
    private String mob;
    private String eml;
    private String gndrid;
    private String gndr;
    private String dob;
    private Integer dobm;
    private String dma;
    private Integer dman;
    private String ctgid;
    private String ctg;
    private String regno;
    private String lica;
    private String licb;
    Collection<pplAddr> pplA = new ArrayList<>();

    public Ppls(  Integer typr, String nma, String nmb, String nmc, String cde, String mob, String eml, String gndrid, String gndr, String dob,
            Integer dobm, String dma, Integer dman, String ctgid, String ctg, String regno, String lica, String licb,
            Collection<pplAddr> pplA , String id){
            this.id=id;
            this.typr = typr;
            this.nma    = nma;
            this.nmb = nmb  ;
            this.nmc =nmc;
            this.cde = cde;
            this.mob = mob;
            this.eml = eml;
            this.gndrid = gndrid;
            this.gndr = gndr;
            this.dob= dob;
            this.dobm   = dobm  ;
            this.dma = dma;
            this.dman = dman;
            this.ctgid = ctgid;
            this.ctg = ctg;
            this.regno = regno;
            this.lica   = lica;
            this.licb   = licb;
            this.pplA = pplA;
    }

    public String getId() {
        return id;
    }

    public Integer getTypr() {
        return typr;
    }

    public Collection<pplAddr> getPplA() {
        return pplA;
    }

    public String getDma() {
        return dma;
    }

    public String getDob() {
        return dob;
    }

    public Integer getDman() {
        return dman;
    }

    public Integer getDobm() {
        return dobm;
    }

    public String getCde() {
        return cde;
    }

    public String getCtg() {
        return ctg;
    }

    public String getCtgid() {
        return ctgid;
    }

    public String getEml() {
        return eml;
    }

    public String getGndr() {
        return gndr;
    }

    public String getGndrid() {
        return gndrid;
    }

    public String getLica() {
        return lica;
    }

    public String getLicb() {
        return licb;
    }

    public String getMob() {
        return mob;
    }

    public String getNma() {
        return nma;
    }

    public String getNmb() {
        return nmb;
    }

    public String getNmc() {
        return nmc;
    }

    public String getRegno() {
        return regno;
    }

    public void setTypr(Integer typr) {
        this.typr = typr;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCde(String cde) {
        this.cde = cde;
    }

    public void setCtg(String ctg) {
        this.ctg = ctg;
    }

    public void setCtgid(String ctgid) {
        this.ctgid = ctgid;
    }

    public void setDma(String dma) {
        this.dma = dma;
    }

    public void setDman(Integer dman) {
        this.dman = dman;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setDobm(Integer dobm) {
        this.dobm = dobm;
    }

    public void setEml(String eml) {
        this.eml = eml;
    }

    public void setGndr(String gndr) {
        this.gndr = gndr;
    }

    public void setGndrid(String gndrid) {
        this.gndrid = gndrid;
    }

    public void setLica(String lica) {
        this.lica = lica;
    }

    public void setLicb(String licb) {
        this.licb = licb;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public void setNma(String nma) {
        this.nma = nma;
    }

    public void setNmb(String nmb) {
        this.nmb = nmb;
    }

    public void setNmc(String nmc) {
        this.nmc = nmc;
    }

    public void setPplA(Collection<pplAddr> pplA) {
        this.pplA = pplA;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

}
