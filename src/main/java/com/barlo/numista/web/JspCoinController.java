package com.barlo.numista.web;

import com.barlo.numista.model.Coin;
import com.barlo.numista.model.Collection;
import com.barlo.numista.model.users.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/numista/coin")
public class JspCoinController extends AbstractController {

    @PostMapping
    public String updateOrCreate(HttpServletRequest request, @RequestParam(value = "subcollectionCheck", required = false) String subcollectionCheck){

        Collection collection;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        //If Subcollection checkbox have been chosen then if there are subcollections?
        //For occasions when there is collections without subcollections, but subcollection checkbox have been chosen
        //Else: if subcollection check box have not been chosen get parameter from top level collection
        if (subcollectionCheck != null) {
            if (request.getParameter("collectionsList") == null) {
                collection = collectionService.get(Integer.parseInt(request.getParameter("topLevelCollectionsList")));
            } else {
                collection = collectionService.get(Integer.parseInt(request.getParameter("collectionsList")));
            }
        } else {
            collection = collectionService.get(Integer.parseInt(request.getParameter("topLevelCollectionsList")));
        }

        //Create coin and set parameters
        Coin coin = new Coin();

        coin.setName(request.getParameter("coinName"));
        coin.setCollection(collection);

        if (!request.getParameter("coinYear").isEmpty()){
            coin.setYear(Integer.parseInt(request.getParameter("coinYear")));
        }

        if (!request.getParameter("coinCountry").isEmpty()){
            coin.setCountry(request.getParameter("coinCountry"));
        }

        if (!request.getParameter("coinDescription").isEmpty()){
            coin.setDescription(request.getParameter("coinDescription"));
        }

        //What to do if it is a new coin or update coin
        User user = (User) auth.getPrincipal();

        if (request.getParameter("id").isEmpty()) {
            coinService.create(coin, collection.getId(), user.getId());
        } else {
            coin.setId(getId(request));
            coinService.update(coin, collection.getId(), user.getId());
        }

        return "redirect:/numista";
    }
}
