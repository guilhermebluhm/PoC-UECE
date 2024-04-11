package com.example.demo.service.Impl;

import com.example.demo.model.Pessoa;
import com.example.demo.repository.EscolaRepository;
import com.example.demo.repository.PessoaRepository;
import com.example.demo.service.PessoaService;
import com.example.demo.utils.ClearningData;
import com.example.demo.utils.security.ObjectNotFoundInSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PessoaServiceImpl implements PessoaService {

    public static final String CLEAR_REGEX_CPF_CNPJ = "[\\.\\-\\/]";
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EscolaRepository escolaRepository;

    @Override
    public Pessoa saveModel(Pessoa pessoa) {

        String documento = pessoa.getDocumento();
        pessoa.setDocumento(documento.replaceAll(CLEAR_REGEX_CPF_CNPJ, ""));

        if(pessoa != null) {
            return this.pessoaRepository.save(ClearningData.teste(pessoa));
        }
        throw new ObjectNotFoundInSearch("objeto nulo passado");
    }

    @Override
    public List<Pessoa> findAll() {
        if(this.pessoaRepository.findAll().isEmpty())
            return new ArrayList<>();
        else
            return this.pessoaRepository.findAll();
    }

    @Override
    public Pessoa findById(String id) {
        return this.pessoaRepository.findById(Long.valueOf(id)).orElseThrow(RuntimeException::new);
    }

    @Override
    public Pessoa updateModel(String id, String numeroTelefone, String cargo) {
        Pessoa pessoa = this.findById(id);
        if(pessoa != null) {
            pessoa.setCargo(cargo);
            pessoa.setTelefone(numeroTelefone);
            this.pessoaRepository.save(pessoa);
        }
        throw new RuntimeException("erro geral da aplicacao - erro generico");
    }

    @Override
    public void deleteModel(String id) {
        this.pessoaRepository.deleteById(Long.valueOf(id));
    }
}
