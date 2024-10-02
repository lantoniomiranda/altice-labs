package pt.altice.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.json.Json;
import jakarta.json.JsonObject;

import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class LabSeqService {

    private final Map<Integer, Long> cache = new HashMap<>();

    public JsonObject getLabSeqResponse(int n) {
        long result = calculateLabSeq(n);

        return Json.createObjectBuilder()
                   .add("n", n)
                   .add("result", result)
                   .build();
    }

    private long calculateLabSeq(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 0;
        if (n == 3) return 1;

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        long result = calculateLabSeq(n - 4) + calculateLabSeq(n - 3);
        cache.put(n, result);

        return result;
    }
}
