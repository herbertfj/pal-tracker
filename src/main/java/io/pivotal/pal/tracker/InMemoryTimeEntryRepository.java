package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private Map<Long, TimeEntry> map = new HashMap<>();
    private long id = 1L;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(id);
        map.put(id, timeEntry);
        id++;
        return timeEntry;
    }

    @Override
    public TimeEntry find(long id) {
        return map.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(map.values());
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        TimeEntry existing = map.get(id);
        if (existing == null) return null;

        timeEntry.setId(id);
        map.put(id, timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry delete(long id) {
        return map.remove(id);
    }

}
