package com.usm.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * Created by csandu on 29.03.2017.
 */


public class LoggerClass {

    static final Logger rootLogger = LogManager.getRootLogger();

    public static void main(String[] args) {
        rootLogger.trace("trace");
        rootLogger.debug("debug");
        rootLogger.info("info");
        rootLogger.warn("warn");
        rootLogger.error("error");
        rootLogger.fatal("fatal");
    }

}
