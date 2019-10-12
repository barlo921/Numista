package com.barlo.numista.utils;

import com.barlo.numista.model.Collection;
import com.barlo.numista.to.CollectionTO;

import java.util.List;
import java.util.stream.Collectors;

public class CollectionUtil {

    public List<CollectionTO> convertToCollectionTO(List<Collection> collections) {
        return collections.stream()
                .map(collection -> createCollectionTO(collection))
                .collect(Collectors.toList());
    }

    public CollectionTO createCollectionTO(Collection collection) {
        return new CollectionTO(collection);
    }

}
