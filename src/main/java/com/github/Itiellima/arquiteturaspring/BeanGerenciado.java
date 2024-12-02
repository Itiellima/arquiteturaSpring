package com.github.Itiellima.arquiteturaspring;

import com.github.Itiellima.arquiteturaspring.todos.TodoEntity;
import com.github.Itiellima.arquiteturaspring.todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Lazy
@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
//@Scope(WebApplicationContext.SCOPE_REQUEST)
//@Scope("request")
//@Scope("session")
//@Scope("application")
public class BeanGerenciado {

    @Autowired
    private TodoValidator validator;

    @Autowired
    public BeanGerenciado(TodoValidator validator) {
        this.validator = validator;
    }

    public void utilizar(){
        var todo = new TodoEntity();
        validator.validar(todo);
    }

    @Autowired
    public void setValidator(TodoValidator validator){
        this.validator = validator;
    }

}
