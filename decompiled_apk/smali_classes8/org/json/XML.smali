.class public Lorg/json/XML;
.super Ljava/lang/Object;
.source "XML.java"


# static fields
.field public static final AMP:Ljava/lang/Character;

.field public static final APOS:Ljava/lang/Character;

.field public static final BANG:Ljava/lang/Character;

.field public static final EQ:Ljava/lang/Character;

.field public static final GT:Ljava/lang/Character;

.field public static final LT:Ljava/lang/Character;

.field public static final NULL_ATTR:Ljava/lang/String; = "xsi:nil"

.field public static final QUEST:Ljava/lang/Character;

.field public static final QUOT:Ljava/lang/Character;

.field public static final SLASH:Ljava/lang/Character;

.field public static final TYPE_ATTR:Ljava/lang/String; = "xsi:type"


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 25
    const/16 v0, 0x26

    invoke-static {v0}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v0

    sput-object v0, Lorg/json/XML;->AMP:Ljava/lang/Character;

    .line 28
    const/16 v0, 0x27

    invoke-static {v0}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v0

    sput-object v0, Lorg/json/XML;->APOS:Ljava/lang/Character;

    .line 31
    const/16 v0, 0x21

    invoke-static {v0}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v0

    sput-object v0, Lorg/json/XML;->BANG:Ljava/lang/Character;

    .line 34
    const/16 v0, 0x3d

    invoke-static {v0}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v0

    sput-object v0, Lorg/json/XML;->EQ:Ljava/lang/Character;

    .line 37
    const/16 v0, 0x3e

    invoke-static {v0}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v0

    sput-object v0, Lorg/json/XML;->GT:Ljava/lang/Character;

    .line 40
    const/16 v0, 0x3c

    invoke-static {v0}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v0

    sput-object v0, Lorg/json/XML;->LT:Ljava/lang/Character;

    .line 43
    const/16 v0, 0x3f

    invoke-static {v0}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v0

    sput-object v0, Lorg/json/XML;->QUEST:Ljava/lang/Character;

    .line 46
    const/16 v0, 0x22

    invoke-static {v0}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v0

    sput-object v0, Lorg/json/XML;->QUOT:Ljava/lang/Character;

    .line 49
    const/16 v0, 0x2f

    invoke-static {v0}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v0

    sput-object v0, Lorg/json/XML;->SLASH:Ljava/lang/Character;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static codePointIterator(Ljava/lang/String;)Ljava/lang/Iterable;
    .locals 1
    .param p0, "string"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/lang/Iterable<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .line 70
    new-instance v0, Lorg/json/XML$1;

    invoke-direct {v0, p0}, Lorg/json/XML$1;-><init>(Ljava/lang/String;)V

    return-object v0
.end method

.method public static escape(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p0, "string"    # Ljava/lang/String;

    .line 114
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 115
    .local v0, "sb":Ljava/lang/StringBuilder;
    invoke-static {p0}, Lorg/json/XML;->codePointIterator(Ljava/lang/String;)Ljava/lang/Iterable;

    move-result-object v1

    invoke-interface {v1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    .line 116
    .local v2, "cp":I
    sparse-switch v2, :sswitch_data_0

    .line 133
    invoke-static {v2}, Lorg/json/XML;->mustEscape(I)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 134
    const-string v3, "&#x"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 135
    invoke-static {v2}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 136
    const/16 v3, 0x3b

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 124
    :sswitch_0
    const-string v3, "&gt;"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 125
    goto :goto_1

    .line 121
    :sswitch_1
    const-string v3, "&lt;"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 122
    goto :goto_1

    .line 130
    :sswitch_2
    const-string v3, "&apos;"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 131
    goto :goto_1

    .line 118
    :sswitch_3
    const-string v3, "&amp;"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 119
    goto :goto_1

    .line 127
    :sswitch_4
    const-string v3, "&quot;"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 128
    goto :goto_1

    .line 138
    :cond_0
    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->appendCodePoint(I)Ljava/lang/StringBuilder;

    .line 141
    .end local v2    # "cp":I
    :goto_1
    goto :goto_0

    .line 142
    :cond_1
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1

    nop

    :sswitch_data_0
    .sparse-switch
        0x22 -> :sswitch_4
        0x26 -> :sswitch_3
        0x27 -> :sswitch_2
        0x3c -> :sswitch_1
        0x3e -> :sswitch_0
    .end sparse-switch
.end method

.method private static final indent(I)Ljava/lang/String;
    .locals 3
    .param p0, "indent"    # I

    .line 970
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 971
    .local v0, "sb":Ljava/lang/StringBuilder;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, p0, :cond_0

    .line 972
    const/16 v2, 0x20

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 971
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 974
    .end local v1    # "i":I
    :cond_0
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method private static isDecimalNotation(Ljava/lang/String;)Z
    .locals 2
    .param p0, "val"    # Ljava/lang/String;

    .line 566
    const/16 v0, 0x2e

    invoke-virtual {p0, v0}, Ljava/lang/String;->indexOf(I)I

    move-result v0

    const/4 v1, -0x1

    if-gt v0, v1, :cond_1

    const/16 v0, 0x65

    invoke-virtual {p0, v0}, Ljava/lang/String;->indexOf(I)I

    move-result v0

    if-gt v0, v1, :cond_1

    .line 567
    const/16 v0, 0x45

    invoke-virtual {p0, v0}, Ljava/lang/String;->indexOf(I)I

    move-result v0

    if-gt v0, v1, :cond_1

    const-string v0, "-0"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v0, 0x1

    .line 566
    :goto_1
    return v0
.end method

.method private static mustEscape(I)Z
    .locals 1
    .param p0, "cp"    # I

    .line 158
    invoke-static {p0}, Ljava/lang/Character;->isISOControl(I)Z

    move-result v0

    if-eqz v0, :cond_0

    const/16 v0, 0x9

    if-eq p0, v0, :cond_0

    const/16 v0, 0xa

    if-eq p0, v0, :cond_0

    const/16 v0, 0xd

    if-ne p0, v0, :cond_4

    :cond_0
    const/16 v0, 0x20

    if-lt p0, v0, :cond_1

    const v0, 0xd7ff

    if-le p0, v0, :cond_3

    :cond_1
    const v0, 0xe000

    if-lt p0, v0, :cond_2

    const v0, 0xfffd

    if-le p0, v0, :cond_3

    :cond_2
    const/high16 v0, 0x10000

    if-lt p0, v0, :cond_4

    const v0, 0x10ffff

    if-le p0, v0, :cond_3

    goto :goto_0

    :cond_3
    const/4 v0, 0x0

    goto :goto_1

    :cond_4
    :goto_0
    const/4 v0, 0x1

    :goto_1
    return v0
.end method

.method public static noSpace(Ljava/lang/String;)V
    .locals 5
    .param p0, "string"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 211
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    .line 212
    .local v0, "length":I
    if-eqz v0, :cond_2

    .line 215
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_1

    .line 216
    invoke-virtual {p0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v2

    invoke-static {v2}, Ljava/lang/Character;->isWhitespace(C)Z

    move-result v2

    if-nez v2, :cond_0

    .line 215
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 217
    :cond_0
    new-instance v2, Lorg/json/JSONException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "\'"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\' contains a space character."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lorg/json/JSONException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 221
    :cond_1
    return-void

    .line 213
    .end local v1    # "i":I
    :cond_2
    new-instance v1, Lorg/json/JSONException;

    const-string v2, "Empty string."

    invoke-direct {v1, v2}, Lorg/json/JSONException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method private static parse(Lorg/json/XMLTokener;Lorg/json/JSONObject;Ljava/lang/String;Lorg/json/XMLParserConfiguration;I)Z
    .locals 11
    .param p0, "x"    # Lorg/json/XMLTokener;
    .param p1, "context"    # Lorg/json/JSONObject;
    .param p2, "name"    # Ljava/lang/String;
    .param p3, "config"    # Lorg/json/XMLParserConfiguration;
    .param p4, "currentNestingDepth"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 243
    const/4 v0, 0x0

    .line 259
    .local v0, "jsonObject":Lorg/json/JSONObject;
    invoke-virtual {p0}, Lorg/json/XMLTokener;->nextToken()Ljava/lang/Object;

    move-result-object v1

    .line 263
    .local v1, "token":Ljava/lang/Object;
    sget-object v2, Lorg/json/XML;->BANG:Ljava/lang/Character;

    const/4 v3, 0x0

    if-ne v1, v2, :cond_9

    .line 264
    invoke-virtual {p0}, Lorg/json/XMLTokener;->next()C

    move-result v2

    .line 265
    .local v2, "c":C
    const/16 v4, 0x2d

    if-ne v2, v4, :cond_1

    .line 266
    invoke-virtual {p0}, Lorg/json/XMLTokener;->next()C

    move-result v5

    if-ne v5, v4, :cond_0

    .line 267
    const-string v4, "-->"

    invoke-virtual {p0, v4}, Lorg/json/XMLTokener;->skipPast(Ljava/lang/String;)V

    .line 268
    return v3

    .line 270
    :cond_0
    invoke-virtual {p0}, Lorg/json/XMLTokener;->back()V

    goto :goto_0

    .line 271
    :cond_1
    const/16 v4, 0x5b

    if-ne v2, v4, :cond_4

    .line 272
    invoke-virtual {p0}, Lorg/json/XMLTokener;->nextToken()Ljava/lang/Object;

    move-result-object v1

    .line 273
    const-string v5, "CDATA"

    invoke-virtual {v5, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 274
    invoke-virtual {p0}, Lorg/json/XMLTokener;->next()C

    move-result v5

    if-ne v5, v4, :cond_3

    .line 275
    invoke-virtual {p0}, Lorg/json/XMLTokener;->nextCDATA()Ljava/lang/String;

    move-result-object v4

    .line 276
    .local v4, "string":Ljava/lang/String;
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v5

    if-lez v5, :cond_2

    .line 277
    invoke-virtual {p3}, Lorg/json/XMLParserConfiguration;->getcDataTagName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p1, v5, v4}, Lorg/json/JSONObject;->accumulate(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 279
    :cond_2
    return v3

    .line 282
    .end local v4    # "string":Ljava/lang/String;
    :cond_3
    const-string v3, "Expected \'CDATA[\'"

    invoke-virtual {p0, v3}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v3

    throw v3

    .line 284
    :cond_4
    :goto_0
    const/4 v4, 0x1

    .line 286
    .local v4, "i":I
    :cond_5
    invoke-virtual {p0}, Lorg/json/XMLTokener;->nextMeta()Ljava/lang/Object;

    move-result-object v1

    .line 287
    if-eqz v1, :cond_8

    .line 289
    sget-object v5, Lorg/json/XML;->LT:Ljava/lang/Character;

    if-ne v1, v5, :cond_6

    .line 290
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 291
    :cond_6
    sget-object v5, Lorg/json/XML;->GT:Ljava/lang/Character;

    if-ne v1, v5, :cond_7

    .line 292
    add-int/lit8 v4, v4, -0x1

    .line 294
    :cond_7
    :goto_1
    if-gtz v4, :cond_5

    .line 295
    return v3

    .line 288
    :cond_8
    const-string v3, "Missing \'>\' after \'<!\'."

    invoke-virtual {p0, v3}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v3

    throw v3

    .line 296
    .end local v2    # "c":C
    .end local v4    # "i":I
    :cond_9
    sget-object v2, Lorg/json/XML;->QUEST:Ljava/lang/Character;

    if-ne v1, v2, :cond_a

    .line 299
    const-string v2, "?>"

    invoke-virtual {p0, v2}, Lorg/json/XMLTokener;->skipPast(Ljava/lang/String;)V

    .line 300
    return v3

    .line 301
    :cond_a
    sget-object v2, Lorg/json/XML;->SLASH:Ljava/lang/Character;

    const/4 v4, 0x1

    if-ne v1, v2, :cond_e

    .line 305
    invoke-virtual {p0}, Lorg/json/XMLTokener;->nextToken()Ljava/lang/Object;

    move-result-object v1

    .line 306
    if-eqz p2, :cond_d

    .line 309
    invoke-virtual {v1, p2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_c

    .line 312
    invoke-virtual {p0}, Lorg/json/XMLTokener;->nextToken()Ljava/lang/Object;

    move-result-object v2

    sget-object v3, Lorg/json/XML;->GT:Ljava/lang/Character;

    if-ne v2, v3, :cond_b

    .line 315
    return v4

    .line 313
    :cond_b
    const-string v2, "Misshaped close tag"

    invoke-virtual {p0, v2}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v2

    throw v2

    .line 310
    :cond_c
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Mismatched "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " and "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v2

    throw v2

    .line 307
    :cond_d
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Mismatched close tag "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v2

    throw v2

    .line 317
    :cond_e
    instance-of v2, v1, Ljava/lang/Character;

    const-string v5, "Misshaped tag"

    if-nez v2, :cond_2b

    .line 323
    move-object v2, v1

    check-cast v2, Ljava/lang/String;

    .line 324
    .local v2, "tagName":Ljava/lang/String;
    const/4 v1, 0x0

    .line 325
    new-instance v6, Lorg/json/JSONObject;

    invoke-direct {v6}, Lorg/json/JSONObject;-><init>()V

    move-object v0, v6

    .line 326
    const/4 v6, 0x0

    .line 327
    .local v6, "nilAttributeFound":Z
    const/4 v7, 0x0

    .line 329
    .local v7, "xmlXsiTypeConverter":Lorg/json/XMLXsiTypeConverter;, "Lorg/json/XMLXsiTypeConverter<*>;"
    :goto_2
    if-nez v1, :cond_f

    .line 330
    invoke-virtual {p0}, Lorg/json/XMLTokener;->nextToken()Ljava/lang/Object;

    move-result-object v1

    .line 333
    :cond_f
    instance-of v8, v1, Ljava/lang/String;

    const-string v9, ""

    if-eqz v8, :cond_16

    .line 334
    move-object v8, v1

    check-cast v8, Ljava/lang/String;

    .line 335
    .local v8, "string":Ljava/lang/String;
    invoke-virtual {p0}, Lorg/json/XMLTokener;->nextToken()Ljava/lang/Object;

    move-result-object v1

    .line 336
    sget-object v10, Lorg/json/XML;->EQ:Ljava/lang/Character;

    if-ne v1, v10, :cond_15

    .line 337
    invoke-virtual {p0}, Lorg/json/XMLTokener;->nextToken()Ljava/lang/Object;

    move-result-object v1

    .line 338
    instance-of v9, v1, Ljava/lang/String;

    if-eqz v9, :cond_14

    .line 342
    invoke-virtual {p3}, Lorg/json/XMLParserConfiguration;->isConvertNilAttributeToNull()Z

    move-result v9

    if-eqz v9, :cond_10

    .line 343
    const-string v9, "xsi:nil"

    invoke-virtual {v9, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_10

    move-object v9, v1

    check-cast v9, Ljava/lang/String;

    .line 344
    invoke-static {v9}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_10

    .line 345
    const/4 v6, 0x1

    goto :goto_4

    .line 346
    :cond_10
    invoke-virtual {p3}, Lorg/json/XMLParserConfiguration;->getXsiTypeMap()Ljava/util/Map;

    move-result-object v9

    if-eqz v9, :cond_11

    invoke-virtual {p3}, Lorg/json/XMLParserConfiguration;->getXsiTypeMap()Ljava/util/Map;

    move-result-object v9

    invoke-interface {v9}, Ljava/util/Map;->isEmpty()Z

    move-result v9

    if-nez v9, :cond_11

    .line 347
    const-string v9, "xsi:type"

    invoke-virtual {v9, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_11

    .line 348
    invoke-virtual {p3}, Lorg/json/XMLParserConfiguration;->getXsiTypeMap()Ljava/util/Map;

    move-result-object v9

    invoke-interface {v9, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    move-object v7, v9

    check-cast v7, Lorg/json/XMLXsiTypeConverter;

    goto :goto_4

    .line 349
    :cond_11
    if-nez v6, :cond_13

    .line 350
    nop

    .line 351
    invoke-virtual {p3}, Lorg/json/XMLParserConfiguration;->isKeepStrings()Z

    move-result v9

    if-eqz v9, :cond_12

    move-object v9, v1

    check-cast v9, Ljava/lang/String;

    goto :goto_3

    :cond_12
    move-object v9, v1

    check-cast v9, Ljava/lang/String;

    .line 353
    invoke-static {v9}, Lorg/json/XML;->stringToValue(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v9

    .line 350
    :goto_3
    invoke-virtual {v0, v8, v9}, Lorg/json/JSONObject;->accumulate(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 355
    :cond_13
    :goto_4
    const/4 v1, 0x0

    goto :goto_2

    .line 339
    :cond_14
    const-string v3, "Missing value"

    invoke-virtual {p0, v3}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v3

    throw v3

    .line 357
    :cond_15
    invoke-virtual {v0, v8, v9}, Lorg/json/JSONObject;->accumulate(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_2

    .line 361
    .end local v8    # "string":Ljava/lang/String;
    :cond_16
    sget-object v8, Lorg/json/XML;->SLASH:Ljava/lang/Character;

    if-ne v1, v8, :cond_1d

    .line 363
    invoke-virtual {p0}, Lorg/json/XMLTokener;->nextToken()Ljava/lang/Object;

    move-result-object v4

    sget-object v8, Lorg/json/XML;->GT:Ljava/lang/Character;

    if-ne v4, v8, :cond_1c

    .line 366
    invoke-virtual {p3}, Lorg/json/XMLParserConfiguration;->getForceList()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4, v2}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_19

    .line 368
    if-eqz v6, :cond_17

    .line 369
    sget-object v4, Lorg/json/JSONObject;->NULL:Ljava/lang/Object;

    invoke-virtual {p1, v2, v4}, Lorg/json/JSONObject;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_5

    .line 370
    :cond_17
    invoke-virtual {v0}, Lorg/json/JSONObject;->length()I

    move-result v4

    if-lez v4, :cond_18

    .line 371
    invoke-virtual {p1, v2, v0}, Lorg/json/JSONObject;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_5

    .line 373
    :cond_18
    new-instance v4, Lorg/json/JSONArray;

    invoke-direct {v4}, Lorg/json/JSONArray;-><init>()V

    invoke-virtual {p1, v2, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_5

    .line 376
    :cond_19
    if-eqz v6, :cond_1a

    .line 377
    sget-object v4, Lorg/json/JSONObject;->NULL:Ljava/lang/Object;

    invoke-virtual {p1, v2, v4}, Lorg/json/JSONObject;->accumulate(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_5

    .line 378
    :cond_1a
    invoke-virtual {v0}, Lorg/json/JSONObject;->length()I

    move-result v4

    if-lez v4, :cond_1b

    .line 379
    invoke-virtual {p1, v2, v0}, Lorg/json/JSONObject;->accumulate(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_5

    .line 381
    :cond_1b
    invoke-virtual {p1, v2, v9}, Lorg/json/JSONObject;->accumulate(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 384
    :goto_5
    return v3

    .line 364
    :cond_1c
    invoke-virtual {p0, v5}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v3

    throw v3

    .line 386
    :cond_1d
    sget-object v8, Lorg/json/XML;->GT:Ljava/lang/Character;

    if-ne v1, v8, :cond_2a

    .line 389
    :cond_1e
    :goto_6
    invoke-virtual {p0}, Lorg/json/XMLTokener;->nextContent()Ljava/lang/Object;

    move-result-object v1

    .line 390
    if-nez v1, :cond_20

    .line 391
    if-nez v2, :cond_1f

    .line 394
    return v3

    .line 392
    :cond_1f
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unclosed tag "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v3}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v3

    throw v3

    .line 395
    :cond_20
    instance-of v5, v1, Ljava/lang/String;

    if-eqz v5, :cond_23

    .line 396
    move-object v5, v1

    check-cast v5, Ljava/lang/String;

    .line 397
    .local v5, "string":Ljava/lang/String;
    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v8

    if-lez v8, :cond_1e

    .line 398
    if-eqz v7, :cond_21

    .line 399
    invoke-virtual {p3}, Lorg/json/XMLParserConfiguration;->getcDataTagName()Ljava/lang/String;

    move-result-object v8

    .line 400
    invoke-static {v5, v7}, Lorg/json/XML;->stringToValue(Ljava/lang/String;Lorg/json/XMLXsiTypeConverter;)Ljava/lang/Object;

    move-result-object v10

    .line 399
    invoke-virtual {v0, v8, v10}, Lorg/json/JSONObject;->accumulate(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_6

    .line 402
    :cond_21
    invoke-virtual {p3}, Lorg/json/XMLParserConfiguration;->getcDataTagName()Ljava/lang/String;

    move-result-object v8

    .line 403
    invoke-virtual {p3}, Lorg/json/XMLParserConfiguration;->isKeepStrings()Z

    move-result v10

    if-eqz v10, :cond_22

    move-object v10, v5

    goto :goto_7

    :cond_22
    invoke-static {v5}, Lorg/json/XML;->stringToValue(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v10

    .line 402
    :goto_7
    invoke-virtual {v0, v8, v10}, Lorg/json/JSONObject;->accumulate(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_6

    .line 407
    .end local v5    # "string":Ljava/lang/String;
    :cond_23
    sget-object v5, Lorg/json/XML;->LT:Ljava/lang/Character;

    if-ne v1, v5, :cond_1e

    .line 409
    invoke-virtual {p3}, Lorg/json/XMLParserConfiguration;->getMaxNestingDepth()I

    move-result v5

    if-eq p4, v5, :cond_29

    .line 413
    add-int/lit8 v5, p4, 0x1

    invoke-static {p0, v0, v2, p3, v5}, Lorg/json/XML;->parse(Lorg/json/XMLTokener;Lorg/json/JSONObject;Ljava/lang/String;Lorg/json/XMLParserConfiguration;I)Z

    move-result v5

    if-eqz v5, :cond_1e

    .line 414
    invoke-virtual {p3}, Lorg/json/XMLParserConfiguration;->getForceList()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5, v2}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_26

    .line 416
    invoke-virtual {v0}, Lorg/json/JSONObject;->length()I

    move-result v5

    if-nez v5, :cond_24

    .line 417
    new-instance v4, Lorg/json/JSONArray;

    invoke-direct {v4}, Lorg/json/JSONArray;-><init>()V

    invoke-virtual {p1, v2, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_8

    .line 418
    :cond_24
    invoke-virtual {v0}, Lorg/json/JSONObject;->length()I

    move-result v5

    if-ne v5, v4, :cond_25

    .line 419
    invoke-virtual {p3}, Lorg/json/XMLParserConfiguration;->getcDataTagName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->opt(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    if-eqz v4, :cond_25

    .line 420
    invoke-virtual {p3}, Lorg/json/XMLParserConfiguration;->getcDataTagName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->opt(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {p1, v2, v4}, Lorg/json/JSONObject;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_8

    .line 422
    :cond_25
    invoke-virtual {p1, v2, v0}, Lorg/json/JSONObject;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_8

    .line 425
    :cond_26
    invoke-virtual {v0}, Lorg/json/JSONObject;->length()I

    move-result v5

    if-nez v5, :cond_27

    .line 426
    invoke-virtual {p1, v2, v9}, Lorg/json/JSONObject;->accumulate(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_8

    .line 427
    :cond_27
    invoke-virtual {v0}, Lorg/json/JSONObject;->length()I

    move-result v5

    if-ne v5, v4, :cond_28

    .line 428
    invoke-virtual {p3}, Lorg/json/XMLParserConfiguration;->getcDataTagName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->opt(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    if-eqz v4, :cond_28

    .line 429
    invoke-virtual {p3}, Lorg/json/XMLParserConfiguration;->getcDataTagName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->opt(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {p1, v2, v4}, Lorg/json/JSONObject;->accumulate(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_8

    .line 431
    :cond_28
    invoke-virtual {p1, v2, v0}, Lorg/json/JSONObject;->accumulate(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 435
    :goto_8
    return v3

    .line 410
    :cond_29
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Maximum nesting depth of "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p3}, Lorg/json/XMLParserConfiguration;->getMaxNestingDepth()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " reached"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v3}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v3

    throw v3

    .line 440
    :cond_2a
    invoke-virtual {p0, v5}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v3

    throw v3

    .line 318
    .end local v2    # "tagName":Ljava/lang/String;
    .end local v6    # "nilAttributeFound":Z
    .end local v7    # "xmlXsiTypeConverter":Lorg/json/XMLXsiTypeConverter;, "Lorg/json/XMLXsiTypeConverter<*>;"
    :cond_2b
    invoke-virtual {p0, v5}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v2

    throw v2
.end method

.method private static stringToNumber(Ljava/lang/String;)Ljava/lang/Number;
    .locals 8
    .param p0, "val"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/NumberFormatException;
        }
    .end annotation

    .line 503
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 504
    .local v0, "initial":C
    const/16 v1, 0x39

    const/16 v2, 0x2d

    const-string v3, "] is not a valid number."

    const-string v4, "val ["

    const/16 v5, 0x30

    if-lt v0, v5, :cond_0

    if-le v0, v1, :cond_1

    :cond_0
    if-ne v0, v2, :cond_c

    .line 506
    :cond_1
    invoke-static {p0}, Lorg/json/XML;->isDecimalNotation(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_4

    .line 511
    :try_start_0
    new-instance v1, Ljava/math/BigDecimal;

    invoke-direct {v1, p0}, Ljava/math/BigDecimal;-><init>(Ljava/lang/String;)V

    .line 512
    .local v1, "bd":Ljava/math/BigDecimal;
    if-ne v0, v2, :cond_2

    sget-object v2, Ljava/math/BigDecimal;->ZERO:Ljava/math/BigDecimal;

    invoke-virtual {v2, v1}, Ljava/math/BigDecimal;->compareTo(Ljava/math/BigDecimal;)I

    move-result v2

    if-nez v2, :cond_2

    .line 513
    const-wide/high16 v5, -0x8000000000000000L

    invoke-static {v5, v6}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v2

    .line 515
    :cond_2
    return-object v1

    .line 516
    .end local v1    # "bd":Ljava/math/BigDecimal;
    :catch_0
    move-exception v1

    .line 519
    .local v1, "retryAsDouble":Ljava/lang/NumberFormatException;
    :try_start_1
    invoke-static {p0}, Ljava/lang/Double;->valueOf(Ljava/lang/String;)Ljava/lang/Double;

    move-result-object v2

    .line 520
    .local v2, "d":Ljava/lang/Double;
    invoke-virtual {v2}, Ljava/lang/Double;->isNaN()Z

    move-result v5

    if-nez v5, :cond_3

    invoke-virtual {v2}, Ljava/lang/Double;->isInfinite()Z

    move-result v5

    if-nez v5, :cond_3

    .line 523
    return-object v2

    .line 521
    :cond_3
    new-instance v5, Ljava/lang/NumberFormatException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    .end local v0    # "initial":C
    .end local v1    # "retryAsDouble":Ljava/lang/NumberFormatException;
    .end local p0    # "val":Ljava/lang/String;
    throw v5
    :try_end_1
    .catch Ljava/lang/NumberFormatException; {:try_start_1 .. :try_end_1} :catch_1

    .line 524
    .end local v2    # "d":Ljava/lang/Double;
    .restart local v0    # "initial":C
    .restart local v1    # "retryAsDouble":Ljava/lang/NumberFormatException;
    .restart local p0    # "val":Ljava/lang/String;
    :catch_1
    move-exception v2

    .line 525
    .local v2, "ignore":Ljava/lang/NumberFormatException;
    new-instance v5, Ljava/lang/NumberFormatException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v5, v3}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 530
    .end local v1    # "retryAsDouble":Ljava/lang/NumberFormatException;
    .end local v2    # "ignore":Ljava/lang/NumberFormatException;
    :cond_4
    const/4 v6, 0x1

    if-ne v0, v5, :cond_6

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v7

    if-le v7, v6, :cond_6

    .line 531
    invoke-virtual {p0, v6}, Ljava/lang/String;->charAt(I)C

    move-result v2

    .line 532
    .local v2, "at1":C
    if-lt v2, v5, :cond_8

    if-le v2, v1, :cond_5

    goto :goto_0

    .line 533
    :cond_5
    new-instance v1, Ljava/lang/NumberFormatException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 535
    .end local v2    # "at1":C
    :cond_6
    if-ne v0, v2, :cond_8

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    const/4 v7, 0x2

    if-le v2, v7, :cond_8

    .line 536
    invoke-virtual {p0, v6}, Ljava/lang/String;->charAt(I)C

    move-result v2

    .line 537
    .restart local v2    # "at1":C
    invoke-virtual {p0, v7}, Ljava/lang/String;->charAt(I)C

    move-result v6

    .line 538
    .local v6, "at2":C
    if-ne v2, v5, :cond_9

    if-lt v6, v5, :cond_9

    if-le v6, v1, :cond_7

    goto :goto_1

    .line 539
    :cond_7
    new-instance v1, Ljava/lang/NumberFormatException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 535
    .end local v2    # "at1":C
    .end local v6    # "at2":C
    :cond_8
    :goto_0
    nop

    .line 550
    :cond_9
    :goto_1
    new-instance v1, Ljava/math/BigInteger;

    invoke-direct {v1, p0}, Ljava/math/BigInteger;-><init>(Ljava/lang/String;)V

    .line 551
    .local v1, "bi":Ljava/math/BigInteger;
    invoke-virtual {v1}, Ljava/math/BigInteger;->bitLength()I

    move-result v2

    const/16 v3, 0x1f

    if-gt v2, v3, :cond_a

    .line 552
    invoke-virtual {v1}, Ljava/math/BigInteger;->intValue()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    return-object v2

    .line 554
    :cond_a
    invoke-virtual {v1}, Ljava/math/BigInteger;->bitLength()I

    move-result v2

    const/16 v3, 0x3f

    if-gt v2, v3, :cond_b

    .line 555
    invoke-virtual {v1}, Ljava/math/BigInteger;->longValue()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    return-object v2

    .line 557
    :cond_b
    return-object v1

    .line 559
    .end local v1    # "bi":Ljava/math/BigInteger;
    :cond_c
    new-instance v1, Ljava/lang/NumberFormatException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public static stringToValue(Ljava/lang/String;)Ljava/lang/Object;
    .locals 2
    .param p0, "string"    # Ljava/lang/String;

    .line 469
    const-string v0, ""

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 470
    return-object p0

    .line 474
    :cond_0
    const-string v0, "true"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 475
    sget-object v0, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    return-object v0

    .line 477
    :cond_1
    const-string v0, "false"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 478
    sget-object v0, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    return-object v0

    .line 480
    :cond_2
    const-string v0, "null"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 481
    sget-object v0, Lorg/json/JSONObject;->NULL:Ljava/lang/Object;

    return-object v0

    .line 489
    :cond_3
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 490
    .local v0, "initial":C
    const/16 v1, 0x30

    if-lt v0, v1, :cond_4

    const/16 v1, 0x39

    if-le v0, v1, :cond_5

    :cond_4
    const/16 v1, 0x2d

    if-ne v0, v1, :cond_6

    .line 492
    :cond_5
    :try_start_0
    invoke-static {p0}, Lorg/json/XML;->stringToNumber(Ljava/lang/String;)Ljava/lang/Number;

    move-result-object v1
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-object v1

    .line 493
    :catch_0
    move-exception v1

    .line 496
    :cond_6
    return-object p0
.end method

.method public static stringToValue(Ljava/lang/String;Lorg/json/XMLXsiTypeConverter;)Ljava/lang/Object;
    .locals 1
    .param p0, "string"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lorg/json/XMLXsiTypeConverter<",
            "*>;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    .line 453
    .local p1, "typeConverter":Lorg/json/XMLXsiTypeConverter;, "Lorg/json/XMLXsiTypeConverter<*>;"
    if-eqz p1, :cond_0

    .line 454
    invoke-interface {p1, p0}, Lorg/json/XMLXsiTypeConverter;->convert(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    return-object v0

    .line 456
    :cond_0
    invoke-static {p0}, Lorg/json/XML;->stringToValue(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public static toJSONObject(Ljava/io/Reader;)Lorg/json/JSONObject;
    .locals 1
    .param p0, "reader"    # Ljava/io/Reader;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 609
    sget-object v0, Lorg/json/XMLParserConfiguration;->ORIGINAL:Lorg/json/XMLParserConfiguration;

    invoke-static {p0, v0}, Lorg/json/XML;->toJSONObject(Ljava/io/Reader;Lorg/json/XMLParserConfiguration;)Lorg/json/JSONObject;

    move-result-object v0

    return-object v0
.end method

.method public static toJSONObject(Ljava/io/Reader;Lorg/json/XMLParserConfiguration;)Lorg/json/JSONObject;
    .locals 4
    .param p0, "reader"    # Ljava/io/Reader;
    .param p1, "config"    # Lorg/json/XMLParserConfiguration;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 661
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .line 662
    .local v0, "jo":Lorg/json/JSONObject;
    new-instance v1, Lorg/json/XMLTokener;

    invoke-direct {v1, p0}, Lorg/json/XMLTokener;-><init>(Ljava/io/Reader;)V

    .line 663
    .local v1, "x":Lorg/json/XMLTokener;
    :cond_0
    :goto_0
    invoke-virtual {v1}, Lorg/json/XMLTokener;->more()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 664
    const-string v2, "<"

    invoke-virtual {v1, v2}, Lorg/json/XMLTokener;->skipPast(Ljava/lang/String;)V

    .line 665
    invoke-virtual {v1}, Lorg/json/XMLTokener;->more()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 666
    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-static {v1, v0, v2, p1, v3}, Lorg/json/XML;->parse(Lorg/json/XMLTokener;Lorg/json/JSONObject;Ljava/lang/String;Lorg/json/XMLParserConfiguration;I)Z

    goto :goto_0

    .line 669
    :cond_1
    return-object v0
.end method

.method public static toJSONObject(Ljava/io/Reader;Z)Lorg/json/JSONObject;
    .locals 1
    .param p0, "reader"    # Ljava/io/Reader;
    .param p1, "keepStrings"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 634
    if-eqz p1, :cond_0

    .line 635
    sget-object v0, Lorg/json/XMLParserConfiguration;->KEEP_STRINGS:Lorg/json/XMLParserConfiguration;

    invoke-static {p0, v0}, Lorg/json/XML;->toJSONObject(Ljava/io/Reader;Lorg/json/XMLParserConfiguration;)Lorg/json/JSONObject;

    move-result-object v0

    return-object v0

    .line 637
    :cond_0
    sget-object v0, Lorg/json/XMLParserConfiguration;->ORIGINAL:Lorg/json/XMLParserConfiguration;

    invoke-static {p0, v0}, Lorg/json/XML;->toJSONObject(Ljava/io/Reader;Lorg/json/XMLParserConfiguration;)Lorg/json/JSONObject;

    move-result-object v0

    return-object v0
.end method

.method public static toJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 1
    .param p0, "string"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 589
    sget-object v0, Lorg/json/XMLParserConfiguration;->ORIGINAL:Lorg/json/XMLParserConfiguration;

    invoke-static {p0, v0}, Lorg/json/XML;->toJSONObject(Ljava/lang/String;Lorg/json/XMLParserConfiguration;)Lorg/json/JSONObject;

    move-result-object v0

    return-object v0
.end method

.method public static toJSONObject(Ljava/lang/String;Lorg/json/XMLParserConfiguration;)Lorg/json/JSONObject;
    .locals 1
    .param p0, "string"    # Ljava/lang/String;
    .param p1, "config"    # Lorg/json/XMLParserConfiguration;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 720
    new-instance v0, Ljava/io/StringReader;

    invoke-direct {v0, p0}, Ljava/io/StringReader;-><init>(Ljava/lang/String;)V

    invoke-static {v0, p1}, Lorg/json/XML;->toJSONObject(Ljava/io/Reader;Lorg/json/XMLParserConfiguration;)Lorg/json/JSONObject;

    move-result-object v0

    return-object v0
.end method

.method public static toJSONObject(Ljava/lang/String;Z)Lorg/json/JSONObject;
    .locals 1
    .param p0, "string"    # Ljava/lang/String;
    .param p1, "keepStrings"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 695
    new-instance v0, Ljava/io/StringReader;

    invoke-direct {v0, p0}, Ljava/io/StringReader;-><init>(Ljava/lang/String;)V

    invoke-static {v0, p1}, Lorg/json/XML;->toJSONObject(Ljava/io/Reader;Z)Lorg/json/JSONObject;

    move-result-object v0

    return-object v0
.end method

.method public static toString(Ljava/lang/Object;)Ljava/lang/String;
    .locals 2
    .param p0, "object"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 732
    const/4 v0, 0x0

    sget-object v1, Lorg/json/XMLParserConfiguration;->ORIGINAL:Lorg/json/XMLParserConfiguration;

    invoke-static {p0, v0, v1}, Lorg/json/XML;->toString(Ljava/lang/Object;Ljava/lang/String;Lorg/json/XMLParserConfiguration;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static toString(Ljava/lang/Object;I)Ljava/lang/String;
    .locals 2
    .param p0, "object"    # Ljava/lang/Object;
    .param p1, "indentFactor"    # I

    .line 924
    const/4 v0, 0x0

    sget-object v1, Lorg/json/XMLParserConfiguration;->ORIGINAL:Lorg/json/XMLParserConfiguration;

    invoke-static {p0, v0, v1, p1}, Lorg/json/XML;->toString(Ljava/lang/Object;Ljava/lang/String;Lorg/json/XMLParserConfiguration;I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static toString(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "object"    # Ljava/lang/Object;
    .param p1, "tagName"    # Ljava/lang/String;

    .line 746
    sget-object v0, Lorg/json/XMLParserConfiguration;->ORIGINAL:Lorg/json/XMLParserConfiguration;

    invoke-static {p0, p1, v0}, Lorg/json/XML;->toString(Ljava/lang/Object;Ljava/lang/String;Lorg/json/XMLParserConfiguration;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static toString(Ljava/lang/Object;Ljava/lang/String;I)Ljava/lang/String;
    .locals 1
    .param p0, "object"    # Ljava/lang/Object;
    .param p1, "tagName"    # Ljava/lang/String;
    .param p2, "indentFactor"    # I

    .line 940
    sget-object v0, Lorg/json/XMLParserConfiguration;->ORIGINAL:Lorg/json/XMLParserConfiguration;

    invoke-static {p0, p1, v0, p2}, Lorg/json/XML;->toString(Ljava/lang/Object;Ljava/lang/String;Lorg/json/XMLParserConfiguration;I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static toString(Ljava/lang/Object;Ljava/lang/String;Lorg/json/XMLParserConfiguration;)Ljava/lang/String;
    .locals 1
    .param p0, "object"    # Ljava/lang/Object;
    .param p1, "tagName"    # Ljava/lang/String;
    .param p2, "config"    # Lorg/json/XMLParserConfiguration;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 763
    const/4 v0, 0x0

    invoke-static {p0, p1, p2, v0, v0}, Lorg/json/XML;->toString(Ljava/lang/Object;Ljava/lang/String;Lorg/json/XMLParserConfiguration;II)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static toString(Ljava/lang/Object;Ljava/lang/String;Lorg/json/XMLParserConfiguration;I)Ljava/lang/String;
    .locals 1
    .param p0, "object"    # Ljava/lang/Object;
    .param p1, "tagName"    # Ljava/lang/String;
    .param p2, "config"    # Lorg/json/XMLParserConfiguration;
    .param p3, "indentFactor"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 959
    const/4 v0, 0x0

    invoke-static {p0, p1, p2, p3, v0}, Lorg/json/XML;->toString(Ljava/lang/Object;Ljava/lang/String;Lorg/json/XMLParserConfiguration;II)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static toString(Ljava/lang/Object;Ljava/lang/String;Lorg/json/XMLParserConfiguration;II)Ljava/lang/String;
    .locals 20
    .param p0, "object"    # Ljava/lang/Object;
    .param p1, "tagName"    # Ljava/lang/String;
    .param p2, "config"    # Lorg/json/XMLParserConfiguration;
    .param p3, "indentFactor"    # I
    .param p4, "indent"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 785
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    move/from16 v3, p3

    move/from16 v4, p4

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    .line 790
    .local v5, "sb":Ljava/lang/StringBuilder;
    instance-of v6, v0, Lorg/json/JSONObject;

    const-string v7, "/>"

    const-string v8, "</"

    const-string v9, ""

    const-string v10, "\n"

    if-eqz v6, :cond_e

    .line 793
    const/16 v6, 0x3c

    const/16 v11, 0x3e

    if-eqz v1, :cond_0

    .line 794
    invoke-static/range {p4 .. p4}, Lorg/json/XML;->indent(I)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v5, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 795
    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 796
    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 797
    invoke-virtual {v5, v11}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 798
    if-lez v3, :cond_0

    .line 799
    invoke-virtual {v5, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 800
    add-int/2addr v4, v3

    .line 806
    .end local p4    # "indent":I
    .local v4, "indent":I
    :cond_0
    move-object v12, v0

    check-cast v12, Lorg/json/JSONObject;

    .line 807
    .local v12, "jo":Lorg/json/JSONObject;
    invoke-virtual {v12}, Lorg/json/JSONObject;->keySet()Ljava/util/Set;

    move-result-object v13

    invoke-interface {v13}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v13

    :goto_0
    invoke-interface {v13}, Ljava/util/Iterator;->hasNext()Z

    move-result v14

    if-eqz v14, :cond_c

    invoke-interface {v13}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Ljava/lang/String;

    .line 808
    .local v14, "key":Ljava/lang/String;
    invoke-virtual {v12, v14}, Lorg/json/JSONObject;->opt(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v15

    .line 809
    .local v15, "value":Ljava/lang/Object;
    if-nez v15, :cond_1

    .line 810
    const-string v15, ""

    goto :goto_1

    .line 811
    :cond_1
    invoke-virtual {v15}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/Class;->isArray()Z

    move-result v16

    if-eqz v16, :cond_2

    .line 812
    new-instance v11, Lorg/json/JSONArray;

    invoke-direct {v11, v15}, Lorg/json/JSONArray;-><init>(Ljava/lang/Object;)V

    move-object v15, v11

    .line 816
    :cond_2
    :goto_1
    invoke-virtual/range {p2 .. p2}, Lorg/json/XMLParserConfiguration;->getcDataTagName()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v14, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_6

    .line 817
    instance-of v11, v15, Lorg/json/JSONArray;

    if-eqz v11, :cond_5

    .line 818
    move-object v11, v15

    check-cast v11, Lorg/json/JSONArray;

    .line 819
    .local v11, "ja":Lorg/json/JSONArray;
    invoke-virtual {v11}, Lorg/json/JSONArray;->length()I

    move-result v6

    .line 821
    .local v6, "jaLength":I
    const/16 v17, 0x0

    move-object/from16 p4, v12

    move/from16 v12, v17

    .local v12, "i":I
    .local p4, "jo":Lorg/json/JSONObject;
    :goto_2
    if-ge v12, v6, :cond_4

    .line 822
    if-lez v12, :cond_3

    .line 823
    move/from16 v17, v6

    .end local v6    # "jaLength":I
    .local v17, "jaLength":I
    const/16 v6, 0xa

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_3

    .line 822
    .end local v17    # "jaLength":I
    .restart local v6    # "jaLength":I
    :cond_3
    move/from16 v17, v6

    .line 825
    .end local v6    # "jaLength":I
    .restart local v17    # "jaLength":I
    :goto_3
    invoke-virtual {v11, v12}, Lorg/json/JSONArray;->opt(I)Ljava/lang/Object;

    move-result-object v6

    .line 826
    .local v6, "val":Ljava/lang/Object;
    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v19, v6

    .end local v6    # "val":Ljava/lang/Object;
    .local v19, "val":Ljava/lang/Object;
    invoke-static/range {v18 .. v18}, Lorg/json/XML;->escape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 821
    .end local v19    # "val":Ljava/lang/Object;
    add-int/lit8 v12, v12, 0x1

    move/from16 v6, v17

    goto :goto_2

    .end local v17    # "jaLength":I
    .local v6, "jaLength":I
    :cond_4
    move/from16 v17, v6

    .line 828
    .end local v6    # "jaLength":I
    .end local v12    # "i":I
    const/16 v6, 0x3c

    goto/16 :goto_6

    .line 829
    .end local v11    # "ja":Lorg/json/JSONArray;
    .end local p4    # "jo":Lorg/json/JSONObject;
    .local v12, "jo":Lorg/json/JSONObject;
    :cond_5
    move-object/from16 p4, v12

    .end local v12    # "jo":Lorg/json/JSONObject;
    .restart local p4    # "jo":Lorg/json/JSONObject;
    invoke-virtual {v15}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lorg/json/XML;->escape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/16 v6, 0x3c

    goto/16 :goto_6

    .line 834
    .end local p4    # "jo":Lorg/json/JSONObject;
    .restart local v12    # "jo":Lorg/json/JSONObject;
    :cond_6
    move-object/from16 p4, v12

    .end local v12    # "jo":Lorg/json/JSONObject;
    .restart local p4    # "jo":Lorg/json/JSONObject;
    instance-of v6, v15, Lorg/json/JSONArray;

    if-eqz v6, :cond_9

    .line 835
    move-object v6, v15

    check-cast v6, Lorg/json/JSONArray;

    .line 836
    .local v6, "ja":Lorg/json/JSONArray;
    invoke-virtual {v6}, Lorg/json/JSONArray;->length()I

    move-result v11

    .line 838
    .local v11, "jaLength":I
    const/4 v12, 0x0

    .local v12, "i":I
    :goto_4
    if-ge v12, v11, :cond_8

    .line 839
    move/from16 v17, v11

    .end local v11    # "jaLength":I
    .restart local v17    # "jaLength":I
    invoke-virtual {v6, v12}, Lorg/json/JSONArray;->opt(I)Ljava/lang/Object;

    move-result-object v11

    .line 840
    .local v11, "val":Ljava/lang/Object;
    move-object/from16 v18, v6

    .end local v6    # "ja":Lorg/json/JSONArray;
    .local v18, "ja":Lorg/json/JSONArray;
    instance-of v6, v11, Lorg/json/JSONArray;

    if-eqz v6, :cond_7

    .line 841
    const/16 v6, 0x3c

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 842
    invoke-virtual {v5, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 843
    const/16 v6, 0x3e

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 844
    const/4 v6, 0x0

    invoke-static {v11, v6, v2, v3, v4}, Lorg/json/XML;->toString(Ljava/lang/Object;Ljava/lang/String;Lorg/json/XMLParserConfiguration;II)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 845
    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 846
    invoke-virtual {v5, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 847
    const/16 v6, 0x3e

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_5

    .line 849
    :cond_7
    invoke-static {v11, v14, v2, v3, v4}, Lorg/json/XML;->toString(Ljava/lang/Object;Ljava/lang/String;Lorg/json/XMLParserConfiguration;II)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 838
    .end local v11    # "val":Ljava/lang/Object;
    :goto_5
    add-int/lit8 v12, v12, 0x1

    move/from16 v11, v17

    move-object/from16 v6, v18

    goto :goto_4

    .end local v17    # "jaLength":I
    .end local v18    # "ja":Lorg/json/JSONArray;
    .restart local v6    # "ja":Lorg/json/JSONArray;
    .local v11, "jaLength":I
    :cond_8
    move-object/from16 v18, v6

    move/from16 v17, v11

    .line 852
    .end local v6    # "ja":Lorg/json/JSONArray;
    .end local v11    # "jaLength":I
    .end local v12    # "i":I
    .restart local v18    # "ja":Lorg/json/JSONArray;
    const/16 v6, 0x3c

    goto :goto_6

    .end local v18    # "ja":Lorg/json/JSONArray;
    :cond_9
    invoke-virtual {v9, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_a

    .line 853
    invoke-static {v4}, Lorg/json/XML;->indent(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 854
    const/16 v6, 0x3c

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 855
    invoke-virtual {v5, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 856
    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 857
    if-lez v3, :cond_b

    .line 858
    invoke-virtual {v5, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_6

    .line 864
    :cond_a
    const/16 v6, 0x3c

    invoke-static {v15, v14, v2, v3, v4}, Lorg/json/XML;->toString(Ljava/lang/Object;Ljava/lang/String;Lorg/json/XMLParserConfiguration;II)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v5, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 866
    .end local v14    # "key":Ljava/lang/String;
    .end local v15    # "value":Ljava/lang/Object;
    :cond_b
    :goto_6
    move-object/from16 v12, p4

    const/16 v11, 0x3e

    goto/16 :goto_0

    .line 867
    .end local p4    # "jo":Lorg/json/JSONObject;
    .local v12, "jo":Lorg/json/JSONObject;
    :cond_c
    move-object/from16 p4, v12

    .end local v12    # "jo":Lorg/json/JSONObject;
    .restart local p4    # "jo":Lorg/json/JSONObject;
    if-eqz v1, :cond_d

    .line 870
    sub-int v6, v4, v3

    invoke-static {v6}, Lorg/json/XML;->indent(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 871
    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 872
    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 873
    const/16 v6, 0x3e

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 874
    if-lez v3, :cond_d

    .line 875
    invoke-virtual {v5, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 878
    :cond_d
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    return-object v6

    .line 882
    .end local v4    # "indent":I
    .local p4, "indent":I
    :cond_e
    if-eqz v0, :cond_13

    instance-of v6, v0, Lorg/json/JSONArray;

    if-nez v6, :cond_f

    invoke-virtual/range {p0 .. p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Class;->isArray()Z

    move-result v6

    if-eqz v6, :cond_13

    .line 883
    :cond_f
    invoke-virtual/range {p0 .. p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Class;->isArray()Z

    move-result v6

    if-eqz v6, :cond_10

    .line 884
    new-instance v6, Lorg/json/JSONArray;

    invoke-direct {v6, v0}, Lorg/json/JSONArray;-><init>(Ljava/lang/Object;)V

    .restart local v6    # "ja":Lorg/json/JSONArray;
    goto :goto_7

    .line 886
    .end local v6    # "ja":Lorg/json/JSONArray;
    :cond_10
    move-object v6, v0

    check-cast v6, Lorg/json/JSONArray;

    .line 888
    .restart local v6    # "ja":Lorg/json/JSONArray;
    :goto_7
    invoke-virtual {v6}, Lorg/json/JSONArray;->length()I

    move-result v7

    .line 890
    .local v7, "jaLength":I
    const/4 v8, 0x0

    .local v8, "i":I
    :goto_8
    if-ge v8, v7, :cond_12

    .line 891
    invoke-virtual {v6, v8}, Lorg/json/JSONArray;->opt(I)Ljava/lang/Object;

    move-result-object v9

    .line 895
    .local v9, "val":Ljava/lang/Object;
    if-nez v1, :cond_11

    const-string v10, "array"

    goto :goto_9

    :cond_11
    move-object v10, v1

    :goto_9
    invoke-static {v9, v10, v2, v3, v4}, Lorg/json/XML;->toString(Ljava/lang/Object;Ljava/lang/String;Lorg/json/XMLParserConfiguration;II)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 890
    .end local v9    # "val":Ljava/lang/Object;
    add-int/lit8 v8, v8, 0x1

    goto :goto_8

    .line 897
    .end local v8    # "i":I
    :cond_12
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    return-object v8

    .line 901
    .end local v6    # "ja":Lorg/json/JSONArray;
    .end local v7    # "jaLength":I
    :cond_13
    if-nez v0, :cond_14

    const-string v6, "null"

    goto :goto_a

    :cond_14
    invoke-virtual/range {p0 .. p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lorg/json/XML;->escape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 903
    .local v6, "string":Ljava/lang/String;
    :goto_a
    if-nez v1, :cond_16

    .line 904
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static/range {p4 .. p4}, Lorg/json/XML;->indent(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "\""

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    if-lez v3, :cond_15

    move-object v9, v10

    :cond_15
    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    return-object v7

    .line 905
    :cond_16
    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v11

    const-string v12, "<"

    if-nez v11, :cond_18

    .line 906
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static/range {p4 .. p4}, Lorg/json/XML;->indent(I)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v8, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    if-lez v3, :cond_17

    move-object v9, v10

    :cond_17
    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    return-object v7

    .line 908
    :cond_18
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static/range {p4 .. p4}, Lorg/json/XML;->indent(I)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v7, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v11, ">"

    invoke-virtual {v7, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    if-lez v3, :cond_19

    move-object v9, v10

    :cond_19
    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    return-object v7
.end method

.method public static unescape(Ljava/lang/String;)Ljava/lang/String;
    .locals 7
    .param p0, "string"    # Ljava/lang/String;

    .line 179
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 180
    .local v0, "sb":Ljava/lang/StringBuilder;
    const/4 v1, 0x0

    .local v1, "i":I
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    .local v2, "length":I
    :goto_0
    if-ge v1, v2, :cond_2

    .line 181
    invoke-virtual {p0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v3

    .line 182
    .local v3, "c":C
    const/16 v4, 0x26

    if-ne v3, v4, :cond_1

    .line 183
    const/16 v4, 0x3b

    invoke-virtual {p0, v4, v1}, Ljava/lang/String;->indexOf(II)I

    move-result v4

    .line 184
    .local v4, "semic":I
    if-le v4, v1, :cond_0

    .line 185
    add-int/lit8 v5, v1, 0x1

    invoke-virtual {p0, v5, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v5

    .line 186
    .local v5, "entity":Ljava/lang/String;
    invoke-static {v5}, Lorg/json/XMLTokener;->unescapeEntity(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 188
    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v6

    add-int/lit8 v6, v6, 0x1

    add-int/2addr v1, v6

    .line 189
    .end local v5    # "entity":Ljava/lang/String;
    goto :goto_1

    .line 192
    :cond_0
    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 194
    .end local v4    # "semic":I
    :goto_1
    goto :goto_2

    .line 196
    :cond_1
    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 180
    .end local v3    # "c":C
    :goto_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 199
    .end local v1    # "i":I
    .end local v2    # "length":I
    :cond_2
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
