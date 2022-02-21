package gr.hua.dit.dis_sys.project.postpone_enlist.Controller;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.Application;
import gr.hua.dit.dis_sys.project.postpone_enlist.Service.CitizenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/cit")
public class CitizenController {

    @Autowired
    private CitizenServiceImpl citizenService;

    //Will be the page to redirect every Citizen after login
    //Currently just shows a message to the /cit url
    @RequestMapping("/")
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
    @PostMapping(value = "/app", consumes = {"multipart/form-data"})
    Application submitApp(@RequestPart(value = "user") Application newApplication, @RequestPart(value = "file") MultipartFile file) {
        return citizenService.submitApplication(newApplication,file);
    }

    //Update the application
    @PutMapping(value = "/app/{id}",consumes = {"multipart/form-data"})
    Application changeApp(@RequestPart(value = "id") Application newApplication ,@RequestPart(value = "file") MultipartFile file, @PathVariable int id) {
        return citizenService.changeApplication(newApplication, id, file);
    }
}
