package gr.hua.dit.dis_sys.project.postpone_enlist.Exceptions;

public class ApplicationNotFoundException extends RuntimeException{

    //Custom exception that sends a message if someone searches for an application that doesn't exists
    public ApplicationNotFoundException(int id) {
        super("Could not find application with id: " + id);
    }
}
