package wallet.controller;


import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.Api;
import io.swagger.models.auth.In;
import net.bytebuddy.asm.Advice;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import wallet.mapper.UserWalletMapper;
import wallet.pojo.entity.UserWallet;
import wallet.service.UserWalletService;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Zz
 * @since 2023-02-16
 */
@RestController
@RequestMapping("/userWallet")

public class UserWalletController {

    @Autowired
    private UserWalletService userWalletService;

    @GetMapping("/getAmount/{userId}")
    public BigDecimal getAmount(@PathVariable("userId") int userId) {

        return userWalletService.getAmount(userId);
    }

    @GetMapping("/cost/{userId}")
    public String cost(@PathVariable("userId") int userId) {
        return userWalletService.cost(userId);
    }

    @GetMapping("/refund/{userId}")
    public String refund(@PathVariable("userId") int userId) {
        return userWalletService.refund(userId);
    }
}

