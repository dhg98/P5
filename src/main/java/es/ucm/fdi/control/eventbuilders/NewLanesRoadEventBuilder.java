package es.ucm.fdi.control.eventbuilders;

import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.model.*;
import es.ucm.fdi.model.events.Event;
import es.ucm.fdi.model.events.NewDirtRoadEvent;
import es.ucm.fdi.model.events.NewLanesRoadEvent;

public class NewLanesRoadEventBuilder implements EventBuilder {

	@Override
	public Event parse(IniSection sec) {
		if (!"new_road".equals(sec.getTag()) || !"lanes".equals(sec.getValue("type"))) {
			return null;
		} else {
			try {
				int time = this.parseInt(sec, "time", 0);
				int maxspeed = parseInt(sec, "max_speed", 1);
				int length = parseInt(sec, "length", 1);
				int lanes = parseInt(sec, "lanes", 1);
				if (isValidId(sec.getValue("id"))) {
					if (isValidId(sec.getValue("src"))) {
						if (isValidId(sec.getValue("dest"))) {
							return new NewLanesRoadEvent(time, sec.getValue("id"), sec.getValue("src"),
									sec.getValue("dest"), maxspeed, length, lanes);
						} else {
							throw new IllegalArgumentException(
								"The id " + sec.getValue("dest")
								+ " contains invalid characters in the IniSection " + sec);
						}
					} else {
						throw new IllegalArgumentException(
								"The id " + sec.getValue("src")
								+ " contains invalid characters in the IniSection " + sec);
					}
				} else {
					throw new IllegalArgumentException(
								"The id " + sec.getValue("id") 
								+ " contains invalid characters in the IniSection " + sec);
				}
			} catch (IllegalArgumentException e) {
				throw new IllegalArgumentException("Error while building a NewLanesRoadEvent", e);
			}
		}
	}
}