package dio.exercicio.singleton;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ConfigManager {
    private final Map<String, String> configs = new HashMap<>();

    public void setConfig(String key, String value) {
        configs.put(key, value);
    }

    public String getConfig(String key) {
        return configs.get(key);
    }
}