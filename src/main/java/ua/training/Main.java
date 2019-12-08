package ua.training;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            throwDifferentExceptions();
        } catch (Throwable e) {
            printToErr("Exception " + e.getClass().toString() + " caught in main\n\n");
        }

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

    private static void throwDifferentExceptions() throws IOException,
            InterruptedException {
        if (System.currentTimeMillis() % 2 == 0) {
            throwIOException();
        } else {
            throwInterruptedException();
        }
    }

    private static void throwIOException() throws IOException {
        IOException exception = new FileNotFoundException();
        throw exception;
    }

    private static void throwInterruptedException() throws InterruptedException {
        throw new InterruptedException();
    }

}
