package br.upe.acs.utils;


import br.upe.acs.model.dto.RegistroDTO;
import br.upe.acs.utils.exceptions.AcsException;
import br.upe.acs.utils.exceptions.InvalidRegisterException;

import java.util.Random;


public class AuthUtils {

    public static void validatePassword(String password) {
        boolean withUppercase = false, withLowercase = false, withNumber = false, withSpecialChars = false;

        if (password.length() < 8) {
            throw new InvalidRegisterException("The password must be 8 or more characters!");
        }

        for (char characters : password.toCharArray()) {
            if (Character.isDigit(characters)) {
                withNumber = true;
            } else if (Character.isUpperCase(characters)) {
                withUppercase = true;
            } else if (Character.isLowerCase(characters)) {
                withLowercase = true;
            } else {
                withSpecialChars = true;
            }
        }

        if (!(withUppercase && withLowercase && withNumber && withSpecialChars)) {
            StringBuilder error = new StringBuilder("Invalid password: This password needs special chars");

            if (!withUppercase) {
                error.append(" upper case;");
            }
            if (!withLowercase) {
                error.append(" lower case;");
            }
            if (!withNumber) {
                error.append(" number;");
            }
            if (!withSpecialChars) {
                error.append(" specials;");
            }

            throw new InvalidRegisterException(error.toString());
        }
    }

    public static String generateVerificationCode() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder code = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(characters.length());
            char character = characters.charAt(index);
            code.append(character);
        }

        return code.toString();
    }

    public void validateAuthData(RegistroDTO authDto, boolean cpfExists, boolean emailExists) {
        checkUniqueData(cpfExists, emailExists);
        validatePassword(authDto.getSenha());
        validateInstitutionalEmail(authDto.getEmail());
        validateEnrollment(authDto.getMatricula());
        validatePeriod(authDto.getPeriodo());
    }

    private void checkUniqueData(boolean cpfExists, boolean emailExists) {
        String message = "";

        if (cpfExists) {
            message += "cpf";
        }

        if (emailExists) {
            message += "/email";
        }

        if (!message.isBlank()) {
            throw new AcsException("This data:  " + message + " already be registered!");
        }
    }

    private void validateInstitutionalEmail(String email) {
        if (!email.split("@")[1].equals("upe.br")) {
            throw new InvalidRegisterException("Invalid email! Please insert a valid institutional email");
        }
    }

    private void validateEnrollment(String enrollment) {

        if (!enrollment.matches("[0-9]+")) {
            throw new InvalidRegisterException("Please, insert a valid enrollment");
        }

        if (enrollment.length() < 4 || enrollment.length() > 9) {
            throw new InvalidRegisterException("Please, insert a valid enrollment");
        }

        if (Integer.parseInt(enrollment) < 1) {
            throw new InvalidRegisterException("Please, insert a valid enrollments");
        }

    }

    private void validatePeriod(int period) {
        if (period < 1 || period > 12) {
            throw new InvalidRegisterException("Please, insert a valid period");
        }
    }
}
