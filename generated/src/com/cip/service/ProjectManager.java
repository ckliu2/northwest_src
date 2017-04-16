package com.cip.service;

import com.cip.value.Project;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Tue Feb 10 10:37:05 CST 2015
*/

public interface ProjectManager extends CommonManager 
{
    public abstract void saveProject(Project val);

    public abstract void removeProject(Project val);

    public abstract void removeProject(Long id);

    public abstract Project getProjectById(Long id);

    public abstract List<Project> getProjectList();
}

