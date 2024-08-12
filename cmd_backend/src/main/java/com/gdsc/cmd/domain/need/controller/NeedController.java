package com.gdsc.cmd.domain.need.controller;

import com.gdsc.cmd.domain.need.dto.NeedPostDto;
import com.gdsc.cmd.domain.need.dto.NeedUpdateDto;
import com.gdsc.cmd.domain.need.domain.Need;
import com.gdsc.cmd.domain.need.domain.repository.NeedRepositroy;
import com.gdsc.cmd.domain.need.service.NeedService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Getter @Setter
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class NeedController {
    private final NeedService needService;
    private final NeedRepositroy needRepositroy;

    @PostMapping
    public ResponseEntity postNeed(@RequestBody @Validated NeedPostDto postDto){
        Long NeedId = needService.postneed(postDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(NeedId); //응답 상태:created, body 내용:NeedId
    }

    @GetMapping("/{needId}")
    public ResponseEntity readNeed(@PathVariable("needId")Long needId){

    }


    @PatchMapping("/{needId}")
    public ResponseEntity updateNeed(@PathVariable("needId") Long needId,
                                     @RequestBody @Validated NeedUpdateDto needUpdateDto)
    {
        needService.updateNeed(needUpdateDto,needId);
        return ResponseEntity.ok().build();
    }

    public Need findNeedId(Long needId){
        return needRepositroy.findById(needId)
                .orElseThrow(()->new )
    }


}
