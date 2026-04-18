.class public Lorg/json/XMLTokener;
.super Lorg/json/JSONTokener;
.source "XMLTokener.java"


# static fields
.field public static final entity:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap<",
            "Ljava/lang/String;",
            "Ljava/lang/Character;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .line 24
    new-instance v0, Ljava/util/HashMap;

    const/16 v1, 0x8

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(I)V

    sput-object v0, Lorg/json/XMLTokener;->entity:Ljava/util/HashMap;

    .line 25
    const-string v1, "amp"

    sget-object v2, Lorg/json/XML;->AMP:Ljava/lang/Character;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 26
    const-string v1, "apos"

    sget-object v2, Lorg/json/XML;->APOS:Ljava/lang/Character;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 27
    const-string v1, "gt"

    sget-object v2, Lorg/json/XML;->GT:Ljava/lang/Character;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 28
    const-string v1, "lt"

    sget-object v2, Lorg/json/XML;->LT:Ljava/lang/Character;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 29
    const-string v1, "quot"

    sget-object v2, Lorg/json/XML;->QUOT:Ljava/lang/Character;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 30
    return-void
.end method

.method public constructor <init>(Ljava/io/Reader;)V
    .locals 0
    .param p1, "r"    # Ljava/io/Reader;

    .line 37
    invoke-direct {p0, p1}, Lorg/json/JSONTokener;-><init>(Ljava/io/Reader;)V

    .line 38
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "s"    # Ljava/lang/String;

    .line 45
    invoke-direct {p0, p1}, Lorg/json/JSONTokener;-><init>(Ljava/lang/String;)V

    .line 46
    return-void
.end method

.method static unescapeEntity(Ljava/lang/String;)Ljava/lang/String;
    .locals 5
    .param p0, "e"    # Ljava/lang/String;

    .line 144
    if-eqz p0, :cond_5

    invoke-virtual {p0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_2

    .line 148
    :cond_0
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Ljava/lang/String;->charAt(I)C

    move-result v1

    const/16 v2, 0x23

    if-ne v1, v2, :cond_3

    .line 150
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v2

    const/16 v3, 0x78

    if-eq v2, v3, :cond_2

    invoke-virtual {p0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v2

    const/16 v3, 0x58

    if-ne v2, v3, :cond_1

    goto :goto_0

    .line 155
    :cond_1
    invoke-virtual {p0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    .local v2, "cp":I
    goto :goto_1

    .line 152
    .end local v2    # "cp":I
    :cond_2
    :goto_0
    const/4 v2, 0x2

    invoke-virtual {p0, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v2

    const/16 v3, 0x10

    invoke-static {v2, v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;I)I

    move-result v2

    .line 157
    .restart local v2    # "cp":I
    :goto_1
    new-instance v3, Ljava/lang/String;

    filled-new-array {v2}, [I

    move-result-object v4

    invoke-direct {v3, v4, v0, v1}, Ljava/lang/String;-><init>([III)V

    return-object v3

    .line 159
    .end local v2    # "cp":I
    :cond_3
    sget-object v0, Lorg/json/XMLTokener;->entity:Ljava/util/HashMap;

    invoke-virtual {v0, p0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Character;

    .line 160
    .local v0, "knownEntity":Ljava/lang/Character;
    if-nez v0, :cond_4

    .line 162
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const/16 v2, 0x26

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const/16 v2, 0x3b

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1

    .line 164
    :cond_4
    invoke-virtual {v0}, Ljava/lang/Character;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1

    .line 145
    .end local v0    # "knownEntity":Ljava/lang/Character;
    :cond_5
    :goto_2
    const-string v0, ""

    return-object v0
.end method


# virtual methods
.method public nextCDATA()Ljava/lang/String;
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 56
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 57
    .local v0, "sb":Ljava/lang/StringBuilder;
    :cond_0
    invoke-virtual {p0}, Lorg/json/XMLTokener;->more()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 58
    invoke-virtual {p0}, Lorg/json/XMLTokener;->next()C

    move-result v1

    .line 59
    .local v1, "c":C
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 60
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->length()I

    move-result v2

    add-int/lit8 v2, v2, -0x3

    .line 61
    .local v2, "i":I
    if-ltz v2, :cond_0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->charAt(I)C

    move-result v3

    const/16 v4, 0x5d

    if-ne v3, v4, :cond_0

    add-int/lit8 v3, v2, 0x1

    .line 62
    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->charAt(I)C

    move-result v3

    if-ne v3, v4, :cond_0

    add-int/lit8 v3, v2, 0x2

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->charAt(I)C

    move-result v3

    const/16 v4, 0x3e

    if-ne v3, v4, :cond_0

    .line 63
    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->setLength(I)V

    .line 64
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 67
    .end local v1    # "c":C
    .end local v2    # "i":I
    :cond_1
    const-string v1, "Unclosed CDATA"

    invoke-virtual {p0, v1}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v1

    throw v1
.end method

.method public nextContent()Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 85
    nop

    :cond_0
    invoke-virtual {p0}, Lorg/json/XMLTokener;->next()C

    move-result v0

    .line 86
    .local v0, "c":C
    invoke-static {v0}, Ljava/lang/Character;->isWhitespace(C)Z

    move-result v1

    if-nez v1, :cond_0

    .line 87
    if-nez v0, :cond_1

    .line 88
    const/4 v1, 0x0

    return-object v1

    .line 90
    :cond_1
    const/16 v1, 0x3c

    if-ne v0, v1, :cond_2

    .line 91
    sget-object v1, Lorg/json/XML;->LT:Ljava/lang/Character;

    return-object v1

    .line 93
    :cond_2
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 95
    .local v2, "sb":Ljava/lang/StringBuilder;
    :goto_0
    if-nez v0, :cond_3

    .line 96
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    return-object v1

    .line 98
    :cond_3
    if-ne v0, v1, :cond_4

    .line 99
    invoke-virtual {p0}, Lorg/json/XMLTokener;->back()V

    .line 100
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    return-object v1

    .line 102
    :cond_4
    const/16 v3, 0x26

    if-ne v0, v3, :cond_5

    .line 103
    invoke-virtual {p0, v0}, Lorg/json/XMLTokener;->nextEntity(C)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 105
    :cond_5
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 107
    :goto_1
    invoke-virtual {p0}, Lorg/json/XMLTokener;->next()C

    move-result v0

    goto :goto_0
.end method

.method public nextEntity(C)Ljava/lang/Object;
    .locals 4
    .param p1, "ampersand"    # C
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 122
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 124
    .local v0, "sb":Ljava/lang/StringBuilder;
    :goto_0
    invoke-virtual {p0}, Lorg/json/XMLTokener;->next()C

    move-result v1

    .line 125
    .local v1, "c":C
    invoke-static {v1}, Ljava/lang/Character;->isLetterOrDigit(C)Z

    move-result v2

    if-nez v2, :cond_2

    const/16 v2, 0x23

    if-ne v1, v2, :cond_0

    goto :goto_1

    .line 127
    :cond_0
    const/16 v2, 0x3b

    if-ne v1, v2, :cond_1

    .line 128
    nop

    .line 133
    .end local v1    # "c":C
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 134
    .local v1, "string":Ljava/lang/String;
    invoke-static {v1}, Lorg/json/XMLTokener;->unescapeEntity(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 130
    .local v1, "c":C
    :cond_1
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Missing \';\' in XML entity: &"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v2

    throw v2

    .line 126
    :cond_2
    :goto_1
    invoke-static {v1}, Ljava/lang/Character;->toLowerCase(C)C

    move-result v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 132
    .end local v1    # "c":C
    goto :goto_0
.end method

.method public nextMeta()Ljava/lang/Object;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 184
    nop

    :cond_0
    invoke-virtual {p0}, Lorg/json/XMLTokener;->next()C

    move-result v0

    .line 185
    .local v0, "c":C
    invoke-static {v0}, Ljava/lang/Character;->isWhitespace(C)Z

    move-result v1

    if-nez v1, :cond_0

    .line 186
    const-string v1, "Unterminated string"

    sparse-switch v0, :sswitch_data_0

    goto :goto_0

    .line 200
    :sswitch_0
    sget-object v1, Lorg/json/XML;->QUEST:Ljava/lang/Character;

    return-object v1

    .line 192
    :sswitch_1
    sget-object v1, Lorg/json/XML;->GT:Ljava/lang/Character;

    return-object v1

    .line 196
    :sswitch_2
    sget-object v1, Lorg/json/XML;->EQ:Ljava/lang/Character;

    return-object v1

    .line 190
    :sswitch_3
    sget-object v1, Lorg/json/XML;->LT:Ljava/lang/Character;

    return-object v1

    .line 194
    :sswitch_4
    sget-object v1, Lorg/json/XML;->SLASH:Ljava/lang/Character;

    return-object v1

    .line 203
    :sswitch_5
    move v2, v0

    .line 205
    .local v2, "q":C
    :cond_1
    invoke-virtual {p0}, Lorg/json/XMLTokener;->next()C

    move-result v0

    .line 206
    if-eqz v0, :cond_2

    .line 209
    if-ne v0, v2, :cond_1

    .line 210
    sget-object v1, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    return-object v1

    .line 207
    :cond_2
    invoke-virtual {p0, v1}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v1

    throw v1

    .line 198
    .end local v2    # "q":C
    :sswitch_6
    sget-object v1, Lorg/json/XML;->BANG:Ljava/lang/Character;

    return-object v1

    .line 188
    :sswitch_7
    const-string v1, "Misshaped meta tag"

    invoke-virtual {p0, v1}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v1

    throw v1

    .line 215
    :goto_0
    invoke-virtual {p0}, Lorg/json/XMLTokener;->next()C

    move-result v0

    .line 216
    invoke-static {v0}, Ljava/lang/Character;->isWhitespace(C)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 217
    sget-object v1, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    return-object v1

    .line 219
    :cond_3
    sparse-switch v0, :sswitch_data_1

    .line 231
    goto :goto_0

    .line 230
    :sswitch_8
    invoke-virtual {p0}, Lorg/json/XMLTokener;->back()V

    .line 231
    sget-object v1, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    return-object v1

    .line 221
    :sswitch_9
    invoke-virtual {p0, v1}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v1

    throw v1

    nop

    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_7
        0x21 -> :sswitch_6
        0x22 -> :sswitch_5
        0x27 -> :sswitch_5
        0x2f -> :sswitch_4
        0x3c -> :sswitch_3
        0x3d -> :sswitch_2
        0x3e -> :sswitch_1
        0x3f -> :sswitch_0
    .end sparse-switch

    :sswitch_data_1
    .sparse-switch
        0x0 -> :sswitch_9
        0x21 -> :sswitch_8
        0x22 -> :sswitch_8
        0x27 -> :sswitch_8
        0x2f -> :sswitch_8
        0x3c -> :sswitch_8
        0x3d -> :sswitch_8
        0x3e -> :sswitch_8
        0x3f -> :sswitch_8
    .end sparse-switch
.end method

.method public nextToken()Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 253
    nop

    :cond_0
    invoke-virtual {p0}, Lorg/json/XMLTokener;->next()C

    move-result v0

    .line 254
    .local v0, "c":C
    invoke-static {v0}, Ljava/lang/Character;->isWhitespace(C)Z

    move-result v1

    if-nez v1, :cond_0

    .line 255
    sparse-switch v0, :sswitch_data_0

    .line 295
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .local v1, "sb":Ljava/lang/StringBuilder;
    goto :goto_1

    .line 269
    .end local v1    # "sb":Ljava/lang/StringBuilder;
    :sswitch_0
    sget-object v1, Lorg/json/XML;->QUEST:Ljava/lang/Character;

    return-object v1

    .line 261
    :sswitch_1
    sget-object v1, Lorg/json/XML;->GT:Ljava/lang/Character;

    return-object v1

    .line 265
    :sswitch_2
    sget-object v1, Lorg/json/XML;->EQ:Ljava/lang/Character;

    return-object v1

    .line 259
    :sswitch_3
    const-string v1, "Misplaced \'<\'"

    invoke-virtual {p0, v1}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v1

    throw v1

    .line 263
    :sswitch_4
    sget-object v1, Lorg/json/XML;->SLASH:Ljava/lang/Character;

    return-object v1

    .line 275
    :sswitch_5
    move v1, v0

    .line 276
    .local v1, "q":C
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 278
    .local v2, "sb":Ljava/lang/StringBuilder;
    :goto_0
    invoke-virtual {p0}, Lorg/json/XMLTokener;->next()C

    move-result v0

    .line 279
    if-eqz v0, :cond_3

    .line 282
    if-ne v0, v1, :cond_1

    .line 283
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 285
    :cond_1
    const/16 v3, 0x26

    if-ne v0, v3, :cond_2

    .line 286
    invoke-virtual {p0, v0}, Lorg/json/XMLTokener;->nextEntity(C)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 288
    :cond_2
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 280
    :cond_3
    const-string v3, "Unterminated string"

    invoke-virtual {p0, v3}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v3

    throw v3

    .line 267
    .end local v1    # "q":C
    .end local v2    # "sb":Ljava/lang/StringBuilder;
    :sswitch_6
    sget-object v1, Lorg/json/XML;->BANG:Ljava/lang/Character;

    return-object v1

    .line 257
    :sswitch_7
    const-string v1, "Misshaped element"

    invoke-virtual {p0, v1}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v1

    throw v1

    .line 297
    .local v1, "sb":Ljava/lang/StringBuilder;
    :goto_1
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 298
    invoke-virtual {p0}, Lorg/json/XMLTokener;->next()C

    move-result v0

    .line 299
    invoke-static {v0}, Ljava/lang/Character;->isWhitespace(C)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 300
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 302
    :cond_4
    sparse-switch v0, :sswitch_data_1

    .line 317
    goto :goto_1

    :sswitch_8
    const-string v2, "Bad character in a name"

    invoke-virtual {p0, v2}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v2

    throw v2

    .line 312
    :sswitch_9
    invoke-virtual {p0}, Lorg/json/XMLTokener;->back()V

    .line 313
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 304
    :sswitch_a
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2

    nop

    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_7
        0x21 -> :sswitch_6
        0x22 -> :sswitch_5
        0x27 -> :sswitch_5
        0x2f -> :sswitch_4
        0x3c -> :sswitch_3
        0x3d -> :sswitch_2
        0x3e -> :sswitch_1
        0x3f -> :sswitch_0
    .end sparse-switch

    :sswitch_data_1
    .sparse-switch
        0x0 -> :sswitch_a
        0x21 -> :sswitch_9
        0x22 -> :sswitch_8
        0x27 -> :sswitch_8
        0x2f -> :sswitch_9
        0x3c -> :sswitch_8
        0x3d -> :sswitch_9
        0x3e -> :sswitch_9
        0x3f -> :sswitch_9
        0x5b -> :sswitch_9
        0x5d -> :sswitch_9
    .end sparse-switch
.end method

.method public skipPast(Ljava/lang/String;)V
    .locals 8
    .param p1, "to"    # Ljava/lang/String;

    .line 337
    const/4 v0, 0x0

    .line 338
    .local v0, "offset":I
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    .line 339
    .local v1, "length":I
    new-array v2, v1, [C

    .line 346
    .local v2, "circle":[C
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    if-ge v3, v1, :cond_1

    .line 347
    invoke-virtual {p0}, Lorg/json/XMLTokener;->next()C

    move-result v4

    .line 348
    .local v4, "c":C
    if-nez v4, :cond_0

    .line 349
    return-void

    .line 351
    :cond_0
    aput-char v4, v2, v3

    .line 346
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 357
    .end local v4    # "c":C
    :cond_1
    :goto_1
    move v4, v0

    .line 358
    .local v4, "j":I
    const/4 v5, 0x1

    .line 362
    .local v5, "b":Z
    const/4 v3, 0x0

    :goto_2
    if-ge v3, v1, :cond_4

    .line 363
    aget-char v6, v2, v4

    invoke-virtual {p1, v3}, Ljava/lang/String;->charAt(I)C

    move-result v7

    if-eq v6, v7, :cond_2

    .line 364
    const/4 v5, 0x0

    .line 365
    goto :goto_3

    .line 367
    :cond_2
    add-int/lit8 v4, v4, 0x1

    .line 368
    if-lt v4, v1, :cond_3

    .line 369
    sub-int/2addr v4, v1

    .line 362
    :cond_3
    add-int/lit8 v3, v3, 0x1

    goto :goto_2

    .line 375
    :cond_4
    :goto_3
    if-eqz v5, :cond_5

    .line 376
    return-void

    .line 381
    :cond_5
    invoke-virtual {p0}, Lorg/json/XMLTokener;->next()C

    move-result v6

    .line 382
    .local v6, "c":C
    if-nez v6, :cond_6

    .line 383
    return-void

    .line 389
    :cond_6
    aput-char v6, v2, v0

    .line 390
    add-int/lit8 v0, v0, 0x1

    .line 391
    if-lt v0, v1, :cond_1

    .line 392
    sub-int/2addr v0, v1

    goto :goto_1
.end method
