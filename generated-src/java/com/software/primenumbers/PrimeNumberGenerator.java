// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from example.djinni

package com.software.primenumbers;

import java.util.concurrent.atomic.AtomicBoolean;

public abstract class PrimeNumberGenerator {
    public static native int generatePrime(int previousPrime);

    private static final class CppProxy extends PrimeNumberGenerator
    {
        private final long nativeRef;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);

        private CppProxy(long nativeRef)
        {
            if (nativeRef == 0) throw new RuntimeException("nativeRef is zero");
            this.nativeRef = nativeRef;
        }

        private native void nativeDestroy(long nativeRef);
        public void destroy()
        {
            boolean destroyed = this.destroyed.getAndSet(true);
            if (!destroyed) nativeDestroy(this.nativeRef);
        }
        protected void finalize() throws java.lang.Throwable
        {
            destroy();
            super.finalize();
        }
    }
}
