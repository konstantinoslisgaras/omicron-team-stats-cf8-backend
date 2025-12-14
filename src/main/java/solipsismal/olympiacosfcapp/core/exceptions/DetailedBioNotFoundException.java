package solipsismal.olympiacosfcapp.core.exceptions;

public class DetailedBioNotFoundException extends AppGenericException {

    private static final String DEFAULT_CODE = "DetailedBioNotFound";
    private static final String DEFAULT_MESSAGE = "The requested Detailed Biography was not found";

    public DetailedBioNotFoundException() {
        super(DEFAULT_CODE, DEFAULT_MESSAGE);
    }

    public DetailedBioNotFoundException(String id) {
        super(DEFAULT_CODE, "Detailed Biography: " + id + " was not found");
    }

    public DetailedBioNotFoundException(String id, String bioId) {
        super(DEFAULT_CODE, "Detailed Biography: " + id + " was not found for Entity: " + bioId);
    }
}
