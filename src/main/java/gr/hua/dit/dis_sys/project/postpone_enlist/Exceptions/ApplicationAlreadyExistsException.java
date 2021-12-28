package gr.hua.dit.dis_sys.project.postpone_enlist.Exceptions;

public class ApplicationAlreadyExistsException extends RuntimeException {

    public ApplicationAlreadyExistsException() {

        super("You already submited an application");
    }
}
