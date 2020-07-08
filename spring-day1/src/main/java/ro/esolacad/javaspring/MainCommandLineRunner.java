package ro.esolacad.javaspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MainCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(final String... args) throws Exception {
        System.out.println("---------------------------");
        System.out.println();
        System.out.println(Arrays.toString(args));
        System.out.println();
        System.out.println();
        System.out.println("---------------------------");
    }
}
