package gr.hua.dit.dis_sys.project.postpone_enlist.Controller;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.User;
import gr.hua.dit.dis_sys.project.postpone_enlist.Service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OpenEndpointsController {

    //We use the admin service just for the addUser method, So we dont make a User Service just for one method
    @Autowired
    private AdminServiceImpl service;

    //Will be the home page
    //Currently just shows a message to the / url
    @RequestMapping("/")
    String welcome() {
        return "Welcome To Home Page";
    }

    //Register
    @PostMapping("/register")
    User register(@RequestBody User user) {
        service.makeUserCitizen(user.getADT());
        return service.addUser(user);
    }

    //Register Page
    @GetMapping("/register")
    String registerPage() {
        return "Register Page!";
    }
}
