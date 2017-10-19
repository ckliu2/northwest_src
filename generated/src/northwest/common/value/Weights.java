package northwest.common.value;

import java.io.Serializable;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Weights implements Serializable {

    private static final long serialVersionUID = 1L;
    /** identifier field */
    private Long id;

    /** persistent field */
    private Float productClassWeight;

    /** persistent field */
    private Float inkWeight;

    /** nullable persistent field */
    private northwest.common.value.OutputEquipment outputEquipment;
    private Long outputEquipmentId;

    /** nullable persistent field */
    private List productClasses;

    /** full constructor */
    public Weights(Float productClassWeight, Float inkWeight, northwest.common.value.OutputEquipment outputEquipment, List productClasses) {
        this.productClassWeight = productClassWeight;
        this.inkWeight = inkWeight;
        this.outputEquipment = outputEquipment;
        this.productClasses = productClasses;
    }

    /** default constructor */
    public Weights() {
    }

    /** minimal constructor */
    public Weights(Float productClassWeight, Float inkWeight) {
        this.productClassWeight = productClassWeight;
        this.inkWeight = inkWeight;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getProductClassWeight() {
        return this.productClassWeight;
    }

    public void setProductClassWeight(Float productClassWeight) {
        this.productClassWeight = productClassWeight;
    }

    public Float getInkWeight() {
        return this.inkWeight;
    }

    public void setInkWeight(Float inkWeight) {
        this.inkWeight = inkWeight;
    }

    public northwest.common.value.OutputEquipment getOutputEquipment() {
        return this.outputEquipment;
    }

    public void setOutputEquipment(northwest.common.value.OutputEquipment outputEquipment) {
        this.outputEquipment = outputEquipment;
    }

    public Long getOutputEquipmentId() {
        if (this.outputEquipment != null && this.outputEquipment.getId() != null)
            return outputEquipment.getId();
        return this.outputEquipmentId;
    }

    public void setOutputEquipmentId(Long id) {
        this.outputEquipmentId = id;
    }

    public List getProductClasses() {
        return this.productClasses;
    }

    public void setProductClasses(List productClasses) {
        this.productClasses = productClasses;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .append("productClassWeight", getProductClassWeight())
            .append("inkWeight", getInkWeight())
            .append("outputEquipment", getOutputEquipment())
            .append("productClasses", getProductClasses())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
