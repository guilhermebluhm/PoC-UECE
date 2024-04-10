package com.example.demo.service.Impl;

import com.example.demo.model.Cidade;
import com.example.demo.repository.CidadeRepository;
import com.example.demo.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CidadeServiceImpl implements CidadeService {

    @Autowired
    private CidadeRepository cid;

    @Override
    public Cidade adicionarCidade(Cidade cidade) {
        return this.cid.save(cidade);
    }

    @Override
    public void removerCidade(String idCidade) {
        this.cid.deleteById(Long.valueOf(idCidade));
    }
}
