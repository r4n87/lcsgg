package dev.saariselka.inlol;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UIController {
    @RequestMapping(value = "/UI", method = RequestMethod.GET)
    public ModelAndView goUI(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();

        // test 구문
//        List<String> resultList = new ArrayList<String>();
//        resultList.add("Zeus");
//        resultList.add("Oner");
//        resultList.add("Faker");
//        resultList.add("Gumayusi");
//        resultList.add("Keria");
//        modelAndView.addObject("resultList",resultList);

        // home 화면에서 검색 버튼 누르면 facade 선언하고, 생성된 facade로 데이터 가져와서 보여주는 식으로 하면 될 것 같은데
        // 앞부분이 뭔가 되어야 할 수 있을듯;

        modelAndView.setViewName("content/summoner");

        return modelAndView;
    }
}
