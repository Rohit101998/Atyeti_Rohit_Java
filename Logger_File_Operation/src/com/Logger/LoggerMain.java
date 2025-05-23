package com.Logger;

public class LoggerMain {
    public static void main(String[] args) {
        String logDir = "logs";

        try{
            LogAggregator aggregator  = new LogAggregator();
            aggregator.aggregateLogs(logDir);

            DatabaseHandler dbHandler = new DatabaseHandler();
            dbHandler.insertErrorLogs(aggregator.errorMap);
            dbHandler.insertWarningLogs(aggregator.warningMap);
            dbHandler.insertSuccessLogs(aggregator.successMap);

            System.out.println("Loges Processed and saved to database. ");
        } catch (Exception e) {
            ErrorLogger.log(e);
        }
    }
}
