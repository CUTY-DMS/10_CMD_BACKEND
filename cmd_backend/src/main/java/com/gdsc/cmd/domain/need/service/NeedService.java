package com.gdsc.cmd.domain.need.service;


import com.gdsc.cmd.domain.need.dto.NeedPostDto;
import com.gdsc.cmd.domain.need.entity.Need;
import com.gdsc.cmd.domain.need.repository.NeedRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NeedService {
    private final NeedRepositroy needRepositroy;

    @Autowired
    public NeedService(NeedRepositroy needRepositroy) { // RequiredArgsConstructor 를 대신 써도 됨.
        this.needRepositroy = needRepositroy;
    }

    public Long postneed(NeedPostDto postDto){
        Need need = new Need();
        need.setContent(postDto.getContent());
        need.setTitle(postDto.getTitle());
        return needRepositroy.save(need).getNeedId();
    }



}
