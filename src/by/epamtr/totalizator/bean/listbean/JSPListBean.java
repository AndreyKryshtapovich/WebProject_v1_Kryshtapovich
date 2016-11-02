package by.epamtr.totalizator.bean.listbean;

import java.util.Iterator;
import java.util.List;

import by.epamtr.totalizator.bean.entity.Event;

public class JSPListBean {
	private Iterator<?> it;
	private List<?> list;

	public JSPListBean() {
	}

	public JSPListBean(List<?> list) {
		this.list = list;
	}

	public String getSize() {
		it = list.iterator();
		return Integer.toString(list.size());
	}

	public Event getElement() {
		return (Event) it.next();
	}

}
