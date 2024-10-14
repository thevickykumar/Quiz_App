package com.genie.quiz.controller;

import com.genie.quiz.dto.LoginRequest;
import com.genie.quiz.entity.QuizQuestion;
import com.genie.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class LoginController {


    @Autowired
    QuestionService questionService;

    // Hardcoded credentials for now
    private final String USERNAME = "user";
    private final String PASSWORD = "password";

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        if (USERNAME.equals(loginRequest.getUsername()) && PASSWORD.equals(loginRequest.getPassword())) {
            return "Login Successful!";
        } else {
            return "Invalid username or password";
        }
    }

    @GetMapping("/questions")
    public List<QuizQuestion> getQuestions() {
            return questionService.getAllQuestions();
    }

    @GetMapping("/questions/{subject}")
    public List<QuizQuestion> getQuestionsBySubject(@PathVariable String subject) {
        return questionService.getQuestionsBySubject(subject);
    }

    @PostMapping(value = "/save/{subject}", consumes = "application/json", produces = "application/json")
    public QuizQuestion saveQuestion(@PathVariable String subject,@RequestBody QuizQuestion question) {
        question.setSubject(subject); // Set the subject before saving the question
        return questionService.saveQuestion(question);
    }
}
