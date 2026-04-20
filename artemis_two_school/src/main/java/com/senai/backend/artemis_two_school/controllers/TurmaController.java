package com.senai.backend.artemis_two_school.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.backend.artemis_two_school.Services.TurmaService;
import com.senai.backend.artemis_two_school.models.Turma;

@RestController
@RequestMapping("/turma")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @GetMapping("/contar-turmas")
    public Long contarPautas() {
        return turmaService.contarTurma();
    }

    @GetMapping("/buscar-turmas/{id}")
    public Turma buscarPauta(@PathVariable Integer id) {
        return turmaService.buscarTurma(id);
    }

    @GetMapping("/listar-turmas")
    public List<Turma> listarPautas() {
        return turmaService.listarTurma();
    }

    @DeleteMapping("/deletar-turma/{id}")
    public String deletarPaurta(@PathVariable Integer id) {
        if (turmaService.deletarTurma(id)) {
            return "Turma excluída com sucesso";
        }
        return "Falha na exclusão da turma";
    }

    @PostMapping("/salvar-turmas")
    public Turma cadastrarTurma(@RequestBody Turma turma) {
        return turmaService.cadastrarTurma(turma);
    }

    @PutMapping("atualizar-turma/{id}")
    public String atualizarTurma(@PathVariable Integer id, @RequestBody Turma turma) {
        if (turmaService.atualizarTurma(id, turma) != null) {
            return "Turma atualizada com sucesso";
        }
        return "Falha na atualização da turma";
    }

}
