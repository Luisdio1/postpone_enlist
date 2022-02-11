package gr.hua.dit.dis_sys.project.postpone_enlist.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebControler {

    @GetMapping({ "/", "/initial" })
    public String initial(Model model) {
        return "initial"; // name of the View
    }
    @GetMapping({ "/register", "/register" })
    public String register(Model model) {
        return "register"; // name of the View
    }
    @GetMapping({ "/cit", "/welcomeCitizen" })
    public String welcomeCitizen(Model model) {
        return "welcomeCitizen"; // name of the View
    }
    @GetMapping({ "/app", "/newApplication" })
    public String newApplication(Model model) {
        return "newApplication"; // name of the View
    }
    @GetMapping({ "/app/{id}", "/changes" })
    public String changes (Model model) {
        return "changes"; // name of the View
    }
    @GetMapping({ "/aks", "/WelcomeOfficer" })
    public String welcomeOfficer(Model model) {
        return "WelcomeOfficer"; // name of the View
    }
    @GetMapping({ "/apps", "/officerAll" })
    public String officerAll(Model model) {
        return "officerAll"; // name of the View
    }
    @GetMapping({ "/apps/{id}", "/OfficerApprove" })
    public String officerApprove(Model model) {
        return "OfficerApprove"; // name of the View
    }
    @GetMapping({ "/eml", "/welcomeEmployee" })
    public String welcomeEmployee(Model model) {
        return "welcomeEmployee"; // name of the View
    }
    @GetMapping({ "/apps", "/employeeAll" })
    public String employeeAll(Model model) {
        return "employeeAll"; // name of the View
    }
    @GetMapping({ "/apps/{id}", "/employeeApprove" })
    public String employeeApprove(Model model) {
        return "employeeApprove"; // name of the View
    }


}