package solipsismal.olympiacosfcapp.core.exceptions;

public class TeamStatsNotFoundException extends AppGenericException {
    private static final String DEFAULT_CODE = "TeamStatsNotFound";
    private static final String DEFAULT_MESSAGE = "The requested team stats were not found";

    public TeamStatsNotFoundException() {
        super(DEFAULT_CODE, DEFAULT_MESSAGE);
    }

    public TeamStatsNotFoundException(String id) {
        super(DEFAULT_CODE, "Team Stats with id: '" + id + "' were not found");
    }
}