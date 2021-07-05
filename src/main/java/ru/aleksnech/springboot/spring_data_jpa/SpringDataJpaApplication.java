package ru.aleksnech.springboot.spring_data_jpa;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.aleksnech.springboot.spring_data_jpa.entity.ClientCredit;


@SpringBootApplication
public class SpringDataJpaApplication {

    private static final Logger rootLogger = LogManager.getRootLogger();
    private static final Logger userLogger = LogManager.getLogger(SpringDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

//    rootLogger.("Debug log message");
//        logger.info("Info log message");
//        logger.error("Error log message");
//        logger.warn("Warn log message");
//        logger.fatal("Fatal log message");
//        logger.trace("Trace log message");
}
