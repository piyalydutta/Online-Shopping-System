public class User {
    private final String username;
    private final Account account;

    public User(String username, Account account) {
        this.username = username;
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public Account getAccount() {
        return account;
    }
}
