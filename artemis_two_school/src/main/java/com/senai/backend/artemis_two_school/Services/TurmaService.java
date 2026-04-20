package com.senai.backend.artemis_two_school.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.backend.artemis_two_school.Repositories.TurmaRepository;
import com.senai.backend.artemis_two_school.models.Turma;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public Long contarTurma() {
        return turmaRepository.count();
    }

    public Turma buscarTurma(Integer id) {
        return turmaRepository.findById(id).get();
    }

    public List<Turma> listarTurma() {
        return turmaRepository.findAll();
    }

    public Boolean deletarTurma(Integer id) {
        if (turmaRepository.existsById(id)) {
            turmaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Turma cadastrarTurma(Turma turma) {
        return turmaRepository.save(turma);
    }

    public Turma atualizarTurma(Integer id, Turma turma){
        Turma turmaRecuperada = buscarTurma(id);
        if (turmaRecuperada != null){
            turmaRecuperada.setId(id);
            if (turma.getTurma() != null){
                turmaRecuperada.setTurma(turma.getTurma());
                return turmaRepository.save(turmaRecuperada);
            }
        }
        return null;
    }
}

