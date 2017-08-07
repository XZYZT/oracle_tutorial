package oracle.javase.tutorial.datetime.iso.date;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TimeZoneId {
	public static void main(String[] args) {
		Path p = Paths.get("timeZones");
		
		try(BufferedWriter tzfile = Files.newBufferedWriter(p, StandardCharsets.US_ASCII)) {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	public static List<String> timeZones() {
		Set<String> allZones = ZoneId.getAvailableZoneIds();
		List<String> zoneList = new ArrayList<String>(allZones);
		Collections.sort(zoneList);
		return zoneList;
	}
	
	public static String printTimeZones(){
		return timeZones().stream().collect(Collectors.joining("\n"));
	}
	
	public static Map<String, String> printTimeZonesAndOffset(){
		LocalDateTime now = LocalDateTime.now();
		
		Map<String, String> zonesAndOffset = new HashMap<String, String>();
		
		for(String s : timeZones()){
			ZoneId zoneId = ZoneId.of(s);
			ZonedDateTime zoneTime = now.atZone(zoneId);
			ZoneOffset offset = zoneTime.getOffset();
			
			int secondsOfHour = offset.getTotalSeconds() % (60 * 60);
			
			if(secondsOfHour != 0){
				zonesAndOffset.put(zoneId.toString(), offset.toString());
			}
		}
		return zonesAndOffset;
	}
	
	
	public void writeTimeZones() {
		
	}
}
