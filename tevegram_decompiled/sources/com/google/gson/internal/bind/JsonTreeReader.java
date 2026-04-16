package com.google.gson.internal.bind;

import androidx.fragment.app.a;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import m7.c;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class JsonTreeReader extends JsonReader {
    private int[] pathIndices;
    private String[] pathNames;
    private Object[] stack;
    private int stackSize;
    private static final Reader UNREADABLE_READER = new Reader() { // from class: com.google.gson.internal.bind.JsonTreeReader.1
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i9, int i10) {
            throw new AssertionError();
        }
    };
    private static final Object SENTINEL_CLOSED = new Object();

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    /* renamed from: com.google.gson.internal.bind.JsonTreeReader$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;

        static {
            int[] iArr = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = iArr;
            try {
                iArr[JsonToken.NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_DOCUMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public JsonTreeReader(JsonElement jsonElement) {
        super(UNREADABLE_READER);
        this.stack = new Object[32];
        this.stackSize = 0;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        push(jsonElement);
    }

    private void expect(JsonToken jsonToken) {
        if (peek() == jsonToken) {
            return;
        }
        StringBuilder sb = new StringBuilder("Expected ");
        sb.append(jsonToken);
        sb.append(" but was ");
        sb.append(peek());
        a.j(sb, locationString());
    }

    private String getPath(boolean z8) {
        StringBuilder sb = new StringBuilder("$");
        int i9 = 0;
        while (true) {
            int i10 = this.stackSize;
            if (i9 >= i10) {
                return sb.toString();
            }
            Object[] objArr = this.stack;
            Object obj = objArr[i9];
            if (obj instanceof JsonArray) {
                i9++;
                if (i9 < i10 && (objArr[i9] instanceof Iterator)) {
                    int i11 = this.pathIndices[i9];
                    if (z8 && i11 > 0 && (i9 == i10 - 1 || i9 == i10 - 2)) {
                        i11--;
                    }
                    sb.append('[');
                    sb.append(i11);
                    sb.append(']');
                }
            } else if ((obj instanceof JsonObject) && (i9 = i9 + 1) < i10 && (objArr[i9] instanceof Iterator)) {
                sb.append('.');
                String str = this.pathNames[i9];
                if (str != null) {
                    sb.append(str);
                }
            }
            i9++;
        }
    }

    private String locationString() {
        return " at path " + getPath();
    }

    private String nextName(boolean z8) {
        expect(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) peekStack()).next();
        String str = (String) entry.getKey();
        this.pathNames[this.stackSize - 1] = z8 ? "<skipped>" : str;
        push(entry.getValue());
        return str;
    }

    private Object peekStack() {
        return this.stack[this.stackSize - 1];
    }

    private Object popStack() {
        Object[] objArr = this.stack;
        int i9 = this.stackSize - 1;
        this.stackSize = i9;
        Object obj = objArr[i9];
        objArr[i9] = null;
        return obj;
    }

    private void push(Object obj) {
        int i9 = this.stackSize;
        Object[] objArr = this.stack;
        if (i9 == objArr.length) {
            int i10 = i9 * 2;
            this.stack = Arrays.copyOf(objArr, i10);
            this.pathIndices = Arrays.copyOf(this.pathIndices, i10);
            this.pathNames = (String[]) Arrays.copyOf(this.pathNames, i10);
        }
        Object[] objArr2 = this.stack;
        int i11 = this.stackSize;
        this.stackSize = i11 + 1;
        objArr2[i11] = obj;
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginArray() {
        expect(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) peekStack()).iterator());
        this.pathIndices[this.stackSize - 1] = 0;
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginObject() {
        expect(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) peekStack()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.JsonReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.stack = new Object[]{SENTINEL_CLOSED};
        this.stackSize = 1;
    }

    @Override // com.google.gson.stream.JsonReader
    public void endArray() {
        expect(JsonToken.END_ARRAY);
        popStack();
        popStack();
        int i9 = this.stackSize;
        if (i9 > 0) {
            int[] iArr = this.pathIndices;
            int i10 = i9 - 1;
            iArr[i10] = iArr[i10] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public void endObject() {
        expect(JsonToken.END_OBJECT);
        this.pathNames[this.stackSize - 1] = null;
        popStack();
        popStack();
        int i9 = this.stackSize;
        if (i9 > 0) {
            int[] iArr = this.pathIndices;
            int i10 = i9 - 1;
            iArr[i10] = iArr[i10] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String getPreviousPath() {
        return getPath(true);
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean hasNext() {
        JsonToken peek = peek();
        return (peek == JsonToken.END_OBJECT || peek == JsonToken.END_ARRAY || peek == JsonToken.END_DOCUMENT) ? false : true;
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean nextBoolean() {
        expect(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) popStack()).getAsBoolean();
        int i9 = this.stackSize;
        if (i9 > 0) {
            int[] iArr = this.pathIndices;
            int i10 = i9 - 1;
            iArr[i10] = iArr[i10] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.JsonReader
    public double nextDouble() {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek != jsonToken && peek != JsonToken.STRING) {
            StringBuilder sb = new StringBuilder("Expected ");
            sb.append(jsonToken);
            sb.append(" but was ");
            sb.append(peek);
            a.j(sb, locationString());
            return 0.0d;
        }
        double asDouble = ((JsonPrimitive) peekStack()).getAsDouble();
        if (!isLenient() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + asDouble);
        }
        popStack();
        int i9 = this.stackSize;
        if (i9 > 0) {
            int[] iArr = this.pathIndices;
            int i10 = i9 - 1;
            iArr[i10] = iArr[i10] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.JsonReader
    public int nextInt() {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek != jsonToken && peek != JsonToken.STRING) {
            StringBuilder sb = new StringBuilder("Expected ");
            sb.append(jsonToken);
            sb.append(" but was ");
            sb.append(peek);
            a.j(sb, locationString());
            return 0;
        }
        int asInt = ((JsonPrimitive) peekStack()).getAsInt();
        popStack();
        int i9 = this.stackSize;
        if (i9 > 0) {
            int[] iArr = this.pathIndices;
            int i10 = i9 - 1;
            iArr[i10] = iArr[i10] + 1;
        }
        return asInt;
    }

    public JsonElement nextJsonElement() {
        JsonToken peek = peek();
        if (peek == JsonToken.NAME || peek == JsonToken.END_ARRAY || peek == JsonToken.END_OBJECT || peek == JsonToken.END_DOCUMENT) {
            a.f(peek, " when reading a JsonElement.", "Unexpected ");
            return null;
        }
        JsonElement jsonElement = (JsonElement) peekStack();
        skipValue();
        return jsonElement;
    }

    @Override // com.google.gson.stream.JsonReader
    public long nextLong() {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek != jsonToken && peek != JsonToken.STRING) {
            StringBuilder sb = new StringBuilder("Expected ");
            sb.append(jsonToken);
            sb.append(" but was ");
            sb.append(peek);
            a.j(sb, locationString());
            return 0L;
        }
        long asLong = ((JsonPrimitive) peekStack()).getAsLong();
        popStack();
        int i9 = this.stackSize;
        if (i9 > 0) {
            int[] iArr = this.pathIndices;
            int i10 = i9 - 1;
            iArr[i10] = iArr[i10] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.JsonReader
    public void nextNull() {
        expect(JsonToken.NULL);
        popStack();
        int i9 = this.stackSize;
        if (i9 > 0) {
            int[] iArr = this.pathIndices;
            int i10 = i9 - 1;
            iArr[i10] = iArr[i10] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextString() {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.STRING;
        if (peek != jsonToken && peek != JsonToken.NUMBER) {
            StringBuilder sb = new StringBuilder("Expected ");
            sb.append(jsonToken);
            sb.append(" but was ");
            sb.append(peek);
            a.j(sb, locationString());
            return null;
        }
        String asString = ((JsonPrimitive) popStack()).getAsString();
        int i9 = this.stackSize;
        if (i9 > 0) {
            int[] iArr = this.pathIndices;
            int i10 = i9 - 1;
            iArr[i10] = iArr[i10] + 1;
        }
        return asString;
    }

    @Override // com.google.gson.stream.JsonReader
    public JsonToken peek() {
        if (this.stackSize == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object peekStack = peekStack();
        if (peekStack instanceof Iterator) {
            boolean z8 = this.stack[this.stackSize - 2] instanceof JsonObject;
            Iterator it = (Iterator) peekStack;
            if (!it.hasNext()) {
                return z8 ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            }
            if (z8) {
                return JsonToken.NAME;
            }
            push(it.next());
            return peek();
        }
        if (peekStack instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        }
        if (peekStack instanceof JsonArray) {
            return JsonToken.BEGIN_ARRAY;
        }
        if (peekStack instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive = (JsonPrimitive) peekStack;
            if (jsonPrimitive.isString()) {
                return JsonToken.STRING;
            }
            if (jsonPrimitive.isBoolean()) {
                return JsonToken.BOOLEAN;
            }
            if (jsonPrimitive.isNumber()) {
                return JsonToken.NUMBER;
            }
            throw new AssertionError();
        }
        if (peekStack instanceof JsonNull) {
            return JsonToken.NULL;
        }
        if (peekStack == SENTINEL_CLOSED) {
            c.p("JsonReader is closed");
            return null;
        }
        throw new MalformedJsonException("Custom JsonElement subclass " + peekStack.getClass().getName() + " is not supported");
    }

    public void promoteNameToValue() {
        expect(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) peekStack()).next();
        push(entry.getValue());
        push(new JsonPrimitive((String) entry.getKey()));
    }

    @Override // com.google.gson.stream.JsonReader
    public void skipValue() {
        int i9 = AnonymousClass2.$SwitchMap$com$google$gson$stream$JsonToken[peek().ordinal()];
        if (i9 == 1) {
            nextName(true);
            return;
        }
        if (i9 == 2) {
            endArray();
            return;
        }
        if (i9 == 3) {
            endObject();
            return;
        }
        if (i9 != 4) {
            popStack();
            int i10 = this.stackSize;
            if (i10 > 0) {
                int[] iArr = this.pathIndices;
                int i11 = i10 - 1;
                iArr[i11] = iArr[i11] + 1;
            }
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String toString() {
        return "JsonTreeReader" + locationString();
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextName() {
        return nextName(false);
    }

    @Override // com.google.gson.stream.JsonReader
    public String getPath() {
        return getPath(false);
    }
}
