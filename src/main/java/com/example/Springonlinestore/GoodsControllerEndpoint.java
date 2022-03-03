package com.example.Springonlinestore;

import com.example.Springonlinestore.entities.Goods;
import com.example.Springonlinestore.repositories.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

@Controller
public class GoodsControllerEndpoint {
    @Autowired
    private GoodsRepository goodsRepository;

    private static List<Goods> goods;

    public static List<Goods> getGoods() {
        if (goods == null) {
            goods = new LinkedList<Goods>();
        }
        return goods;
    }
    @GetMapping(path = "/postGoodsToDatabase" )
    public String postGoodsToDatabase(Model model){
        model.addAttribute("goods", new Goods());
        return "editGoods";
    }
    @PostMapping(path = "postGoodsToDatabase")
    public Goods getGoods(@RequestBody Goods goods){
        return goodsRepository.save(goods);
    }


//    @PostMapping(value = "/postGoodsToDatabase")
//    public String postGoodsToDatabase(@Valid Goods goods, BindingResult result, Model model){
//        if (result.hasErrors()){
//            model.addAttribute("goods",goods);
//            return "editGoods";
//        }
//        goodsRepository.save(goods);
//        return "redirect:/viewGoods/" + goods.getId();
//    }






//    @PostMapping(value = "/postGoodsToDatabase", produces = MediaType.TEXT_PLAIN_VALUE)
//    @ResponseBody
//    public String postGoodsToDatabase(@Valid Goods goods, BindingResult result) {
//        if(result.hasErrors()){
//            String errorMessage = "";
//            for (FieldError error : result.getFieldErrors()){
//                errorMessage += error.getField() + ": " + error.getDefaultMessage() + "\n";
//            }
//            return errorMessage;
//        }
//        goodsRepository.save(goods);
//        return "Successfully saved!";
//    }

//    @GetMapping(path = "/getGoodsData" )
//    public String getGoodsData(Model model){
//        model.addAttribute("someAttribute", "TEXT TO THYMELEAF FROM JAVA");
//        return "viewWithData";
//    }

    @GetMapping(value = "/viewGoods")
    public String viewGoods(Model model){
        Iterable<Goods> goods= goodsRepository.findAll();
        model.addAttribute("goods", goods);
        return "viewGoods";
    }
}
