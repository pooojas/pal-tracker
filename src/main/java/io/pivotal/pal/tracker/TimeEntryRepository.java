package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
   TimeEntry create(TimeEntry timeEntry);

   TimeEntry find(Long id);

    void delete(Long id);

    List<TimeEntry> list();

    TimeEntry update(Long id, TimeEntry timeEntry);
}
