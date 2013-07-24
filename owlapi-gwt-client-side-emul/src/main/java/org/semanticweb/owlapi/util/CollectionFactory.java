/*
 * This file is part of the OWL API.
 *
 * The contents of this file are subject to the LGPL License, Version 3.0.
 *
 * Copyright (C) 2011, The University of Manchester
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 *
 *
 * Alternatively, the contents of this file may be used under the terms of the Apache License, Version 2.0
 * in which case, the provisions of the Apache License Version 2.0 are applicable instead of those above.
 *
 * Copyright 2011, University of Manchester
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.semanticweb.owlapi.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Author: Matthew Horridge<br>
 * The University Of Manchester<br>
 * Bio-Health Informatics Group<br>
 * Date: 10-Jan-2007<br>
 * <br>
 */
public class CollectionFactory {


    /**
     * @return fresh non threadsafe set
     */
    public static <T> Set<T> createSet() {
        //TODO large number of sets stay very small, wasting space
        return new HashSet<T>();
    }

    /**
     * @return fresh non threadsafe list
     */
    public static <T> List<T> createList() {
        //TODO large number of sets stay very small, wasting space
        return new ArrayList<T>();
    }

    /**
     * @param c
     *            values to add to the set
     * @return fresh non threadsafe set
     */
    public static <T> Set<T> createSet(Collection<T> c) {
        return new HashSet<T>(c);
    }

    /**
     * @param initialCapacity
     *            initial capacity for the new set
     * @return fresh non threadsafe set
     */
    public static <T> Set<T> createSet(int initialCapacity) {
        return new HashSet<T>(initialCapacity);
    }

    /** @return fresh map */
    public static <K, V> Map<K, V> createMap() {
        return new HashMap<K, V>();
    }

    /**
     * @param elements
     *            values to add to the set
     * @return fresh non threadsafe set
     */
    public static <T> Set<T> createSet(T... elements) {
        Set<T> result = createSet();
        for (T t : elements) {
            result.add(t);
        }
        return result;
    }



    /**
     *
     * @param source
     *            the collection to lazily copy
     * @return a lazy defensive copy for source; the source collection will not
     *         be copied until a method that modifies the collection gets
     *         called, e.g., add(), addAll()
     */
    public static <T> Set<T> getCopyOnRequestSet(Collection<T> source) {
        return getCopyOnRequestSetFromMutableCollection(source);
    }

    /** @param source
     * @return copy on request that builds a list from the input set */
    public static <T> Set<T> getCopyOnRequestSetFromMutableCollection(Collection<T> source) {
        if (source == null || source.isEmpty()) {
            return Collections.emptySet();
        }
        return new ConditionalCopySet<T>(source, true);
    }

    /** @param source
     * @return copy on request that does not build a list immediately */
    public static <T> Set<T> getCopyOnRequestSetFromImmutableCollection(Collection<T> source) {
        if (source == null || source.isEmpty()) {
            return Collections.emptySet();
        }
        return new ConditionalCopySet<T>(source, false);
    }


    /**
     * a set implementation that uses a delegate collection for all read-only
     * operations and makes a copy if changes are attempted. Useful for cheap
     * defensive copies: no costly rehashing on the original collection is made
     * unless changes are attempted. Changes are not mirrored back to the
     * original collection, although changes to the original set BEFORE changes
     * to the copy are reflected in the copy. If the source collection is not
     * supposed to change, then this collection behaves just like a regular
     * defensive copy; if the source collection can change, then this collection
     * should be built from a cheap copy of the original collection.
     *
     * For example, if the source collection is a set, it can be copied into a
     * list; the cost of the copy operation from set to list is approximately
     * 1/3 of the cost of copying into a new HashSet. This is not efficient if
     * the most common operations performed on the copy are contains() or
     * containsAll(), since they are more expensive for lists wrt sets; a
     * counter for these calls is maintained by the collection, so if a large
     * number of contains/containsAll calls takes place, the delegate is turned
     * into a regular set.
     *
     * This implementation is not threadsafe even if the source set is: there is
     * no lock during the copy, and the new set is not threadsafe.
     *
     * @param <T>
     *            the type contained
     */
    public static class ConditionalCopySet<T> implements Set<T> {
        private boolean copyDone = false;
        protected Collection<T> delegate;
        private final static int maxContains = 10;
        private int containsCounter = 0;

        /** @param source
         *            initial elements
         * @param listCopy
         *            true if a copy must be made */
        public ConditionalCopySet(Collection<T> source, boolean listCopy) {
            if(listCopy) {
                this.delegate = new ArrayList<T>(source);
            }else {
                this.delegate=source;
            }
        }

        @SuppressWarnings("rawtypes")
        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (obj instanceof ConditionalCopySet) {
                return delegate.containsAll(((ConditionalCopySet) obj).delegate) && ((ConditionalCopySet<?>) obj).delegate.containsAll(delegate);
            }
            if (obj instanceof Collection) {
                return delegate.containsAll((Collection<?>)obj) && ((Collection<?>)obj).containsAll(delegate);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return delegate.hashCode();
        }

        @Override
        public String toString() {
            return delegate.toString();
        }

        @Override
        public boolean add(T arg0) {
            if (!copyDone) {
                copyDone = true;
                delegate = new HashSet<T>(delegate);
            }
            return delegate.add(arg0);
        }

        @Override
        public boolean addAll(Collection<? extends T> arg0) {
            if (!copyDone) {
                copyDone = true;
                delegate = new HashSet<T>(delegate);
            }
            return delegate.addAll(arg0);
        }

        @Override
        public void clear() {
            if (!copyDone) {
                copyDone = true;
                delegate = new HashSet<T>();
            }
            delegate.clear();
        }

        @Override
        public boolean contains(Object arg0) {
            containsCounter++;
            if (containsCounter >= maxContains && !copyDone) {
                // many calls to contains, inefficient if the delegate is not a set
                if (!(delegate instanceof Set)) {
                    copyDone = true;
                    delegate = new HashSet<T>(delegate);
                }
            }
            return delegate.contains(arg0);
        }

        @Override
        public boolean containsAll(Collection<?> arg0) {
            containsCounter++;
            if (containsCounter >= maxContains && !copyDone) {
                // many calls to contains, inefficient if the delegate is not a set
                if (!(delegate instanceof Set)) {
                    copyDone = true;
                    delegate = new HashSet<T>(delegate);
                }
            }
            return delegate.containsAll(arg0);
        }

        @Override
        public boolean isEmpty() {
            return delegate.isEmpty();
        }

        @Override
        public Iterator<T> iterator() {
            return delegate.iterator();
        }

        @Override
        public boolean remove(Object arg0) {
            if (!copyDone) {
                copyDone = true;
                delegate = new HashSet<T>(delegate);
            }
            return delegate.remove(arg0);
        }

        @Override
        public boolean removeAll(Collection<?> arg0) {
            if (!copyDone) {
                copyDone = true;
                delegate = new HashSet<T>(delegate);
            }
            return delegate.removeAll(arg0);
        }

        @Override
        public boolean retainAll(Collection<?> arg0) {
            if (!copyDone) {
                copyDone = true;
                delegate = new HashSet<T>(delegate);
            }
            return delegate.retainAll(arg0);
        }

        @Override
        public int size() {
            return delegate.size();
        }

        @Override
        public Object[] toArray() {
            return delegate.toArray();
        }

        @Override
        public <Type> Type[] toArray(Type[] arg0) {
            return delegate.toArray(arg0);
        }
    }


}
