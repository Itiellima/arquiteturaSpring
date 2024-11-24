package com.github.Itiellima.arquiteturaspring.todos;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("todos")
public class todoController {

    private TodoService service;

    public todoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public TodoEntity salvar(@RequestBody TodoEntity todo){
        return this.service.salvar(todo);
    }

    @PutMapping("{id}")
    public void atualizarStatus(@PathVariable("id") Integer id, @RequestBody TodoEntity todo){
        todo.setId(id);

        service.atualizarStatus(todo);
    }

    @GetMapping("{id}")
    public TodoEntity buscar(@PathVariable("id") Integer id){
        return service.buscarPorId(id);
    }

}