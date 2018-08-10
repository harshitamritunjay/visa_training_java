package com.visa.prj.dao;

import java.util.List;

import com.visa.prj.entity.Event;

public interface EventDao {
	void addEvent(Event event);
	//feedback on open events and reg on closed events
	List<Event> getOpenEvents();
	List<Event> getClosedEvents();
	Event getEventById(int id);
	
}
