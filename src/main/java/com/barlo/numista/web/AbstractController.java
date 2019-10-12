package com.barlo.numista.web;

import com.barlo.numista.service.CoinService;
import com.barlo.numista.service.CollectionService;
import com.barlo.numista.utils.CoinUtil;
import com.barlo.numista.utils.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

public abstract class AbstractController {

    @Autowired
    protected CollectionService collectionService;
    @Autowired
    protected CoinService coinService;
    @Autowired
    protected CollectionUtil collectionUtil;
    @Autowired
    protected CoinUtil coinUtil;

    protected int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }

}
