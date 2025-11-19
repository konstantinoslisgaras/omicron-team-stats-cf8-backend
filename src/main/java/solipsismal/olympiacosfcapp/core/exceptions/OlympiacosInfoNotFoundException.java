package solipsismal.olympiacosfcapp.core.exceptions;

public class OlympiacosInfoNotFoundException extends AppGenericException {
    private static final String DEFAULT_CODE = "OlympiacosInfoNotFound";
    private static final String DEFAULT_MESSAGE = "The requested Olympiacos info was not found";

    public OlympiacosInfoNotFoundException() {
        super(DEFAULT_CODE, DEFAULT_MESSAGE);
    }
}
