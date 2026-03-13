import java.time.LocalDate;

public class Programmer extends Person {
    private String usedLanguage;

    public Programmer(String hobby, LocalDate dob, String name, String id, String usedLanguage) {
        super(hobby, dob, name, id);
        this.usedLanguage = usedLanguage;
    }
}
