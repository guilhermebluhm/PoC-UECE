package com.example.demo.service.Impl;

import com.example.demo.model.Pessoa;
import com.example.demo.repository.EscolaRepository;
import com.example.demo.repository.PessoaRepository;
import com.example.demo.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository colab;

    @Autowired
    private EscolaRepository esc;

    @Override
    public Pessoa saveModel(Pessoa colaborador) {
        return this.colab.save(colaborador);
    }

    @Override
    public List<Pessoa> findAll() {
        if(this.colab.findAll().isEmpty())
            return new ArrayList<>();
        else
            return this.colab.findAll();
    }

    @Override
    public Pessoa findById(String id) {
        return this.colab.findById(Long.valueOf(id)).orElseThrow(RuntimeException::new);
    }

    @Override
    public void updateModel(String id, String numeroTelefone, String cargo) {
        Pessoa byId = this.findById(id);
        byId.setCargo(cargo);
        byId.setTelefone(numeroTelefone);
        this.colab.save(byId);
    }

    @Override
    public void deleteModel(String id) {
        this.colab.deleteById(Long.valueOf(id));
    }
}
