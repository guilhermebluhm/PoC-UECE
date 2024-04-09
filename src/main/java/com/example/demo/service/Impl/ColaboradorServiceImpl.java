package com.example.demo.service.Impl;

import com.example.demo.model.Colaborador;
import com.example.demo.model.Escola;
import com.example.demo.repository.ColaboradorRepository;
import com.example.demo.repository.EscolaRepository;
import com.example.demo.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ColaboradorServiceImpl implements ColaboradorService {

    @Autowired
    private ColaboradorRepository colab;

    @Autowired
    private EscolaRepository esc;

    @Override
    public Colaborador saveModel(Colaborador colaborador) {
        return this.colab.save(colaborador);
    }

    @Override
    public List<Colaborador> findAll() {
        if(this.colab.findAll().isEmpty())
            return new ArrayList<>();
        else
            return this.colab.findAll();
    }

    @Override
    public Colaborador findById(String id) {
        return this.colab.findById(Long.valueOf(id)).orElseThrow(RuntimeException::new);
    }

    @Override
    public void updateModel(String id, String numeroTelefone, String cargo) {
        Colaborador byId = this.findById(id);
        byId.setCargo(cargo);
        byId.setTelefone(numeroTelefone);
        this.colab.save(byId);
    }

    @Override
    public void deleteModel(String id) {
        this.colab.deleteById(Long.valueOf(id));
    }

    @Override
    public void adicionarColaboradorEscola(String idColaborador, String idEscola) {

        Colaborador byId = this.findById(idColaborador);
        Escola escola = this.esc.findById(Long.valueOf(idEscola)).orElseThrow(RuntimeException::new);
        byId.addEscola(escola);
        this.colab.save(byId);

    }
}
