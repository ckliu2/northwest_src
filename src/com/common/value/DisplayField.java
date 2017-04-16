package com.common.value;

public class DisplayField extends Field
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String property;
    private String sortable; 
    private String format; 
    private String decorator;
    private String group;
    private String style;
    private String total;
    private String href;
    private String paramId;
    private String paramProperty;
    
    public DisplayField()
    {
        super();
    }

    public DisplayField(String name, String property, String title, String sortable, String decorator, String format)
    {
        super(name, title);
        this.property = property;
        this.sortable = sortable; 
        this.format = format; 
        this.decorator = decorator;
    }

    public DisplayField(String name, String property, String title, String sortable, String decorator, String format, String group)
    {
        super(name, title);
        this.property = property;
        this.sortable = sortable; 
        this.format = format; 
        this.decorator = decorator;
        this.group = group;
    }

    public DisplayField(String name, String property, String title, String sortable, String decorator, String format, String group, String style)
    {
        super(name, title);
        this.property = property;
        this.sortable = sortable; 
        this.format = format; 
        this.decorator = decorator;
        this.group = group;
        this.style = style;
    }

    public DisplayField(String name, String property, String title, String sortable, 
                        String decorator, String format, String group, String style, String total)
    {
        super(name, title);
        this.property = property;
        this.sortable = sortable; 
        this.format = format; 
        this.decorator = decorator;
        this.group = group;
        this.style = style;
        this.total = total;
    }

    public String getDecorator()
    {
        return decorator;
    }

    public void setDecorator(String decorator)
    {
        this.decorator = decorator;
    }

    public String getFormat()
    {
        return format;
    }

    public void setFormat(String format)
    {
        this.format = format;
    }

    public String getSortable()
    {
        return sortable;
    }

    public void setSortable(String sortable)
    {
        this.sortable = sortable;
    }

    public String getProperty()
    {
        return property;
    }

    public void setProperty(String property)
    {
        this.property = property;
    }

    public String getGroup()
    {
        return group;
    }

    public void setGroup(String group)
    {
        this.group = group;
    }

    public String getStyle()
    {
        return style;
    }

    public void setStyle(String style)
    {
        this.style = style;
    }

    public String getTotal()
    {
        return total;
    }

    public void setTotal(String total)
    {
        this.total = total;
    }

    public String getHref()
    {
        return href;
    }

    public void setHref(String href)
    {
        this.href = href;
    }

    public String getParamId()
    {
        return paramId;
    }

    public void setParamId(String paramId)
    {
        this.paramId = paramId;
    }

    public String getParamProperty()
    {
        return paramProperty;
    }

    public void setParamProperty(String paramProperty)
    {
        this.paramProperty = paramProperty;
    }
}
