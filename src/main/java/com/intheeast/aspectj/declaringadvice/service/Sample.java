package com.intheeast.aspectj.declaringadvice.service;

import java.util.Collection;

public interface Sample<T> {
	
	void sampleGenericMethod(T sampleGenericParam);
	void sampleGenericCollectionMethod(Collection<T> param);

}
