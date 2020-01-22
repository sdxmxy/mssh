package com.sdxmxy.dao.impl;

import com.sdxmxy.dao.UserDao;
import com.sdxmxy.domain.User;
import lombok.Data;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    private SessionFactory sessionFactory;

    @Override
    public int findCount() {
        String hql = "select count(*) from User";
        List<Long> list = this.getHibernateTemplate().find(hql);
        if (list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
    }

    //分页查询的
    @Override
    public List<User> findByPage(int begin, int pageSize) {
        DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
        List<User> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
        return list;
    }

    @Override
    public void save(User user) {
        this.getHibernateTemplate().save(user);
    }

    @Override
    public User findById(int id) {
        return this.getHibernateTemplate().get(User.class, id);
    }

    @Override
    public void update(User user) {
        this.getHibernateTemplate().update(user);
    }

    @Override
    public void delete(User user) {
        this.getHibernateTemplate().delete(user);
    }

    @Override
    public List findAll() {
        return this.getHibernateTemplate().find("from User");
    }

}
