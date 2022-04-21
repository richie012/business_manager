package ru.ml.Business.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ru.ml.Business.manager.entity.Businessmen;
import ru.ml.Business.manager.services.BusinessmenService;
import ru.ml.Business.manager.services.UserBusinessmenService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
public class BusinessmanController {
    private List<BusinessmenService> businessmanServices;

    @Autowired
    public void BusinessmenController(List<BusinessmenService> BusinessmenServices) { this.businessmanServices = BusinessmenServices; }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value =
            "/businessmen")
    @ResponseBody
    public List<Businessmen> getBusinessmens() {
        List<Businessmen> businessmens = new ArrayList<>();
        businessmanServices.forEach(businessmenService -> businessmens.addAll(businessmenService.getBusinessmen()));
        return businessmens;
    }

    @GetMapping(value = "/businessmen/{id}")
    @ResponseBody
    public Businessmen getBusinessmensById(@PathVariable("id") Long businessmenId) {
        Businessmen businessmen = businessmanServices.stream()
                .map(businessmenService -> businessmenService.getBusinessmenById(businessmenId))
                .filter(Objects::nonNull)
                .findFirst().orElseGet(null);
        return businessmen;
    }

    @GetMapping(value = "/businessmen")
    @ResponseBody
    public Businessmen getBusinessmensByParamId(@RequestParam("id") Long businessmenId) {
        Businessmen businessman = businessmanServices.stream()
                .map(businessmenService -> businessmenService.getBusinessmenById(businessmenId))
                .filter(Objects::nonNull)
                .findFirst().orElseGet(null);
        return businessman;

    }

    @GetMapping("/businessmensView")
    public ModelAndView getBusinessmenView() {
        List<Businessmen> businessmens = businessmanServices.stream()
                .map(businessmenService -> businessmenService.getBusinessmen())
                .flatMap(List::stream)
                .collect(Collectors.toList());
        ModelAndView modelAndView = new ModelAndView("businessmens");
        modelAndView.addObject("businessmens", businessmens);
        return modelAndView;
    }

    @GetMapping("/createBusinessmen/{name}")
    public ModelAndView createBusinessmen(@PathVariable String name) {
        businessmanServices.stream()
                .filter(businessmenService -> businessmenService instanceof UserBusinessmenService)
                .findFirst()
                .get().saveBusinessmen(name);
        return getBusinessmenView();
    }
}
