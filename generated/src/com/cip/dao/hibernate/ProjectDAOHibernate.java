package com.cip.dao.hibernate;

import com.cip.value.Project;
import com.cip.dao.ProjectDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Tue Feb 10 10:37:05 CST 2015
*/

public class ProjectDAOHibernate extends CommonDAOHibernate implements ProjectDAO
{

    public ProjectDAOHibernate()
    {
    }

    public void saveProject(Project val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeProject(Project val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeProject(Long id)
    {
        Project obj = findProjectById(id);
        getHibernateTemplate().delete(obj);
    }

    public Project findProjectById(Long id)
    {
        if (id == null)
            return null;
        Project obj = (Project)getHibernateTemplate().get(com.cip.value.Project.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.cip.value.Project.class, id);
        else
            return obj;
    }

    public List<Project> findAllProject()
    {
        return getHibernateTemplate().find("from Project");
    }
}

