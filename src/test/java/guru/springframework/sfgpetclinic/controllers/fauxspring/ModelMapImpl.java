package guru.springframework.sfgpetclinic.controllers.fauxspring;

import guru.springframework.sfgpetclinic.fauxspring.Model;

import java.util.HashMap;
import java.util.Map;

public class ModelMapImpl implements Model {

    Map<String, Object> map = new HashMap<>(1);

    public Map<String, Object> getMap() {
        return map;
    }

    @Override
    public void addAttribute(String key, Object o) {
        map.put(key, o);
    }

    @Override
    public void addAttribute(Object o) {
        // do nothing ...
    }

}
