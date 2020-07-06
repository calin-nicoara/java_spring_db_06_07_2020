package designpatterns.decoratorpattern;

public abstract class PrompterDecorator implements Prompter {
    protected Prompter prompter;

    public PrompterDecorator(Prompter prompter) {
        this.prompter = prompter;
    }

    @Override
    public void giveYourRegards(final String message) {
        prompter.giveYourRegards(message);
    }

    @Override
    public void dontCareAboutThis() {
        prompter.dontCareAboutThis();
    }
}
