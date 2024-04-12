package com.example.demo.service.Impl;

import com.example.demo.model.Cidade;
import com.example.demo.repository.CidadeRepository;
import com.example.demo.service.CidadeService;
import com.example.demo.utils.enums.ErrorTypes;
import com.example.demo.utils.misc.ClearningData;
import com.example.demo.utils.security.ObjectNotFoundInSearchOrRuntimeError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CidadeServiceImpl implements CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Override
    public Cidade saveCidade(Cidade cidade) {

        if(cidade != null) {
            ClearningData.correctDataInField(null, cidade);
            return this.cidadeRepository.save(cidade);
        }

        throw new ObjectNotFoundInSearchOrRuntimeError(ErrorTypes.OBJETO_NULO.toString());
    }

    @Override
    public void deleteCidade(String idCidade) {
        this.cidadeRepository.deleteById(Long.valueOf(idCidade));
    }
}
