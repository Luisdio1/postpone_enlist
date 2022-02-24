package gr.hua.dit.dis_sys.project.postpone_enlist.Controller;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.User;
import gr.hua.dit.dis_sys.project.postpone_enlist.Service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    //Find all the users
    @GetMapping("/users")
    public ModelAndView all() {
        ModelAndView mav = new ModelAndView("list-users");
        List<User> list = adminService.findAllUsers();
        mav.addObject("users",list);
        return mav;
    }

    @GetMapping("/addUserForm")
    public ModelAndView addUserForm() {
        ModelAndView mav = new ModelAndView("add-user-form");
        User newUser = new User();
        mav.addObject("user", newUser);
        return mav;
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam String ADT){
        ModelAndView mav = new ModelAndView("add-user-form");
        User user = new User();
        user = adminService.findUserByADT(ADT);
        mav.addObject("user",user);
        return mav;
    };

    //Add a User
    @PostMapping("/user")
    public RedirectView addUser(@ModelAttribute User user) {
        adminService.addUser(user);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/admin/users");
        return redirectView;
    }

    //Deletes a User
    @GetMapping("/deleteUser")
    public RedirectView deleteUser(@RequestParam String ADT) {
        adminService.deleteUser(ADT);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/admin/users");
        return redirectView;
    }

    //Update authority to citizen
    @GetMapping("/auth/citizen")
    public RedirectView makeCitizen(@RequestParam String ADT) {
        adminService.updateAuthorityToCitizen(ADT);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/admin/users");
        return redirectView;
    }

    //Update authority to employee
    @GetMapping("/auth/employee")
    public RedirectView makeEmployee(@RequestParam String ADT) {
        adminService.updateAuthorityToEmployee(ADT);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/admin/users");
        return redirectView;
    }

    //Update authority to aksiomatiko
    @GetMapping("/auth/aks")
    public RedirectView makeAksiomatiko(@RequestParam String ADT) {
        adminService.updateAuthorityToAksioamtiko(ADT);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/admin/users");
        return redirectView;
    }
}
