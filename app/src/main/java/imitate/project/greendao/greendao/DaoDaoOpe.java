package imitate.project.greendao.greendao;

import android.content.Context;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import imitate.project.greendao.dao.Dao;
import imitate.project.greendao.utils.DbManager;
/*
 *Dao 类的相对应的操作数据
 *
 */

public class DaoDaoOpe {



    /**
     * 添加数据至数据库
     *
     * @param context
     * @param stu
     */
    public static void insertData(Context context, Dao stu) {
        DbManager.getDaoSession(context).getDaoDao().insert(stu);
    }


    /**
     * 将数据实体通过事务添加至数据库
     *
     * @param context
     * @param list
     */
    public static void insertData(Context context, List<Dao> list) {
        if (null == list || list.size() <= 0) {
            return;
        }
        DbManager.getDaoSession(context).getDaoDao().insertInTx(list);
    }

    /**
     * 添加数据至数据库，如果存在，将原来的数据覆盖
     * 内部代码判断了如果存在就update(entity);不存在就insert(entity)；
     *
     * @param context
     * @param student
     */
    public static void saveData(Context context, Dao student) {
        DbManager.getDaoSession(context).getDaoDao().save(student);
    }

    /**
     * 删除数据至数据库
     *
     * @param context
     * @param student 删除具体内容
     */
    public static void deleteData(Context context, Dao student) {
        DbManager.getDaoSession(context).getDaoDao().delete(student);
    }

    /**
     * 根据id删除数据至数据库
     *
     * @param context
     * @param id 删除具体内容
     */
    public static void deleteByKeyData(Context context, Dao id) {
        DbManager.getDaoSession(context).getDaoDao().delete(id);
        // DbManager.getDaoSession(context).getDaoDao().deleteByKey(id.getId());
        //DbManager.getDaoSession(context).getDaoDao().deleteInTx();
    }

    /**
     * 删除全部数据
     *
     * @param context
     */
    public static void deleteAllData(Context context) {
        DbManager.getDaoSession(context).getDaoDao().deleteAll();
    }

    /**
     * 更新数据库
     *
     * @param context
     * @param student
     */
    public static void updateData(Context context, Dao student) {
        DbManager.getDaoSession(context).getDaoDao().update(student);
    }


    /**
     * 查询所有数据
     *
     * @param context
     * @return
     */
    public static List<Dao> queryAll(Context context) {
        QueryBuilder<Dao> builder = DbManager.getDaoSession(context).getDaoDao().queryBuilder();

        return builder.build().list();
    }



    /**
     * 分页加载
     * @param context
     * @param pageSize 当前第几页(程序中动态修改pageSize的值即可)
     * @param pageNum 每页显示多少个
     * @return
     */
    public static List<Dao> queryPaging( int pageSize, int pageNum,Context context){
        DaoDao studentDao = DbManager.getDaoSession(context).getDaoDao();
        List<Dao> listMsg = studentDao.queryBuilder()
                .offset(pageSize * pageNum).limit(pageNum).list();
        return listMsg;
    }



    /**
     * @param context
     * @return
     */
    public static List<Dao> queryByName( String name,Context context){
        //    greenDao除了eq()操作之外还有很多其他方法，比如：
        //             eq()：==    等于
        //             noteq()：!= 不等于
        //             gt()： >    大于
        //             lt()：<     小于
        //             ge：>=      大于等于
        //             le:<=       小于等于
        //             like()：    包含
        //             between：   俩者之间  //闭区间,若参数为10,12,则为10,11,12
        //             in：        在某个值内
        //             notIn：     不在某个值内
        DaoDao studentDao = DbManager.getDaoSession(context).getDaoDao();
        //条件查询数据  出入参数进行查询   查询名字中包含某个字的人的集合
        List<Dao> listMsg = studentDao.queryBuilder().where(DaoDao.Properties.Name.like(name)).list();

               // .offset(1 * 1).limit(1).list();

        return listMsg;
    }




}
