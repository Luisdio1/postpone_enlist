package gr.hua.dit.dis_sys.project.postpone_enlist.Controller;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.User;
import gr.hua.dit.dis_sys.project.postpone_enlist.Service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
public class OpenEndpointsController {

    //We user the admin service just for the addUser method, So we dont make a User Service just for one method
    @Autowired
    private AdminServiceImpl service;

    //Will be the home page
    //Currently just shows a message to the / url
    @RequestMapping("/")
    String welcome() {
        return "Welcome";
    }

    //Register

    @PostMapping(value ="/register" , consumes = {"application/json"})
    User register(@RequestBody User user) {
        User newUser = service.addUser(user);
       service.makeUserCitizen(user.getADT());
        return newUser;
    }

    //Register Page
}
