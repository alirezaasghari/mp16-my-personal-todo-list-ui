package at.refugeescode.mp16mypersonaltodolistui.controller;

import at.refugeescode.mp16mypersonaltodolistui.model.ToDo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ToDoController {

    @Value("${todo.url}")
    private String todoUrl;

    private RestTemplate restTemplate;

    public ToDoController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ToDo> showAll() {
        return Arrays.asList(restTemplate.getForObject(todoUrl, ToDo[].class));
    }

    public void addNewToDo(ToDo toDo) {
        restTemplate.postForObject(todoUrl, toDo, ToDo.class);
    }

    private void print(Object toDo) {
        System.out.println(toDo);
    }

    public void done(String id) {
        String url = todoUrl + "/" + id + "/done";
        restTemplate.put(url, ToDo.class);
    }

    public void removeToDo(String id) {
        String url = todoUrl + "/" + id;
        restTemplate.delete(url, ToDo.class);
    }


}
