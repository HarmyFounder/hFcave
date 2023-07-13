package com.hF.hFcave.controllers;

import com.hF.hFcave.models.Habit;
import com.hF.hFcave.models.User;
import com.hF.hFcave.services.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping("/habits")
public class HabitController {

    @Autowired
    private HabitService habitService;

    @GetMapping("/all")
    public List<Habit> getAll(){
        return habitService.getAll();
    }

    @GetMapping("/{id}")
    public Habit getCertain(@PathVariable("id") Habit habit){
        return habit;
    }

    @GetMapping("/byTag")
    public List<Habit> getByTag(@RequestParam String filter){
        return habitService.getByTag(filter);
    }

    @PostMapping("/new")
    public Habit create(@RequestBody Habit habit){
        return habitService.create(habit);
    }

    @PutMapping("/{id}/update")
    public Habit update(@PathVariable("id") Habit habitToBeUpdated, @RequestBody Habit updatedHabit){
        return habitService.update(habitToBeUpdated,updatedHabit);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Habit habit){
        habitService.delete(habit);
    }

    @PostMapping("/{id}/switchStatus")
    public void setDone(@PathVariable("id") Habit habit){
        habitService.setDone(habit);
    }

    @PostMapping("/setNotifications")
    public void setNotifications(@AuthenticationPrincipal User user, @RequestParam int hour, int minute) throws MessagingException {
        habitService.setNotifications(user,hour,minute);
    }

}
