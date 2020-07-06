package designpatterns.decoratorpattern;

public class SpaceBetweenPrompter extends PrompterDecorator{
    public SpaceBetweenPrompter(final Prompter prompter) {
        super(prompter);
    }

    @Override
    public void giveYourRegards(final String message) {
        System.out.println("------------------------");
        prompter.giveYourRegards(message);
        System.out.println("------------------------");
    }
}
