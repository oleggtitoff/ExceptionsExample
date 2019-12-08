package ua.training;

public class Main {

    public static void main(String[] args) {
        catchExceptionInInnerBlock();
        catchExceptionInOuterBlock();
        exceptionWithoutCatching();
    }

    private static void catchExceptionInInnerBlock() {
        printToErr("catchExceptionInInnerBlock:\n");

        try {
            printToErr(" 0");

            try {
                printToErr(" 1");
                if (true) {
                    throw new RuntimeException();
                }
                printToErr(" 2");
            } catch (RuntimeException e) {
                printToErr(" 3");
            } finally {
                printToErr(" 4");
            }

            printToErr(" 5");
        } catch (Exception e) {
            printToErr(" 6");
        } finally {
            printToErr(" 7");
        }

        printToErr(" 8\n\n");
    }

    private static void printToErr(String message) {
        System.err.print(message);
    }

    private static void catchExceptionInOuterBlock() {
        printToErr("catchExceptionInOuterBlock:\n");

        try {
            printToErr(" 0");

            try {
                printToErr(" 1");
                if (true) {
                    throw new Exception();
                }
                printToErr(" 2");
            } catch (RuntimeException e) {
                printToErr(" 3");
            } finally {
                printToErr(" 4");
            }

            printToErr(" 5");
        } catch (Exception e) {
            printToErr(" 6");
        } finally {
            printToErr(" 7");
        }

        printToErr(" 8\n\n");
    }

    private static void exceptionWithoutCatching() {
        printToErr("exceptionWithoutCatching:\n");

        try {
            printToErr(" 0");

            try {
                printToErr(" 1");
                if (true) {
                    throw new Error();
                }
                printToErr(" 2");
            } catch (RuntimeException e) {
                printToErr(" 3");
            } finally {
                printToErr(" 4");
            }

            printToErr(" 5");
        } catch (Exception e) {
            printToErr(" 6");
        } finally {
            printToErr(" 7");
        }

        printToErr(" 8");
    }

}
