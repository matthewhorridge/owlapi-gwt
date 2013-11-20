package org.semanticweb.owlapi.gwt.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import org.semanticweb.owlapi.model.*;
import uk.ac.manchester.cs.owl.owlapi.*;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 19/11/2013
 * <p>
 *     Test cases for concrete implementation classes.  Real services would use interfaces e.g. OWLClass.
 *     The service has a method for each type that should be serializable.  This ensures it gets compiled by
 *     the GWT compiler and that errors are informative.
 * </p>
 */
@RemoteServiceRelativePath("owlobjects")
public interface OWLObjectSerializationTestsService extends RemoteService {


    AxiomType<?> testAxiomType(AxiomType<?> axiomType);

    EntityType<?> testEntityType(EntityType<?> entityType);

    ClassExpressionType testClassExpressionType(ClassExpressionType type);

    IRI testIRI(IRI iri);

    OWLOntologyID testOWLOntologyId(OWLOntologyID id);

    OWLClassImpl testOWLClassImpl(OWLClassImpl cls);

    OWLObjectPropertyImpl testOWLObjectPropertyImpl(OWLObjectPropertyImpl property);

    OWLDataPropertyImpl testOWLDataPropertyImpl(OWLDataPropertyImpl dataProperty);

    OWLAnnotationPropertyImpl testOWLAnnotationPropertyImpl(OWLAnnotationPropertyImpl annotationProperty);

    OWLNamedIndividualImpl testOWLNamedIndividualImpl(OWLNamedIndividualImpl namedIndividual);

    OWLDatatypeImpl testOWLDatatypeImpl(OWLDatatypeImpl datatype);

    OWLAnonymousIndividualImpl testOWLAnonymousIndividualImpl(OWLAnonymousIndividualImpl individual);

    OWLAnnotationImpl testOWLAnnotationImpl(OWLAnnotationImpl annotation);

    OWLImportsDeclarationImpl testOWLImportsDeclarationImpl(OWLImportsDeclarationImpl importsDeclaration);

    OWLLiteralImplBoolean testOWLLiteralImplBoolean(OWLLiteralImplBoolean literal);

    OWLLiteralImplDouble testOWLLiteralImplDouble(OWLLiteralImplDouble literal);

    OWLLiteralImplInteger testOWLLiteralImplInteger(OWLLiteralImplInteger literal);

    OWLLiteralImplNoCompression testOWLLiteralImplNoCompression(OWLLiteralImplNoCompression literal);

    OWL2DatatypeImpl testOWL2DatatypeImpl(OWL2DatatypeImpl datatype);
    
}
