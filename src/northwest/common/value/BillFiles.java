package northwest.common.value;

import com.base.value.UploadedFile;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class BillFiles implements Serializable {

    private static final long serialVersionUID = 1L;
    /** identifier field */
    private Long id;

    /** nullable persistent field */
    private northwest.common.value.Bill bill;
    private String billId;

    /** nullable persistent field */
    private UploadedFile doc1;
    private String doc1FileName;
    private Long doc1Id;

    /** nullable persistent field */
    private UploadedFile doc2;
    private String doc2FileName;
    private Long doc2Id;

    /** nullable persistent field */
    private UploadedFile doc3;
    private String doc3FileName;
    private Long doc3Id;

    /** nullable persistent field */
    private UploadedFile doc4;
    private String doc4FileName;
    private Long doc4Id;

    /** nullable persistent field */
    private UploadedFile doc5;
    private String doc5FileName;
    private Long doc5Id;

    /** nullable persistent field */
    private UploadedFile doc6;
    private String doc6FileName;
    private Long doc6Id;

    /** full constructor */
    public BillFiles(northwest.common.value.Bill bill, UploadedFile doc1, UploadedFile doc2, UploadedFile doc3, UploadedFile doc4, UploadedFile doc5, UploadedFile doc6) {
        this.bill = bill;
        this.doc1 = doc1;
        this.doc2 = doc2;
        this.doc3 = doc3;
        this.doc4 = doc4;
        this.doc5 = doc5;
        this.doc6 = doc6;
    }

    /** Labor constructor */
    public BillFiles() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public northwest.common.value.Bill getBill() {
        return this.bill;
    }

    public void setBill(northwest.common.value.Bill bill) {
        this.bill = bill;
    }

    public String getBillId() {
        if (this.bill != null && this.bill.getId() != null)
            return bill.getId();
        return this.billId;
    }

    public void setBillId(String id) {
        this.billId = id;
    }

    public UploadedFile getDoc1() {
        return this.doc1;
    }

    public void setDoc1(UploadedFile doc1) {
        this.doc1 = doc1;
    }

    public String getDoc1FileName() {
        return this.doc1FileName;
    }

    public void setDoc1FileName(String val) {
        this.doc1FileName = val;
    }

    public Long getDoc1Id() {
        if (this.doc1 != null && this.doc1.getId() != null)
            return doc1.getId();
        return this.doc1Id;
    }

    public void setDoc1Id(Long id) {
        this.doc1Id = id;
    }

    public UploadedFile getDoc2() {
        return this.doc2;
    }

    public void setDoc2(UploadedFile doc2) {
        this.doc2 = doc2;
    }

    public String getDoc2FileName() {
        return this.doc2FileName;
    }

    public void setDoc2FileName(String val) {
        this.doc2FileName = val;
    }

    public Long getDoc2Id() {
        if (this.doc2 != null && this.doc2.getId() != null)
            return doc2.getId();
        return this.doc2Id;
    }

    public void setDoc2Id(Long id) {
        this.doc2Id = id;
    }

    public UploadedFile getDoc3() {
        return this.doc3;
    }

    public void setDoc3(UploadedFile doc3) {
        this.doc3 = doc3;
    }

    public String getDoc3FileName() {
        return this.doc3FileName;
    }

    public void setDoc3FileName(String val) {
        this.doc3FileName = val;
    }

    public Long getDoc3Id() {
        if (this.doc3 != null && this.doc3.getId() != null)
            return doc3.getId();
        return this.doc3Id;
    }

    public void setDoc3Id(Long id) {
        this.doc3Id = id;
    }

    public UploadedFile getDoc4() {
        return this.doc4;
    }

    public void setDoc4(UploadedFile doc4) {
        this.doc4 = doc4;
    }

    public String getDoc4FileName() {
        return this.doc4FileName;
    }

    public void setDoc4FileName(String val) {
        this.doc4FileName = val;
    }

    public Long getDoc4Id() {
        if (this.doc4 != null && this.doc4.getId() != null)
            return doc4.getId();
        return this.doc4Id;
    }

    public void setDoc4Id(Long id) {
        this.doc4Id = id;
    }

    public UploadedFile getDoc5() {
        return this.doc5;
    }

    public void setDoc5(UploadedFile doc5) {
        this.doc5 = doc5;
    }

    public String getDoc5FileName() {
        return this.doc5FileName;
    }

    public void setDoc5FileName(String val) {
        this.doc5FileName = val;
    }

    public Long getDoc5Id() {
        if (this.doc5 != null && this.doc5.getId() != null)
            return doc5.getId();
        return this.doc5Id;
    }

    public void setDoc5Id(Long id) {
        this.doc5Id = id;
    }

    public UploadedFile getDoc6() {
        return this.doc6;
    }

    public void setDoc6(UploadedFile doc6) {
        this.doc6 = doc6;
    }

    public String getDoc6FileName() {
        return this.doc6FileName;
    }

    public void setDoc6FileName(String val) {
        this.doc6FileName = val;
    }

    public Long getDoc6Id() {
        if (this.doc6 != null && this.doc6.getId() != null)
            return doc6.getId();
        return this.doc6Id;
    }

    public void setDoc6Id(Long id) {
        this.doc6Id = id;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .append("bill", getBill())
            .append("doc1", getDoc1())
            .append("doc2", getDoc2())
            .append("doc3", getDoc3())
            .append("doc4", getDoc4())
            .append("doc5", getDoc5())
            .append("doc6", getDoc6())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
