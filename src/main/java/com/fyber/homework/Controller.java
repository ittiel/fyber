package com.fyber.homework;

import com.orbitz.consul.Consul;
import com.orbitz.consul.KeyValueClient;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @RequestMapping(value = "/setKey/", method = RequestMethod.POST)
    public void setValueForKey(@RequestParam String keyName, @RequestParam  String value) {
        System.out.println("Going to set value " + value +" for key: " + keyName);
        Consul client = Consul.builder().withUrl("http://consul:8500").build(); // connect on localhost
        KeyValueClient kvClient = client.keyValueClient();
        kvClient.putValue(keyName, value);
    }

    @RequestMapping(value = "/getKey/{keyName}", method = RequestMethod.GET)
    public String getValueForKey(@PathVariable String keyName) {
        System.out.println("Going to get value for key: " + keyName);
        Consul client = Consul.builder().withUrl("http://consul:8500").build(); // connect on localhost
        KeyValueClient kvClient = client.keyValueClient();
        return kvClient.getValueAsString(keyName).get();
    }
}
