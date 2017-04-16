package com.base.web.displaytag;


import org.apache.commons.lang.StringUtils;
import org.displaytag.model.TableModel;
import org.displaytag.export.*;



public class ExportExcel extends BaseExportView
{

    /**
     * @see org.displaytag.export.BaseExportView#setParameters(TableModel, boolean, boolean, boolean)
     */
    public void setParameters(TableModel tableModel, boolean exportFullList, boolean includeHeader,
        boolean decorateValues)
    {
        super.setParameters(tableModel, exportFullList, includeHeader, decorateValues);
    }

    /**
     * @see org.displaytag.export.ExportView#getMimeType()
     * @return "application/vnd.ms-excel"
     */
    public String getMimeType()
    {
        return "application/vnd.ms-excel"; //$NON-NLS-1$
    }

    /**
     * @see org.displaytag.export.BaseExportView#getRowEnd()
     */
    protected String getRowEnd()
    {
        return "\n"; //$NON-NLS-1$
    }

    /**
     * @see org.displaytag.export.BaseExportView#getCellEnd()
     */
    protected String getCellEnd()
    {
        return "\t"; //$NON-NLS-1$
    }

    /**
     * @see org.displaytag.export.BaseExportView#getAlwaysAppendCellEnd()
     * @return false
     */
    protected boolean getAlwaysAppendCellEnd()
    {
        return false;
    }

    /**
     * @see org.displaytag.export.BaseExportView#getAlwaysAppendRowEnd()
     * @return false
     */
    protected boolean getAlwaysAppendRowEnd()
    {
        return false;
    }

    /**
     * Escaping for excel format.
     * <ul>
     * <li>Quotes inside quoted strings are escaped with a double quote</li>
     * <li>Fields are surrounded by " (should be optional, but sometimes you get a "Sylk error" without those)</li>
     * </ul>
     * @see org.displaytag.export.BaseExportView#escapeColumnValue(java.lang.Object)
     */
    protected String escapeColumnValue(Object value)
    {
        if (value != null)
        {
            
            StringBuffer str = new StringBuffer();
            String val = value.toString();
            String[] en = {"UTF-8", "ISO-8859-1", "Big5", null};
            
     
            str.append(val);
//            try {
//                for (int i=0; i < en.length; i++) {
//                    for (int j=0; j < en.length; j++) {
//                        byte[] bs =  (en[i] != null) ? val.getBytes(en[i]) : val.getBytes();
//                        String ss =  (en[j] != null) ? new String(bs, en[j]) : new String(bs);
//                        str.append("(" + en[i]+ "," + en[j] + ")" + ss);
//                        //=  new String(s.getBytes(en[i]), en[j]); 
//                    }
//                    
//                }
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
            
            // quotes around fields are needed to avoid occasional "Sylk format invalid" messages from excel
            return "\"" //$NON-NLS-1$
                +  StringUtils.replace(StringUtils.trim(str.toString()), "\"", "\"\"") //$NON-NLS-1$ //$NON-NLS-2$ 
                + "\""; //$NON-NLS-1$ 
        }

        return null;
    }

}
