package ru.averkiev.springlesson.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.averkiev.springlesson.models.Person;
import ru.averkiev.springlesson.services.ItemsService;
import ru.averkiev.springlesson.services.PeopleService;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;
    private final ItemsService itemsService;

    @Autowired
    public PeopleController(PeopleService peopleService, ItemsService itemsService) {
        this.peopleService = peopleService;
        this.itemsService = itemsService;
    }

    @GetMapping()
    public String index(Model model) {
        // Получаем всех людей из DAO и передадим на отображение в Thymeleaf на представление
        model.addAttribute("people", peopleService.findAll());

        itemsService.findByName("Airpods");
        itemsService.findByOwner(peopleService.findOne(5));

        peopleService.test();

        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        // Извлекаем одного человека по id из DAO и передаем на отображение в представление
        model.addAttribute("person", peopleService.findOne(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
//        model.addAttribute("person", new Person());
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "people/new";
        }

        peopleService.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", peopleService.findOne(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "people/edit";
        }

        peopleService.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") int id) {
        peopleService.delete(id);
        return "redirect:/people";
    }


}