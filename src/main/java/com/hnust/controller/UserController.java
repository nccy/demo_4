package com.hnust.controller;

import com.hnust.entity.Course;
import com.hnust.entity.User;
import com.hnust.service.CourseService;
import com.hnust.service.UerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author 长夜
 * @date 2023/4/11 14:48
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UerService uerService;
    @Autowired
    private CourseService courseService;
    @GetMapping("/login_page")
    public String login_page(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        //request.getSession().invalidate();
        return "login";
    }
    @PostMapping("/login_solve")
    public String login_solve(@RequestParam("email") String email, @RequestParam("password") String passWord, Model model, HttpServletRequest request) {
        User user=uerService.selectByEmail(email);
        if(user!=null&&passWord.equals(user.getPassWord()))
        {
            List<Course> courses=courseService.selectAll();
            //按照id升序排序
            Collections.sort(courses, new Comparator<Course>() {
                @Override
                public int compare(Course o1, Course o2) {
                    return o1.getSchools() - o2.getSchools();
                }
            });
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return "redirect:/course/main_page";
        }else{
            model.addAttribute("login_msg", "邮箱或密码错误");
            return "login";
        }
    }
}
