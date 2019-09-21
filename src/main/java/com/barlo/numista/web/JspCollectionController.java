package com.barlo.numista.web;

import com.barlo.numista.model.Collection;
import com.barlo.numista.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
@RequestMapping(value = "/numista/collection")
public class JspCollectionController {

    @Autowired
    private CollectionService service;

    @PostMapping()
    public String updateOrCreate(HttpServletRequest request, @RequestParam(value = "subcollectionCheck", required = false) String subcollectionCheck) {
        Integer parentId = null;

        if (subcollectionCheck != null) {
            Collection topLevelCollection = service.getByName(request.getParameter("subcollectionOf"));
            parentId = topLevelCollection.getId();
        }

        Collection collection = new Collection(
                request.getParameter("collectionName"),
                parentId);

        if (request.getParameter("id").isEmpty()) {
            service.create(collection);
        } else {
            collection.setId(getId(request));
            service.update(collection);
        }

        return "redirect:/numista";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }
}
