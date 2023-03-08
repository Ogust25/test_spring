package fr.ogu.INITEST;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Controller
public class WebController {
    @GetMapping("/index")
    public String index(HttpSession session, Model model){

        // DATE
        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateSchema  = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss");
        String time = dateSchema.format(c.getTime());
        session.setAttribute("time", time );

        // USER FORM
        model.addAttribute("users", new Users());

        return "index";
    }

    @PostMapping("/index")
    public String userSubmit(@ModelAttribute Users users, Model model) {
        model.addAttribute("users", users);

        return "index";
    }
}
