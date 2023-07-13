package com.hF.hFcave.controllers;

import com.hF.hFcave.models.Note;
import com.hF.hFcave.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/all")
    public List<Note> getAll(){
        return noteService.getAll();
    }

    @GetMapping("/{id}")
    public Note getCertain(@PathVariable("id")Note note){
        return note;
    }

    @GetMapping("/byTag")
    public List<Note> getByTag(@RequestParam String filter){
        return noteService.getByTag(filter);
    }

    @PostMapping("/new")
    public Note create(@RequestBody Note note){
        return noteService.create(note);
    }

    @PutMapping("/{id}/update")
    public Note update(@PathVariable("id")Note noteToBeUpdated, @RequestBody Note updatedNote){
        return noteService.update(noteToBeUpdated,updatedNote);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Note note){
        noteService.delete(note);
    }

}
