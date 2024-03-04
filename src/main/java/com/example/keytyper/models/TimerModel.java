
package com.example.keytyper.models;

import java.util.*;

public class TimerModel extends BaseModel {
    @Override
    public void execute() {
        int j = (int) getParameters().getOrDefault("j", 0);
        Collection<Map<Object, Object>> data = (Collection<Map<Object, Object>>) getParameters().getOrDefault("data", new ArrayList<>());
        if (j != 0 || !data.isEmpty()) {
            int errors = (int) getParameters().getOrDefault("errors", 0);
            int errorsPrev = (int) getParameters().getOrDefault("errorsPrev", 0);
            int jPrev = (int) getParameters().getOrDefault("jPrev", 0);
            Map<Object, Object> map = new HashMap<>();
            map.put("errors", errors - errorsPrev);
            map.put("typed", j - jPrev);
            data.add(map);

            getParameters().put("data", data);

            getParameters().put("errorsPrev", errors);
            getParameters().put("jPrev", j);
        }
    }
}
