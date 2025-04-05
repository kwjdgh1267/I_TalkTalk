package i_talktalk.i_talktalk.controller;

import i_talktalk.i_talktalk.entity.Quiz;
import i_talktalk.i_talktalk.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @PostMapping("/quiz/create")
    public String createQuiz() {
        return quizService.createQuiz();
    }


    @GetMapping("/quiz")
    public ResponseEntity<Quiz> getQuiz() {
        Quiz quiz = quizService.getNotSolvedQuiz();
        if(quiz==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(quiz);
    }

    @PatchMapping("/quiz/solve")
    public ResponseEntity<Void> solveQuiz(@RequestParam String quizId){
        quizService.solve(quizId);
        return ResponseEntity.ok().build();
    }




}
