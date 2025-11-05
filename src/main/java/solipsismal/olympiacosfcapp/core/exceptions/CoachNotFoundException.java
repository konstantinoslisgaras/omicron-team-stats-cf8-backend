package solipsismal.olympiacosfcapp.core.exceptions;

public class CoachNotFoundException extends AppGenericException {
    private static final String DEFAULT_CODE = "CoachNotFound";
    private static final String DEFAULT_MESSAGE = "The requested coach was not found";

    public CoachNotFoundException() {
        super(DEFAULT_CODE, DEFAULT_MESSAGE);
    }

    public CoachNotFoundException(String lastname) {
        super(DEFAULT_CODE, "Coach with lastname: '" + lastname + "' was not found");
    }
}