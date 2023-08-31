package com.thymeleaf.study.controller;

import com.thymeleaf.study.dto.PagingDto;
import com.thymeleaf.study.dto.QnaBoardDto;
import com.thymeleaf.study.dto.UserDto;
import com.thymeleaf.study.service.QnaBoardDetailService;
import com.thymeleaf.study.service.QnaBoardService;
import com.thymeleaf.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

    @Controller public class HomeController {
        UserService userService;
        QnaBoardService qnaBoardService;
        QnaBoardDetailService qnaBoardDetailService;



        @Autowired
        public HomeController(UserService userService, QnaBoardService qnaBoardService, QnaBoardDetailService qnaBoardDetailService) {

            this.userService = userService;
            this.qnaBoardService = qnaBoardService;
            this.qnaBoardDetailService = qnaBoardDetailService;
        }

        @RequestMapping("/")
        public String home() {
            return "index";
        }

        @RequestMapping("/bakery")
        public String go_bakery() {
            return "Bakery";
        }

        @RequestMapping("/cake")
        public String go_cake() {
            return "Cake";
        }


        @RequestMapping("/faqPage")
        public String faq() {
            return "faqpage";
        }

        @GetMapping("/login")
        public String goLogin() {
            return "login";
        }

        @PostMapping("/login")
        public String login() {


            return "login";
        }


        @PostMapping("/join")
        public String join(@ModelAttribute UserDto userDto) {
            System.out.println(userDto);
            userService.writeJoin(userDto);

            return "index";
        }

        @GetMapping("/join")
        public String goJoin() {
            return "join";
        }

        @PostMapping("/writePage")
        public String writePage(@ModelAttribute QnaBoardDto qnaBoardDto) {
            qnaBoardService.writeQnaBoard(qnaBoardDto);
            return "redirect:qnaBoardList";
        }
        @GetMapping("/writePage")
        public String goWritePage(){
            return "writePage";
        }




        @GetMapping("/post/{uid}")
        public String showPost(@PathVariable int uid, Model model){
            QnaBoardDto post = qnaBoardDetailService.selectQnaBoardDetail(uid);
            model.addAttribute("post", post);
            return "qnaBoard";

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
    }

