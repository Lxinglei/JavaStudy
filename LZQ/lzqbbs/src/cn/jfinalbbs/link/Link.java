package cn.jfinalbbs.link;

import cn.jfinalbbs.common.Constants;
import com.jfinal.plugin.activerecord.Model;

import java.util.List;

/**
 * Created by liuyang on 15/4/26.
 */
public class Link extends Model<Link> {
    public static final Link me = new Link();

    public List<Link> findAll() {
        return super.findByCache(
                Constants.CacheName.LINKLIST,
                Constants.CacheKey.LINKLISTKEY,
                "select * from link order by display_index");
    }

}
