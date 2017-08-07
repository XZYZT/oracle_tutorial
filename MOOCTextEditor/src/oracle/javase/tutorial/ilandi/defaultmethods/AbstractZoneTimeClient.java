package oracle.javase.tutorial.ilandi.defaultmethods;

import java.time.ZonedDateTime;

public interface AbstractZoneTimeClient extends TimeClient{
	public ZonedDateTime getZonedDateTime(String zoneString);
}
