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

    //Will be the page to redirect every Citizen after login
    //Currently just shows a message to the /cit url
    @RequestMapping("")
    String welcome() {
        return "Welcome Citizen";
    }

    //Get the application of the citizen, must provide id of the application
    //Probably need to change implamentation so that we find the application not provided the id of the application but some information from the citizen
    @GetMapping("/app/{id}")
    Application app (@PathVariable int id) {
        return citizenService.getApplication(id);
    }

    //Submit an application
    @PostMapping("/app")
    Application submitApp(@RequestBody Application newApplication) {
        return citizenService.submitApplication(newApplication);
    }

    //Update the application
    @PutMapping("/app/{id}")
    Application changeApp(@RequestBody Application newApplication, @PathVariable int id) {
        return citizenService.changeApplication(newApplication, id);
    }
}
