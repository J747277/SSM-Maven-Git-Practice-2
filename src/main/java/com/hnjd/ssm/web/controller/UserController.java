package com.hnjd.ssm.web.controller;

import com.hnjd.ssm.domain.User;
import com.hnjd.ssm.service.IGradeService;
import com.hnjd.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

/**
 * @BelongsProject: SSMMavenGitPractice1
 * @BelongsPackage: com.hnjd.ssm.web.controller
 * @Author: Jiang Haiming
 * @CreateTime: 2020-04-13 17:23
 * @Description: user控制器
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IGradeService gradeService;

    @Autowired
    private ServletContext servletContext;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("users", userService.listAll());
        return "user/list";
    }

    @RequestMapping("/delete")
    public String delete(Long id) throws IOException {
        userService.delete(id);
        return "redirect:/user/list";
    }

    @RequestMapping("/input")
    public String input(Long id, Model model) {
        //请求中存在id则是修改更新操作
        if (!ObjectUtils.isEmpty(id)) {
            model.addAttribute("user", userService.get(id));
        } else {
            model.addAttribute("user", new User());
        }
        model.addAttribute("grades", gradeService.listAll());
        return "user/input";
    }

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(@Validated User user, BindingResult bindingResult, MultipartFile headImgFile, Model model) throws IOException {
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        for (ObjectError allError : allErrors) {
            System.out.println(allError);
        }
        //若数据校验失败则将所有数据校验的错误存入请求中
        if (allErrors.size() > 0) {
            model.addAttribute("errors", allErrors);
            return "redirect:/user/input";
        }
        //若不存在id则为保存操作
        if (ObjectUtils.isEmpty(user.getId())) {
            //用户未上传头像时为其设置一个默认头像
            if (!StringUtils.isEmpty(headImgFile.getOriginalFilename())) {
                user.setHeadImg(headImgUpload(headImgFile));
            } else {
                user.setHeadImg("defaultHeadImg.png");
            }
            userService.save(user);
        } else {
            //仅在用户更新头像时且之前的头像不是默认头像时将原头像删除
            if (!StringUtils.isEmpty(headImgFile.getOriginalFilename()) && !"defaultHeadImg.png".equals(user.getHeadImg())) {
                Files.deleteIfExists(Paths.get(servletContext.getRealPath("images/headImg/" + user.getHeadImg())));
            }
            if (!StringUtils.isEmpty(headImgFile.getOriginalFilename())) {
                user.setHeadImg(headImgUpload(headImgFile));
            }
            userService.update(user);
        }
        return "redirect:/user/list";
    }

    /**
     * 用户头像下载
     *
     * @param headImgFile 用户头像对象
     * @return 头像的新名称
     * @throws IOException
     */
    private String headImgUpload(MultipartFile headImgFile) throws IOException {
        String fileName = UUID.randomUUID().toString() + "." + StringUtils.getFilenameExtension(headImgFile.getOriginalFilename());
        if (!StringUtils.isEmpty(headImgFile.getOriginalFilename())) {
            String saveDir = servletContext.getRealPath("images/headImg");
            Files.copy(headImgFile.getInputStream(), Paths.get(saveDir, fileName));
        }
        return fileName;
    }
}