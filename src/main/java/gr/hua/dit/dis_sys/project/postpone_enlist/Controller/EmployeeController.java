package gr.hua.dit.dis_sys.project.postpone_enlist.Controller;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.Application;
import gr.hua.dit.dis_sys.project.postpone_enlist.Service.AksiomatikosServiceImpl;
import gr.hua.dit.dis_sys.project.postpone_enlist.Service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empl")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/apps")
    List<Application> all() {
        return employeeService.findAll();
    }

    @GetMapping("/apps/{id}")
    Application app (@PathVariable int id) {
        return employeeService.getApplication(id);
    }

    @PutMapping("/apps/{id}/approve")
    Application approve (@PathVariable int id) {
        return employeeService.validateApplication(id);
    }

    @PutMapping("/apps/{id}/reject")
    Application reject (@PathVariable int id) {
        return employeeService.rejectApplication(id);
    }
}