package org.semanticweb.owlapi.model;

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
            if (!Character.isLetter(ch) && !Character.isDigit(ch) && ch != '.' && ch != '+' && ch != '-') {
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
     */
    public String getStart() {
        return prefix;
    }


    /**
     * Determines if this IRI is in the reserved vocabulary. An IRI is in the
     * reserved vocabulary if it starts with
     * &lt;http://www.w3.org/1999/02/22-rdf-syntax-ns#&gt; or
     * &lt;http://www.w3.org/2000/01/rdf-schema#&gt; or
     * &lt;http://www.w3.org/2001/XMLSchema#&gt; or
     * &lt;http://www.w3.org/2002/07/owl#&gt;
     * @return <code>true</code> if the IRI is in the reserved vocabulary,
     *         otherwise <code>false</code>.
     */
    public boolean isReservedVocabulary() {
        return prefix.startsWith(Namespaces.OWL.toString()) || prefix.startsWith(Namespaces.RDF.toString()) || prefix.startsWith(Namespaces.RDFS.toString()) || prefix.startsWith(Namespaces.XSD.toString());
    }

    /**
     * Determines if this IRI is equal to the IRI that <code>owl:Thing</code> is
     * named with
     * @return <code>true</code> if this IRI is equal to
     *         &lt;http://www.w3.org/2002/07/owl#Thing&gt; and otherwise
     *         <code>false</code>
     */
    public boolean isThing() {
        return remainder != null && remainder.equals("Thing") && prefix.equals(Namespaces.OWL.toString());
    }

    /**
     * Determines if this IRI is equal to the IRI that <code>owl:Nothing</code>
     * is named with
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
     * @return <code>true</code> if this IRI is equal to
     *         &lt;http://www.w3.org/1999/02/22-rdf-syntax-ns#PlainLiteral&gt;,
     *         otherwise <code>false</code>
     */
    public boolean isPlainLiteral() {
        return remainder != null && remainder.equals("PlainLiteral") && prefix.equals(Namespaces.RDF.toString());
    }

    /**
     * Gets the fragment of the IRI.
     * @return The IRI fragment, or <code>null</code> if the IRI does not have a
     *         fragment
     */
    public String getFragment() {
        return remainder;
    }

    /**
     * Obtained this IRI surrounded by angled brackets
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
     * @param str The String that specifies the IRI. Cannot be null.
     * @return The IRI that has the specified string representation.
     */
    public static IRI create(String str) {
        if (str == null) {
            throw new IllegalArgumentException("String must not be null");
        }
        return new IRI(str);
    }

    /**
     * Creates an IRI by concatenating two strings.  The full IRI is an IRI that contains the characters in
     * prefix + suffix.
     * @param prefix The first string.  May be <code>null</code>.
     * @param suffix The second string. May be <code>null</code>.
     * @return An IRI whose characters consist of prefix + suffix.
     * @since 3.3
     */
    public static IRI create(String prefix, String suffix) {
        return new IRI(prefix, suffix);
    }




    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////
    //// Impl - All constructors are private - factory methods are used for public creation
    ////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////



    private static final long serialVersionUID = 30402L;

    private final String remainder;

    private final String prefix;

    private int hashCode = 0;


    /**
     * Constructs an IRI which is built from the concatenation of the specified prefix and suffix.
     * @param prefix The prefix.
     * @param fragment The suffix.
     */
    protected IRI(String prefix, String fragment) {
        this.prefix = prefix;
        remainder = fragment;
    }

    protected IRI(String s) {
        int fragmentSeparatorIndex = s.lastIndexOf('#');
        if (fragmentSeparatorIndex != -1 && fragmentSeparatorIndex < s.length()) {
            remainder = s.substring(fragmentSeparatorIndex + 1);
            prefix = s.substring(0, fragmentSeparatorIndex + 1);
        }
        else {
            int pathSeparatorIndex = s.lastIndexOf('/');
            if (pathSeparatorIndex != -1 && pathSeparatorIndex < s.length()) {
                remainder = s.substring(pathSeparatorIndex + 1);
                prefix = s.substring(0, pathSeparatorIndex + 1);
            }
            else {
                remainder = null;
                prefix = s;
            }
        }
    }

    /**
     * Returns the length of this character sequence.  The length is the number
     * of 16-bit <code>char</code>s in the sequence.</p>
     * @return the number of <code>char</code>s in this sequence
     */
    @Override
    public int length() {
        return prefix.length() + (remainder == null ? 0 : remainder.length());
    }

    /**
     * Returns the <code>char</code> value at the specified index.  An index ranges from zero
     * to <tt>length() - 1</tt>.  The first <code>char</code> value of the sequence is at
     * index zero, the next at index one, and so on, as for array
     * indexing. </p>
     * <p>If the <code>char</code> value specified by the index is a
     * <a href="Character.html#unicode">surrogate</a>, the surrogate
     * value is returned.
     * @param index the index of the <code>char</code> value to be returned
     * @return the specified <code>char</code> value
     * @throws IndexOutOfBoundsException if the <tt>index</tt> argument is negative or not less than
     *                                   <tt>length()</tt>
     */
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

    /**
     * Returns a new <code>CharSequence</code> that is a subsequence of this sequence.
     * The subsequence starts with the <code>char</code> value at the specified index and
     * ends with the <code>char</code> value at index <tt>end - 1</tt>.  The length
     * (in <code>char</code>s) of the
     * returned sequence is <tt>end - start</tt>, so if <tt>start == end</tt>
     * then an empty sequence is returned. </p>
     * @param start the start index, inclusive
     * @param end the end index, exclusive
     * @return the specified subsequence
     * @throws IndexOutOfBoundsException if <tt>start</tt> or <tt>end</tt> are negative,
     *                                   if <tt>end</tt> is greater than <tt>length()</tt>,
     *                                   or if <tt>start</tt> is greater than <tt>end</tt>
     */
    @Override
    public CharSequence subSequence(int start, int end) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        sb.append(remainder);
        return sb.subSequence(start, end);
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
            return otherRemainder != null && remainder.equals(otherRemainder) && other.prefix.equals(prefix);
        }
    }


    /**
     * Gets the signature of this object
     * @return A set of entities that correspond to the
     *         signature of this object. The set is a copy, changes are not reflected back.
     */
    @Override
    public Set<OWLEntity> getSignature() {
        return Collections.emptySet();
    }

    /**
     * Gets the anonymous individuals occurring in this object, as collected by an
     * OWLEntityCollector. The set is a copy, changes are not reflected back.
     * @return A set of anonymous individuals.
     */
    @Override
    public Set<OWLAnonymousIndividual> getAnonymousIndividuals() {
        return Collections.emptySet();
    }

    /**
     * A convenience method that obtains the classes
     * that are in the signature of this object
     * @return A set containing the classes that are in the signature
     *         of this object. The set is a subset of the signature, and
     *         is not backed by the signature; it is a modifiable collection
     *         and changes are not reflected by the signature.
     */
    @Override
    public Set<OWLClass> getClassesInSignature() {
        return Collections.emptySet();
    }

    /**
     * A convenience method that obtains the data properties
     * that are in the signature of this object
     * @return A set containing the data properties that are in the signature
     *         of this object.The set is a subset of the signature, and
     *         is not backed by the signature; it is a modifiable collection
     *         and changes are not reflected by the signature.
     */
    @Override
    public Set<OWLDataProperty> getDataPropertiesInSignature() {
        return Collections.emptySet();
    }

    /**
     * A convenience method that obtains the object properties
     * that are in the signature of this object
     * @return A set containing the object properties that are in the signature
     *         of this object.The set is a subset of the signature, and
     *         is not backed by the signature; it is a modifiable collection
     *         and changes are not reflected by the signature.
     */
    @Override
    public Set<OWLObjectProperty> getObjectPropertiesInSignature() {
        return Collections.emptySet();
    }

    /**
     * A convenience method that obtains the individuals
     * that are in the signature of this object
     * @return A set containing the individuals that are in the signature
     *         of this object.The set is a subset of the signature, and
     *         is not backed by the signature; it is a modifiable collection
     *         and changes are not reflected by the signature.
     */
    @Override
    public Set<OWLNamedIndividual> getIndividualsInSignature() {
        return Collections.emptySet();
    }

    /**
     * A convenience method that obtains the datatypes
     * that are in the signature of this object
     * @return A set containing the datatypes that are in the signature
     *         of this object.The set is a subset of the signature, and
     *         is not backed by the signature; it is a modifiable collection
     *         and changes are not reflected by the signature.
     */
    @Override
    public Set<OWLDatatype> getDatatypesInSignature() {
        return Collections.emptySet();
    }

    /**
     * Gets all of the nested (includes top level) class expressions that are used in this object
     * @return A set of {@link org.semanticweb.owlapi.model.OWLClassExpression}s that represent the nested class
     *         expressions used in this object.
     */
    @Override
    public Set<OWLClassExpression> getNestedClassExpressions() {
        return Collections.emptySet();
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
    public void accept(OWLAnnotationValueVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public <O> O accept(OWLAnnotationValueVisitorEx<O> visitor) {
        return visitor.visit(this);
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
     * <tt>y.compareTo(x)</tt> throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
     * <tt>x.compareTo(z)&gt;0</tt>.
     *
     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
     * all <tt>z</tt>.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
     * class that implements the <tt>Comparable</tt> interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     *         is less than, equal to, or greater than the specified object.
     * @throws ClassCastException if the specified object's type prevents it
     *                            from being compared to this object.
     */
    @Override
    public int compareTo(OWLObject o) {
        // TODO: COMPARATOR
        return 0;
    }
}
