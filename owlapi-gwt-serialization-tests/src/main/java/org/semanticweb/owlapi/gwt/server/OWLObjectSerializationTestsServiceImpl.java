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

    @Override
    public OWLSubClassOfAxiomImpl testOWLSubClassOfAxiomImpl(OWLSubClassOfAxiomImpl axiom) {
        return axiom;
    }

    @Override
    public OWLEquivalentClassesAxiomImpl testOWLEquivalentClassesAxiomImpl(OWLEquivalentClassesAxiomImpl axiom) {
        return axiom;
    }

    @Override
    public OWLDisjointClassesAxiomImpl testOWLDisjointClassesAxiomImpl(OWLDisjointClassesAxiomImpl axiom) {
        return axiom;
    }

    @Override
    public OWLDisjointUnionAxiomImpl testOWLDisjointUnionAxiomImpl(OWLDisjointUnionAxiomImpl axiom) {
        return axiom;
    }

    @Override
    public OWLClassAssertionAxiomImpl testOWLClassAssertionAxiomImpl(OWLClassAssertionAxiomImpl axiom) {
        return axiom;
    }

    @Override
    public OWLObjectPropertyAssertionAxiomImpl testOWLObjectPropertyAssertionAxiomImpl(OWLObjectPropertyAssertionAxiomImpl axiom) {
        return axiom;
    }

    @Override
    public OWLDataPropertyAssertionAxiomImpl testOWLDataPropertyAssertionAxiomImpl(OWLDataPropertyAssertionAxiomImpl axiom) {
        return axiom;
    }

    @Override
    public OWLNegativeObjectPropertyAssertionAxiomImpl testOWLNegativeObjectPropertyAssertionAxiomImpl(OWLNegativeObjectPropertyAssertionAxiomImpl axiom) {
        return axiom;
    }

    @Override
    public OWLNegativeDataPropertyAssertionAxiomImpl testOWLNegativeDataPropertyAssertionAxiomImpl(OWLNegativeDataPropertyAssertionAxiomImpl axiom) {
        return axiom;
    }

    @Override
    public OWLSameIndividualAxiomImpl testOWLSameIndividualAxiomImpl(OWLSameIndividualAxiomImpl axiom) {
        return axiom;
    }

    @Override
    public OWLDifferentIndividualsAxiomImpl testOWLDifferentIndividualsAxiomImpl(OWLDifferentIndividualsAxiomImpl axiom) {
        return axiom;
    }

    @Override
    public OWLSubObjectPropertyOfAxiomImpl testOWLSubObjectPropertyOfAxiomImpl(OWLSubObjectPropertyOfAxiomImpl axiom) {
        return axiom;
    }

    @Override
    public OWLEquivalentObjectPropertiesAxiomImpl testOWLEquivalentObjectPropertiesAxiomImpl(OWLEquivalentObjectPropertiesAxiomImpl axiom) {
        return axiom;
    }

    @Override
    public OWLDisjointObjectPropertiesAxiomImpl testOWLDisjointObjectPropertiesAxiomImpl(OWLDisjointObjectPropertiesAxiomImpl axiom) {
        return axiom;
    }

    @Override
    public OWLInverseObjectPropertiesAxiomImpl testOWLInverseObjectPropertiesAxiomImpl(OWLInverseObjectPropertiesAxiomImpl axiom) {
        return axiom;
    }

    @Override
    public OWLObjectPropertyDomainAxiomImpl testOWLObjectPropertyDomainAxiomImpl(OWLObjectPropertyDomainAxiomImpl axiom) {
        return axiom;
    }

    @Override
    public OWLObjectPropertyRangeAxiomImpl testOWLObjectPropertyRangeAxiomImpl(OWLObjectPropertyRangeAxiomImpl axiom) {
        return axiom;
    }

    @Override
    public OWLFunctionalObjectPropertyAxiomImpl testOWLFunctionalObjectPropertyAxiomImpl(OWLFunctionalObjectPropertyAxiomImpl axiom) {
        return axiom;
    }

    @Override
    public OWLInverseFunctionalObjectPropertyAxiomImpl testOWLInverseFunctionalObjectPropertyAxiomImpl(OWLInverseFunctionalObjectPropertyAxiomImpl axiom) {
        return axiom;
    }

    @Override
    public OWLReflexiveObjectPropertyAxiomImpl testOWLReflexiveObjectPropertyAxiomImpl(OWLReflexiveObjectPropertyAxiomImpl axiom) {
        return axiom;
    }

    @Override
    public OWLIrreflexiveObjectPropertyAxiomImpl testOWLIrreflexiveObjectPropertyAxiomImpl(OWLIrreflexiveObjectPropertyAxiomImpl axiom) {
        return axiom;
    }

    @Override
    public OWLSymmetricObjectPropertyAxiomImpl testOWLSymmetricObjectPropertyAxiomImpl(OWLSymmetricObjectPropertyAxiomImpl axiom) {
        return axiom;
    }

    @Override
    public OWLAsymmetricObjectPropertyAxiomImpl testOWLAsymmetricObjectPropertyAxiomImpl(OWLAsymmetricObjectPropertyAxiomImpl axiom) {
        return axiom;
    }

    @Override
    public OWLTransitiveObjectPropertyAxiomImpl testOWLTransitiveObjectPropertyAxiomImpl(OWLTransitiveObjectPropertyAxiomImpl axiom) {
        return axiom;
    }

    @Override
    public OWLSubDataPropertyOfAxiomImpl testOWLSubDataPropertyOfAxiomImpl(OWLSubDataPropertyOfAxiomImpl axiom) {
        return axiom;
    }

    @Override
    public OWLEquivalentDataPropertiesAxiomImpl testOWLEquivalentDataPropertiesAxiomImpl(OWLEquivalentDataPropertiesAxiomImpl axiom) {
        return axiom;
    }

    @Override
    public OWLDisjointDataPropertiesAxiomImpl testOWLDisjointDataPropertiesAxiomImpl(OWLDisjointDataPropertiesAxiomImpl axiom) {
        return axiom;
    }

    @Override
    public OWLDataPropertyDomainAxiomImpl testOWLDataPropertyDomainAxiomImpl(OWLDataPropertyDomainAxiomImpl axiom) {
        return axiom;
    }

    @Override
    public OWLDataPropertyRangeAxiomImpl testOWLDataPropertyRangeAxiomImpl(OWLDataPropertyRangeAxiomImpl axiom) {
        return axiom;
    }

    @Override
    public OWLFunctionalDataPropertyAxiomImpl testOWLFunctionalDataPropertyAxiomImpl(OWLFunctionalDataPropertyAxiomImpl axiom) {
        return axiom;
    }

    @Override
    public OWLSubAnnotationPropertyOfAxiomImpl testOWLSubAnnotationPropertyOfAxiomImpl(OWLSubAnnotationPropertyOfAxiomImpl axiom) {
        return axiom;
    }

    @Override
    public OWLAnnotationPropertyDomainAxiomImpl testOWLAnnotationPropertyDomainAxiomImpl(OWLAnnotationPropertyDomainAxiomImpl axiom) {
        return axiom;
    }

    @Override
    public OWLAnnotationPropertyRangeAxiomImpl testOWLAnnotationPropertyRangeAxiomImpl(OWLAnnotationPropertyRangeAxiomImpl axiom) {
        return axiom;
    }

    @Override
    public OWLDatatypeDefinitionAxiomImpl testOWLDatatypeDefinitionAxiomImpl(OWLDatatypeDefinitionAxiomImpl axiom) {
        return axiom;
    }

    @Override
    public OWLHasKeyAxiomImpl testOWLHasKeyAxiomImpl(OWLHasKeyAxiomImpl axiom) {
        return axiom;
    }
}
