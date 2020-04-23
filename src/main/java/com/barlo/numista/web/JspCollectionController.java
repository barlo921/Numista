package com.barlo.numista.web;

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
@RequestMapping(value = "/numista/collection")
public class JspCollectionController extends AbstractController {

    @PostMapping
    public String updateOrCreate(HttpServletRequest request, @RequestParam(value = "subcollectionCheck", required = false) String subcollectionCheck) {
        Integer parentId = null;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (subcollectionCheck != null) {
            Collection topLevelCollection = collectionService.getByName(request.getParameter("subcollectionOf"));
            parentId = topLevelCollection.getId();
        }

        Collection collection = new Collection(
                request.getParameter("collectionName"),
                parentId);


        User user = (User) auth.getPrincipal();

        if (request.getParameter("id").isEmpty()) {
            collectionService.create(collection, user.getId());
        } else {
            collection.setId(getId(request));
            collectionService.update(collection, user.getId());
        }

        return "redirect:/numista";
    }
}
