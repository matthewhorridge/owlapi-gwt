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

package uk.ac.manchester.cs.owl.owlapi;

import org.semanticweb.owlapi.model.*;

/**
 * Author: Matthew Horridge<br> The University of Manchester<br> Information Management Group<br>
 * Date: 15-Jan-2009
 */
public class OWLNamedIndividualImpl extends OWLIndividualImpl implements OWLNamedIndividual {


	private static final long serialVersionUID = 30402L;
	private final IRI iri;

    /**
     * @param iri the iri
     */
    public OWLNamedIndividualImpl(IRI iri) {
        super();
        this.iri = iri;
    }


    @Override
    public boolean isNamed() {
        return true;
    }

    /**
     * Gets the entity type for this entity
     * @return The entity type
     */
    @Override
    public EntityType<?> getEntityType() {
        return EntityType.NAMED_INDIVIDUAL;
    }

    /**
     * Gets an entity that has the same IRI as this entity but is of the specified type.
     * @param entityType The type of the entity to obtain.  This entity is not affected in any way.
     * @return An entity that has the same IRI as this entity and is of the specified type
     */
    @Override
    public <E extends OWLEntity> E getOWLEntity(EntityType<E> entityType) {
        return getOWLDataFactory().getOWLEntity(entityType, getIRI());
    }

    /**
     * Tests to see if this entity is of the specified type
     * @param entityType The entity type
     * @return <code>true</code> if this entity is of the specified type, otherwise <code>false</code>.
     */
    @Override
    public boolean isType(EntityType<?> entityType) {
        return getEntityType().equals(entityType);
    }

    /**
     * Returns a string representation that can be used as the ID of this entity.  This is the toString
     * representation of the IRI
     * @return A string representing the toString of the IRI of this entity.
     */
    @Override
    public String toStringID() {
        return iri.toString();
    }

    @Override
    public boolean isOWLNamedIndividual() {
        return true;
    }

    @Override
    public IRI getIRI() {
        return iri;
    }

    @Override
    public boolean isAnonymous() {
        return false;
    }

    @Override
    public OWLNamedIndividual asOWLNamedIndividual() {
        return this;
    }

    @Override
    public OWLAnonymousIndividual asOWLAnonymousIndividual() {
        throw new OWLRuntimeException("Not an anonymous individual");
    }

    @Override
    public OWLAnnotationProperty asOWLAnnotationProperty() {
        throw new OWLRuntimeException("Not an annotation property");
    }

    @Override
    public boolean isOWLAnnotationProperty() {
        return false;
    }

    @Override
	public boolean equals(Object obj) {
        if (super.equals(obj)) {
            if (!(obj instanceof OWLNamedIndividual)) {
                return false;
            }
            IRI otherIRI = ((OWLNamedIndividual) obj).getIRI();
            return otherIRI.equals(iri);
        }
        return false;
    }


    @Override
	protected int compareObjectOfSameType(OWLObject object) {
        OWLNamedIndividual other = (OWLNamedIndividual) object;
        return iri.compareTo(other.getIRI());
    }

    @Override
    public void accept(OWLObjectVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public <O> O accept(OWLObjectVisitorEx<O> visitor) {
        return visitor.visit(this);
    }

    @Override
    public void accept(OWLEntityVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public <O> O accept(OWLEntityVisitorEx<O> visitor) {
        return visitor.visit(this);
    }

    @Override
    public void accept(OWLNamedObjectVisitor visitor) {
        visitor.visit(this);
    }


    @Override
    public void accept(OWLIndividualVisitor visitor) {
        visitor.visit(this);
    }


    @Override
    public <O> O accept(OWLIndividualVisitorEx<O> visitor) {
        return visitor.visit(this);
    }


}
