package com.skypro.teamwork.repository;

import com.skypro.teamwork.model.Requests;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RequestRepository extends JpaRepository<Requests, Long> {


}
