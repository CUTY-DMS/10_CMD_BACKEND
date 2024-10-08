package com.gdsc.cmd.domain.user.controller;



import com.gdsc.cmd.domain.user.controller.dto.request.UserDetailRequest;
import com.gdsc.cmd.domain.user.controller.dto.response.UserDetailResponse;
import com.gdsc.cmd.domain.user.controller.dto.response.UserSearchResponse;
import com.gdsc.cmd.domain.user.service.AllUserSearchService;
import com.gdsc.cmd.domain.user.service.MyPageService;
import com.gdsc.cmd.domain.user.service.UpdateUserInfoService;
import com.gdsc.cmd.domain.user.service.UserDetailService;
import com.gdsc.cmd.global.findpassword.dto.SendResetPasswordEmailRequest;
import com.gdsc.cmd.global.findpassword.dto.SendResetPasswordEmailResponse;
import com.gdsc.cmd.global.findpassword.service.ExistsEmailService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final AllUserSearchService allUserSearchService;
    private final UserDetailService userDetailService;
    private final MyPageService myPageService;
    private final UpdateUserInfoService updateUserInfoService;
    private final ExistsEmailService existsEmailService;

    @GetMapping("")
    public List<UserSearchResponse> showAllUser() {
        return allUserSearchService.findAll();
    }

    @GetMapping("/{account-id}")
    public Optional<UserDetailResponse> searchUserDetail(@PathVariable("account-id") String accountId) {
        return userDetailService.findUserDetail(accountId);
    }

    @GetMapping("/myinfo")
    public Optional<UserDetailResponse> showMyInfo(){
        return Optional.ofNullable(myPageService.myInfo());
    }

    @PatchMapping("/{account-id}")
    public String changeMyInfo(@PathVariable("account-id") String accountId, UserDetailRequest userDetailRequest){
        updateUserInfoService.userInfoUpdate(accountId, userDetailRequest);
        return "Updated!!";
    }

  /*  //UUID 생성 및 이메일 전송
    @Operation(summary = "UUID 생성 및 이메일 전송")
    @PostMapping("/send-reset-password")
    public SendResetPasswordEmailResponse sendRestPassword(
            @Validated @RequestBody SendResetPasswordEmailRequest resetPasswordEmailRequest) {
            existsEmailService.checkUserByEmail(resetPasswordEmailRequest.getEmail());


    }
*/
}