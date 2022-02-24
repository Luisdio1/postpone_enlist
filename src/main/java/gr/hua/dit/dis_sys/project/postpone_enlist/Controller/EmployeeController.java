package gr.hua.dit.dis_sys.project.postpone_enlist.Controller;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.Application;
import gr.hua.dit.dis_sys.project.postpone_enlist.Service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/empl")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    //Will be the page to redirect every Employee after login
    @GetMapping("/apps")
    public ModelAndView all() {
        ModelAndView mav = new ModelAndView("list-apps");
        List<Application> list = employeeService.findAll();
        mav.addObject("apps",list);
        return mav;
    }

    //Approve an application given the id
    @GetMapping("/apps/approve")
    public RedirectView approveApp(@RequestParam int applicationId) {
        employeeService.validateApplication(applicationId);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/empl/apps");
        return redirectView;
    }

    //Reject an application given the id
    @GetMapping("/apps/reject")
    public RedirectView rejectApp(@RequestParam int applicationId) {
        employeeService.rejectApplication(applicationId);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/empl/apps");
        return redirectView;
    }
}