package org.semanticweb.owlapi.model;

import org.semanticweb.owlapi.io.XMLUtils;
import org.semanticweb.owlapi.vocab.Namespaces;
import org.semanticweb.owlapi.vocab.OWLRDFVocabulary;

import java.util.Collections;
import java.util.Set;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 19/11/2012
 */
public class IRI implements CharSequence, OWLObject, SWRLPredicate, OWLAnnotationSubject, OWLAnnotationValue {

    /**
     * Determines if this IRI is absolute
     *
     * @return <code>true</code> if this IRI is absolute or <code>false</code>
     *         if this IRI is not absolute
     */
    public boolean isAbsolute() {
        int colonIndex = prefix.indexOf(':');
        if (colonIndex == -1) {
            return false;
        }
        for (int i = 0; i < colonIndex; i++) {
            char ch = prefix.charAt(i);
            if (!Character.isLetter(ch) && !Character.isDigit(ch) && ch != '.'
                    && ch != '+' && ch != '-') {
                return false;
            }
        }
        return true;
    }

    /**
     * @return the IRI scheme, e.g., http, urn... can be null
     */
    public String getScheme() {
        int colonIndex = prefix.indexOf(':');
        if (colonIndex == -1) {
            return null;
        }
        return prefix.substring(0, colonIndex);
    }

    /**
     * @return the prefix. Can be null.
     * @deprecated use getNamespace instead - better name
     */
    @Deprecated
    public String getStart() {
        return prefix;
    }

    /**
     * @return the prefix. Can be null.
     */
    public String getNamespace() {
        return prefix;
    }


    /**
     * Determines if this IRI is in the reserved vocabulary. An IRI is in the
     * reserved vocabulary if it starts with
     * &lt;http://www.w3.org/1999/02/22-rdf-syntax-ns#&gt; or
     * &lt;http://www.w3.org/2000/01/rdf-schema#&gt; or
     * &lt;http://www.w3.org/2001/XMLSchema#&gt; or
     * &lt;http://www.w3.org/2002/07/owl#&gt;
     *
     * @return <code>true</code> if the IRI is in the reserved vocabulary,
     *         otherwise <code>false</code>.
     */
    public boolean isReservedVocabulary() {
        return Namespaces.OWL.inNamespace(prefix) || Namespaces.RDF.inNamespace(prefix)
                || Namespaces.RDFS.inNamespace(prefix)
                || Namespaces.XSD.inNamespace(prefix);
    }

    /**
     * Determines if this IRI is equal to the IRI that <code>owl:Thing</code> is
     * named with
     *
     * @return <code>true</code> if this IRI is equal to
     *         &lt;http://www.w3.org/2002/07/owl#Thing&gt; and otherwise
     *         <code>false</code>
     */
    public boolean isThing() {
        return remainder != null && remainder.equals("Thing")
                && Namespaces.OWL.inNamespace(prefix);
    }

    /**
     * Determines if this IRI is equal to the IRI that <code>owl:Nothing</code>
     * is named with
     *
     * @return <code>true</code> if this IRI is equal to
     *         &lt;http://www.w3.org/2002/07/owl#Nothing&gt; and otherwise
     *         <code>false</code>
     */
    public boolean isNothing() {
        return equals(OWLRDFVocabulary.OWL_NOTHING.getIRI());
    }

    /**
     * Determines if this IRI is equal to the IRI that is named
     * <code>rdf:PlainLiteral</code>
     *
     * @return <code>true</code> if this IRI is equal to
     *         &lt;http://www.w3.org/1999/02/22-rdf-syntax-ns#PlainLiteral&gt;,
     *         otherwise <code>false</code>
     */
    public boolean isPlainLiteral() {
        return remainder != null && remainder.equals("PlainLiteral")
                && Namespaces.RDF.inNamespace(prefix);
    }

    /**
     * Gets the fragment of the IRI.
     *
     * @return The IRI fragment, or <code>null</code> if the IRI does not have a
     *         fragment
     */
    public String getFragment() {
        return remainder;
    }

    /**
     * Obtained this IRI surrounded by angled brackets
     *
     * @return This IRI surrounded by &lt; and &gt;
     */
    public String toQuotedString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(prefix);
        if (remainder != null) {
            sb.append(remainder);
        }
        sb.append(">");
        return sb.toString();
    }

    /**
     * Creates an IRI from the specified String.
     *
     * @param str The String that specifies the IRI. Cannot be null.
     * @return The IRI that has the specified string representation.
     */
    public static IRI create(String str) {
        if (str == null) {
            throw new IllegalArgumentException("String must not be null");
        }
        int index = XMLUtils.getNCNameSuffixIndex(str);
        if (index < 0) {
            // no ncname
            return new IRI(str, null);
        }
        return new IRI(str.substring(0, index), str.substring(index));
    }

    /**
     * Creates an IRI by concatenating two strings. The full IRI is an IRI that
     * contains the characters in prefix + suffix.
     *
     * @param prefix The first string. May be <code>null</code>.
     * @param suffix The second string. May be <code>null</code>.
     * @return An IRI whose characters consist of prefix + suffix.
     * @since 3.3
     */
    public static IRI create(String prefix, String suffix) {
        if (prefix == null) {
            return create(suffix);
        }
        else if (suffix == null) {
            // suffix set deliberately to null is used only in blank node
            // management
            // this is not great but blank nodes should be changed to not refer
            // to IRIs at all
            // XXX address blank node issues with iris
            return create(prefix);
        }
        else {
            int index = XMLUtils.getNCNameSuffixIndex(prefix);
            int test = XMLUtils.getNCNameSuffixIndex(suffix);
            if (index == -1 && test == 0) {
                // the prefix does not contain an ncname character and there is
                // no illegal character in the suffix
                // the split is therefore correct
                return new IRI(prefix, suffix);
            }
            // otherwise the split is wrong; we could obtain the right split by
            // using index and test, but it's just as easy to use the other
            // constructor
            return create(prefix + suffix);
        }
    }

    // ///////////////////////////////////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////
    // //
    // // Impl - All constructors are private - factory methods are used for
    // public creation
    // //
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////

    private final String remainder;

    private final String prefix;

    private int hashCode = 0;

    /**
     * Constructs an IRI which is built from the concatenation of the specified
     * prefix and suffix.
     *
     * @param prefix   The prefix.
     * @param fragment The suffix.
     */
    protected IRI(String prefix, String fragment) {
        this.prefix = prefix;
        remainder = fragment;
    }

    protected IRI(String s) {
        this(XMLUtils.getNCNamePrefix(s), XMLUtils.getNCNameSuffix(s));
    }

    @Override
    public int length() {
        return prefix.length() + (remainder == null ? 0 : remainder.length());
    }

    @Override
    public char charAt(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index >= length()) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index < prefix.length()) {
            return prefix.charAt(index);
        }
        return remainder.charAt(index - prefix.length());
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        sb.append(remainder);
        return sb.subSequence(start, end);
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
    public void accept(OWLAnnotationSubjectVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public <E> E accept(OWLAnnotationSubjectVisitorEx<E> visitor) {
        return visitor.visit(this);
    }

    @Override
    public Set<OWLClass> getClassesInSignature() {
        return Collections.emptySet();
    }

    @Override
    public Set<OWLDataProperty> getDataPropertiesInSignature() {
        return Collections.emptySet();
    }

    @Override
    public Set<OWLNamedIndividual> getIndividualsInSignature() {
        return Collections.emptySet();
    }

    @Override
    public Set<OWLObjectProperty> getObjectPropertiesInSignature() {
        return Collections.emptySet();
    }

    @Override
    public Set<OWLEntity> getSignature() {
        return Collections.emptySet();
    }

    @Override
    public Set<OWLAnonymousIndividual> getAnonymousIndividuals() {
        return Collections.emptySet();
    }

    @Override
    public Set<OWLDatatype> getDatatypesInSignature() {
        return Collections.emptySet();
    }

    @Override
    public Set<OWLClassExpression> getNestedClassExpressions() {
        return Collections.emptySet();
    }

    @Override
    public int compareTo(OWLObject o) {
        if (o == this) {
            return 0;
        }
        if (!(o instanceof IRI)) {
            return -1;
        }
        IRI other = (IRI) o;
        int diff = prefix.compareTo(other.prefix);
        if (diff != 0) {
            return diff;
        }
        String otherRemainder = other.remainder;
        if (remainder == null) {
            if (otherRemainder == null) {
                return 0;
            }
            else {
                return -1;
            }
        }
        else {
            if (otherRemainder == null) {
                return 1;
            }
            else {
                return remainder.compareTo(otherRemainder);
            }
        }
    }

    @Override
    public String toString() {
        if (remainder != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(prefix);
            sb.append(remainder);
            return sb.toString();
        }
        else {
            return prefix;
        }
    }

    @Override
    public int hashCode() {
        if (hashCode == 0) {
            hashCode = prefix.hashCode() + (remainder != null ? remainder.hashCode() : 0);
        }
        return hashCode;
    }

    @Override
    public void accept(OWLAnnotationValueVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public <O> O accept(OWLAnnotationValueVisitorEx<O> visitor) {
        return visitor.visit(this);
    }

    @Override
    public boolean isTopEntity() {
        return false;
    }

    @Override
    public boolean isBottomEntity() {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IRI)) {
            return false;
        }
        IRI other = (IRI) obj;
        String otherRemainder = other.remainder;
        if (remainder == null) {
            return otherRemainder == null && prefix.equals(other.prefix);
        }
        else {
            return otherRemainder != null && remainder.equals(otherRemainder)
                    && other.prefix.equals(prefix);
        }
    }
}
