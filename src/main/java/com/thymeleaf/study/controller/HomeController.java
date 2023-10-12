package com.thymeleaf.study.controller;

import com.thymeleaf.study.dto.*;
import com.thymeleaf.study.service.QnaBoardDetailService;
import com.thymeleaf.study.service.QnaBoardService;
import com.thymeleaf.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    UserService userService;
    QnaBoardService qnaBoardService;
    QnaBoardDetailService qnaBoardDetailService;


    @Autowired
    public HomeController(UserService userService, QnaBoardService qnaBoardService, QnaBoardDetailService qnaBoardDetailService) {

        this.userService = userService;
        this.qnaBoardService = qnaBoardService;
        this.qnaBoardDetailService = qnaBoardDetailService;
    }


    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/bakery")
    public String go_bakery() {
        return "Bakery";
    }

    @GetMapping("/cake")
    public String go_cake() {
        return "Cake";
    }

    @GetMapping("/faqPage")
    public String faq() {
        return "faqpage";
    }


    @GetMapping("/login")
    public String goLogin(Model model, @ModelAttribute LoginDto loginDto) {

        return "login";
    }

    @PostMapping("/login")
    public String login(@Validated @ModelAttribute LoginDto loginDto, BindingResult bindingResult, Model model, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("loginDto", loginDto);
            return "login";
        }

        LoginResponseDto loginResponseDto = userService.findUser(loginDto);

        if (loginResponseDto != null) {
            HttpSession httpSession = request.getSession(true);
            httpSession.setAttribute("userInfo", loginResponseDto);
            model.addAttribute("userInfo", loginResponseDto);

            return "redirect:/";
        } else {

            return "login";
        }


    }


    @PostMapping("/join")
    public String join(@Validated @ModelAttribute UserDto userDto, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("userDto", userDto);
            return "join";
        }
        userService.writeJoin(userDto);
        return "redirect:/";
    }

    @GetMapping("/join")
    public String goJoin(Model model) {

        model.addAttribute("userDto", new UserDto());
        return "join";
    }

    @PostMapping("/writePage")
    public String writePage(@SessionAttribute("userInfo") LoginResponseDto loginResponseDto ,@ModelAttribute QnaBoardDto qnaBoardDto) {
        System.out.println(loginResponseDto.getUid());
        qnaBoardDto.setUserUid(loginResponseDto.getUid());
        qnaBoardService.writeQnaBoard(qnaBoardDto);
        return "redirect:/qnaBoardList";
    }

    @GetMapping("/writePage")
    public String goWritePage() {
        return "writePage";
    }


    @GetMapping("/post/{uid}")
    public String showPost(@PathVariable int uid, Model model) {
        QnaBoardDto post = qnaBoardDetailService.selectQnaBoardDetail(uid);
        model.addAttribute("post", post);
        return "qnaBoard";

    }

    @PostMapping("/deletePost/{uid}")
    public String deletePost(@PathVariable int uid) {
        qnaBoardDetailService.deleteQnaBoard(uid);
        return "redirect:/qnaBoardList";
    }

    @GetMapping("/updatePost/{uid}")
    public String updatePost(@PathVariable int uid, Model model) {
        QnaBoardDto post = qnaBoardDetailService.selectQnaBoardDetail(uid);
        model.addAttribute("post", post);
        return "updatePage";
    }

    @PostMapping("/updatePost/{uid}")
    public String processUpdatePost(@PathVariable int uid, @ModelAttribute QnaBoardDto editePost) {
        editePost.setUid(uid);
        qnaBoardDetailService.updateQnaBoard(editePost);
        return "redirect:/qnaBoardList";
    }


    @RequestMapping("/qnaBoardList")
    public String boardList(Model model, @ModelAttribute PagingDto pagingDto) {
        long totalPostCount = qnaBoardService.getTotalPostCount(new PagingDto());
        int totalPages = (int) Math.ceil((double) totalPostCount / pagingDto.getCount());
        if (pagingDto.getPage() > totalPages) {
            pagingDto.setPage(totalPages);
        }

        if (pagingDto.getPage() < 1) {
            pagingDto.setPage(1);
        }

        pagingDto.setTotalPages(totalPages);


        pagingDto.setEndPage((int) Math.ceil((double) pagingDto.getPage() / pagingDto.getCount()) * pagingDto.getCount());
        pagingDto.setStartPage(pagingDto.getEndPage() - pagingDto.getCount() + 1);
        pagingDto.setOffset((pagingDto.getPage() - 1) * pagingDto.getCount());


        model.addAttribute("boardList", qnaBoardService.selectQnaBoard(pagingDto));
        model.addAttribute("pagingDto", pagingDto);

        return "qnaBoardList";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession httpSession = request.getSession(false);
        if(httpSession!=null){
            httpSession.invalidate();
        }
        return "redirect:/";
    }
}

