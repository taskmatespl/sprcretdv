package in.crtdvtspl.tsplcrt;

import in.crtdvtspl.tsplcrt.Srvice.SrvcUsrs;
import in.crtdvtspl.tsplcrt.model.Usrs;
import in.crtdvtspl.tsplcrt.repository.UsrsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
//, "in.crtdvtspl.tsplcrt.Controller", "in.crtdvtspl.tsplcrt.Srvice"
@SpringBootApplication(scanBasePackages = {"in.crtdvtspl.tsplcrt"})
//@ComponentScan //({"in.crtdvtspl.tsplcrt.model", "in.crtdvtspl.tsplcrt.repository"})
@EnableMongoRepositories("in.crtdvtspl.tsplcrt.repository")
public class TsplcrtApplication  extends SpringBootServletInitializer {
    @Autowired
    UsrsRepository usrR;
    static SrvcUsrs Srv;
    @RequestMapping("/")
    public static void main(String[] args)  {
        SpringApplication.run(TsplcrtApplication.class, args);
    }

   /* @Override
    public void run(String...args) throws Exception {
        //	deleteAll();
        if (args != null) {
            System.out.println("A");
            //System.out.println(args[0]);
        }
        System.out.println(args.length);
		/*System.out.println(args[0].toString());
		System.out.println(args[1].toString());*/
        //	addSampleData();
    //    list();
        //		findFirst();
        //	findByRegex();
   // }

    public void list(){

        List<Usrs> Usr = usrR.findAllByUsrEquals("sanjay");
        Usrs u = Usr.get(0);
        System.out.println(u.getPsw());
    }

}
