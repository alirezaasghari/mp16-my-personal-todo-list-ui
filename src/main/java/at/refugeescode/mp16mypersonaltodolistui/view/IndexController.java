package at.refugeescode.mp16mypersonaltodolistui.view;

import at.refugeescode.mp16mypersonaltodolistui.controller.ToDoController;
import at.refugeescode.mp16mypersonaltodolistui.model.ToDo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    private ToDoController toDoController;

    public IndexController(ToDoController toDoController) {
        this.toDoController = toDoController;
    }

    @ModelAttribute("todos")
    List<ToDo> todos() {
        return toDoController.showAll();
    }

    @ModelAttribute("newToDo")
    ToDo toDo() {
        return new ToDo();
    }

    @PostMapping()
    String newToDo(ToDo toDo) {
        toDoController.addNewToDo(toDo);
        return "redirect:/";
    }

    @GetMapping("/done/{id}")
    String done(@PathVariable String id) {
        toDoController.done(id);
        return "redirect:/";
    }

    @GetMapping("{id}")
    String remove(@PathVariable String id) {
        toDoController.removeToDo(id);
        return "redirect:/";
    }

    @GetMapping
    String page() {
        return "index";
    }
}
