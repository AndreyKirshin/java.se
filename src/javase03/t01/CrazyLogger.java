package javase03.t01;


import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CrazyLogger {
    private StringBuilder logStorage;
    private SimpleDateFormat logTime = new SimpleDateFormat("dd-MM-YYYY : hh-mm");

    public CrazyLogger() {
        logStorage = new StringBuilder();
        logStorage.append("Welcome to Crazy Logger!\n");
    }

    public void writeToLog(String s) {
        logStorage.append(logTime.format(Calendar.getInstance().getTime()))
                .append(" * ")
                .append(s)
                .append("\n");
    }

    public String getLog() {
        return logStorage.toString();
    }

    public String findInLog(String request) {
        if (null == logStorage) {
            return "Log os empty";
        } else {
            String[] stringsOfLog = logStorage.toString().split("\n");
            StringBuilder containsRequest = new StringBuilder("This is found:\n");
            for (String s : stringsOfLog) {
                if (s.contains(request)) {
                    containsRequest.append(s)
                            .append("\n");
                }
            }
            return containsRequest.toString();
        }
    }

    public void printFoundInLog(String request) {
        System.out.println(findInLog(request));
    }

    public void printLog(){
        System.out.println(logStorage);
    }
}
