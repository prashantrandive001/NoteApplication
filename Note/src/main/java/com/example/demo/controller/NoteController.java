package com.example.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Note;
import com.example.demo.repository.NoteRepository;
import com.example.demo.service.NoteService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class NoteController {

	@Autowired
	NoteService serve;

	@Autowired
	NoteRepository repo;

	@RequestMapping("/")
	public String index() {

		return "home.html";
	}

	@RequestMapping("/index")
	public String index1() {
		return "home.html";
	}

	@RequestMapping("/home")
	public String home() {
		return "home.html";
	}

	@RequestMapping("/addnote")
	public String addnote() {
		return "addnote.html";
	}

	@RequestMapping("/savenote")
	public String savenote(Model m, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		Note n = new Note(title, content, new Date());
		serve.savenote(n);

		System.out.println("Data Inserted!!!...");
		
		
		
		return "noteadded.html";
	}

	@RequestMapping("/shownotes")
	public String shownotes(HttpServletResponse res, HttpServletRequest req, Model m) {
		/*
		 * System.out.println("From AllNotes Controller"); List<Note> notes =
		 * repo.findAll(); m.addAttribute("notes", notes);
		 * 
		 * 
		 * //m.addAttribute("name", "Prashant"); // HttpSession ss = req.getSession();
		 * // ss.setAttribute("notes",notes);
		 * 
		 * for(Note n : notes) { System.out.println(n); }
		 */
		m.addAttribute("notes", serve.shownotes());
		
		return "shownotes.jsp";
	}

	@RequestMapping("/deletenote")
	public String deletenote(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		System.out.println("From delete controller!!");

		int id = Integer.parseInt(req.getParameter("id"));
		serve.deletenote(id);
		
		return"notedeleted.html";
		
	}

	@RequestMapping("/updatenote")
	public String updatenote(HttpServletResponse res, HttpServletRequest req, Model m) throws IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Note n = serve.getnoteByid(id);
		req.setAttribute("n", n);
		

		m.addAttribute("n", n);
		
		
		
		/*
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		Note nn = new Note(title, content, new Date());
		serve.savenote(nn);*/

		System.out.println("from updatenote controller" + n);
		//res.sendRedirect("update.jsp");
		return "update.jsp?n";

	}

	
	@RequestMapping("/update")
	public String update(Model m, HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		System.out.println("from update controller");
		
		
		int id = Integer.parseInt(req.getParameter("id"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		Note n1 = new Note(id,title, content, new Date());
		repo.save(n1);

		System.out.println("Data Updated!!!..."+n1);
		return "noteupdated.html";
	}
	
	
	

}
