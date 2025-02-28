package uibooster.model;

import uibooster.model.formelements.ListFormElement;
import uibooster.model.formelements.SelectionFormElement;
import uibooster.model.formelements.TableFormElement;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class FormElement {

    protected String id;
    protected String label;
    protected int formIndex;
    protected Form form;

    public FormElement(String label) {
        this.label = label;
    }

    public void setFormIndex(int formIndex) {
        this.formIndex = formIndex;
    }

    public abstract JComponent createComponent(FormElementChangeListener onChange);

    public abstract void setEnabled(boolean enable);

    public abstract Object getValue();

    public abstract void setValue(Object value);

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public String getId() {
        return id;
    }

    public int getIndex() {
        return formIndex;
    }

    public Float asFloat() {
        return Float.parseFloat(getValue().toString());
    }

    public Integer asInt() {
        return Integer.parseInt(getValue().toString());
    }

    public String asString() {
        return getValue().toString();
    }

    public Date asDate() {
        return (Date) getValue();
    }

    public String asDateFormatted() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((Date) getValue());
    }

    public Color asColor() {
        return (Color) getValue();
    }

    public String asColorHex() {
        Color color = (Color) getValue();
        return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
    }

    void setForm(Form filledForm) {
        this.form = filledForm;
    }

    public TableFormElement toTable() {
        return (TableFormElement) this;
    }

    public ListFormElement toList() {
        return (ListFormElement) this;
    }

    public RowFormElement toRow() {
        return (RowFormElement) this;
    }

    public SelectionFormElement toSelection() {
        return (SelectionFormElement) this;
    }

}
