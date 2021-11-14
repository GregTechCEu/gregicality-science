package gregicality.science.api;

import org.apache.logging.log4j.Logger;

public class GCYSciLog {
    public static Logger logger;

    public GCYSciLog() {
    }

    public static void init(Logger modLogger) {
        logger = modLogger;
    }

}