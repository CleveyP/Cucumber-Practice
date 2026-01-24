package org.example.spring;

import io.cucumber.java.Scenario;
import io.cucumber.spring.ScenarioScope;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@ScenarioScope
public class ScenarioContext {

    @Getter
    @Setter
    private Scenario scenario;
    private final Map<Object, Object> data = new HashMap<>();

    public <T> void setData(Object key, T value) {
        data.put(key, value);
    }

    @SuppressWarnings("unchecked")
    public <T> T getData(Object key) {
        if(data.containsKey(key))
            return (T) data.get(key);
        return null;
    }
}
