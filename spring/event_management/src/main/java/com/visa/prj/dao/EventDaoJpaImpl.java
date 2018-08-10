package com.visa.prj.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Event;
import com.visa.prj.entity.User;

@Repository
public class EventDaoJpaImpl implements EventDao {

	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addEvent(Event event) {
		em.persist(event);

	}

	@Override
	public List<Event> getOpenEvents() {
		//for scalar values/for joins we need to start with select, otherwise for entities starting from "from" will work(shortcut)
		TypedQuery<Event> query=em.createQuery("FROM Event e WHERE e.eventDate >= :today",Event.class);
		query.setParameter("today", new Date(), TemporalType.TIMESTAMP);
		return query.getResultList();
	}

	@Override
	public List<Event> getClosedEvents() {
		TypedQuery<Event> query=em.createQuery("FROM Event e WHERE e.eventDate <= :today",Event.class);
		query.setParameter("today", new Date(), TemporalType.TIMESTAMP);
		return query.getResultList();
	}

	@Override
	public Event getEventById(int id) {
		return em.find(Event.class, id);
		
	}

}
