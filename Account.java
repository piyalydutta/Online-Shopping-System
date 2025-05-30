public class Account {
    private final String email;
    private final String password;

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public boolean verifyPassword(String input) {
        return password.equals(input);
    }
}
