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
    public ClassExpressionType testClassExpressionType(ClassExpressionType type) {
        return type;
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

    @Override
    public OWLObjectInverseOfImpl testOWLObjectInverseOfImpl(OWLObjectInverseOfImpl property) {
        return property;
    }

    @Override
    public OWLObjectSomeValuesFromImpl testOWLObjectSomeValuesFromImpl(OWLObjectSomeValuesFromImpl classExpression) {
        return classExpression;
    }

    @Override
    public OWLObjectAllValuesFromImpl testOWLObjectAllValuesFromImpl(OWLObjectAllValuesFromImpl classExpression) {
        return classExpression;
    }

    @Override
    public OWLObjectHasValueImpl testOWLObjectHasValueImpl(OWLObjectHasValueImpl classExpression) {
        return classExpression;
    }

    @Override
    public OWLObjectMinCardinalityImpl testOWLObjectMinCardinalityImpl(OWLObjectMinCardinalityImpl classExpression) {
        return classExpression;
    }

    @Override
    public OWLObjectMaxCardinalityImpl testOWLObjectMaxCardinalityImpl(OWLObjectMaxCardinalityImpl classExpression) {
        return classExpression;
    }

    @Override
    public OWLObjectExactCardinalityImpl testOWLObjectExactCardinalityImpl(OWLObjectExactCardinalityImpl classExpression) {
        return classExpression;
    }

    @Override
    public OWLObjectHasSelfImpl testOWLObjectHasSelfImpl(OWLObjectHasSelfImpl classExpression) {
        return classExpression;
    }

    @Override
    public OWLObjectIntersectionOfImpl testOWLObjectIntersectionOfImpl(OWLObjectIntersectionOfImpl classExpression) {
        return classExpression;
    }

    @Override
    public OWLObjectUnionOfImpl testOWLObjectUnionOfImpl(OWLObjectUnionOfImpl classExpression) {
        return classExpression;
    }

    @Override
    public OWLObjectComplementOfImpl testOWLObjectComplementOfImpl(OWLObjectComplementOfImpl classExpression) {
        return classExpression;
    }

    @Override
    public OWLObjectOneOfImpl testOWLObjectOneOfImpl(OWLObjectOneOfImpl classExpression) {
        return classExpression;
    }

    @Override
    public OWLDataSomeValuesFromImpl testOWLDataSomeValuesFromImpl(OWLDataSomeValuesFromImpl classExpression) {
        return classExpression;
    }

    @Override
    public OWLDataAllValuesFromImpl testOWLDataAllValuesFromImpl(OWLDataAllValuesFromImpl classExpression) {
        return classExpression;
    }

    @Override
    public OWLDataHasValueImpl testOWLDataHasValueImpl(OWLDataHasValueImpl classExpression) {
        return classExpression;
    }

    @Override
    public OWLDataMinCardinalityImpl testOWLDataMinCardinalityImpl(OWLDataMinCardinalityImpl classExpression) {
        return classExpression;
    }

    @Override
    public OWLDataMaxCardinalityImpl testOWLDataMaxCardinalityImpl(OWLDataMaxCardinalityImpl classExpression) {
        return classExpression;
    }

    @Override
    public OWLDataExactCardinalityImpl testOWLDataExactCardinalityImpl(OWLDataExactCardinalityImpl classExpression) {
        return classExpression;
    }

    @Override
    public OWLDataIntersectionOfImpl testOWLDataIntersectionOfImpl(OWLDataIntersectionOfImpl classExpression) {
        return classExpression;
    }

    @Override
    public OWLDataUnionOfImpl testOWLDataUnionOfImpl(OWLDataUnionOfImpl classExpression) {
        return classExpression;
    }

    @Override
    public OWLDataComplementOfImpl testOWLDataComplementOfImpl(OWLDataComplementOfImpl classExpression) {
        return classExpression;
    }

    @Override
    public OWLDataOneOfImpl testOWLDataOneOfImpl(OWLDataOneOfImpl classExpression) {
        return classExpression;
    }

    @Override
    public OWLDatatypeRestrictionImpl testOWLDatatypeRestrictionImpl(OWLDatatypeRestrictionImpl classExpression) {
        return classExpression;
    }

    @Override
    public OWLFacetRestrictionImpl testOWLFacetRestrictionImpl(OWLFacetRestrictionImpl facetRestriction) {
        return facetRestriction;
    }
}
