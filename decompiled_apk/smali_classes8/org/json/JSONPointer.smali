.class public Lorg/json/JSONPointer;
.super Ljava/lang/Object;
.source "JSONPointer.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/json/JSONPointer$Builder;
    }
.end annotation


# static fields
.field private static final ENCODING:Ljava/lang/String; = "utf-8"


# instance fields
.field private final refTokens:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 6
    .param p1, "pointer"    # Ljava/lang/String;

    .line 120
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 121
    if-eqz p1, :cond_8

    .line 124
    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_7

    const-string v0, "#"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    goto/16 :goto_3

    .line 129
    :cond_0
    const-string v0, "#/"

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 130
    const/4 v0, 0x2

    invoke-virtual {p1, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    .line 132
    .local v0, "refs":Ljava/lang/String;
    :try_start_0
    const-string v1, "utf-8"

    invoke-static {v0, v1}, Ljava/net/URLDecoder;->decode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-object v0, v1

    .line 135
    goto :goto_0

    .line 133
    :catch_0
    move-exception v1

    .line 134
    .local v1, "e":Ljava/io/UnsupportedEncodingException;
    new-instance v2, Ljava/lang/RuntimeException;

    invoke-direct {v2, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v2

    .line 136
    .end local v0    # "refs":Ljava/lang/String;
    .end local v1    # "e":Ljava/io/UnsupportedEncodingException;
    :cond_1
    const-string v0, "/"

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 137
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    .line 141
    .restart local v0    # "refs":Ljava/lang/String;
    :goto_0
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lorg/json/JSONPointer;->refTokens:Ljava/util/List;

    .line 142
    const/4 v1, -0x1

    .line 143
    .local v1, "slashIdx":I
    const/4 v2, 0x0

    .line 145
    .local v2, "prevSlashIdx":I
    :cond_2
    add-int/lit8 v2, v1, 0x1

    .line 146
    const/16 v3, 0x2f

    invoke-virtual {v0, v3, v2}, Ljava/lang/String;->indexOf(II)I

    move-result v1

    .line 147
    if-eq v2, v1, :cond_5

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v3

    if-ne v2, v3, :cond_3

    goto :goto_1

    .line 151
    :cond_3
    if-ltz v1, :cond_4

    .line 152
    invoke-virtual {v0, v2, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    .line 153
    .local v3, "token":Ljava/lang/String;
    iget-object v4, p0, Lorg/json/JSONPointer;->refTokens:Ljava/util/List;

    invoke-static {v3}, Lorg/json/JSONPointer;->unescape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 154
    .end local v3    # "token":Ljava/lang/String;
    goto :goto_2

    .line 156
    :cond_4
    invoke-virtual {v0, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v3

    .line 157
    .restart local v3    # "token":Ljava/lang/String;
    iget-object v4, p0, Lorg/json/JSONPointer;->refTokens:Ljava/util/List;

    invoke-static {v3}, Lorg/json/JSONPointer;->unescape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 150
    .end local v3    # "token":Ljava/lang/String;
    :cond_5
    :goto_1
    iget-object v3, p0, Lorg/json/JSONPointer;->refTokens:Ljava/util/List;

    const-string v4, ""

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 159
    :goto_2
    if-gez v1, :cond_2

    .line 164
    return-void

    .line 139
    .end local v0    # "refs":Ljava/lang/String;
    .end local v1    # "slashIdx":I
    .end local v2    # "prevSlashIdx":I
    :cond_6
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "a JSON pointer should start with \'/\' or \'#/\'"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 125
    :cond_7
    :goto_3
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lorg/json/JSONPointer;->refTokens:Ljava/util/List;

    .line 126
    return-void

    .line 122
    :cond_8
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "pointer cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public constructor <init>(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .line 166
    .local p1, "refTokens":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 167
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, p1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v0, p0, Lorg/json/JSONPointer;->refTokens:Ljava/util/List;

    .line 168
    return-void
.end method

.method public static builder()Lorg/json/JSONPointer$Builder;
    .locals 1

    .line 106
    new-instance v0, Lorg/json/JSONPointer$Builder;

    invoke-direct {v0}, Lorg/json/JSONPointer$Builder;-><init>()V

    return-object v0
.end method

.method private static escape(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "token"    # Ljava/lang/String;

    .line 254
    const-string v0, "~"

    const-string v1, "~0"

    invoke-virtual {p0, v0, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 255
    const-string v1, "/"

    const-string v2, "~1"

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 254
    return-object v0
.end method

.method private static readByIndexToken(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    .locals 7
    .param p0, "current"    # Ljava/lang/Object;
    .param p1, "indexToken"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONPointerException;
        }
    .end annotation

    .line 215
    :try_start_0
    invoke-static {p1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    .line 216
    .local v0, "index":I
    move-object v1, p0

    check-cast v1, Lorg/json/JSONArray;

    .line 217
    .local v1, "currentArr":Lorg/json/JSONArray;
    invoke-virtual {v1}, Lorg/json/JSONArray;->length()I

    move-result v2
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_1

    if-ge v0, v2, :cond_0

    .line 222
    :try_start_1
    invoke-virtual {v1, v0}, Lorg/json/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object v2
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/NumberFormatException; {:try_start_1 .. :try_end_1} :catch_1

    return-object v2

    .line 223
    :catch_0
    move-exception v2

    .line 224
    .local v2, "e":Lorg/json/JSONException;
    :try_start_2
    new-instance v3, Lorg/json/JSONPointerException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Error reading value at index position "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4, v2}, Lorg/json/JSONPointerException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .end local p0    # "current":Ljava/lang/Object;
    .end local p1    # "indexToken":Ljava/lang/String;
    throw v3

    .line 218
    .end local v2    # "e":Lorg/json/JSONException;
    .restart local p0    # "current":Ljava/lang/Object;
    .restart local p1    # "indexToken":Ljava/lang/String;
    :cond_0
    new-instance v2, Lorg/json/JSONPointerException;

    const-string v3, "index %s is out of bounds - the array has %d elements"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object p1, v4, v5

    .line 219
    invoke-virtual {v1}, Lorg/json/JSONArray;->length()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    const/4 v6, 0x1

    aput-object v5, v4, v6

    .line 218
    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lorg/json/JSONPointerException;-><init>(Ljava/lang/String;)V

    .end local p0    # "current":Ljava/lang/Object;
    .end local p1    # "indexToken":Ljava/lang/String;
    throw v2
    :try_end_2
    .catch Ljava/lang/NumberFormatException; {:try_start_2 .. :try_end_2} :catch_1

    .line 226
    .end local v0    # "index":I
    .end local v1    # "currentArr":Lorg/json/JSONArray;
    .restart local p0    # "current":Ljava/lang/Object;
    .restart local p1    # "indexToken":Ljava/lang/String;
    :catch_1
    move-exception v0

    .line 227
    .local v0, "e":Ljava/lang/NumberFormatException;
    new-instance v1, Lorg/json/JSONPointerException;

    const-string v2, "%s is not an array index"

    filled-new-array {p1}, [Ljava/lang/Object;

    move-result-object v3

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Lorg/json/JSONPointerException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method private static unescape(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "token"    # Ljava/lang/String;

    .line 174
    const-string v0, "~1"

    const-string v1, "/"

    invoke-virtual {p0, v0, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "~0"

    const-string v2, "~"

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public queryFrom(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 5
    .param p1, "document"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONPointerException;
        }
    .end annotation

    .line 188
    iget-object v0, p0, Lorg/json/JSONPointer;->refTokens:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 189
    return-object p1

    .line 191
    :cond_0
    move-object v0, p1

    .line 192
    .local v0, "current":Ljava/lang/Object;
    iget-object v1, p0, Lorg/json/JSONPointer;->refTokens:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 193
    .local v2, "token":Ljava/lang/String;
    instance-of v3, v0, Lorg/json/JSONObject;

    if-eqz v3, :cond_1

    .line 194
    move-object v3, v0

    check-cast v3, Lorg/json/JSONObject;

    invoke-static {v2}, Lorg/json/JSONPointer;->unescape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->opt(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_1

    .line 195
    :cond_1
    instance-of v3, v0, Lorg/json/JSONArray;

    if-eqz v3, :cond_2

    .line 196
    invoke-static {v0, v2}, Lorg/json/JSONPointer;->readByIndexToken(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 202
    .end local v2    # "token":Ljava/lang/String;
    :goto_1
    goto :goto_0

    .line 198
    .restart local v2    # "token":Ljava/lang/String;
    :cond_2
    new-instance v1, Lorg/json/JSONPointerException;

    const-string v3, "value [%s] is not an array or object therefore its key %s cannot be resolved"

    filled-new-array {v0, v2}, [Ljava/lang/Object;

    move-result-object v4

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Lorg/json/JSONPointerException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 203
    .end local v2    # "token":Ljava/lang/String;
    :cond_3
    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 5

    .line 237
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, ""

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 238
    .local v0, "rval":Ljava/lang/StringBuilder;
    iget-object v1, p0, Lorg/json/JSONPointer;->refTokens:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 239
    .local v2, "token":Ljava/lang/String;
    const/16 v3, 0x2f

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {v2}, Lorg/json/JSONPointer;->escape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 240
    .end local v2    # "token":Ljava/lang/String;
    goto :goto_0

    .line 241
    :cond_0
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public toURIFragment()Ljava/lang/String;
    .locals 5

    .line 265
    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "#"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 266
    .local v0, "rval":Ljava/lang/StringBuilder;
    iget-object v1, p0, Lorg/json/JSONPointer;->refTokens:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 267
    .local v2, "token":Ljava/lang/String;
    const/16 v3, 0x2f

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "utf-8"

    invoke-static {v2, v4}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 268
    nop

    .end local v2    # "token":Ljava/lang/String;
    goto :goto_0

    .line 269
    :cond_0
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v1

    .line 270
    .end local v0    # "rval":Ljava/lang/StringBuilder;
    :catch_0
    move-exception v0

    .line 271
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method
