package com.gregorbyte.xsp.renderkit;

import java.util.Collections;
import java.util.Iterator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import com.gregorbyte.xsp.component.Messages;
import com.ibm.commons.util.StringUtil;
import com.ibm.xsp.renderkit.html_basic.MessagesRendererEx;

public class MessagesRenderer extends MessagesRendererEx {

	@SuppressWarnings("unchecked")
	@Override
	protected Iterator getMessageIter(FacesContext context,
			String forComponent, UIComponent component) {

		Iterator messageIter = null;

		if (component == null) {

			messageIter = Collections.EMPTY_LIST.iterator();

		} else if (component instanceof Messages) {

			Messages m = (Messages) component;

			String forString = m.getFor();

			/*
			 * If a 'for' component was specified, return the messages for that
			 */
			if (StringUtil.isNotEmpty(forString)) {

				UIComponent forComp = getForComponent(context, forString,
						component);

				if (forComp != null) {
					messageIter = context.getMessages(forComp
							.getClientId(context));
				} else {
					messageIter = Collections.EMPTY_LIST.iterator();
				}

			} else {

				/*
				 * If no 'for' component was specified then return the messages
				 * registered against the 'messages' component
				 */
				messageIter = context.getMessages(component.getClientId(context));
			}

		} else {

			/*
			 * It is probably the normal messages control and this renderer was
			 * assigned using rendererType property, so we will do our default 
			 * functionality and return the messages for the messages component
			 */
			messageIter = context.getMessages(component.getClientId(context));
		}

		return messageIter;

	}

}
