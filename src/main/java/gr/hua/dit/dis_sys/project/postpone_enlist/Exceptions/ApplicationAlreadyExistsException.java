package gr.hua.dit.dis_sys.project.postpone_enlist.Exceptions;

public class ApplicationAlreadyExistsException extends RuntimeException {

    //Custom exception that sends a message if someone submits an application and it already existed
    public ApplicationAlreadyExistsException() {
        super("You already submited an application");
    }
}
