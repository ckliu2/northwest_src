package com.cip.dao;

import com.cip.value.Project;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Tue Feb 10 10:37:05 CST 2015
*/

public interface ProjectDAO extends CommonDAO 
{
    public abstract void saveProject(Project val);

    public abstract void removeProject(Project val);

    public abstract void removeProject(Long id);

    public abstract Project findProjectById(Long id);

    public abstract List<Project> findAllProject();
}

