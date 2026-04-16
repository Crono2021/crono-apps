package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class JsonStreamParser implements Iterator<JsonElement> {
    private final Object lock;
    private final JsonReader parser;

    public JsonStreamParser(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        this.parser = jsonReader;
        jsonReader.setLenient(true);
        this.lock = new Object();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        boolean z8;
        synchronized (this.lock) {
            try {
                try {
                    try {
                        z8 = this.parser.peek() != JsonToken.END_DOCUMENT;
                    } catch (IOException e9) {
                        throw new JsonIOException(e9);
                    }
                } catch (MalformedJsonException e10) {
                    throw new JsonSyntaxException(e10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z8;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public JsonElement next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        try {
            return Streams.parse(this.parser);
        } catch (OutOfMemoryError e9) {
            throw new JsonParseException("Failed parsing JSON source to Json", e9);
        } catch (StackOverflowError e10) {
            throw new JsonParseException("Failed parsing JSON source to Json", e10);
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public JsonStreamParser(String str) {
        this(new StringReader(str));
    }
}
