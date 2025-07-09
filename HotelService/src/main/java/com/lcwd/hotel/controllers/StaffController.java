package com.lcwd.hotel.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/staffs")
public class StaffController {
    @GetMapping
    public ResponseEntity<List<String>> getStaffs() {
        // This method should return a list of staff members.
        // For now, we will return a placeholder response.
        List<String> staffs = List.of("Staff 1", "Staff 2", "Staff 3");
        return ResponseEntity.ok(staffs);

    }

}
