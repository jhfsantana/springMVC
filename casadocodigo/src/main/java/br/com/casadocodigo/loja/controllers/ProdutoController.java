package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoDAO produtoDAO;

    @RequestMapping("/produtos/add")
    public String add() {
        return "produtos/add";
    }

    @RequestMapping("/produtos/save")
    public String save(Produto produto)
    {
        System.out.println(produto);
        produtoDAO.save(produto);
        return "produtos/ok";
    }
}
