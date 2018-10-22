package com.example.NumberGame.controller;

import com.example.NumberGame.Log;
import com.example.NumberGame.dto.RequestDTO;
import com.example.NumberGame.dto.ResponseDTO;
import com.example.NumberGame.entity.RequestTable;
import com.example.NumberGame.repository.RequestTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.Random;

@Controller
public class TestController {

    private RequestTableRepository requestTableRepository;

    public TestController(){

    }

    @Autowired //DAO will be set in controller
    public TestController(RequestTableRepository requestTableRepository) {
        this.requestTableRepository = requestTableRepository;
    }

    private static  int gameNumber;

    static {
        Random random = new Random();
        gameNumber = random.nextInt(10)+1;
    }

    /*@GetMapping("/doGame")
    @ResponseBody //method could be return Json
    public ResponseDTO play(@ModelAttribute RequestDTO requestDTO) {
        RequestTable requestTable = new RequestTable();
        requestTable.setGuess(requestDTO.getNumber());
        requestTable.setReal(gameNumber);
        requestTableRepository.save(requestTable);
        return new ResponseDTO(requestDTO.getNumber() == gameNumber, LocalDateTime.now(), requestTable);
    }*/

    @PostMapping("/doGame")
    @ResponseBody
    @Log(enabled = false)
    public ResponseDTO play(@ModelAttribute RequestDTO requestDTO){
        RequestTable requestTable = new RequestTable();
        requestTable.setGuess(requestDTO.getNumber());
        requestTable.setReal(gameNumber);
        requestTableRepository.save(requestTable);
        return new ResponseDTO(requestDTO.getNumber() == gameNumber, LocalDateTime.now(), requestTable);
    }

    @PostMapping("/test")
    @ResponseBody
    public void test(){
        requestTableRepository.save(new RequestTable(5, 6));
        requestTableRepository.save(new RequestTable(100, 101));
    }

    private String stringTest(){
        return "I'm here";
    }

    protected int intTest(String question){
        return 42;
    }
}
