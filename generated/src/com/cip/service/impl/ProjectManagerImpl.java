package com.cip.service.impl;

import com.cip.service.ProjectManager;
import com.cip.dao.ProjectDAO;
import com.cip.value.Project;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Tue Feb 10 10:37:05 CST 2015
*/

public class ProjectManagerImpl extends CommonManagerImpl implements ProjectManager
{

    public ProjectManagerImpl()
    {
    }

    public ProjectDAO getGenericDAO()
    {
        return (ProjectDAO)super.getGenericDAO();
    }

    public void setGenericDAO(ProjectDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveProject(Project val)
    {
        getGenericDAO().saveProject(val);
    }

    public void removeProject(Project val)
    {
        getGenericDAO().removeProject(val);
    }

    public void removeProject(Long id)
    {
        getGenericDAO().removeProject(id);
    }

    public Project getProjectById(Long id)
    {
         return getGenericDAO().findProjectById(id);
    }

    public List<Project> getProjectList()
    {
        return getGenericDAO().findAllProject();
    }
}

