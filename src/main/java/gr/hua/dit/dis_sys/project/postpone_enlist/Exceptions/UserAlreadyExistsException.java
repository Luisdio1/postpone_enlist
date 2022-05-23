package gr.hua.dit.dis_sys.project.postpone_enlist.Exceptions;

//Custom exception that sends a message if user already exists
public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException() {
        super("User already exists");
    }
}
