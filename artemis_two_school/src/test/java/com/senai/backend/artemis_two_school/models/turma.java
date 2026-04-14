package com.senai.backend.artemis_two_school.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "turma")
public class turma {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @OneToMany
    @JoinColumn(name = "id_turma")
    private List<aluno> aluno;

    public turma() {
    }

    public turma(Integer id, String nome, List<com.senai.backend.artemis_two_school.models.aluno> aluno) {
        this.id = id;
        this.nome = nome;
        this.aluno = aluno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<aluno> getAluno() {
        return aluno;
    }

    public void setAluno(List<aluno> aluno) {
        this.aluno = aluno;
    }
    
}
