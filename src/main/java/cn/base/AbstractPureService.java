package cn.base;

import com.baomidou.mybatisplus.entity.TableInfo;
import com.baomidou.mybatisplus.enums.SqlMethod;
import com.baomidou.mybatisplus.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.mapper.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.toolkit.ReflectionKit;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.baomidou.mybatisplus.toolkit.TableInfoHelper;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author zhangheng
 * @date 2017-12-01  14:12:00
 */
@Transactional(readOnly = true,rollbackFor={RuntimeException.class})
public abstract class AbstractPureService<D extends BaseMapper<T>,T extends AbstractModel<T>> {

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
     * <p>
     * 判断数据库操作是否成功
     * </p>
     * <p>
     * 注意！！ 该方法为 Integer 判断，不可传入 int 基本类型
     * </p>
     *
     * @param result 数据库操作返回影响条数
     * @return boolean
     */
    protected static boolean retBool(Integer result) {
        return SqlHelper.retBool(result);
    }

    @SuppressWarnings("unchecked")
    protected Class<T> currentModelClass() {
        return ReflectionKit.getSuperClassGenricType(getClass(), 1);
    }

    /**
     * <p>
     * 批量操作 SqlSession
     * </p>
     */
    protected SqlSession sqlSessionBatch() {
        return SqlHelper.sqlSessionBatch(currentModelClass());
    }

    /**
     * 获取SqlStatement
     *
     * @param sqlMethod
     * @return
     */
    protected String sqlStatement(SqlMethod sqlMethod) {
        return SqlHelper.table(currentModelClass()).getSqlStatement(sqlMethod.getMethod());
    }

    /**
     * <p>
     * 获取Session 默认自动提交
     * <p/>
     */
    protected SqlSession sqlSession() {
        return SqlHelper.sqlSession(currentModelClass());
    }


    /**
     * 批量插入
     *
     * @param entityList
     * @param batchSize
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean insertBatch(List<T> entityList, int batchSize) {
        if (CollectionUtils.isEmpty(entityList)) {
            throw new IllegalArgumentException("Error: entityList must not be empty");
        }
        try (SqlSession batchSqlSession = sqlSessionBatch()) {
            int size = entityList.size();
            String sqlStatement = sqlStatement(SqlMethod.INSERT_ONE);
            for (int i = 0; i < size; i++) {
                T entity = entityList.get(i);
                if (entity.getIsNewRecord()){
//                    entity.setID(sequence.nextId());
                }
                batchSqlSession.insert(sqlStatement, entity);
                if (i >= 1 && i % batchSize == 0) {
                    batchSqlSession.flushStatements();
                }
            }
            batchSqlSession.flushStatements();
        } catch (Throwable e) {
            throw new MybatisPlusException("Error: Cannot execute insertBatch Method. Cause", e);
        }
        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean insertBatch(List<T> entityList) {
        return insertBatch(entityList, 30);
    }

    /**
     * 批量插入修改
     *
     * @param entityList 实体对象列表
     * @param batchSize  批量刷新个数
     * @param selective  是否滤掉空字段
     * @return boolean
     */
    private boolean insertOrUpdateBatch(List<T> entityList, int batchSize, boolean selective) {
        if (CollectionUtils.isEmpty(entityList)) {
            throw new IllegalArgumentException("Error: entityList must not be empty");
        }
        try (SqlSession batchSqlSession = sqlSessionBatch()) {
            int size = entityList.size();
            for (int i = 0; i < size; i++) {
                if (selective) {
                    insertOrUpdate(entityList.get(i));
                } else {
                    insertOrUpdateAllColumn(entityList.get(i));
                }
                if (i >= 1 && i % batchSize == 0) {
                    batchSqlSession.flushStatements();
                }
            }
            batchSqlSession.flushStatements();
        } catch (Throwable e) {
            throw new MybatisPlusException("Error: Cannot execute insertOrUpdateBatch Method. Cause", e);
        }
        return true;
    }


    /**
     * <p>
     * TableId 注解存在更新记录，否插入一条记录
     * </p>
     *
     * @param entity 实体对象
     * @return boolean
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean insertOrUpdate(T entity) {
        if (null != entity) {
            if (entity.getIsNewRecord()) {
                return insert(entity);
            } else {
                /*
                 * 更新成功直接返回，失败执行插入逻辑
                 */
                return updateById(entity) || insert(entity);
            }
        }
        return false;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean insertOrUpdateAllColumn(T entity) {
        if (null != entity) {
            Class<?> cls = entity.getClass();
            TableInfo tableInfo = TableInfoHelper.getTableInfo(cls);
            if (null != tableInfo && StringUtils.isNotEmpty(tableInfo.getKeyProperty())) {
                Object idVal = ReflectionKit.getMethodValue(cls, entity, tableInfo.getKeyProperty());
                if (StringUtils.checkValNull(idVal)) {
                    return insertAllColumn(entity);
                } else {
                    /*
                     * 更新成功直接返回，失败执行插入逻辑
                     */
                    return updateAllColumnById(entity) || insertAllColumn(entity);
                }
            } else {
                throw new MybatisPlusException("Error:  Can not execute. Could not find @TableId.");
            }
        }
        return false;
    }

    /**
     * 插入一条记录
     *
     * @param entity 实体对象
     * @return int
     */
    @Transactional(rollbackFor={RuntimeException.class})
    public boolean insert(T entity){
        if (entity.getIsNewRecord()){
            entity.preInsert();
        }
        return retBool(dao.insert(entity));
    }
    /**
     * 插入一条记录并返回记录
     *
     * @param entity 实体对象
     * @return int
     */
    @Transactional(rollbackFor={RuntimeException.class})
    public Object insertAndReturn(T entity){
        if (entity.getIsNewRecord()){
            entity.preInsert();
        }
        retBool(dao.insert(entity));
        return entity;
    }

    /**
     * 全部行插入一条记录
     *
     * @param entity 实体对象
     * @return int
     */
    @Transactional(readOnly = false,rollbackFor={RuntimeException.class})
    public boolean insertAllColumn(T entity){
        if (entity.getIsNewRecord()){
            entity.preInsert();
        }
        return retBool(dao.insertAllColumn(entity));
    }

    /**
     * 根据 ID 删除
     *
     * @param id 主键ID
     * @return int
     */
    @Transactional(readOnly = false,rollbackFor={RuntimeException.class})
    public boolean deleteById(Serializable id){
        return SqlHelper.delBool(dao.deleteById(id));
    }
    /**
     * 根据 columnMap 条件，删除记录
     *
     * @param columnMap 表字段 map 对象
     * @return int
     */
    @Transactional(rollbackFor={RuntimeException.class})
    public boolean deleteByMap(Map<String, Object> columnMap){
        return SqlHelper.delBool(dao.deleteByMap(columnMap));
    }

    /**
     * 根据 entity 条件，删除记录
     *
     * @param wrapper 实体对象封装操作类（可以为 null）
     * @return int
     */
    @Transactional(readOnly = false,rollbackFor={RuntimeException.class})
    public boolean delete(Wrapper<T> wrapper){
       return SqlHelper.delBool(dao.delete(wrapper));
    }

    /**
     * <p>
     * 删除（根据ID 批量删除）
     * </p>
     *
     * @param idList 主键ID列表
     * @return int
     */
    @Transactional(readOnly = false,rollbackFor={RuntimeException.class})
    public boolean deleteBatchIds(List<? extends Serializable> idList){
        return SqlHelper.delBool(dao.deleteBatchIds(idList));
    }

    /**
     * <p>
     * 根据 ID 修改
     * </p>
     *
     * @param entity 实体对象
     * @return int
     */
    @Transactional(readOnly = false,rollbackFor={RuntimeException.class})
    public boolean updateById(T entity){
        entity.preUpdate();
        return retBool(dao.updateById(entity));
    }

    /**
     * <p>
     * 根据 ID 修改
     * </p>
     *
     * @param entity 实体对象
     * @return int
     */
    @Transactional(readOnly = false,rollbackFor={RuntimeException.class})
    public boolean updateAllColumnById(T entity){
        return retBool(dao.updateAllColumnById(entity));
    }

    /**
     * <p>
     * 根据 whereEntity 条件，更新记录
     * </p>
     *
     * @param entity  实体对象
     * @param wrapper 实体对象封装操作类（可以为 null）
     * @return
     */
    @Transactional(readOnly = false,rollbackFor={RuntimeException.class})
    public boolean update(T entity,  Wrapper<T> wrapper){
        return retBool(dao.update(entity,wrapper));
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean updateAllColumnBatchById(List<T> entityList, int batchSize) {
        return updateBatchById(entityList, batchSize, false);
    }


    @Transactional(rollbackFor = Exception.class)
    public boolean updateBatchById(List<T> entityList) {
        return updateBatchById(entityList, 30);
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean updateBatchById(List<T> entityList, int batchSize) {
        return updateBatchById(entityList, batchSize, true);
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean updateAllColumnBatchById(List<T> entityList) {
        return updateAllColumnBatchById(entityList, 30);
    }

    /**
     * 根据主键ID进行批量修改
     *
     * @param entityList 实体对象列表
     * @param batchSize  批量刷新个数
     * @param selective  是否滤掉空字段
     * @return boolean
     */
    private boolean updateBatchById(List<T> entityList, int batchSize, boolean selective) {
        if (CollectionUtils.isEmpty(entityList)) {
            throw new IllegalArgumentException("Error: entityList must not be empty");
        }
        try (SqlSession batchSqlSession = sqlSessionBatch()) {
            int size = entityList.size();
            SqlMethod sqlMethod = selective ? SqlMethod.UPDATE_BY_ID : SqlMethod.UPDATE_ALL_COLUMN_BY_ID;
            String sqlStatement = sqlStatement(sqlMethod);
            for (int i = 0; i < size; i++) {
                MapperMethod.ParamMap<T> param = new MapperMethod.ParamMap<>();
                param.put("et", entityList.get(i));
                batchSqlSession.update(sqlStatement, param);
                if (i >= 1 && i % batchSize == 0) {
                    batchSqlSession.flushStatements();
                }
            }
            batchSqlSession.flushStatements();
        } catch (Throwable e) {
            throw new MybatisPlusException("Error: Cannot execute updateBatchById Method. Cause", e);
        }
        return true;
    }
    /**
     * 根据 ID 查询
     *
     * @param id 主键ID
     * @return T
     */
    public T selectById(Serializable id){
        T t = dao.selectById(id);

        return t;
    }

    /**
     * <p>
     * 查询（根据ID 批量查询）
     * </p>
     *
     * @param idList 主键ID列表
     * @return List<T>
     */
    public List<T> selectBatchIds(List<? extends Serializable> idList){
        return dao.selectBatchIds(idList);
    }

    /**
     * <p>
     * 查询（根据 columnMap 条件）
     * </p>
     *
     * @param columnMap 表字段 map 对象
     * @return List<T>
     */
    public List<T> selectByMap( Map<String, Object> columnMap){
        return dao.selectByMap(columnMap);
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
    public T selectOne(Wrapper<T> wrapper) {
        return SqlHelper.getObject(dao.selectList(wrapper));
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


    /**
     *  根据 Wrapper 条件，判断是否存在
     *
     * @param wrapper 实体对象
     * @return boolean
     */
    public boolean exists(Wrapper<T> wrapper){
        return selectCount(wrapper) > 0;
    }

    /**
     * <p>
     * 根据 Wrapper 条件，查询总记录数
     * </p>
     *
     * @param wrapper 实体对象
     * @return int
     */
    public Integer selectCount(Wrapper<T> wrapper){
        return dao.selectCount(wrapper);
    }

    /**
     * 根据 entity 条件，查询全部记录
     *
     * @param wrapper 实体对象封装操作类（可以为 null）
     * @return List<T>
     */
    public List<T> selectList(Wrapper<T> wrapper){
        return dao.selectList(wrapper);
    }

    /**
     * 查询全部记录
     *
     * @return List<T>
     */
    public List<T> selectAll(){
        return dao.selectList(new EntityWrapper<T>());
    }
    /**
     * <p>
     * 根据 Wrapper 条件，查询全部记录
     * </p>
     *
     * @param wrapper 实体对象封装操作类（可以为 null）
     * @return List<T>
     */
    public List<Map<String, Object>> selectMaps(Wrapper<T> wrapper){
        return dao.selectMaps(wrapper);
    }

    /**
     * <p>
     * 根据 Wrapper 条件，查询全部记录
     * </p>
     *
     * @param wrapper 实体对象封装操作类（可以为 null）
     * @return List<Object>
     */
    public List<Object> selectObjs(Wrapper<T> wrapper){
            return dao.selectObjs(wrapper);
    }
    /**
     * <p>
     * 根据 entity 条件，查询全部记录（并翻页）
     * </p>
     *
     * @param rowBounds 分页查询条件（可以为 RowBounds.DEFAULT）
     * @param model
     * @param wrapper   实体对象封装操作类（可以为 null）
     * @return List<T>
     */
    public List<T> selectPage(RowBounds rowBounds, T model, Wrapper<T> wrapper){
        return dao.selectPage(rowBounds,wrapper);
    }

    /**
     * 根据 Wrapper 条件，查询全部记录（并翻页）
     *
     * @param rowBounds 分页查询条件（可以为 RowBounds.DEFAULT）
     * @param wrapper   实体对象封装操作类
     * @return List<Map<String, Object>>
     */
    public List<Map<String, Object>> selectMapsPage(RowBounds rowBounds, Wrapper<T> wrapper){
        return dao.selectMapsPage(rowBounds,wrapper);
    }

    public Page<T> selectPage(Page<T> page, Wrapper<T> wrapper) {
        wrapper = (Wrapper<T>) SqlHelper.fillWrapper(page, wrapper);
        page.setRecords(dao.selectPage(page, wrapper));
        return page;
    }

}
