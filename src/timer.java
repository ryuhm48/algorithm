import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class timer {

	public static void main(String[] args) throws Exception {
		Timer scheduler = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				LocalDate nowDate = LocalDate.now();
				LocalTime nowTime = LocalTime.now();
				System.out.println(nowDate + " " + nowTime.getHour() + " " + nowTime.getMinute());
			}
		};
		scheduler.scheduleAtFixedRate(task, 1000, 60000);
	}
}
