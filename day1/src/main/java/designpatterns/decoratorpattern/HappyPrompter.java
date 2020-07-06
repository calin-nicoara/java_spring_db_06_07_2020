package designpatterns.decoratorpattern;

public class HappyPrompter implements Prompter{
    @Override
    public void giveYourRegards(final String message) {
        System.out.println("So happy yo say: " + message);
    }

    @Override
    public void dontCareAboutThis() {

    }
}
