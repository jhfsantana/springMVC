package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.infra.FileSaver;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;
import br.com.casadocodigo.loja.validations.ProdutoValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoDAO produtoDAO;

    @Autowired
    private FileSaver fileSaver;
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new ProdutoValidation());
    }

    @RequestMapping("/add")
    public ModelAndView add(Produto produto) {
        ModelAndView modelAndView = new ModelAndView("produtos/add");
        modelAndView.addObject("tipos", TipoPreco.values());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(MultipartFile sumario, @Validated Produto produto, BindingResult bindingResult, RedirectAttributes redirectAttributes)
    {
        if(bindingResult.hasErrors())
        {
            return add(produto);
        }

        String write = fileSaver.write("arquivo-sumario", sumario);

        produto.setSumarioPath(write);
        System.out.println(sumario.getOriginalFilename());
        System.out.println(produto);;
        produtoDAO.save(produto);
        redirectAttributes.addFlashAttribute("success", "Produto "+ produto.getTitulo() +" cadastrado comsucesso");
        return new ModelAndView("redirect:/produtos");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView list(){
        List<Produto> produtos = produtoDAO.findALl();
        ModelAndView modelAndView = new ModelAndView("produtos/list");
        modelAndView.addObject("produtos", produtos);

        return modelAndView;
    }

    @RequestMapping("/detalhes/{id}")
    public ModelAndView details(@PathVariable("id") Integer id){
        Produto produto = produtoDAO.findById(id);
        System.out.print(produto);
        ModelAndView modelAndView = new ModelAndView("produtos/details");
        modelAndView.addObject("produto", produto);

        return modelAndView;
    }
}
