package gr.hua.dit.dis_sys.project.postpone_enlist.Controller;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.Application;
import gr.hua.dit.dis_sys.project.postpone_enlist.Service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/empl")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    //Will be the page to redirect every Employee after login
    //Currently just shows a message to the /empl url
    @RequestMapping("")
    String welcome() {
        return "Welcome Employee";
    }

    //Find all the applications
    @GetMapping("/apps")
    String all() {
        return employeeService.findAll().toString();
    }

    //Find the application with given id
    //Experiment with HATEOAS
    @GetMapping("/apps/{id}")
    String app (@PathVariable int id) {
        Application app = employeeService.getApplication(id);
        return app.toString();
//        return EntityModel.of(app, linkTo(methodOn(EmployeeController.class).app(id)).withSelfRel(), linkTo(methodOn(EmployeeController.class).all()).withRel("Applications"));
    }

    //Approve an application given the id
    @PutMapping("/apps/{id}/approve")
    Application approve (@PathVariable int id) {
        return employeeService.validateApplication(id);
    }

    //Reject an application given the id
    @PutMapping("/apps/{id}/reject")
    Application reject (@PathVariable int id) {
        return employeeService.rejectApplication(id);
    }
}