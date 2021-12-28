package gr.hua.dit.dis_sys.project.postpone_enlist.Controller;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.Application;
import gr.hua.dit.dis_sys.project.postpone_enlist.Service.CitizenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cit")
public class CitizenController {

    @Autowired
    private CitizenServiceImpl citizenService;

    @RequestMapping("")
    String welcome() {
        return "Welcome Citizen";
    }

    @GetMapping("/app/{id}")
    Application app (@PathVariable int id) {
        return citizenService.getApplication(id);
    }

    @PostMapping("/app")
    Application submitApp(@RequestBody Application newApplication) {
        return citizenService.submitApplication(newApplication);
    }

    @PutMapping("/app/{id}")
    Application changeApp(@RequestBody Application newApplication, @PathVariable int id) {
        return citizenService.changeApplication(newApplication, id);
    }
}
