package com.example.selfupdatingapp.controller;

import com.selfupdate.Update;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/update")
public class UpdateController {

    private final ResourceLoader resourceLoader;
    // private final Update update; // Include the Update class

    public UpdateController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
        // this.update = new Update(); // Initialize Update class
    }

    @GetMapping("/latest")
    public ResponseEntity<Resource> getLatestVersion() {
        Resource resource = resourceLoader.getResource("classpath:update/update-version-1.2.0.jar");
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"update-version-1.2.0.jar\"")
                .body(resource);
    }

    @SuppressWarnings("finally")
    @GetMapping("/check")
    public String checkForUpdates() {
        try {
            Update.checkForUpdates(); // Call the method from the Update class
        } catch(Exception e) {
            System.out.println(e.getStackTrace());
        } finally {
            return "Update check initiated!";
        }
    }
}
