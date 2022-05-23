package gr.hua.dit.dis_sys.project.postpone_enlist.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginSuccesController {





//    @GetMapping( "/success")
//    public String index(HttpServletRequest request) {
//        if (request.isUserInRole("USER")) {
//            return "cityzen";
//        } else if (request.isUserInRole("ADMIN")) {
//            return "list-users";
//        } else if (request.isUserInRole("EMPL")){
//            return "welcomeEmployee";
//        }else if (request.isUserInRole("AKS")){
//            return"WelcomeOfficer";
//        }
//        return "initial";
//    }

    @GetMapping("/success")
    public RedirectView index(HttpServletRequest request){
        RedirectView redirectView = new RedirectView();
        if (request.isUserInRole("USER")) {
            redirectView.setUrl("/cityzen");
            return redirectView;
        } else if (request.isUserInRole("ADMIN")) {
            redirectView.setUrl("/admin/users");
            return redirectView;
        } else if (request.isUserInRole("EMPL")){
            redirectView.setUrl("/empl/apps");
            return redirectView;
        }else if (request.isUserInRole("AKS")){
            redirectView.setUrl("/aks/apps");
            return redirectView;
        }
        redirectView.setUrl("/initial");
        return redirectView;
    }

}
