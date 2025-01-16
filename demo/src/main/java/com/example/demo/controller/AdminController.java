package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    private final BookService bookService;

    // Pagina de adăugare a cărții
    @GetMapping("/add-book")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "admin/add-book"; // Asigură-te că fișierul HTML există
    }

    // Post pentru adăugarea cărții
    @PostMapping("/add-book")
    public String addBook(@ModelAttribute Book book) {
        bookService.createBook(book);
        return "redirect:/admin/books"; // După adăugare, redirectează la lista de cărți
    }

    // Pagina cu lista de cărți
    @GetMapping("/books")
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "admin/books"; // Asigură-te că fișierul HTML există
    }

    // Ștergere carte
    @PostMapping("/delete-book/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/admin/books"; // După ștergere, redirectează la lista de cărți
    }
}
