package solipsismal.olympiacosfcapp.core.exceptions;

public class CoachStatsNotFoundException extends AppGenericException {
    private static final String DEFAULT_CODE = "CoachStatsNotFound";
    private static final String DEFAULT_MESSAGE = "The requested coach stats were not found";

    public CoachStatsNotFoundException() {
        super(DEFAULT_CODE, DEFAULT_MESSAGE);
    }

    public CoachStatsNotFoundException(String id) {
        super(DEFAULT_CODE, "Coach Stats with id: '" + id + "' were not found");
    }
}