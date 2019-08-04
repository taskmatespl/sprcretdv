package in.crtdvtspl.tsplcrt.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="usrs")
public class Usrs {
    @Id
    private String id;
    private String usr;
    private String psw;

    public  Usrs (String usr, String psw){
        this.usr = usr;
        this.psw = psw;
    }

    public String getUsr() {
        return usr;
    }

    public String getId() {
        return id;
    }

    public String getPsw() {
        return psw;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }
}
