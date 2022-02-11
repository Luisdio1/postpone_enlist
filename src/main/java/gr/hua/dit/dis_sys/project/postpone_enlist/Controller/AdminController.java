package gr.hua.dit.dis_sys.project.postpone_enlist.Controller;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.User;
import gr.hua.dit.dis_sys.project.postpone_enlist.Service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    //Will be the page to redirect Admin after login
    //Currently just shows a message to the /admin url
    @RequestMapping("/admin")
    String welcome() {
        return "Welcome Admin";
    }

    //Find all the users
    @GetMapping("/users")
    List<User> all() {
        return adminService.findAllUsers();
    }

    //Add a User
    @PostMapping("/user")
    User addUser(@RequestBody User user) {
        return adminService.addUser(user);
    }

    //Updates a User
    @PutMapping("/user/{ADT}")
    User updateUser(@RequestBody User user, @PathVariable String ADT) {
        return adminService.updateUser(user, ADT);
    }

    //Deletes a User
    @DeleteMapping("/user/{ADT}")
    void deleteUser(@PathVariable String ADT) {
        adminService.deleteUser(ADT);
    }

    //Find User Given the ADT
    @GetMapping("/user/{ADT}")
    User findUserByADT(@PathVariable String ADT) {
        return adminService.findUserByADT(ADT);
    }

    //Find User Given the username
    @GetMapping("/user/{username}")
    User findUserByUsername(@PathVariable String username) {
        return adminService.findUser(username);
    }

    //Update authority to citizen
    @PutMapping("/auth/citizen/{ADT}")
    void makeCitizen(@PathVariable String ADT) {
        adminService.updateAuthorityToCitizen(ADT);
    }

    //Update authority to employee
    @PutMapping("/auth/employee/{ADT}")
    void makeEmployee(@PathVariable String ADT) {
        adminService.updateAuthorityToEmployee(ADT);
    }

    //Update authority to aksiomatiko
    @PutMapping("/auth/aks/{ADT}")
    void makeAksiomatiko(@PathVariable String ADT) {
        adminService.updateAuthorityToAksioamtiko(ADT);
    }
}
