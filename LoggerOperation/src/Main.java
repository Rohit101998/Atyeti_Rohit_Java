import com.logger.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;


public class Main {
    public static void main(String[] args) {

        String logDir = "logs";
       // String logDir1 = "logs1";

        try {
//            File_Reader readFileLogger = new File_Reader();
//            readFileLogger.readData1(logDir);

            File_Reader_AtomicInt readerAtomicInt =new File_Reader_AtomicInt();
            readerAtomicInt.readData1(logDir);

//            Map<String, Integer> logCounts = readFileLogger.getLog_Counts();
//            LocalDateTime currentTimeStamp = LocalDateTime.now();

            ConcurrentMap<String, AtomicInteger> logCounts1 =readerAtomicInt.getLog_Counts();
            LocalDateTime currentTimeStamp = LocalDateTime.now();

           DatabaseHandler handler = new DatabaseHandler();
              handler.insertLoges(currentTimeStamp,logCounts1);


            //CopyOneToAnother readLogger = new CopyOneToAnother();
            //readLogger.writeFile(logDir, logDir1);

            System.out.println("Loges Processed and saved to database");


        }catch (LogProcessException | DatabaseProcessException e){
            ErrorLog.log(e);
            System.out.println("Error occurred"+e.getMessage());
        }catch (Exception e){
            ErrorLog.log(e);
            System.out.println("Unwanted error occurred"+e.getMessage());
        }
    }
}