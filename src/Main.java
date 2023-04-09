public class Main {
    public static void main(String[] args) {
        String login = "login_123";
        String password = "password_123";
        String confirmPassword = "password_123";

        try {
            boolean result = checkLoginAndPassword(login, password, confirmPassword);
            System.out.println(result);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean checkLoginAndPassword(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        if (!login.matches("[a-zA-Z0-9_]{1,20}")) {
            throw new WrongLoginException("Login is not valid");
        }

        if (!password.matches("[a-zA-Z0-9_]{1,20}")) {
            throw new WrongPasswordException("Password is not valid");
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Passwords do not match");
        }

        return true;
    }
}

