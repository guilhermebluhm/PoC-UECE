package com.example.demo.service.Impl;

import com.example.demo.model.Cidade;
import com.example.demo.repository.CidadeRepository;
import com.example.demo.service.CidadeService;
import com.example.demo.utils.ClearningData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CidadeServiceImpl implements CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Override
    public Cidade addCidade(Cidade cidade) {

        //comportamento ainda ha definir
        ClearningData checkData = new ClearningData();
        return this.cidadeRepository.save(cidade);

    }

    @Override
    public void removeCidade(String idCidade) {
        this.cidadeRepository.deleteById(Long.valueOf(idCidade));
    }
}
