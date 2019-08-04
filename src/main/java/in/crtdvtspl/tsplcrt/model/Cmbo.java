package in.crtdvtspl.tsplcrt.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;

@Document(collection="cmbo")
public class Cmbo {
    @Id
    private String Id;
    private Integer typr;
    private Integer md;
    private String txt;
    private Integer cmp;
    private Integer usr;
    private Integer del;
    private Timestamp tms;

    public Cmbo (Integer typr, Integer md, String txt, Integer cmp, Integer usr, Integer del){
        this.cmp = cmp;
        this.typr = typr;
        this.md = md;
        this.txt = txt;
        this.usr = usr;
        this.del = del;

    }

    public Integer getCmp() {
        return cmp;
    }

    public Integer getDel() {
        return del;
    }

    public Integer getMd() {
        return md;
    }

    public Integer getTypr() {
        return typr;
    }

    public Integer getUsr() {
        return usr;
    }

    public String getId() {
        return Id;
    }

    public String getTxt() {
        return txt;
    }

    public void setCmp(Integer cmp) {
        this.cmp = cmp;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setMd(Integer md) {
        this.md = md;
    }

    public void setTms(Timestamp tms) {
        this.tms = tms;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public void setTypr(Integer typr) {
        this.typr = typr;
    }

    public void setUsr(Integer usr) {
        this.usr = usr;
    }
}
