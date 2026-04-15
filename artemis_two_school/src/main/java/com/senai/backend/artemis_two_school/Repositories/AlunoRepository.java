package com.senai.backend.artemis_two_school.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.backend.artemis_two_school.models.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository <Aluno, Integer> {
    
}
