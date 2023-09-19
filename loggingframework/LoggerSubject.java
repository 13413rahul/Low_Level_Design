package loggingframework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoggerSubject {
    Map<Integer, List<LogObserver>> logObservers = new HashMap<>();

    protected void addObserver(int level,LogObserver logObserver){
        List<LogObserver> currentLogger = logObservers.getOrDefault(level, new ArrayList<>());
        currentLogger.add(logObserver);
        this.logObservers.put(level, currentLogger);
    }

    protected void removeObserver(LogObserver logObserver){
        for( Map.Entry<Integer, List<LogObserver>> entry : logObservers.entrySet()){
            entry.getValue().remove(logObserver);
        }
    }

    protected void notifyAllObserver(int level, String message){
        for( Map.Entry<Integer, List<LogObserver>> logObserver : logObservers.entrySet()){
            if (logObserver.getKey() == level){
                logObserver.getValue().forEach(observer -> observer.log(message));
            }
        }
    }
}
