package com.deep.movie.controller;

import com.deep.movie.dto.request.CreateShowRequest;
import com.deep.movie.dto.request.UpdateShowRequest;
import com.deep.movie.dto.response.ShowResponse;
import com.deep.movie.entity.Show;
import com.deep.movie.service.ShowService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/show")
@RequiredArgsConstructor
public class ShowController {

    private final ShowService showService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long createShow(@Valid CreateShowRequest createShowRequest) {
        return showService.createShow(createShowRequest);
    }

    @GetMapping("/{id}")
    public ShowResponse getShowById(@PathVariable Long id) {
        return showService.getShowById(id);
    }

    @GetMapping
    public List<ShowResponse> searchShows(@RequestParam String showDate){
        return showService.searchShows(showDate);
    }

    @PutMapping("/{id}")
    public void updateShow(@PathVariable Long id, UpdateShowRequest updateShowRequest) {
        showService.updateShow(id, updateShowRequest);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteShow(@PathVariable Long id) {
        return showService.deleteShow(id);
    }

}
