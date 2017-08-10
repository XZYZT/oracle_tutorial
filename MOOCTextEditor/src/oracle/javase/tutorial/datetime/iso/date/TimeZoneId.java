package oracle.javase.tutorial.datetime.iso.date;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
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
		Path p = Paths.get("oracle_tutorial/datetime/timeZones");
		String format = "%35s %20s";
		writeTimeZones(p, printZonesAndOffset(format));
	}
	/**
	 * ���ʱ��
	 * @return
	 */
	public static List<String> timeZones() {
		Set<String> allZones = ZoneId.getAvailableZoneIds();
		List<String> zoneList = new ArrayList<String>(allZones);
		Collections.sort(zoneList);
		return zoneList;
	}
	
	public static String listToString(List<String> list, String delimiter){
		return list.stream().collect(Collectors.joining(delimiter));
	}
	
	/**
	 * ���д�ӡʱ��
	 * @return
	 */
	public static String printTimeZones(){
		return listToString(timeZones(),"\n");
	}
	/**
	 * ��һ��map�洢ʱ����ʱ��ƫ����
	 * @return
	 */
	public static Map<String, String> timeZonesAndOffset(){
		
		Map<String, String> zonesAndOffset = new HashMap<String, String>();
		
		for(String s : timeZones()){
			ZoneId zoneId = ZoneId.of(s);
			ZonedDateTime zoneTime = LocalDateTime.now().atZone(zoneId);
			ZoneOffset offset = zoneTime.getOffset();
			
			int secondsOfHour = offset.getTotalSeconds() % (60 * 60);
			
			if(secondsOfHour != 0){
				zonesAndOffset.put(zoneId.toString(), offset.toString());
			}
		}
		return zonesAndOffset;
	}
	
	/**
	 * ���д�ӡʱ���Ͷ�Ӧ��ƫ����
	 * @return
	 */
	public static String printZonesAndOffset(String format){
		List<String> list = new ArrayList<String>();
		for(String s : timeZonesAndOffset().keySet()){
			String zoneAndOffset = String.format(format, s, timeZonesAndOffset().get(s));
			list.add(zoneAndOffset);
		}
		return listToString(list, "\n");
	}
	/**
	 * ���ַ�����д��ָ���ļ����ļ�������ʱ�Զ�����
	 * @param p
	 * @param out
	 */
	public static void writeTimeZones(Path p, String out) {
		try(BufferedWriter tzfile = Files.newBufferedWriter(p, StandardCharsets.US_ASCII)) {
			tzfile.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
