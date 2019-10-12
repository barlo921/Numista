package com.barlo.numista.web.rest;

import com.barlo.numista.to.CollectionTO;
import com.barlo.numista.utils.exception.logic.NotFoundException;
import com.barlo.numista.web.AbstractController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/collections")
public class RestCollectionController extends AbstractController {

    @GetMapping("/get_subcollections")
    public List<CollectionTO> getSubcollections(@RequestParam int id) {
        return collectionUtil.convertToCollectionTO(collectionService.getSubLevel(id));
    }

    @GetMapping("/get_unique_name")
    public boolean getUniqueName(@RequestParam String name) {
        try {
            collectionService.getByName(name);
            return false;
        } catch (NotFoundException e) {
            return true;
        }
    }

}
