package gregicality.science.api;

import org.apache.logging.log4j.Logger;

public class GCYSLog {

    public static Logger logger;

    private GCYSLog() {
    }

    public static void init(Logger modLogger) {
        logger = modLogger;
    }
}