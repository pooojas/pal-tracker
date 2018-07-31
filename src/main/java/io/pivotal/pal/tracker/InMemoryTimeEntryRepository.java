package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    Map<Long, TimeEntry> entries = new HashMap<Long, TimeEntry>();
    AtomicLong counter = new AtomicLong(0L);

    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(counter.incrementAndGet());
        entries.put(timeEntry.getId(), timeEntry);
        return entries.get(timeEntry.getId());
    }

    public TimeEntry find(Long id) {
        return entries.get(id);
    }

    @Override
    public void delete(Long id) {
        entries.remove(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(entries.values());
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        timeEntry.setId(id);
        entries.put(id,timeEntry);
        return entries.get(id);
    }
}
