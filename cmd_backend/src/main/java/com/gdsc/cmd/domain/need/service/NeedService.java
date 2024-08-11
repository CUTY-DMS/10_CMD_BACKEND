package com.gdsc.cmd.domain.need.service;


import com.gdsc.cmd.domain.need.dto.NeedPostDto;
import com.gdsc.cmd.domain.need.dto.NeedReadDto;
import com.gdsc.cmd.domain.need.dto.NeedUpdateDto;
import com.gdsc.cmd.domain.need.entity.Need;
import com.gdsc.cmd.domain.need.repository.NeedRepositroy;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class NeedService {
    private final NeedRepositroy needRepositroy;



    public Long postneed(NeedPostDto postDto){
        Need need = new Need();
        need.setContent(postDto.getContent());
        need.setTitle(postDto.getTitle());
        return needRepositroy.save(need).getNeedId();
    }

    public Need readneed(NeedReadDto readDto){
        return needRepositroy.findById(readDto.getNeedId()).get();
    }

    @Transactional
    public Long updateNeed(NeedUpdateDto updateDto, Long NeedId ){
        Need need = needRepositroy.findById(NeedId).orElseThrow(()->new RuntimeException("NeedId not found"));
        need.setTitle(updateDto.getTitle());
        need.setContent(updateDto.getContent());
        return needRepositroy.save(need).getNeedId();
    }

    public void deleteNeed(Long NeedId){
        needRepositroy.deleteById(NeedId);
    }





}
