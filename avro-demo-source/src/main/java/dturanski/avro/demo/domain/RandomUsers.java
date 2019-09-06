package dturanski.avro.demo.domain;

import java.util.Random;
import java.util.UUID;

public class RandomUsers {
    private static Random random = new Random();

    private static String[] colors = {"Red", "Blue", "Green", "Yellow", "Orange", "Purple", "Pink"};

    public static User user() {

        return new User(UUID.randomUUID().toString(), random.nextInt(Integer.MAX_VALUE), colors[random.nextInt(colors.length)]);

    }
}