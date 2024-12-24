public class Verification {

    public static void validata(String login, String password, String confirmPassword) {
        try {
            validataLogin(login);
            validataPassword(confirmPassword, password);
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Валидация успешно пройдена! ");
        }
    }


    private static void validataLogin(String login) throws WrongLoginException {
        if (!login.matches("[a-zA-Z0-9_]+") || login.length() > 20) {
            throw new WrongLoginException("Ошибка: Длина логина должна быть меньше 20 символов, которая должна содержать только латинские буквы, цифры и знак подчеркивания!");
        }
    }

    private static void validataPassword(String password, String confirmPassword) throws WrongPasswordException {
        if (!password.matches("[a-zA-Z0-9_]+") || password.length() > 20) {
            throw new WrongPasswordException("Ошибка: Длина пароля должна быть меньше 20 символов, которая должна содержать только латинские буквы, цифры и знак подчеркивания!");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароль не совпадает");
        }
    }
}