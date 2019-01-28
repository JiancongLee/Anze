package cn.common.factory;

import cn.common.utils.HttpKit;
import cn.common.utils.ToolUtil;
import cn.hutool.core.util.StrUtil;
import cn.common.constant.OrderConstant;
import com.baomidou.mybatisplus.plugins.Page;

import javax.servlet.http.HttpServletRequest;

/**
 * BootStrap Table默认的分页参数创建
 *
 * @author zhangheng
 * @since  2017-04-05 22:25
 */
public class PageFactory<T> {

    public Page<T> defaultPage() {
        HttpServletRequest request = HttpKit.getRequest();

//        添加默认值，方便测试。
        int limit = (StrUtil.isBlank(request.getParameter("limit"))?20:Integer.valueOf(request.getParameter("limit")));
        //已经不用了
        int offset = (StrUtil.isBlank(request.getParameter("offset"))?0:Integer.valueOf(request.getParameter("offset")));

        int current = (StrUtil.isBlank(request.getParameter("page"))?1:Integer.valueOf(request.getParameter("page")));
        String sort = request.getParameter("sort");
        String order = (StrUtil.isBlank(request.getParameter("order"))?"desc":request.getParameter("order"));
        if (ToolUtil.isEmpty(sort)) {
            Page<T> page = new Page<T>(current, limit);
            page.setOpenSort(false);
            return page;
        } else {
            Page<T> page = new Page<T>(current, limit, sort);
            if (OrderConstant.ASC.getDes().equals(order)) {
                page.setAsc(true);
            } else {
                page.setAsc(false);
            }
            return page;
        }
    }
}
