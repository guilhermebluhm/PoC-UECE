package com.example.demo.service.Impl;

import com.example.demo.model.Cidade;
import com.example.demo.repository.CidadeRepository;
import com.example.demo.service.CidadeService;
import com.example.demo.utils.enums.ErrorTypes;
import com.example.demo.utils.misc.ClearningData;
import com.example.demo.utils.security.ObjectNotFoundInSearchOrRuntimeError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CidadeServiceImpl implements CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Override
    public Cidade saveCidade(Cidade cidade) {

        if(cidade != null) {

            ClearningData.correctDataInField(null, cidade, null);
            return this.cidadeRepository.save(cidade);
        }

        throw new ObjectNotFoundInSearchOrRuntimeError(ErrorTypes.OBJETO_NULO.toString());
    }

    @Override
    public void deleteCidade(String idCidade) {
        if(this.cidadeRepository.findById(Long.valueOf(idCidade)).isPresent()){
            this.cidadeRepository.delete(this.cidadeRepository.findById(Long.valueOf(idCidade)).get());
        }
        throw new ObjectNotFoundInSearchOrRuntimeError(ErrorTypes.OBJETO_NAO_LOCALIZADO.toString());
    }

    @Override
    public List<Cidade> findAll() {
        List<Cidade> allCidades = this.cidadeRepository.findAll();
        if(!allCidades.isEmpty())
            return allCidades;
        else
            return new ArrayList<>();
    }
}
