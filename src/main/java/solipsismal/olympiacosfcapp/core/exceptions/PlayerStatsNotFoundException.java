package solipsismal.olympiacosfcapp.core.exceptions;

public class PlayerStatsNotFoundException extends AppGenericException {
    private static final String DEFAULT_CODE = "PlayerStatsNotFound";
    private static final String DEFAULT_MESSAGE = "The requested player stats were not found";

    public PlayerStatsNotFoundException() {
        super(DEFAULT_CODE, DEFAULT_MESSAGE);
    }

    public PlayerStatsNotFoundException(String id) {
        super(DEFAULT_CODE, "Player Stats with id: '" + id + "' were not found");
    }
}