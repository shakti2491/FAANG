package concurrent.threadlocal;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserService
{
    private static ExecutorService threadPool = Executors.newFixedThreadPool(10);
    public static void main(String[] args) throws InterruptedException
    {
        for (int i = 0; i < 1000; i++)
        {
            int finalI = i;
            threadPool.submit(() -> {
                String birthDate = new UserService().birthDate(finalI);
                System.out.println(birthDate);
            });
        }
        Thread.sleep(1000);
    }
    public String birthDate(int userId) {
        LocalDate birthDate = LocalDate.now();
        DateTimeFormatter formatter = ThreadSafeFormatter.dateFormatThreadLocal.get();
        return formatter.format(birthDate);
    }
}


class ThreadSafeFormatter {
    public static ThreadLocal<DateTimeFormatter> dateFormatThreadLocal = ThreadLocal.withInitial(
            () -> DateTimeFormatter.ofPattern("MM/dd/YYYY"));
}
