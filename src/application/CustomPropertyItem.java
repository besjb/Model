package application;

import java.util.Optional;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;

import org.controlsfx.control.PropertySheet;

import impl.org.controlsfx.i18n.Localization;

import java.beans.PropertyDescriptor;
import java.beans.PropertyVetoException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CustomPropertyItem implements PropertySheet.Item {
	
	private Object obj;
	private PropertyDescriptor beanPropertyDescriptor;
	private Method readMethod;
	
	private String category;
	

	@Override
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String getDescription() {
		return beanPropertyDescriptor.getShortDescription();
	}

	@Override
	public String getName() {
		return beanPropertyDescriptor.getDisplayName();
	}

	@Override
	public Optional<ObservableValue<? extends Object>> getObservableValue() {
		return Optional.empty();
	}

	@Override
	public Class<?> getType() {
		return beanPropertyDescriptor.getPropertyType();
	}

	/** {@inheritDoc} */
    @Override public Object getValue() {
        try {
            return this.readMethod.invoke(this.obj);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    /** {@inheritDoc} */
    @Override public void setValue(final Object value) {
        final Method writeMethod = this.beanPropertyDescriptor.getWriteMethod();
        if ( writeMethod != null ) {
            try {
                writeMethod.invoke(this.obj, value);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
            } catch (final Throwable e) {
                if (e instanceof PropertyVetoException) {
                    final Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle(Localization.localize(Localization.asKey("bean.property.change.error.title")));//$NON-NLS-1$
                    alert.setHeaderText(Localization.localize(Localization.asKey("bean.property.change.error.masthead")));//$NON-NLS-1$
                    alert.setContentText(e.getLocalizedMessage());
                    alert.showAndWait();
                } else {
                    throw e;
                }
            }
        }
    }

	public CustomPropertyItem(Object obj, PropertyDescriptor propertyDescriptor) {
		category = "Default";
		this.obj = obj;
		this.beanPropertyDescriptor = propertyDescriptor;
		this.readMethod = propertyDescriptor.getReadMethod();
	}
	
	

}
