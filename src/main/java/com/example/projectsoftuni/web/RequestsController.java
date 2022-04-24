package com.example.projectsoftuni.web;

import com.example.projectsoftuni.model.binding.RequestsBindingModel;
import com.example.projectsoftuni.model.binding.UserRegistrationBindingModel;
import com.example.projectsoftuni.model.entity.Requests;
import com.example.projectsoftuni.model.service.RequestsServiceModel;
import com.example.projectsoftuni.model.view.RequestsViewModel;
import com.example.projectsoftuni.model.view.UserViewModel;
import com.example.projectsoftuni.service.RequestsService;
import com.example.projectsoftuni.service.SellsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/request")
public class RequestsController {

    private final RequestsService requestsService;
    private final ModelMapper modelMapper;
    private final RequestsServiceModel requestsServiceModel;
    private final SellsService sellsService;
    private final RequestsViewModel requestsViewModel;

    public RequestsController(RequestsService requestsService, ModelMapper modelMapper, RequestsServiceModel requestsServiceModel, SellsService sellsService, RequestsViewModel requestsViewModel) {
        this.requestsService = requestsService;
        this.modelMapper = modelMapper;
        this.requestsServiceModel = requestsServiceModel;
        this.sellsService = sellsService;
        this.requestsViewModel = requestsViewModel;
    }


    @GetMapping("/add")
    public String addRequests(Model model) {

        if (!model.containsAttribute("requestsBindingModel")) {
            model.addAttribute("requestsBindingModel", new RequestsBindingModel());
        }

        return "requests-egg";
    }

    @PostMapping("/add")
    public String returnedPalletsConfirm(@Valid RequestsBindingModel requestsBindingModel, BindingResult bindingResult
            , RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("requestsBindingModel", requestsBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.requestsBindingModel", requestsBindingModel);

            return "redirect:add";
        }

        requestsService.add(modelMapper.map(requestsBindingModel, RequestsServiceModel.class));

        return "redirect:message_after_request";
    }

    @GetMapping("/message_after_request")
    public String messAfterRequest(Model model) {
        return "message-after-requests";
    }

    @GetMapping("/view")
    public String requestsView(Model model) {

      // List<Requests> requestsList = requestsService.getAllRequests();
      // List<LocalDate> allReqDate = requestsService.getAllRequests().stream().map(Requests::getRequestsDate).collect(Collectors.toList());
      // List<Sells> allSellBetweenRequestDate = sellsService.getAllSellsByPassedDate();
       List<Requests> withNewColumn = requestsService.getModifiedRequests();

       model.addAttribute("requests", withNewColumn);

        return "requests-view";
    }


    @GetMapping("/{id}/edit")
    public String editConfirm(@PathVariable Long id, Model model){

        RequestsViewModel requests = requestsService.findById(id);

        model.addAttribute("request", requests);

        return "edit-request-count";
    }

    @PostMapping("/{id}/edit")
    public String edit(@PathVariable Long id,
                       RequestsBindingModel requestsBindingModel){

        RequestsViewModel request = requestsService.findById(id);

        request.setCount(requestsBindingModel.getCount());
        requestsService.editRegisteredUser(request,id);



        return "edit-requests";
    }

    @GetMapping("/all-requests")
    public String viewUsers(Model model) {

        model.addAttribute("allRequests",requestsService.getModifiedRequests());

        return "edit-requests";

    }


    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        requestsService.deleteLocation(id);
        return "redirect:/home";
    }

}
