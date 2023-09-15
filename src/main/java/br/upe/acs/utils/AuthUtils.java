package br.upe.acs.utils;


import br.upe.acs.dominio.dto.RegistroDTO;

import java.util.Random;


public class AuthUtils {

    public void validateAuthData(RegistroDTO authDto, boolean cpfExists, boolean emailExists) throws AcsExcecao {
        checkUniqueData(cpfExists, emailExists);
        validatePassword(authDto.getSenha());
        validateInstitutionalEmail(authDto.getEmail());
        validateEnrollment(authDto.getMatricula());
        validatePeriod(authDto.getPeriodo());
    }

    private void checkUniqueData(boolean cpfExists, boolean emailExists) throws AcsExcecao {
        String message = "";

        if (cpfExists) {
            message += "cpf";
        }

        if (emailExists) {
            message += "/email";
        }

        if (!message.isBlank()) {
            throw new AcsExcecao("This data:  " + message + " already be registered!");
        }
    }

    public static void validatePassword(String password) throws AcsExcecao {
        boolean withUppercase = false, withLowercase = false, withNumber = false, withSpecialChars = false;

        if (password.length() < 8) {
            throw new AcsExcecao("The password must be 8 or more characters!");
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

            throw new AcsExcecao(error.toString());
        }
    }

    private void validateInstitutionalEmail(String email) throws AcsExcecao {
        if (!email.split("@")[1].equals("upe.br")) {
            throw new AcsExcecao("Invalid email! Please insert a valid institutional email");
        }
    }

    private void validateEnrollment(String enrollment) throws AcsExcecao {

        if (!enrollment.matches("[0-9]+")) {
            throw new AcsExcecao("Please, insert a valid enrollment");
        }

        if (enrollment.length() < 4 || enrollment.length() > 9) {
            throw new AcsExcecao("Please, insert a valid enrollment");
        }

        if (Integer.parseInt(enrollment) < 1) {
            throw new AcsExcecao("Please, insert a valid enrollments");
        }

    }

    private void validatePeriod(int period) throws AcsExcecao {
        if (period < 1 || period > 12) {
            throw new AcsExcecao("Pleas, insert a valid period");
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
}
