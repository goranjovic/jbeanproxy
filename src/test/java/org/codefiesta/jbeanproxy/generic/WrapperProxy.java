package org.codefiesta.jbeanproxy.generic;

public interface WrapperProxy {

	void putOriginal(Object original);

	Object retrieveOriginal();

}