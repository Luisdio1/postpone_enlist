package gr.hua.dit.dis_sys.project.postpone_enlist.Controller;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.Application;
import gr.hua.dit.dis_sys.project.postpone_enlist.Service.AksiomatikosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/aks")
public class AksiomatikosController {

    @Autowired
    private AksiomatikosServiceImpl aksiomatikosService;

    @GetMapping("/apps")
    public ModelAndView all() {
        ModelAndView mav = new ModelAndView("list-apps-aks");
        List<Application> list = aksiomatikosService.findAll();
        mav.addObject("apps",list);
        return mav;
    }

    //Find all the applications
//    @GetMapping("/apps")
//    List<Application> all() {
//        return aksiomatikosService.findAll();
//    }

//    //Find the application with given id
//    @GetMapping("/apps/{id}")
//    Application app (@PathVariable int id) {
//        return aksiomatikosService.getApplication(id);
//    }

    //Approve an application given the id
//    @PutMapping("/apps/{id}/approve")
//    Application approve (@PathVariable int id) {
//        return aksiomatikosService.approveApplication(id);
//    }
//
//    //Reject an application given the id
//    @PutMapping("/apps/{id}/reject")
//    Application reject (@PathVariable int id) {
//        return aksiomatikosService.rejectApplication(id);
//    }


    //Approve an application given the id
    @GetMapping("/apps/approve")
    public RedirectView approveApp(@RequestParam int applicationId) {
        aksiomatikosService.approveApplication(applicationId);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/aks/apps");
        return redirectView;
    }

    //Reject an application given the id
    @GetMapping("/apps/reject")
    public RedirectView rejectApp(@RequestParam int applicationId) {
        aksiomatikosService.rejectApplication(applicationId);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/aks/apps");
        return redirectView;
    }
}

