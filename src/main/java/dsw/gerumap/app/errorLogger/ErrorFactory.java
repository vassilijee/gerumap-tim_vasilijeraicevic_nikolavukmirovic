package dsw.gerumap.app.errorLogger;

import dsw.gerumap.app.core.ErrorLogger;

public class ErrorFactory {
    public ErrorLogger newLogger(String name) {
        if (name.equals("ConsoleLogger")) {
            return new ConsoleLogger();
        } else if (name.equals("FileLogger")) {
            return new FileLogger();
        }
        return null;
    }
}
