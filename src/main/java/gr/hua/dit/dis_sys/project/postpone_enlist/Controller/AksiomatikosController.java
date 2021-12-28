package gr.hua.dit.dis_sys.project.postpone_enlist.Controller;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.Application;
import gr.hua.dit.dis_sys.project.postpone_enlist.Service.AksiomatikosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aks")
public class AksiomatikosController {

    @Autowired
    private AksiomatikosServiceImpl aksiomatikosService;

    //Will be the page to redirect every Aksiomatiko after login
    //Currently just shows a message to the /aks url
    @RequestMapping("")
    String welcome() {
        return "Welcome Aksiomatike ";
    }

    //Find all the applications
    @GetMapping("/apps")
    List<Application> all() {
        return aksiomatikosService.findAll();
    }

    //Find the application with given id
    @GetMapping("/apps/{id}")
    Application app (@PathVariable int id) {
        return aksiomatikosService.getApplication(id);
    }

    //Approve an application given the id
    @PutMapping("/apps/{id}/approve")
    Application approve (@PathVariable int id) {
        return aksiomatikosService.approveApplication(id);
    }

    //Reject an application given the id
    @PutMapping("/apps/{id}/reject")
    Application reject (@PathVariable int id) {
        return aksiomatikosService.rejectApplication(id);
    }
}
