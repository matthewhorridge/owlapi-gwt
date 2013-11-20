package org.semanticweb.owlapi.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.semanticweb.owlapi.gwt.client.OWLObjectSerializationTestsService;
import org.semanticweb.owlapi.model.*;
import uk.ac.manchester.cs.owl.owlapi.*;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 19/11/2013
 */
public class OWLObjectSerializationTestsServiceImpl extends RemoteServiceServlet implements OWLObjectSerializationTestsService {

    @Override
    public AxiomType<?> testAxiomType(AxiomType<?> axiomType) {
        return axiomType;
    }

    @Override
    public EntityType<?> testEntityType(EntityType<?> entityType) {
        return entityType;
    }

    @Override
    public IRI testIRI(IRI iri) {
        return iri;
    }

    @Override
    public OWLOntologyID testOWLOntologyId(OWLOntologyID id) {
        return id;
    }

    @Override
    public OWLClassImpl testOWLClassImpl(OWLClassImpl cls) {
        return cls;
    }

    @Override
    public OWLObjectPropertyImpl testOWLObjectPropertyImpl(OWLObjectPropertyImpl property) {
        return property;
    }

    @Override
    public OWLDataPropertyImpl testOWLDataPropertyImpl(OWLDataPropertyImpl dataProperty) {
        return dataProperty;
    }

    @Override
    public OWLAnnotationPropertyImpl testOWLAnnotationPropertyImpl(OWLAnnotationPropertyImpl annotationProperty) {
        return annotationProperty;
    }

    @Override
    public OWLNamedIndividualImpl testOWLNamedIndividualImpl(OWLNamedIndividualImpl namedIndividual) {
        return namedIndividual;
    }

    @Override
    public OWLDatatypeImpl testOWLDatatypeImpl(OWLDatatypeImpl datatype) {
        return datatype;
    }

    @Override
    public OWLAnonymousIndividualImpl testOWLAnonymousIndividualImpl(OWLAnonymousIndividualImpl individual) {
        return individual;
    }

    @Override
    public OWLAnnotationImpl testOWLAnnotationImpl(OWLAnnotationImpl annotation) {
        return annotation;
    }

    @Override
    public OWLImportsDeclarationImpl testOWLImportsDeclarationImpl(OWLImportsDeclarationImpl importsDeclaration) {
        return importsDeclaration;
    }

    @Override
    public OWLLiteralImplBoolean testOWLLiteralImplBoolean(OWLLiteralImplBoolean literal) {
        return literal;
    }

    @Override
    public OWLLiteralImplDouble testOWLLiteralImplDouble(OWLLiteralImplDouble literal) {
        return literal;
    }

    @Override
    public OWLLiteralImplInteger testOWLLiteralImplInteger(OWLLiteralImplInteger literal) {
        return literal;
    }

    @Override
    public OWLLiteralImplNoCompression testOWLLiteralImplNoCompression(OWLLiteralImplNoCompression literal) {
        return literal;
    }

    @Override
    public OWL2DatatypeImpl testOWL2DatatypeImpl(OWL2DatatypeImpl datatype) {
        return datatype;
    }
}
