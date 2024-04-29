package org.shopping.backend.controller;

import org.shopping.backend.entity.Attendance;
import org.shopping.backend.entity.Member;
import org.shopping.backend.repository.AttendanceRepository;
import org.shopping.backend.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private MemberRepository memberRepository;

    @PostMapping("/save")
    public ResponseEntity<?> saveAttendance(@RequestParam int memberId) {

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found with id " + memberId));

        Attendance attendance = new Attendance();
        attendance.setMemberId(member.getMember_id());
        attendance.setAttendanceDate(LocalDate.now());

        attendanceRepository.save(attendance);

        return ResponseEntity.ok("Attendance recorded for member with ID: " + memberId);
    }
}