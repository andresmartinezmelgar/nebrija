package fechas;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Instant ahora = Instant.now();
		//System.out.println(ahora);
		
		
		LocalDateTime dt = LocalDateTime.now();
		ZonedDateTime zdt = dt.atZone(ZoneId.of("Europe/Madrid"));
		Instant utc= zdt.toInstant();
		System.out.println(dt);
		System.out.println(utc);
		
	}
}




