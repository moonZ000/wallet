package wallet.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.Data;
import org.springframework.transaction.annotation.Transactional;
import wallet.pojo.entity.Detail;
import wallet.mapper.DetailMapper;
import wallet.service.DetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Zz
 * @since 2023-02-16
 */
@Service
@Transactional
public class DetailServiceImpl extends ServiceImpl<DetailMapper, Detail> implements DetailService {

    @Override
    @Transactional(readOnly = true)
    public List<Detail> viewDetail(int userId) {
        return  baseMapper.selectList(new QueryWrapper<Detail>().eq("user_id", userId));
    }

    @Override
    public void record(int userId, String description) {
        Detail detail = new Detail();
        detail.setUserId(userId);
        detail.setDescription(description);
        detail.setCreateTime(LocalDateTime.now());
        baseMapper.insert(detail);
    }
}
