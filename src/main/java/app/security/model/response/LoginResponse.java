package app.security.model.response;

public class LoginResponse {
    private final TokenResponse tokenResponse;
    private final String firstName;
    private final String lastName;
    private final String role;

    public LoginResponse(TokenResponse tokenResponse, String firstName, String lastName, String role) {
        this.tokenResponse = tokenResponse;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public TokenResponse getTokenResponse() {
        return this.tokenResponse;
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
}