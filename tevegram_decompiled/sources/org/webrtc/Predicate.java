package org.webrtc;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public interface Predicate<T> {

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    /* renamed from: org.webrtc.Predicate$1, reason: invalid class name */
    class AnonymousClass1 implements Predicate {
        final /* synthetic */ Predicate val$other;

        public AnonymousClass1(Predicate predicate) {
            this.val$other = predicate;
        }

        @Override // org.webrtc.Predicate
        public final Predicate and(Predicate predicate) {
            return new AnonymousClass2(predicate);
        }

        @Override // org.webrtc.Predicate
        public final Predicate negate() {
            return new AnonymousClass3();
        }

        @Override // org.webrtc.Predicate
        public final Predicate or(Predicate predicate) {
            return new AnonymousClass1(predicate);
        }

        @Override // org.webrtc.Predicate
        public boolean test(Object obj) {
            return Predicate.this.test(obj) || this.val$other.test(obj);
        }
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    /* renamed from: org.webrtc.Predicate$2, reason: invalid class name */
    class AnonymousClass2 implements Predicate {
        final /* synthetic */ Predicate val$other;

        public AnonymousClass2(Predicate predicate) {
            this.val$other = predicate;
        }

        @Override // org.webrtc.Predicate
        public final Predicate and(Predicate predicate) {
            return new AnonymousClass2(predicate);
        }

        @Override // org.webrtc.Predicate
        public final Predicate negate() {
            return new AnonymousClass3();
        }

        @Override // org.webrtc.Predicate
        public final Predicate or(Predicate predicate) {
            return new AnonymousClass1(predicate);
        }

        @Override // org.webrtc.Predicate
        public boolean test(Object obj) {
            return Predicate.this.test(obj) && this.val$other.test(obj);
        }
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    /* renamed from: org.webrtc.Predicate$3, reason: invalid class name */
    class AnonymousClass3 implements Predicate {
        public AnonymousClass3() {
        }

        @Override // org.webrtc.Predicate
        public final Predicate and(Predicate predicate) {
            return new AnonymousClass2(predicate);
        }

        @Override // org.webrtc.Predicate
        public final Predicate negate() {
            return new AnonymousClass3();
        }

        @Override // org.webrtc.Predicate
        public final Predicate or(Predicate predicate) {
            return new AnonymousClass1(predicate);
        }

        @Override // org.webrtc.Predicate
        public boolean test(Object obj) {
            return !Predicate.this.test(obj);
        }
    }

    Predicate<T> and(Predicate<? super T> predicate);

    Predicate<T> negate();

    Predicate<T> or(Predicate<? super T> predicate);

    boolean test(T t8);
}
