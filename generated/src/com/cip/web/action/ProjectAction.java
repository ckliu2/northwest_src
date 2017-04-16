package com.cip.web.action;

import com.cip.value.Project;
import com.cip.service.ProjectManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Tue Feb 10 10:37:05 CST 2015
*/

public class ProjectAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Project project;
    private Long[] selectedProjectIds;

    public ProjectAction()
    {
        log = LogFactory.getLog(com.cip.web.action.ProjectAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("PROJECT");
    }

    public Project getProject()
    {
        return project;
    }

    public void setProject(Project val)
    {
        project = val;
    }

    public void setGenericManager(ProjectManager m)
    {
        super.setGenericManager(m);
    }

    public ProjectManager getGenericManager()
    {
        return (ProjectManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeProject(project.getId());
        return DELETE;
    }

    public String edit()
    {
        if (project == null) {
            project = new Project();
        } else if (project.getId() != null) {
            project = getGenericManager().getProjectById(project.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedProjectIds != null && selectedProjectIds.length > 0) {
            Project obj = getGenericManager().getProjectById(selectedProjectIds[0]);
            obj.setId(null);
            project = obj;
        }
        beanToForm();

        return SUCCESS;
    }

    public String execute()
    {
        log.info("entering 'execute' method");
        if (getDelete() != null) {
            return delete();
        } else {
            formToBean();
            if (inputValidation(project) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Project val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveProject(project);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        log.info("exit formToBean()");
    }
    public List<Project> getProjectList()
    {
        return getGenericManager().getProjectList();
    }

    public void setSelectedProjectIds(Long[] val)
    {
        selectedProjectIds = val;
    }

    public Long[] getSelectedProjectIds()
    {
        return selectedProjectIds;
    }
}
