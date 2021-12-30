package gr.hua.dit.dis_sys.project.postpone_enlist.Exceptions;

public class UserNotFoundException extends RuntimeException{

    //Custom exception that sends a message if someone searches for an application that doesn't exists
    public UserNotFoundException(String username) {
        super("Could not find user with username/ADT: " + username);
    }
}
