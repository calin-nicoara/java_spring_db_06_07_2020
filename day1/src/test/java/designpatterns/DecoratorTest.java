package designpatterns;

import org.junit.jupiter.api.Test;

import designpatterns.decoratorpattern.HappyPrompter;
import designpatterns.decoratorpattern.Prompter;
import designpatterns.decoratorpattern.SpaceBetweenPrompter;
import designpatterns.decoratorpattern.UpperCasePrompter;

public class DecoratorTest {

    @Test
    public void testDecorator() {
        Prompter prompter = new SpaceBetweenPrompter(new UpperCasePrompter(new HappyPrompter()));

        prompter.giveYourRegards("Hello there!");
    }
}
