package enums;

import java.util.HashMap;
import java.util.Map;

public enum Others {
    RED;

    private static final Map<Others, String> valuesMap = new HashMap<>();

    static {
        valuesMap.put(RED, "rgba(255, 76, 76, 1)");
    }

    public String getValue() {
        return valuesMap.get(this);
    }
}