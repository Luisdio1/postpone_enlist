package gr.hua.dit.dis_sys.project.postpone_enlist.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginSuccesController {





    @GetMapping( "/success")
    public String index(HttpServletRequest request) {
        if (request.isUserInRole("USER")) {
            return "cityzen";
        } else if (request.isUserInRole("ADMIN")) {
            return "welcomeAdmin";
        } else if (request.isUserInRole("EMPL")){
            return "welcomeEmployee";
        }else if (request.isUserInRole("AKS")){
            return"WelcomeOfficer";
        }
        return "initial";
    }



}
