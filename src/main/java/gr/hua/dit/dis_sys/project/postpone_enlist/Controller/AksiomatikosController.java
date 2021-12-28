package gr.hua.dit.dis_sys.project.postpone_enlist.Controller;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.Aksiomatikos;
import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.Application;
import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.User;
import gr.hua.dit.dis_sys.project.postpone_enlist.Service.AksiomatikosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aks")
public class AksiomatikosController {

    @Autowired
    private AksiomatikosServiceImpl aksiomatikosService;

    @RequestMapping("")
    String welcome() {
        return "Welcome Aksiomatike ";
    }

    @GetMapping("/apps")
    List<Application> all() {
        return aksiomatikosService.findAll();
    }

    @GetMapping("/apps/{id}")
    Application app (@PathVariable int id) {
        return aksiomatikosService.getApplication(id);
    }

    @PutMapping("/apps/{id}/approve")
    Application approve (@PathVariable int id) {
        return aksiomatikosService.approveApplication(id);
    }

    @PutMapping("/apps/{id}/reject")
    Application reject (@PathVariable int id) {
        return aksiomatikosService.rejectApplication(id);
    }
}
