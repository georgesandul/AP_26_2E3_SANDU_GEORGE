import java.time.LocalDate;

public class Designer extends Person {
    private String designApp;

    public Designer(String hobby, LocalDate dob, String name, String id, String designApp) {
        super(hobby, dob, name, id);
        this.designApp = designApp;
    }
}
