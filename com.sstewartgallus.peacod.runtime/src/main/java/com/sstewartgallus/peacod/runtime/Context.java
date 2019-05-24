/*
 * Copyright 2019 Steven Stewart-Gallus.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sstewartgallus.peacod.runtime;

import jdk.dynalink.Operation;
import jdk.dynalink.linker.GuardedInvocation;

import java.lang.invoke.MethodType;

@SuppressWarnings("unused")
public abstract class Context {

    static final int INDEX_BITS = 12;
    public static final int PAGE_SIZE = 1 << INDEX_BITS;
    static final int INDEX_MASK = PAGE_SIZE - 1;

    Context() {

    }

    public static Context newInstance() {
        return new ContextImpl();
    }

    public abstract int anonymousPage();

    abstract GuardedInvocation link(Operation operation, Object[] namespaces, Object name, MethodType methodType, Object reciever, Object... arguments);
}
