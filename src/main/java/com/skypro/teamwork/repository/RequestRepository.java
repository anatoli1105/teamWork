package com.skypro.teamwork.repository;

import com.skypro.teamwork.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request,Long> {

}
