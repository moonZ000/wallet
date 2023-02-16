package wallet.controller;


import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import wallet.pojo.entity.Detail;
import wallet.service.DetailService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Zz
 * @since 2023-02-16
 */
@RestController
@RequestMapping("/detail")
public class DetailController {


    @Autowired
    private DetailService detailService;

    /**
     * 查询用户钱包金额变动明细的接口
     * @param userId
     * @return
     */
    @GetMapping("/all/{userId}")
    public String detailView(@PathVariable("userId") int userId) {

        List<Detail> details = detailService.viewDetail(userId);
        return details.stream().map(String::valueOf).collect(Collectors.joining(","));
    }

}

