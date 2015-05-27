package cn.jfinalbbs.section;

import cn.jfinalbbs.common.Constants;
import com.jfinal.plugin.activerecord.Model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by liuyang on 15/4/25.
 */
public class Section extends Model<Section> implements Serializable {

    public final static Section me = new Section();

    public List<Section> findAll() {
        return super.findByCache(Constants.CacheName.SECTIONLIST, Constants.CacheKey.SECTIONLISTKEY, "select * from section order by display_index");
    }

}
