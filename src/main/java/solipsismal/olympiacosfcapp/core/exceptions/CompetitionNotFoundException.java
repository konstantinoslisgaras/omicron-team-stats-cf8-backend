package solipsismal.olympiacosfcapp.core.exceptions;

public class CompetitionNotFoundException extends AppGenericException {
    private static final String DEFAULT_CODE = "CompetitionNotFound";
    private static final String DEFAULT_MESSAGE = "The requested competition was not found";

    public CompetitionNotFoundException() {
        super(DEFAULT_CODE, DEFAULT_MESSAGE);
    }

    public CompetitionNotFoundException(String competition) {
        super(DEFAULT_CODE, "Competition: " + competition + " was not found");
    }
}
