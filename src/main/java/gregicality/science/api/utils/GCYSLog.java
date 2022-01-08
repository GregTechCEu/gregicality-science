package gregicality.science.api.utils;

import org.apache.logging.log4j.Logger;

public class GCYSLog {

    public static Logger logger;

    public GCYSLog() {

    }

    public static void init(Logger modLogger) {
        logger = modLogger;
    }
}
