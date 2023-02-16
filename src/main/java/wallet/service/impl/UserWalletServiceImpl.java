package wallet.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import sun.nio.cs.US_ASCII;
import wallet.pojo.entity.Detail;
import wallet.pojo.entity.UserWallet;
import wallet.mapper.UserWalletMapper;
import wallet.service.DetailService;
import wallet.service.UserWalletService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Zz
 * @since 2023-02-16
 */
@Service
@Transactional()
public class UserWalletServiceImpl extends ServiceImpl<UserWalletMapper, UserWallet> implements UserWalletService {

    @Autowired
    private DetailService detailService;

    /**
     * 查询用户钱包余额
     * @param userId
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public BigDecimal getAmount(int userId) {
        QueryWrapper<UserWallet> userIdQueryWrapper = new QueryWrapper<UserWallet>().eq("user_id", userId);
        UserWallet userWallet = baseMapper.selectOne(userIdQueryWrapper);
        return userWallet.getAmount();
    }

    /**
     * 用户消费100元的接口
     * @param userId
     * @return
     */
    @Override
    public String cost(int userId) {
        QueryWrapper<UserWallet> userIdQueryWrapper = new QueryWrapper<UserWallet>().eq("user_id", userId);
        UserWallet userWallet = baseMapper.selectOne(userIdQueryWrapper);
        BigDecimal balance = userWallet.getAmount().subtract(new BigDecimal(100));
        if (0 > userWallet.getAmount().subtract(new BigDecimal(100)).compareTo(new BigDecimal("0"))) {
            return "账户余额不足！！！";
        }
        userWallet.setAmount(balance);
        baseMapper.updateById(userWallet);
        detailService.record(userId, "消费100元");
        return "消费100元成功！";
    }

    /**
     * 用户退款20元接口
     * @param userId
     * @return
     */
    @Override
    public String refund(int userId) {
        QueryWrapper<UserWallet> userIdQueryWrapper = new QueryWrapper<UserWallet>().eq("user_id", userId);
        UserWallet userWallet = baseMapper.selectOne(userIdQueryWrapper);
        BigDecimal balance = userWallet.getAmount().add(new BigDecimal(20));
        userWallet.setAmount(balance);
        baseMapper.updateById(userWallet);
        detailService.record(userId, "退款20元");
        return "退款20元成功";
    }


}
