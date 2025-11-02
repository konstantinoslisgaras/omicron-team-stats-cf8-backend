package solipsismal.olympiacosfcapp.core.exceptions;

public class PlayerMatchNotFoundException extends AppGenericException {
    private static final String DEFAULT_CODE = "PlayerMatchNotFound";
    private static final String DEFAULT_MESSAGE = "The requested player-match was not found";

    public PlayerMatchNotFoundException() {
        super(DEFAULT_CODE, DEFAULT_MESSAGE);
    }

    public PlayerMatchNotFoundException(String id) {
        super(DEFAULT_CODE, "Player-Match: " + id + " was not found");
    }
}
