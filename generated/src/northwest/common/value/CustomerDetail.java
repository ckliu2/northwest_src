package northwest.common.value;

import com.base.value.UploadedFile;
import com.common.value.Member;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class CustomerDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    /** identifier field */
    private Long id;

    /** nullable persistent field */
    private String counterNo;

    /** nullable persistent field */
    private String counter;

    /** nullable persistent field */
    private String contacts;

    /** nullable persistent field */
    private String screenPosition;

    /** nullable persistent field */
    private String location;

    /** nullable persistent field */
    private String counterPhone;

    /** nullable persistent field */
    private UploadedFile planmap;
    private String planmapFileName;
    private Long planmapId;

    /** nullable persistent field */
    private UploadedFile photo1;
    private String photo1FileName;
    private Long photo1Id;

    /** nullable persistent field */
    private UploadedFile photo2;
    private String photo2FileName;
    private Long photo2Id;

    /** nullable persistent field */
    private UploadedFile photo3;
    private String photo3FileName;
    private Long photo3Id;

    /** nullable persistent field */
    private UploadedFile photo4;
    private String photo4FileName;
    private Long photo4Id;

    /** nullable persistent field */
    private UploadedFile photo5;
    private String photo5FileName;
    private Long photo5Id;

    /** nullable persistent field */
    private Member customerService;
    private Long customerServiceId;

    /** nullable persistent field */
    private northwest.common.value.Customer customer;
    private Long customerId;

    /** full constructor */
    public CustomerDetail(String counterNo, String counter, String contacts, String screenPosition, String location, String counterPhone, UploadedFile planmap, UploadedFile photo1, UploadedFile photo2, UploadedFile photo3, UploadedFile photo4, UploadedFile photo5, Member customerService, northwest.common.value.Customer customer) {
        this.counterNo = counterNo;
        this.counter = counter;
        this.contacts = contacts;
        this.screenPosition = screenPosition;
        this.location = location;
        this.counterPhone = counterPhone;
        this.planmap = planmap;
        this.photo1 = photo1;
        this.photo2 = photo2;
        this.photo3 = photo3;
        this.photo4 = photo4;
        this.photo5 = photo5;
        this.customerService = customerService;
        this.customer = customer;
    }

    /** default constructor */
    public CustomerDetail() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCounterNo() {
        return this.counterNo;
    }

    public void setCounterNo(String counterNo) {
        this.counterNo = counterNo;
    }

    public String getCounter() {
        return this.counter;
    }

    public void setCounter(String counter) {
        this.counter = counter;
    }

    public String getContacts() {
        return this.contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getScreenPosition() {
        return this.screenPosition;
    }

    public void setScreenPosition(String screenPosition) {
        this.screenPosition = screenPosition;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCounterPhone() {
        return this.counterPhone;
    }

    public void setCounterPhone(String counterPhone) {
        this.counterPhone = counterPhone;
    }

    public UploadedFile getPlanmap() {
        return this.planmap;
    }

    public void setPlanmap(UploadedFile planmap) {
        this.planmap = planmap;
    }

    public String getPlanmapFileName() {
        return this.planmapFileName;
    }

    public void setPlanmapFileName(String val) {
        this.planmapFileName = val;
    }

    public Long getPlanmapId() {
        if (this.planmap != null && this.planmap.getId() != null)
            return planmap.getId();
        return this.planmapId;
    }

    public void setPlanmapId(Long id) {
        this.planmapId = id;
    }

    public UploadedFile getPhoto1() {
        return this.photo1;
    }

    public void setPhoto1(UploadedFile photo1) {
        this.photo1 = photo1;
    }

    public String getPhoto1FileName() {
        return this.photo1FileName;
    }

    public void setPhoto1FileName(String val) {
        this.photo1FileName = val;
    }

    public Long getPhoto1Id() {
        if (this.photo1 != null && this.photo1.getId() != null)
            return photo1.getId();
        return this.photo1Id;
    }

    public void setPhoto1Id(Long id) {
        this.photo1Id = id;
    }

    public UploadedFile getPhoto2() {
        return this.photo2;
    }

    public void setPhoto2(UploadedFile photo2) {
        this.photo2 = photo2;
    }

    public String getPhoto2FileName() {
        return this.photo2FileName;
    }

    public void setPhoto2FileName(String val) {
        this.photo2FileName = val;
    }

    public Long getPhoto2Id() {
        if (this.photo2 != null && this.photo2.getId() != null)
            return photo2.getId();
        return this.photo2Id;
    }

    public void setPhoto2Id(Long id) {
        this.photo2Id = id;
    }

    public UploadedFile getPhoto3() {
        return this.photo3;
    }

    public void setPhoto3(UploadedFile photo3) {
        this.photo3 = photo3;
    }

    public String getPhoto3FileName() {
        return this.photo3FileName;
    }

    public void setPhoto3FileName(String val) {
        this.photo3FileName = val;
    }

    public Long getPhoto3Id() {
        if (this.photo3 != null && this.photo3.getId() != null)
            return photo3.getId();
        return this.photo3Id;
    }

    public void setPhoto3Id(Long id) {
        this.photo3Id = id;
    }

    public UploadedFile getPhoto4() {
        return this.photo4;
    }

    public void setPhoto4(UploadedFile photo4) {
        this.photo4 = photo4;
    }

    public String getPhoto4FileName() {
        return this.photo4FileName;
    }

    public void setPhoto4FileName(String val) {
        this.photo4FileName = val;
    }

    public Long getPhoto4Id() {
        if (this.photo4 != null && this.photo4.getId() != null)
            return photo4.getId();
        return this.photo4Id;
    }

    public void setPhoto4Id(Long id) {
        this.photo4Id = id;
    }

    public UploadedFile getPhoto5() {
        return this.photo5;
    }

    public void setPhoto5(UploadedFile photo5) {
        this.photo5 = photo5;
    }

    public String getPhoto5FileName() {
        return this.photo5FileName;
    }

    public void setPhoto5FileName(String val) {
        this.photo5FileName = val;
    }

    public Long getPhoto5Id() {
        if (this.photo5 != null && this.photo5.getId() != null)
            return photo5.getId();
        return this.photo5Id;
    }

    public void setPhoto5Id(Long id) {
        this.photo5Id = id;
    }

    public Member getCustomerService() {
        return this.customerService;
    }

    public void setCustomerService(Member customerService) {
        this.customerService = customerService;
    }

    public Long getCustomerServiceId() {
        if (this.customerService != null && this.customerService.getId() != null)
            return customerService.getId();
        return this.customerServiceId;
    }

    public void setCustomerServiceId(Long id) {
        this.customerServiceId = id;
    }

    public northwest.common.value.Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(northwest.common.value.Customer customer) {
        this.customer = customer;
    }

    public Long getCustomerId() {
        if (this.customer != null && this.customer.getId() != null)
            return customer.getId();
        return this.customerId;
    }

    public void setCustomerId(Long id) {
        this.customerId = id;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .append("counterNo", getCounterNo())
            .append("counter", getCounter())
            .append("contacts", getContacts())
            .append("screenPosition", getScreenPosition())
            .append("location", getLocation())
            .append("counterPhone", getCounterPhone())
            .append("planmap", getPlanmap())
            .append("photo1", getPhoto1())
            .append("photo2", getPhoto2())
            .append("photo3", getPhoto3())
            .append("photo4", getPhoto4())
            .append("photo5", getPhoto5())
            .append("customerService", getCustomerService())
            .append("customer", getCustomer())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
