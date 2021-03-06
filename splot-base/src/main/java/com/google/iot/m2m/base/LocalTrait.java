/*
 * Copyright (C) 2018 Google Inc.
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
package com.google.iot.m2m.base;

import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Interface which is implemented by helper classes (like {@link
 * com.google.iot.m2m.trait.BaseTrait.AbstractLocalTrait}) which are generated exclusively by the
 * trait annotation processor.
 *
 * <h3>END-DEVELOPERS SHOULD NOT DIRECTLY IMPLEMENT THIS INTERFACE.</h3>
 *
 * The automatically generated classes that implement this interface are used to help ease the
 * implementation burdens related to supporting traits when using {@link
 * com.google.iot.m2m.local.LocalFunctionalEndpoint}.
 */
@SuppressWarnings("unused")
public interface LocalTrait {
    /**
     * Should be implemented to return a set containing all of the child functional endpoints
     * associated with this trait. This method is automatically overridden with a {@code final}
     * implementation (returning null) on traits which do not support children.
     *
     * @return a new set containing all of the child functional endpoints for this trait
     */
    @Nullable
    Set<FunctionalEndpoint> onCopyChildrenSet();

    /**
     * Should be implemented to return the string used to identify the given child. If the given
     * functional endpoint isn't actually a child of this trait, this method returns {@code null}.
     * This method is automatically overridden with a {@code final} implementation (returning {@code
     * null}) on traits which do not support children.
     *
     * @param child the functional endpoint to obtain the child id of
     * @return the id of the given child, or {@code null} if not actually a child
     * @see #onGetChild(String)
     * @see #onCopyChildrenSet()
     */
    @Nullable
    String onGetIdForChild(FunctionalEndpoint child);

    /**
     * Should be implemented to return the child functional endpoint associated with the given child
     * id. If this trait doesn't have a child with the given child id, this method returns {@code
     * null}. This method is automatically overridden with a {@code final} implementation (returning
     * {@code null}) on traits which do not support children.
     *
     * @param childId the child id to look up
     * @return the child functional endpoint with the given child id, or {@code null} if the given
     *     child id isn't associated with a child on this trait.
     */
    @Nullable
    FunctionalEndpoint onGetChild(String childId);

    /**
     * Determines if the given property's value should be recorded when saving state or if it should
     * be ignored. The default implementation usually does the right thing, so there is rarely a
     * need to override this method.If overridden, you should handle the specific keys in question
     * and then call the super implementation for all other keys.
     */
    boolean onCanSaveProperty(PropertyKey<?> key);

    // Note: All methods below this point should be considered internal implementation details.

    /**
     * {@hide} Internal callback interface which is used exclusively by {@link
     * com.google.iot.m2m.local.LocalFunctionalEndpoint}.
     *
     * <h3>END-DEVELOPERS SHOULD NOT DIRECTLY USE OR IMPLEMENT THIS INTERFACE.</h3>
     *
     * <p>This is the mechanism that allows {@link com.google.iot.m2m.local.LocalFunctionalEndpoint}
     * to receive change notifications from a {@link LocalTrait} instance.
     */
    boolean onCanTransitionProperty(PropertyKey<?> key);

    /**
     * {@hide} Internal callback interface which is used exclusively by {@link
     * com.google.iot.m2m.local.LocalFunctionalEndpoint}.
     *
     * <h3>END-DEVELOPERS SHOULD NOT DIRECTLY USE OR IMPLEMENT THIS INTERFACE.</h3>
     *
     * <p>This is the mechanism that allows {@link com.google.iot.m2m.local.LocalFunctionalEndpoint}
     * to receive change notifications from a {@link LocalTrait} instance.
     */
    interface Callback {
        <T> void onPropertyChanged(LocalTrait trait, PropertyKey<T> key, T value);

        void onChildAdded(LocalTrait trait, FunctionalEndpoint child);

        void onChildRemoved(LocalTrait trait, FunctionalEndpoint child);
    }

    /**
     * {@hide} Sets the {@link Callback} interface to use to receive trait change notifications.
     *
     * <p>This method is used exclusively by {@link
     * com.google.iot.m2m.local.LocalFunctionalEndpoint} and is implemented automatically by classes
     * generated by the trait annotation processor. <b>END-DEVELOPERS SHOULD NOT DIRECTLY USE OR
     * IMPLEMENT THIS METHOD.</b>
     */
    void setCallback(Callback callback);

    /**
     * {@hide} Internal.
     *
     * <p>This method is used exclusively by {@link
     * com.google.iot.m2m.local.LocalFunctionalEndpoint} and is implemented automatically by classes
     * generated by the trait annotation processor. <b>END-DEVELOPERS SHOULD NOT DIRECTLY USE OR
     * IMPLEMENT THIS METHOD.</b>
     */
    String getTraitName();

    /**
     * {@hide} Internal.
     *
     * <p>This method is used exclusively by {@link
     * com.google.iot.m2m.local.LocalFunctionalEndpoint} and is implemented automatically by classes
     * generated by the trait annotation processor. <b>END-DEVELOPERS SHOULD NOT DIRECTLY USE OR
     * IMPLEMENT THIS METHOD.</b>
     */
    String getTraitUri();

    /**
     * {@hide} Internal.
     *
     * <p>This method is used exclusively by {@link
     * com.google.iot.m2m.local.LocalFunctionalEndpoint} and is implemented automatically by classes
     * generated by the trait annotation processor. <b>END-DEVELOPERS SHOULD NOT DIRECTLY USE OR
     * IMPLEMENT THIS METHOD.</b>
     */
    String getTraitId();

    /**
     * {@hide} Internal.
     *
     * <p>This method is used exclusively by {@link
     * com.google.iot.m2m.local.LocalFunctionalEndpoint} and is implemented automatically by classes
     * generated by the trait annotation processor. <b>END-DEVELOPERS SHOULD NOT DIRECTLY USE OR
     * IMPLEMENT THIS METHOD.</b>
     */
    Set<PropertyKey<?>> getSupportedPropertyKeys();

    /**
     * {@hide} Internal.
     *
     * <p>This method is used exclusively by {@link
     * com.google.iot.m2m.local.LocalFunctionalEndpoint} and is implemented automatically by classes
     * generated by the trait annotation processor. <b>END-DEVELOPERS SHOULD NOT DIRECTLY USE OR
     * IMPLEMENT THIS METHOD.</b>
     */
    <T> T getValueForPropertyKey(PropertyKey<T> key) throws PropertyException, TechnologyException;

    /**
     * {@hide} Internal.
     *
     * <p>This method is used exclusively by {@link
     * com.google.iot.m2m.local.LocalFunctionalEndpoint} and is implemented automatically by classes
     * generated by the trait annotation processor. <b>END-DEVELOPERS SHOULD NOT DIRECTLY USE OR
     * IMPLEMENT THIS METHOD.</b>
     */
    <T> void setValueForPropertyKey(PropertyKey<T> key, T value)
            throws PropertyException, TechnologyException;

    /**
     * {@hide} Internal.
     *
     * <p>This method is used exclusively by {@link
     * com.google.iot.m2m.local.LocalFunctionalEndpoint} and is implemented automatically by classes
     * generated by the trait annotation processor. <b>END-DEVELOPERS SHOULD NOT DIRECTLY USE OR
     * IMPLEMENT THIS METHOD.</b>
     */
    <T> T sanitizeValueForPropertyKey(PropertyKey<T> key, T value)
            throws PropertyException, TechnologyException;

    /**
     * {@hide} Internal.
     *
     * <p>This method is used exclusively by {@link
     * com.google.iot.m2m.local.LocalFunctionalEndpoint} and is implemented automatically by classes
     * generated by the trait annotation processor. <b>END-DEVELOPERS SHOULD NOT DIRECTLY USE OR
     * IMPLEMENT THIS METHOD.</b>
     */
    Set<MethodKey<?>> getSupportedMethodKeys();

    /**
     * {@hide} Internal.
     *
     * <p>This method is used exclusively by {@link
     * com.google.iot.m2m.local.LocalFunctionalEndpoint} and is implemented automatically by classes
     * generated by the trait annotation processor. <b>END-DEVELOPERS SHOULD NOT DIRECTLY USE OR
     * IMPLEMENT THIS METHOD.</b>
     */
    <T> T invokeMethod(MethodKey<T> methodKey, Map<String, Object> arguments)
            throws MethodException, TechnologyException;

    /**
     * {@hide} Internal.
     *
     * <p>This method is used exclusively by {@link
     * com.google.iot.m2m.local.LocalFunctionalEndpoint} and is implemented automatically by classes
     * generated by the trait annotation processor. <b>END-DEVELOPERS SHOULD NOT DIRECTLY USE OR
     * IMPLEMENT THIS METHOD.</b>
     */
    boolean supportsChildren();
}
