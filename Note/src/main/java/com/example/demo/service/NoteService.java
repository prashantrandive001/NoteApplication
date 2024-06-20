package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.demo.entity.Note;
import com.example.demo.repository.NoteRepository;

@Service
public class NoteService {
	
	@Autowired
	NoteRepository repo;
	
	public void savenote(Note n)
	{
		repo.save(n);
		
	}
	
	public List<Note> shownotes()
	{
		List<Note> notes = new ArrayList<>();
		repo.findAll().forEach(note -> notes.add(note));
		return notes;
	}
	

	public Note getnoteByid(int id )
	{
		return repo.findById(id).get();
	}
	
	public void deletenote(int id )
	{
		repo.deleteById(id);
		
	}
	
	
	
	
	
	
	
	

}
