

package validation;


public class Validator {

    public static void validateNotEmpty(String value, String fieldName) throws ValidationException {
        if (value == null || value.trim().isEmpty()) {
            throw new ValidationException("Polje '" + fieldName + "' ne sme biti prazno!");
        }
    }

    public static void validatePositiveNumber(double value, String fieldName) throws ValidationException {
        if (value <= 0) {
            throw new ValidationException("Polje '" + fieldName + "' mora biti pozitivan broj!");
        }
    }

    public static void validateRange(int value, int min, int max, String fieldName) throws ValidationException {
        if (value < min || value > max) {
            throw new ValidationException("Polje '" + fieldName + "' mora biti između " + min + " i " + max + "!");
        }
    }

    public static void validateEmail(String email) throws ValidationException {
        if (email == null || !email.contains("@")) {
            throw new ValidationException("Email adresa nije ispravna!");
        }
    }
}
