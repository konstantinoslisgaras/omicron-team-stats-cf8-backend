package solipsismal.olympiacosfcapp.core.exceptions;

public class PlayerNotFoundException extends AppGenericException {
    private static final String DEFAULT_CODE = "PlayerNotFound";

    public PlayerNotFoundException(String code, String message) {
        super(code + DEFAULT_CODE, message);
    }
}
