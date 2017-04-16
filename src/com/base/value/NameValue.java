package com.base.value;

public class NameValue
{
    private String name;
    private int id;
    private String value;
    private float data;
    
    public NameValue()
    {
        super();
    }

    public NameValue(String val)
    {
        this.name = val;
        this.value = val;
    }

    public NameValue(int id, String val)
    {
        this.id = id;
        this.value = val;
    }

    public NameValue(String name, String val)
    {
        this.name = name;
        this.value = val;
    }

    public NameValue(float data, String val)
    {
        this.data = data;
        this.value = val;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public String toString()
    {
        if (name != null)
            return "name=" + name + ",value=" + value;
        return "id=" + id + ",value=" + value;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public float getData()
    {
        return data;
    }

    public void setData(float data)
    {
        this.data = data;
    }
}
