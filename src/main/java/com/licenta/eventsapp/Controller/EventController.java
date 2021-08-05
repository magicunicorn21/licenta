package com.licenta.eventsapp.Controller;


import com.licenta.eventsapp.Exceptions.ResourceNotFoundException;
import com.licenta.eventsapp.Model.Event;
import com.licenta.eventsapp.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/home")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/events")
    public List<Event> getAllEvents() {
        List<Event> evs = eventRepository.findAll();
        evs.sort(Comparator.comparing(Event::getDate));
        return evs;
    }

    @PostMapping("/events")
    public Event addEvent(@RequestBody Event e) {
        return eventRepository.save(e);
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Event e = eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event with id: " + id + "does not exist"));
        return ResponseEntity.ok(e);
    }

    @PutMapping("/events/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event newE) {
        Event e = eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event with id: " + id + "does not exist"));
        e.setName(newE.getName());
        e.setDate(newE.getDate());
        e.setAddress(newE.getAddress());
        e.setCity(newE.getCity());
        e.setCountry(newE.getCountry());
        e.setLatitude(newE.getLatitude());
        e.setLongitude(newE.getLongitude());
        e.setDescription(newE.getDescription());
        Event updatedE = eventRepository.save(e);
        return ResponseEntity.ok(updatedE);
    }

}
