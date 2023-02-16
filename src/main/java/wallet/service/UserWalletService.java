package wallet.service;

import wallet.pojo.entity.UserWallet;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Zz
 * @since 2023-02-16
 */
public interface UserWalletService extends IService<UserWallet> {

    BigDecimal getAmount(int userId);

    String cost(int userId);

    String refund(int userId);
}
