package gr.hua.dit.dis_sys.project.postpone_enlist.Controller;


import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebControler {

    @GetMapping({ "/", "/initial" })
    public String index(Model model) {
        model.addAttribute("name", "John"); // set 'John' value for 'name' attribute

        return "initial"; // name of the View
    }

    @GetMapping({ "/register", "/register1" })
    public String index1(Model model) {




        return "register1"; // name of the View

    }



    @GetMapping({ "/apps", "/employeeAll" })
    public String employeeAll(Model model) {
        return "employeeAll"; // name of the View
    }

    @GetMapping({ "/empl", "/welcomeEmployee" })
    public String welcomeEmployee(Model model) {
        return "welcomeEmployee"; // name of the View
    }

//    @GetMapping({ "/apps/{id}", "/employeeApprove" })
//    public String employeeApprove(Model model) {
//        return "employeeApprove"; // name of the View
//    }


    @GetMapping({ "/cit", "/cityzen" })
    public String index6(Model model) {


        return "cityzen"; // name of the View

    }



    @GetMapping({ "/app", "/newApplication" })
    public String index2(Model model) {
        model.addAttribute("name", "John"); // set 'John' value for 'name' attribute

        return "newApplication"; // name of the View

    }

    @GetMapping({ "/app/{id}", "/changes" })
    public String index3(Model model) {
        model.addAttribute("name", "John"); // set 'John' value for 'name' attribute

        return "changes"; // name of the View

    }
    @GetMapping({ "/aks/{id}/apps", "/officerAll" })
    public String officerAll(Model model) {
        return "officerAll"; // name of the View
    }

}