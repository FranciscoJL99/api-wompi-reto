package api.co.wompi.utils;

import com.github.javafaker.Faker;

public class GenerateData {
    private static final Faker faker = new Faker();

    public static String correoAleatorio() {
        return faker.internet().emailAddress();
    }

    public static String referenciaAleatoria() {
        return "ref-" + faker.number().digits(6);
    }
}