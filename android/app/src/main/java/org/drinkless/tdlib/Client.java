package org.drinkless.tdlib;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.drinkless.tdlib.TdApi;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class Client {
    private static final AtomicLong clientCount;
    private static final AtomicLong currentQueryId;
    private static final ConcurrentHashMap<Integer, ExceptionHandler> defaultExceptionHandlers;
    private static final ConcurrentHashMap<Long, Handler> handlers;
    private static final ResponseReceiver responseReceiver;
    private static final ConcurrentHashMap<Integer, Handler> updateHandlers;
    private final int nativeClientId;

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public interface ExceptionHandler {
        void onException(Throwable th);
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public static class ExecutionException extends Exception {
        public final TdApi.Error error;

        public ExecutionException(TdApi.Error error) {
            super(error.code + ": " + error.message);
            this.error = error;
        }
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public static class Handler {
        final ExceptionHandler exceptionHandler;
        final ResultHandler resultHandler;

        public Handler(ResultHandler resultHandler, ExceptionHandler exceptionHandler) {
            this.resultHandler = resultHandler;
            this.exceptionHandler = exceptionHandler;
        }
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public interface LogMessageHandler {
        void onLogMessage(int i9, String str);
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public static class ResponseReceiver implements Runnable {
        private static final int MAX_EVENTS = 1000;
        private final int[] clientIds;
        private final long[] eventIds;
        private final TdApi.Object[] events;
        public boolean isRun;

        private ResponseReceiver() {
            this.isRun = false;
            this.clientIds = new int[1000];
            this.eventIds = new long[1000];
            this.events = new TdApi.Object[1000];
        }

        private void processResult(int i9, long j5, TdApi.Object object) {
            boolean z8 = j5 == 0 && (object instanceof TdApi.UpdateAuthorizationState) && (((TdApi.UpdateAuthorizationState) object).authorizationState instanceof TdApi.AuthorizationStateClosed);
            Handler handler = (Handler) (j5 == 0 ? Client.updateHandlers.get(Integer.valueOf(i9)) : Client.handlers.remove(Long.valueOf(j5)));
            if (handler != null) {
                try {
                    handler.resultHandler.onResult(object);
                } catch (Throwable th) {
                    ExceptionHandler exceptionHandler = handler.exceptionHandler;
                    if (exceptionHandler == null) {
                        exceptionHandler = (ExceptionHandler) Client.defaultExceptionHandlers.get(Integer.valueOf(i9));
                    }
                    if (exceptionHandler != null) {
                        try {
                            exceptionHandler.onException(th);
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
            if (z8) {
                Client.updateHandlers.remove(Integer.valueOf(i9));
                Client.defaultExceptionHandlers.remove(Integer.valueOf(i9));
                Client.clientCount.decrementAndGet();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                int nativeClientReceive = Client.nativeClientReceive(this.clientIds, this.eventIds, this.events, 100000.0d);
                for (int i9 = 0; i9 < nativeClientReceive; i9++) {
                    processResult(this.clientIds[i9], this.eventIds[i9], this.events[i9]);
                    this.events[i9] = null;
                }
            }
        }
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public interface ResultHandler {
        void onResult(TdApi.Object object);
    }

    static {
        try {
            System.loadLibrary("tdjni");
        } catch (UnsatisfiedLinkError e9) {
            e9.printStackTrace();
        }
        defaultExceptionHandlers = new ConcurrentHashMap<>();
        updateHandlers = new ConcurrentHashMap<>();
        handlers = new ConcurrentHashMap<>();
        currentQueryId = new AtomicLong();
        clientCount = new AtomicLong();
        responseReceiver = new ResponseReceiver();
    }

    private Client(ResultHandler resultHandler, ExceptionHandler exceptionHandler, ExceptionHandler exceptionHandler2) {
        clientCount.incrementAndGet();
        int createNativeClient = createNativeClient();
        this.nativeClientId = createNativeClient;
        if (resultHandler != null) {
            updateHandlers.put(Integer.valueOf(createNativeClient), new Handler(resultHandler, exceptionHandler));
        }
        if (exceptionHandler2 != null) {
            defaultExceptionHandlers.put(Integer.valueOf(createNativeClient), exceptionHandler2);
        }
        send(new TdApi.GetOption("version"), null, null);
    }

    public static Client create(ResultHandler resultHandler, ExceptionHandler exceptionHandler, ExceptionHandler exceptionHandler2) {
        Client client = new Client(resultHandler, exceptionHandler, exceptionHandler2);
        ResponseReceiver responseReceiver2 = responseReceiver;
        synchronized (responseReceiver2) {
            try {
                if (!responseReceiver2.isRun) {
                    responseReceiver2.isRun = true;
                    Thread thread = new Thread(responseReceiver2, "TDLib thread");
                    thread.setDaemon(true);
                    thread.start();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return client;
    }

    private static native int createNativeClient();

    public static <T extends TdApi.Object> T execute(TdApi.Function<T> function) {
        TdApi.Error error = (T) nativeClientExecute(function);
        if (error instanceof TdApi.Error) {
            throw new ExecutionException(error);
        }
        return error;
    }

    private static native TdApi.Object nativeClientExecute(TdApi.Function function);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int nativeClientReceive(int[] iArr, long[] jArr, TdApi.Object[] objectArr, double d9);

    private static native void nativeClientSend(int i9, long j5, TdApi.Function function);

    private static native void nativeClientSetLogMessageHandler(int i9, LogMessageHandler logMessageHandler);

    public static void setLogMessageHandler(int i9, LogMessageHandler logMessageHandler) {
        nativeClientSetLogMessageHandler(i9, logMessageHandler);
    }

    public void send(TdApi.Function function, ResultHandler resultHandler, ExceptionHandler exceptionHandler) {
        long incrementAndGet = currentQueryId.incrementAndGet();
        if (resultHandler != null) {
            handlers.put(Long.valueOf(incrementAndGet), new Handler(resultHandler, exceptionHandler));
        }
        nativeClientSend(this.nativeClientId, incrementAndGet, function);
    }

    public void send(TdApi.Function function, ResultHandler resultHandler) {
        send(function, resultHandler, null);
    }
}
