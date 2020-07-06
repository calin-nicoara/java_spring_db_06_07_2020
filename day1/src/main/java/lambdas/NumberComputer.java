package lambdas;

@FunctionalInterface
public interface NumberComputer {

    int calculate(int a, int b);

    default int reduce() {
        return 0;
    }
}
