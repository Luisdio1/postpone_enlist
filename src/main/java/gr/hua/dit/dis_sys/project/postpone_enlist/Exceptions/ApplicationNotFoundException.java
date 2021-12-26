package gr.hua.dit.dis_sys.project.postpone_enlist.Exceptions;

public class ApplicationNotFoundException extends RuntimeException{

    public ApplicationNotFoundException(int id) {
        super("Could not find application with id: " + id);
    }
}
