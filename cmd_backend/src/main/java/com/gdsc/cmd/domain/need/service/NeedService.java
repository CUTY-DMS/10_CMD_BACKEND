package com.gdsc.cmd.domain.need.service;


import com.gdsc.cmd.domain.need.domain.type.ExceptionCode;
import com.gdsc.cmd.domain.need.dto.NeedPostDto;
import com.gdsc.cmd.domain.need.dto.NeedResponseDto;
import com.gdsc.cmd.domain.need.dto.NeedUpdateDto;
import com.gdsc.cmd.domain.need.domain.Need;
import com.gdsc.cmd.domain.need.domain.repository.NeedRepositroy;
import com.gdsc.cmd.domain.need.exception.BusinessLogicException;
import lombok.RequiredArgsConstructor;
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


    public NeedResponseDto findByNeedId(Long needId){
        Need need = findNeedId(needId);
        return NeedResponseDto.FindFromNeed(need);
    }


    @Transactional
    public Long updateNeed(NeedUpdateDto updateDto, Long needId ){
        Need need = findNeedId(needId);
        need.setTitle(updateDto.getTitle());
        need.setContent(updateDto.getContent());
        return needRepositroy.save(need).getNeedId();
    }

    public void deleteNeed(Long NeedId){
        needRepositroy.deleteById(NeedId);
    }



    public Need findNeedId(Long needId){
        return needRepositroy.findById(needId)
                .orElseThrow(()->new
                        BusinessLogicException(ExceptionCode.NEED_NOT_FOUND));
    }




}
