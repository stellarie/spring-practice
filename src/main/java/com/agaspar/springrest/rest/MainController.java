package com.agaspar.springrest.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class MainController {

    @RequestMapping(value = "/mapping", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object getMapping(
            @RequestParam(value = "key", defaultValue = "key") String key,
            @RequestParam(value = "value", defaultValue = "value") String value) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(mapper.writeValueAsString(Map.of("key", key, "value", value))).toPrettyString();
    }

    @RequestMapping(value = "/comments/{path}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object getCommentByID(@PathVariable(name = "path") String path) {
        return new RestTemplate().getForObject("https://jsonplaceholder.typicode.com/comments/" + path, Object.class);
    }

    @RequestMapping(value = "/comments", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object getComments() {
        return new RestTemplate().getForObject("https://jsonplaceholder.typicode.com/comments/", Object.class);
    }
}
