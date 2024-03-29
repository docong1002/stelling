package com.team1.stelling.controller;


import com.team1.stelling.aspect.annotation.LogStatus;
import com.team1.stelling.domain.dto.PageDTO;
import com.team1.stelling.domain.vo.Criteria;
import com.team1.stelling.domain.vo.IllustProfileVO;
import com.team1.stelling.domain.vo.IllustVO;
import com.team1.stelling.service.IllustProfileService;
import com.team1.stelling.service.IllustService;
import com.team1.stelling.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
@RequestMapping("/illust/*")
@RequiredArgsConstructor
public class IllustController {

    private final IllustProfileService illustProfileService;
    private final IllustService illustService;

    @LogStatus
    @GetMapping("/illustList")
    public void illustList(Criteria criteria){
    }

    @GetMapping("/illustChatPage")
    public void chatForm(){
    }

    @GetMapping("/illustCategoryList")
    public void illustCategoryList(){
    }

    @GetMapping("/illustPostingPage")
    public void PostingPage(){
    }

    @GetMapping("/illustUserInput")
    public void illustUserInput(){}

    @GetMapping("/register") public void register(){}

    @PostMapping("/register")
    public RedirectView register(IllustProfileVO illustProfileVO, RedirectAttributes rttr){

        illustProfileVO.setUserNumber(21L);

        illustProfileService.register(illustProfileVO);

//        rttr.addFlashAttribute("userNumber", illustProfileVO.getUserNumber());

        return new RedirectView("illustUserPage");
    }

    @GetMapping("/illustUserPage")
    public void illustUserPage(Long userNumber, Criteria criteria, Model model, @PageableDefault(page = 0, size = 10, sort = "illustNumber" ,direction = Sort.Direction.DESC) Pageable pageable){

        Page<IllustVO> list = illustService.getList(pageable);
        PageDTO.PageableDTO pageableDTO = new PageDTO.PageableDTO( (int)list.getTotalElements(),pageable);
        model.addAttribute("list", list);
        model.addAttribute("illustProfile", illustProfileService.get(21L));
//        model.addAttribute("illustProfile", illustProfileService.get(userNumber));
        model.addAttribute("pageableDTO", pageableDTO);
    }


    @GetMapping("/illustViewDetail")
    public void ViewDetail(){
    }




    @GetMapping("/uploadTest")
    public String readFile() {
        return "upload/uploadTest";
    }


/*
    @PostMapping("/uploadTest")
    public String uploadTest(@RequestParam("file") MultipartFile mfile, Model model) throws IOException, TikaException, SAXException {
        log.info("========file들어옴======");
*/
/*        try{
            InputStream fileStream  =  mfile.getInputStream();

        //버퍼 선언
        byte[] readBuffer = new byte[fileStream.available()];
        while (fileStream.read( readBuffer ) != -1){}
        log.info(new String(readBuffer)); //출력

        fileStream.close(); //스트림 닫기
    } catch (Exception e) {
       log.info(e.getMessage());
    }*//*


        String result = null;
        BodyContentHandler handler = new BodyContentHandler();
        AutoDetectParser parser = new AutoDetectParser();
        Metadata metadata = new Metadata();
        InputStream fileStream  =  mfile.getInputStream();
        try (InputStream stream = fileStream)
        {
        parser.parse(stream, handler, metadata);
//        log.info(handler.toString());
        result =handler.toString();
        }


        return result;
    }
*/



}
