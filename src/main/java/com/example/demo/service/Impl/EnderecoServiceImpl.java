package com.example.demo.service.Impl;

import com.example.demo.model.Endereco;
import com.example.demo.repository.EnderecoRepository;
import com.example.demo.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository end;

    @Override
    public Endereco saveModel(Endereco endereco) {
        return this.end.save(endereco);
    }

    @Override
    public List<Endereco> findAll() {
        if(this.end.findAll().isEmpty())
            return new ArrayList<>();
        else
            return this.end.findAll();
    }

    @Override
    public Endereco findById(String id) {
        return this.end.findById(Long.valueOf(id)).orElseThrow(RuntimeException::new);
    }

    @Override
    public void updateModel(String id, String numero) {
        Endereco byId = this.findById(id);
        byId.setNumero(numero);
        this.end.save(byId);
    }

    @Override
    public void deleteModel(String id) {
        this.end.deleteById(Long.valueOf(id));
    }
}
