package com.sample.transactionapp.demo.controller;

import com.sample.transactionapp.demo.model.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping("/new")
    public ResponseEntity<User> addUsers(@RequestBody User user) {
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping(value = "/addProfile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> addProfile(@Valid @RequestPart MultipartFile file) {
        uploadFile(file);
        return new ResponseEntity<>("success!", HttpStatus.OK);
    }

    // TODO : uploaded file should be save in /profile root folder
    private void uploadFile(MultipartFile file) {
        try {
            if (file.isEmpty()) return;

            Files.write(Path.of(""), file.getBytes());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
