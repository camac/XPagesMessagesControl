package com.gregorbyte.xsp.component;

import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;

import com.ibm.xsp.component.xp.XspMessages;

public class Messages extends XspMessages {

	private String _for = null;

	public Messages() {
		super();
		setRendererType("com.gregorbyte.Messages");
	}

	public String getFor() {

		if (_for != null) {
			return _for;
		}

		ValueBinding vb = getValueBinding("for");

		if (vb != null) {
			return (String) vb.getValue(getFacesContext());
		}
		return null;

	}

	public void setFor(String forString) {
		this._for = forString;
	}

	@Override
	public void restoreState(FacesContext fc, Object object) {

		Object[] state = (Object[]) object;

		this._for = (String) state[1];

		super.restoreState(fc, state[0]);
	}

	@Override
	public Object saveState(FacesContext fc) {

		Object[] state = new Object[2];

		state[0] = super.saveState(fc);
		state[1] = this._for;

		return state;
	}

}
