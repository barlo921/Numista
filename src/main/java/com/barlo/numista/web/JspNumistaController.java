package com.barlo.numista.web;

import com.barlo.numista.model.Coin;
import com.barlo.numista.model.Collection;
import com.barlo.numista.to.CoinTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/numista")
public class JspNumistaController extends AbstractController {

    @GetMapping("/collection/create")
    public String createCollection(Model model) {
        model.addAttribute("collections", collectionService.getAllTopLevel());
        model.addAttribute("collection", new Collection());
        return "collectionForm";
    }

    @GetMapping("/collection/update")
    public String updateCollection(Model model, HttpServletRequest request) {
        model.addAttribute("collections", collectionService.getAllTopLevel());
        model.addAttribute("collection", collectionService.get(getId(request)));
        return "collectionForm";
    }

    @GetMapping("/coin/create")
    public String createCoin(Model model) {
        model.addAttribute("coin", new CoinTO());
        model.addAttribute("topLevelCollections", collectionService.getAllTopLevel());
        return "coinForm";
    }

    @GetMapping("/coin/update")
    public String updateCoin(Model model, HttpServletRequest request) {
        Coin coin = coinService.getById(getId(request));
        model.addAttribute("coin", coinUtil.createCoinTO(coin));
        model.addAttribute("topLevelCollections", collectionService.getAllTopLevel());
        if (coin.getCollection().getParentId() != null) {
            model.addAttribute("subcollections", collectionService.getSubLevel(coin.getCollection().getParentId()));
        } else {
            List<Collection> subcollections = collectionService.getSubLevel(coin.getCollection().getId());
            if (!subcollections.isEmpty()) {
                model.addAttribute("subcollections", subcollections);
            }
        }
        return "coinForm";
    }

}