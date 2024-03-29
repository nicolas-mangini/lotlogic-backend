package app.security.model.response;

public class LoginResponse {
    private final TokenResponse tokenResponse;
    private final String dni;
    private final String firstName;
    private final String lastName;
    private final String role;
    private final Long parkingId;

    public LoginResponse(TokenResponse tokenResponse, String dni, String firstName, String lastName, String role, Long parkingId) {
        this.tokenResponse = tokenResponse;
        this.dni = dni;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.parkingId = parkingId;
    }

    public TokenResponse getTokenResponse() {
        return this.tokenResponse;
    }

    public String getDni() {
        return this.dni;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getRole() {
        return this.role;
    }

    public Long getParkingId() {
        return this.parkingId;
    }
}
