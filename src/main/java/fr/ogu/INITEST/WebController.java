package fr.ogu.INITEST;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
public class WebController {
    @GetMapping(value = "/index")
    public String index(HttpSession session){
        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateSchema  = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss");
        String time = dateSchema.format(c.getTime());
        session.setAttribute("time", time );
        return "index";
    }
}
