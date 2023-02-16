package wallet.service;

import wallet.pojo.entity.Detail;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Zz
 * @since 2023-02-16
 */
public interface DetailService extends IService<Detail> {

     List<Detail> viewDetail(int userId);

    void record(int userId, String description);
}
