package cn.base;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.SqlRunner;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhangheng
 * @date 2018-12-05  10:25:00
 */
@Transactional(readOnly = true,rollbackFor={RuntimeException.class})
public abstract class AbstractService<D extends BaseMapper<T>,T extends AbstractModel<T>>  extends ServiceImpl {

    /**
     * 持久层对象
     */
    @Autowired
    protected D dao;
    /**
     * <p>
     * 执行 SQL
     * </p>
     */
    public SqlRunner sql() {
        return new SqlRunner(currentModelClass());
    }


    /**
     * 根据 entity 条件，查询一条记录  这是一个bug 为什么有些属性没有了
     *
     * @param entity 实体对象
     * @return T
     */
    public T selectOne(T entity){
        return dao.selectOne(entity);
    }


    /**
     * 根据 entity 条件，判断是否存在
     *
     * @param entity 实体对象
     * @return boolean
     */
    public boolean exists(T entity){
        return selectOne(entity) != null;
    }


}
