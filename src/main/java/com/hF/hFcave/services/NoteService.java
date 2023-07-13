package com.hF.hFcave.services;

import com.hF.hFcave.models.Note;
import com.hF.hFcave.repositories.NoteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    public List<Note> getByTag(String filter){
        if(filter != null && !filter.isEmpty()){
        return noteRepository.findByTag(filter);
    }
        return noteRepository.findAll();
    }

    public Note create(Note note) {
        return noteRepository.save(note);
    }

    public Note update(Note noteToBeUpdated, Note updatedNote) {
        BeanUtils.copyProperties(updatedNote, noteToBeUpdated, "id");
        return noteRepository.save(noteToBeUpdated);
    }

    public void delete(Note note){
        noteRepository.delete(note);
    }

}
