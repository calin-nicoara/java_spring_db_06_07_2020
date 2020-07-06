package designpatterns.decoratorpattern;

public class UpperCasePrompter extends PrompterDecorator{
    public UpperCasePrompter(final Prompter prompter) {
        super(prompter);
    }

    @Override
    public void giveYourRegards(final String message) {
        prompter.giveYourRegards(message.toUpperCase());
    }
}
