package com.nsp.todo.controller;

import com.nsp.todo.model.dto.LanguageDto;
import com.nsp.todo.model.response.LanguageResponse;
import com.nsp.todo.model.response.Response;
import com.nsp.todo.model.response.ResponseModel;
import com.nsp.todo.service.LanguageService;
import com.nsp.todo.validation.group.AdvancedInfo;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/language")
public class LanguageController {

    private final LanguageService languageService;

    @GetMapping("/list")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseModel<List<LanguageResponse>> getAllLanguage(){
        return languageService.getAllLanguage();
    }
    
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseModel<LanguageResponse> getLanguageById(@PathVariable("id") Long id){
        return languageService.getLanguageById(id);
    }
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public Response addLanguage(@Validated(AdvancedInfo.class) @RequestBody LanguageDto languageDto){
        languageService.addLanguage(languageDto);
        return Response.getSuccess();
    }
    
    @PutMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public Response updateLanguage(@PathVariable("id") Long id, @Validated(AdvancedInfo.class) @RequestBody LanguageDto languageDto){
        languageService.updateLanguage(languageDto, id);
        return Response.getSuccess();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public Response deleteLanguage(@PathVariable("id") Long id){
        languageService.deleteLanguage(id);
        return Response.getSuccess();
    }

}
