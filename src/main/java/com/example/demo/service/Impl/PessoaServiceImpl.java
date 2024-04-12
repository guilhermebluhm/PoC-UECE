package com.example.demo.service.Impl;

import com.example.demo.model.Pessoa;
import com.example.demo.repository.EscolaRepository;
import com.example.demo.repository.PessoaRepository;
import com.example.demo.service.PessoaService;
import com.example.demo.utils.enums.ErrorTypes;
import com.example.demo.utils.misc.ClearningData;
import com.example.demo.utils.security.ObjectNotFoundInSearchOrRuntimeError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EscolaRepository escolaRepository;

    @Override
    public Pessoa savePessoa(Pessoa pessoa) {


        if (pessoa != null) {
            this.pessoaRepository.save(ClearningData.integratyCheck(pessoa));
        }

        throw new ObjectNotFoundInSearchOrRuntimeError(ErrorTypes.OBJETO_NULO.toString());

    }

    @Override
    public List<Pessoa> findAll() {
        if(this.pessoaRepository.findAll().isEmpty())
            return new ArrayList<>();
        else
            return this.pessoaRepository.findAll();
    }

    @Override
    public Pessoa findByIdPessoa(String id) {

        if (this.pessoaRepository.findById(Long.valueOf(id)).isPresent()) {
                return this.pessoaRepository.findById(Long.valueOf(id)).get();
        }
        throw new ObjectNotFoundInSearchOrRuntimeError(ErrorTypes.OBJETO_NAO_LOCALIZADO.toString());

    }

    @Override
    public Pessoa updatePessoa(String id, String telefone, String cargo) {
        Pessoa pessoa = this.findByIdPessoa(id);
        if(pessoa != null) {
            pessoa.setCargo(cargo);
            pessoa.setTelefone(telefone);
            ClearningData.correctDataInField(pessoa);
            this.pessoaRepository.save(pessoa);
        }
        throw new ObjectNotFoundInSearchOrRuntimeError(ErrorTypes.OBJETO_NAO_LOCALIZADO.toString());
    }

    @Override
    public void deletePessoa(String id) {
        this.pessoaRepository.deleteById(Long.valueOf(id));
    }
}
