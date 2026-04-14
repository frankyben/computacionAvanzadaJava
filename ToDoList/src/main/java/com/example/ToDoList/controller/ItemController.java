package com.example.ToDoList.controller;

import org.springframework.beans.factory.annotation.Autowired; //En la mandada a llamar se pone despues del example el nombre del proyecto
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ToDoList.model.Item;
import com.example.ToDoList.repository.ItemRepository;

@Controller
public class ItemController {
    //Con la funcion de autowired hacemos que busque dentro de nuestras dependencias
    //En este caso busca ItemRepository
    @Autowired
    private ItemRepository repository;

    // Con el get mapping mandamos a llamar el index
    @GetMapping("/") // Es como vamos a mandar a llamar la función en HTML en este caso /
    public String home(Model model){
        model.addAttribute("items", repository.findAll());
        model.addAttribute("item", new Item());
        return "index";
    }

    @PostMapping("/agregar")
    public String agregar(@ModelAttribute Item item){
        repository.save(item);
        // redirige de nuevo a la uta principal para ver la lista actual
        return "redirect:/";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        Item item = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID invalido"));
        model.addAttribute("items", repository.findAll());
        model.addAttribute("item", item); // Pasamos el item con sus datos al formulario
        return "index";
    }

    
}
