.class public Lorg/json/JSONML;
.super Ljava/lang/Object;
.source "JSONML.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static parse(Lorg/json/XMLTokener;ZLorg/json/JSONArray;Lorg/json/JSONMLParserConfiguration;I)Ljava/lang/Object;
    .locals 9
    .param p0, "x"    # Lorg/json/XMLTokener;
    .param p1, "arrayForm"    # Z
    .param p2, "ja"    # Lorg/json/JSONArray;
    .param p3, "config"    # Lorg/json/JSONMLParserConfiguration;
    .param p4, "currentNestingDepth"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 59
    const/4 v0, 0x0

    .line 61
    .local v0, "closeTag":Ljava/lang/String;
    const/4 v1, 0x0

    .line 62
    .local v1, "newja":Lorg/json/JSONArray;
    const/4 v2, 0x0

    .line 64
    .local v2, "newjo":Lorg/json/JSONObject;
    const/4 v3, 0x0

    .line 73
    .local v3, "tagName":Ljava/lang/String;
    :cond_0
    :goto_0
    invoke-virtual {p0}, Lorg/json/XMLTokener;->more()Z

    move-result v4

    if-eqz v4, :cond_26

    .line 76
    invoke-virtual {p0}, Lorg/json/XMLTokener;->nextContent()Ljava/lang/Object;

    move-result-object v4

    .line 77
    .local v4, "token":Ljava/lang/Object;
    sget-object v5, Lorg/json/XML;->LT:Ljava/lang/Character;

    if-ne v4, v5, :cond_23

    .line 78
    invoke-virtual {p0}, Lorg/json/XMLTokener;->nextToken()Ljava/lang/Object;

    move-result-object v4

    .line 79
    instance-of v5, v4, Ljava/lang/Character;

    const-string v6, "\'."

    const-string v7, "Misshaped tag"

    if-eqz v5, :cond_e

    .line 80
    sget-object v5, Lorg/json/XML;->SLASH:Ljava/lang/Character;

    if-ne v4, v5, :cond_3

    .line 84
    invoke-virtual {p0}, Lorg/json/XMLTokener;->nextToken()Ljava/lang/Object;

    move-result-object v4

    .line 85
    instance-of v5, v4, Ljava/lang/String;

    if-eqz v5, :cond_2

    .line 90
    invoke-virtual {p0}, Lorg/json/XMLTokener;->nextToken()Ljava/lang/Object;

    move-result-object v5

    sget-object v6, Lorg/json/XML;->GT:Ljava/lang/Character;

    if-ne v5, v6, :cond_1

    .line 93
    return-object v4

    .line 91
    :cond_1
    const-string v5, "Misshaped close tag"

    invoke-virtual {p0, v5}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v5

    throw v5

    .line 86
    :cond_2
    new-instance v5, Lorg/json/JSONException;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Expected a closing name instead of \'"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Lorg/json/JSONException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 94
    :cond_3
    sget-object v5, Lorg/json/XML;->BANG:Ljava/lang/Character;

    if-ne v4, v5, :cond_c

    .line 98
    invoke-virtual {p0}, Lorg/json/XMLTokener;->next()C

    move-result v5

    .line 99
    .local v5, "c":C
    const/16 v6, 0x2d

    if-ne v5, v6, :cond_5

    .line 100
    invoke-virtual {p0}, Lorg/json/XMLTokener;->next()C

    move-result v7

    if-ne v7, v6, :cond_4

    .line 101
    const-string v6, "-->"

    invoke-virtual {p0, v6}, Lorg/json/XMLTokener;->skipPast(Ljava/lang/String;)V

    goto :goto_0

    .line 103
    :cond_4
    invoke-virtual {p0}, Lorg/json/XMLTokener;->back()V

    goto :goto_0

    .line 105
    :cond_5
    const/16 v6, 0x5b

    if-ne v5, v6, :cond_7

    .line 106
    invoke-virtual {p0}, Lorg/json/XMLTokener;->nextToken()Ljava/lang/Object;

    move-result-object v4

    .line 107
    const-string v7, "CDATA"

    invoke-virtual {v4, v7}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_6

    invoke-virtual {p0}, Lorg/json/XMLTokener;->next()C

    move-result v7

    if-ne v7, v6, :cond_6

    .line 108
    if-eqz p2, :cond_0

    .line 109
    invoke-virtual {p0}, Lorg/json/XMLTokener;->nextCDATA()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p2, v6}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    goto/16 :goto_0

    .line 112
    :cond_6
    const-string v6, "Expected \'CDATA[\'"

    invoke-virtual {p0, v6}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v6

    throw v6

    .line 115
    :cond_7
    const/4 v6, 0x1

    .line 117
    .local v6, "i":I
    :cond_8
    invoke-virtual {p0}, Lorg/json/XMLTokener;->nextMeta()Ljava/lang/Object;

    move-result-object v4

    .line 118
    if-eqz v4, :cond_b

    .line 120
    sget-object v7, Lorg/json/XML;->LT:Ljava/lang/Character;

    if-ne v4, v7, :cond_9

    .line 121
    add-int/lit8 v6, v6, 0x1

    goto :goto_1

    .line 122
    :cond_9
    sget-object v7, Lorg/json/XML;->GT:Ljava/lang/Character;

    if-ne v4, v7, :cond_a

    .line 123
    add-int/lit8 v6, v6, -0x1

    .line 125
    :cond_a
    :goto_1
    if-gtz v6, :cond_8

    goto/16 :goto_0

    .line 119
    :cond_b
    const-string v7, "Missing \'>\' after \'<!\'."

    invoke-virtual {p0, v7}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v7

    throw v7

    .line 127
    .end local v5    # "c":C
    .end local v6    # "i":I
    :cond_c
    sget-object v5, Lorg/json/XML;->QUEST:Ljava/lang/Character;

    if-ne v4, v5, :cond_d

    .line 131
    const-string v5, "?>"

    invoke-virtual {p0, v5}, Lorg/json/XMLTokener;->skipPast(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 133
    :cond_d
    invoke-virtual {p0, v7}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v5

    throw v5

    .line 139
    :cond_e
    instance-of v5, v4, Ljava/lang/String;

    if-eqz v5, :cond_22

    .line 142
    move-object v3, v4

    check-cast v3, Ljava/lang/String;

    .line 143
    new-instance v5, Lorg/json/JSONArray;

    invoke-direct {v5}, Lorg/json/JSONArray;-><init>()V

    move-object v1, v5

    .line 144
    new-instance v5, Lorg/json/JSONObject;

    invoke-direct {v5}, Lorg/json/JSONObject;-><init>()V

    move-object v2, v5

    .line 145
    const-string v5, "tagName"

    if-eqz p1, :cond_f

    .line 146
    invoke-virtual {v1, v3}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 147
    if-eqz p2, :cond_10

    .line 148
    invoke-virtual {p2, v1}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    goto :goto_2

    .line 151
    :cond_f
    invoke-virtual {v2, v5, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 152
    if-eqz p2, :cond_10

    .line 153
    invoke-virtual {p2, v2}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 156
    :cond_10
    :goto_2
    const/4 v4, 0x0

    .line 158
    :goto_3
    if-nez v4, :cond_11

    .line 159
    invoke-virtual {p0}, Lorg/json/XMLTokener;->nextToken()Ljava/lang/Object;

    move-result-object v4

    .line 161
    :cond_11
    if-eqz v4, :cond_21

    .line 164
    instance-of v6, v4, Ljava/lang/String;

    if-nez v6, :cond_1b

    .line 165
    nop

    .line 186
    if-eqz p1, :cond_12

    invoke-virtual {v2}, Lorg/json/JSONObject;->length()I

    move-result v5

    if-lez v5, :cond_12

    .line 187
    invoke-virtual {v1, v2}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 192
    :cond_12
    sget-object v5, Lorg/json/XML;->SLASH:Ljava/lang/Character;

    if-ne v4, v5, :cond_15

    .line 193
    invoke-virtual {p0}, Lorg/json/XMLTokener;->nextToken()Ljava/lang/Object;

    move-result-object v5

    sget-object v6, Lorg/json/XML;->GT:Ljava/lang/Character;

    if-ne v5, v6, :cond_14

    .line 196
    if-nez p2, :cond_0

    .line 197
    if-eqz p1, :cond_13

    .line 198
    return-object v1

    .line 200
    :cond_13
    return-object v2

    .line 194
    :cond_14
    invoke-virtual {p0, v7}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v5

    throw v5

    .line 206
    :cond_15
    sget-object v5, Lorg/json/XML;->GT:Ljava/lang/Character;

    if-ne v4, v5, :cond_1a

    .line 210
    invoke-virtual {p3}, Lorg/json/JSONMLParserConfiguration;->getMaxNestingDepth()I

    move-result v5

    if-eq p4, v5, :cond_19

    .line 214
    add-int/lit8 v5, p4, 0x1

    invoke-static {p0, p1, v1, p3, v5}, Lorg/json/JSONML;->parse(Lorg/json/XMLTokener;ZLorg/json/JSONArray;Lorg/json/JSONMLParserConfiguration;I)Ljava/lang/Object;

    move-result-object v5

    move-object v0, v5

    check-cast v0, Ljava/lang/String;

    .line 215
    if-eqz v0, :cond_0

    .line 216
    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_18

    .line 220
    const/4 v3, 0x0

    .line 221
    if-nez p1, :cond_16

    invoke-virtual {v1}, Lorg/json/JSONArray;->length()I

    move-result v5

    if-lez v5, :cond_16

    .line 222
    const-string v5, "childNodes"

    invoke-virtual {v2, v5, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 224
    :cond_16
    if-nez p2, :cond_0

    .line 225
    if-eqz p1, :cond_17

    .line 226
    return-object v1

    .line 228
    :cond_17
    return-object v2

    .line 217
    :cond_18
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Mismatched \'"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "\' and \'"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "\'"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p0, v5}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v5

    throw v5

    .line 211
    :cond_19
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Maximum nesting depth of "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {p3}, Lorg/json/JSONMLParserConfiguration;->getMaxNestingDepth()I

    move-result v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " reached"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p0, v5}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v5

    throw v5

    .line 207
    :cond_1a
    invoke-virtual {p0, v7}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v5

    throw v5

    .line 170
    :cond_1b
    move-object v6, v4

    check-cast v6, Ljava/lang/String;

    .line 171
    .local v6, "attribute":Ljava/lang/String;
    if-nez p1, :cond_1d

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_1c

    const-string v8, "childNode"

    invoke-virtual {v8, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_1c

    goto :goto_4

    .line 172
    :cond_1c
    const-string v5, "Reserved attribute."

    invoke-virtual {p0, v5}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v5

    throw v5

    .line 174
    :cond_1d
    :goto_4
    invoke-virtual {p0}, Lorg/json/XMLTokener;->nextToken()Ljava/lang/Object;

    move-result-object v4

    .line 175
    sget-object v8, Lorg/json/XML;->EQ:Ljava/lang/Character;

    if-ne v4, v8, :cond_20

    .line 176
    invoke-virtual {p0}, Lorg/json/XMLTokener;->nextToken()Ljava/lang/Object;

    move-result-object v4

    .line 177
    instance-of v8, v4, Ljava/lang/String;

    if-eqz v8, :cond_1f

    .line 180
    invoke-virtual {p3}, Lorg/json/JSONMLParserConfiguration;->isKeepStrings()Z

    move-result v8

    if-eqz v8, :cond_1e

    move-object v8, v4

    check-cast v8, Ljava/lang/String;

    goto :goto_5

    :cond_1e
    move-object v8, v4

    check-cast v8, Ljava/lang/String;

    invoke-static {v8}, Lorg/json/XML;->stringToValue(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v8

    :goto_5
    invoke-virtual {v2, v6, v8}, Lorg/json/JSONObject;->accumulate(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 181
    const/4 v4, 0x0

    goto/16 :goto_3

    .line 178
    :cond_1f
    const-string v5, "Missing value"

    invoke-virtual {p0, v5}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v5

    throw v5

    .line 183
    :cond_20
    const-string v8, ""

    invoke-virtual {v2, v6, v8}, Lorg/json/JSONObject;->accumulate(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto/16 :goto_3

    .line 162
    .end local v6    # "attribute":Ljava/lang/String;
    :cond_21
    invoke-virtual {p0, v7}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v5

    throw v5

    .line 140
    :cond_22
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Bad tagName \'"

    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p0, v5}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v5

    throw v5

    .line 234
    :cond_23
    if-eqz p2, :cond_0

    .line 235
    instance-of v5, v4, Ljava/lang/String;

    if-eqz v5, :cond_25

    .line 236
    invoke-virtual {p3}, Lorg/json/JSONMLParserConfiguration;->isKeepStrings()Z

    move-result v5

    if-eqz v5, :cond_24

    move-object v5, v4

    check-cast v5, Ljava/lang/String;

    invoke-static {v5}, Lorg/json/XML;->unescape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    goto :goto_6

    :cond_24
    move-object v5, v4

    check-cast v5, Ljava/lang/String;

    invoke-static {v5}, Lorg/json/XML;->stringToValue(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    goto :goto_6

    :cond_25
    move-object v5, v4

    .line 235
    :goto_6
    invoke-virtual {p2, v5}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    goto/16 :goto_0

    .line 74
    .end local v4    # "token":Ljava/lang/Object;
    :cond_26
    const-string v4, "Bad XML"

    invoke-virtual {p0, v4}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v4

    throw v4
.end method

.method private static parse(Lorg/json/XMLTokener;ZLorg/json/JSONArray;ZI)Ljava/lang/Object;
    .locals 1
    .param p0, "x"    # Lorg/json/XMLTokener;
    .param p1, "arrayForm"    # Z
    .param p2, "ja"    # Lorg/json/JSONArray;
    .param p3, "keepStrings"    # Z
    .param p4, "currentNestingDepth"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 33
    if-eqz p3, :cond_0

    sget-object v0, Lorg/json/JSONMLParserConfiguration;->KEEP_STRINGS:Lorg/json/JSONMLParserConfiguration;

    goto :goto_0

    :cond_0
    sget-object v0, Lorg/json/JSONMLParserConfiguration;->ORIGINAL:Lorg/json/JSONMLParserConfiguration;

    :goto_0
    invoke-static {p0, p1, p2, v0, p4}, Lorg/json/JSONML;->parse(Lorg/json/XMLTokener;ZLorg/json/JSONArray;Lorg/json/JSONMLParserConfiguration;I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public static toJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;
    .locals 5
    .param p0, "string"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 257
    new-instance v0, Lorg/json/XMLTokener;

    invoke-direct {v0, p0}, Lorg/json/XMLTokener;-><init>(Ljava/lang/String;)V

    sget-object v1, Lorg/json/JSONMLParserConfiguration;->ORIGINAL:Lorg/json/JSONMLParserConfiguration;

    const/4 v2, 0x0

    const/4 v3, 0x1

    const/4 v4, 0x0

    invoke-static {v0, v3, v4, v1, v2}, Lorg/json/JSONML;->parse(Lorg/json/XMLTokener;ZLorg/json/JSONArray;Lorg/json/JSONMLParserConfiguration;I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/json/JSONArray;

    return-object v0
.end method

.method public static toJSONArray(Ljava/lang/String;Lorg/json/JSONMLParserConfiguration;)Lorg/json/JSONArray;
    .locals 4
    .param p0, "string"    # Ljava/lang/String;
    .param p1, "config"    # Lorg/json/JSONMLParserConfiguration;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 304
    new-instance v0, Lorg/json/XMLTokener;

    invoke-direct {v0, p0}, Lorg/json/XMLTokener;-><init>(Ljava/lang/String;)V

    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v3, 0x1

    invoke-static {v0, v3, v1, p1, v2}, Lorg/json/JSONML;->parse(Lorg/json/XMLTokener;ZLorg/json/JSONArray;Lorg/json/JSONMLParserConfiguration;I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/json/JSONArray;

    return-object v0
.end method

.method public static toJSONArray(Ljava/lang/String;Z)Lorg/json/JSONArray;
    .locals 4
    .param p0, "string"    # Ljava/lang/String;
    .param p1, "keepStrings"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 279
    new-instance v0, Lorg/json/XMLTokener;

    invoke-direct {v0, p0}, Lorg/json/XMLTokener;-><init>(Ljava/lang/String;)V

    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v3, 0x1

    invoke-static {v0, v3, v1, p1, v2}, Lorg/json/JSONML;->parse(Lorg/json/XMLTokener;ZLorg/json/JSONArray;ZI)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/json/JSONArray;

    return-object v0
.end method

.method public static toJSONArray(Lorg/json/XMLTokener;)Lorg/json/JSONArray;
    .locals 3
    .param p0, "x"    # Lorg/json/XMLTokener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 367
    const/4 v0, 0x0

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-static {p0, v2, v0, v1, v1}, Lorg/json/JSONML;->parse(Lorg/json/XMLTokener;ZLorg/json/JSONArray;ZI)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/json/JSONArray;

    return-object v0
.end method

.method public static toJSONArray(Lorg/json/XMLTokener;Lorg/json/JSONMLParserConfiguration;)Lorg/json/JSONArray;
    .locals 3
    .param p0, "x"    # Lorg/json/XMLTokener;
    .param p1, "config"    # Lorg/json/JSONMLParserConfiguration;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 328
    const/4 v0, 0x0

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-static {p0, v2, v0, p1, v1}, Lorg/json/JSONML;->parse(Lorg/json/XMLTokener;ZLorg/json/JSONArray;Lorg/json/JSONMLParserConfiguration;I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/json/JSONArray;

    return-object v0
.end method

.method public static toJSONArray(Lorg/json/XMLTokener;Z)Lorg/json/JSONArray;
    .locals 3
    .param p0, "x"    # Lorg/json/XMLTokener;
    .param p1, "keepStrings"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 350
    const/4 v0, 0x0

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-static {p0, v2, v0, p1, v1}, Lorg/json/JSONML;->parse(Lorg/json/XMLTokener;ZLorg/json/JSONArray;ZI)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/json/JSONArray;

    return-object v0
.end method

.method public static toJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 3
    .param p0, "string"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 385
    new-instance v0, Lorg/json/XMLTokener;

    invoke-direct {v0, p0}, Lorg/json/XMLTokener;-><init>(Ljava/lang/String;)V

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-static {v0, v1, v2, v1, v1}, Lorg/json/JSONML;->parse(Lorg/json/XMLTokener;ZLorg/json/JSONArray;ZI)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/json/JSONObject;

    return-object v0
.end method

.method public static toJSONObject(Ljava/lang/String;Lorg/json/JSONMLParserConfiguration;)Lorg/json/JSONObject;
    .locals 3
    .param p0, "string"    # Ljava/lang/String;
    .param p1, "config"    # Lorg/json/JSONMLParserConfiguration;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 427
    new-instance v0, Lorg/json/XMLTokener;

    invoke-direct {v0, p0}, Lorg/json/XMLTokener;-><init>(Ljava/lang/String;)V

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-static {v0, v1, v2, p1, v1}, Lorg/json/JSONML;->parse(Lorg/json/XMLTokener;ZLorg/json/JSONArray;Lorg/json/JSONMLParserConfiguration;I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/json/JSONObject;

    return-object v0
.end method

.method public static toJSONObject(Ljava/lang/String;Z)Lorg/json/JSONObject;
    .locals 3
    .param p0, "string"    # Ljava/lang/String;
    .param p1, "keepStrings"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 405
    new-instance v0, Lorg/json/XMLTokener;

    invoke-direct {v0, p0}, Lorg/json/XMLTokener;-><init>(Ljava/lang/String;)V

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-static {v0, v1, v2, p1, v1}, Lorg/json/JSONML;->parse(Lorg/json/XMLTokener;ZLorg/json/JSONArray;ZI)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/json/JSONObject;

    return-object v0
.end method

.method public static toJSONObject(Lorg/json/XMLTokener;)Lorg/json/JSONObject;
    .locals 2
    .param p0, "x"    # Lorg/json/XMLTokener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 445
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-static {p0, v0, v1, v0, v0}, Lorg/json/JSONML;->parse(Lorg/json/XMLTokener;ZLorg/json/JSONArray;ZI)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/json/JSONObject;

    return-object v0
.end method

.method public static toJSONObject(Lorg/json/XMLTokener;Lorg/json/JSONMLParserConfiguration;)Lorg/json/JSONObject;
    .locals 2
    .param p0, "x"    # Lorg/json/XMLTokener;
    .param p1, "config"    # Lorg/json/JSONMLParserConfiguration;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 487
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-static {p0, v0, v1, p1, v0}, Lorg/json/JSONML;->parse(Lorg/json/XMLTokener;ZLorg/json/JSONArray;Lorg/json/JSONMLParserConfiguration;I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/json/JSONObject;

    return-object v0
.end method

.method public static toJSONObject(Lorg/json/XMLTokener;Z)Lorg/json/JSONObject;
    .locals 2
    .param p0, "x"    # Lorg/json/XMLTokener;
    .param p1, "keepStrings"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 465
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-static {p0, v0, v1, p1, v0}, Lorg/json/JSONML;->parse(Lorg/json/XMLTokener;ZLorg/json/JSONArray;ZI)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/json/JSONObject;

    return-object v0
.end method

.method public static toString(Lorg/json/JSONArray;)Ljava/lang/String;
    .locals 12
    .param p0, "ja"    # Lorg/json/JSONArray;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 502
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 507
    .local v0, "sb":Ljava/lang/StringBuilder;
    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 508
    .local v1, "tagName":Ljava/lang/String;
    invoke-static {v1}, Lorg/json/XML;->noSpace(Ljava/lang/String;)V

    .line 509
    invoke-static {v1}, Lorg/json/XML;->escape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 510
    const/16 v2, 0x3c

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 511
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 513
    const/4 v3, 0x1

    invoke-virtual {p0, v3}, Lorg/json/JSONArray;->opt(I)Ljava/lang/Object;

    move-result-object v4

    .line 514
    .local v4, "object":Ljava/lang/Object;
    instance-of v5, v4, Lorg/json/JSONObject;

    if-eqz v5, :cond_2

    .line 515
    const/4 v5, 0x2

    .line 516
    .local v5, "i":I
    move-object v6, v4

    check-cast v6, Lorg/json/JSONObject;

    .line 521
    .local v6, "jo":Lorg/json/JSONObject;
    invoke-virtual {v6}, Lorg/json/JSONObject;->keySet()Ljava/util/Set;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :goto_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_1

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    .line 522
    .local v8, "key":Ljava/lang/String;
    invoke-virtual {v6, v8}, Lorg/json/JSONObject;->opt(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v9

    .line 523
    .local v9, "value":Ljava/lang/Object;
    invoke-static {v8}, Lorg/json/XML;->noSpace(Ljava/lang/String;)V

    .line 524
    if-eqz v9, :cond_0

    .line 525
    const/16 v10, 0x20

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 526
    invoke-static {v8}, Lorg/json/XML;->escape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 527
    const/16 v10, 0x3d

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 528
    const/16 v10, 0x22

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 529
    invoke-virtual {v9}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v11}, Lorg/json/XML;->escape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 530
    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 532
    .end local v8    # "key":Ljava/lang/String;
    .end local v9    # "value":Ljava/lang/Object;
    :cond_0
    goto :goto_0

    :cond_1
    goto :goto_1

    .line 534
    .end local v5    # "i":I
    .end local v6    # "jo":Lorg/json/JSONObject;
    :cond_2
    const/4 v5, 0x1

    .line 539
    .restart local v5    # "i":I
    :goto_1
    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v6

    .line 540
    .local v6, "length":I
    const/16 v7, 0x2f

    const/16 v8, 0x3e

    if-lt v5, v6, :cond_3

    .line 541
    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 542
    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_3

    .line 544
    :cond_3
    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 546
    :cond_4
    invoke-virtual {p0, v5}, Lorg/json/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object v4

    .line 547
    add-int/2addr v5, v3

    .line 548
    if-eqz v4, :cond_8

    .line 549
    instance-of v9, v4, Ljava/lang/String;

    if-eqz v9, :cond_5

    .line 550
    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Lorg/json/XML;->escape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_2

    .line 551
    :cond_5
    instance-of v9, v4, Lorg/json/JSONObject;

    if-eqz v9, :cond_6

    .line 552
    move-object v9, v4

    check-cast v9, Lorg/json/JSONObject;

    invoke-static {v9}, Lorg/json/JSONML;->toString(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_2

    .line 553
    :cond_6
    instance-of v9, v4, Lorg/json/JSONArray;

    if-eqz v9, :cond_7

    .line 554
    move-object v9, v4

    check-cast v9, Lorg/json/JSONArray;

    invoke-static {v9}, Lorg/json/JSONML;->toString(Lorg/json/JSONArray;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_2

    .line 556
    :cond_7
    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 559
    :cond_8
    :goto_2
    if-lt v5, v6, :cond_4

    .line 560
    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 561
    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 562
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 563
    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 565
    :goto_3
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method public static toString(Lorg/json/JSONObject;)Ljava/lang/String;
    .locals 10
    .param p0, "jo"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 579
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 589
    .local v0, "sb":Ljava/lang/StringBuilder;
    const-string v1, "tagName"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 590
    .local v2, "tagName":Ljava/lang/String;
    if-nez v2, :cond_0

    .line 591
    invoke-virtual {p0}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lorg/json/XML;->escape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    return-object v1

    .line 593
    :cond_0
    invoke-static {v2}, Lorg/json/XML;->noSpace(Ljava/lang/String;)V

    .line 594
    invoke-static {v2}, Lorg/json/XML;->escape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 595
    const/16 v3, 0x3c

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 596
    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 601
    invoke-virtual {p0}, Lorg/json/JSONObject;->keySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    const-string v6, "childNodes"

    if-eqz v5, :cond_2

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    .line 602
    .local v5, "key":Ljava/lang/String;
    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-nez v7, :cond_1

    invoke-virtual {v6, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_1

    .line 603
    invoke-static {v5}, Lorg/json/XML;->noSpace(Ljava/lang/String;)V

    .line 604
    invoke-virtual {p0, v5}, Lorg/json/JSONObject;->opt(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v6

    .line 605
    .local v6, "value":Ljava/lang/Object;
    if-eqz v6, :cond_1

    .line 606
    const/16 v7, 0x20

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 607
    invoke-static {v5}, Lorg/json/XML;->escape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 608
    const/16 v7, 0x3d

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 609
    const/16 v7, 0x22

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 610
    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Lorg/json/XML;->escape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 611
    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 614
    .end local v5    # "key":Ljava/lang/String;
    .end local v6    # "value":Ljava/lang/Object;
    :cond_1
    goto :goto_0

    .line 618
    :cond_2
    invoke-virtual {p0, v6}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v1

    .line 619
    .local v1, "ja":Lorg/json/JSONArray;
    const/16 v4, 0x2f

    const/16 v5, 0x3e

    if-nez v1, :cond_3

    .line 620
    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 621
    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_3

    .line 623
    :cond_3
    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 624
    invoke-virtual {v1}, Lorg/json/JSONArray;->length()I

    move-result v6

    .line 625
    .local v6, "length":I
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_1
    if-ge v7, v6, :cond_8

    .line 626
    invoke-virtual {v1, v7}, Lorg/json/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object v8

    .line 627
    .local v8, "object":Ljava/lang/Object;
    if-eqz v8, :cond_7

    .line 628
    instance-of v9, v8, Ljava/lang/String;

    if-eqz v9, :cond_4

    .line 629
    invoke-virtual {v8}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Lorg/json/XML;->escape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_2

    .line 630
    :cond_4
    instance-of v9, v8, Lorg/json/JSONObject;

    if-eqz v9, :cond_5

    .line 631
    move-object v9, v8

    check-cast v9, Lorg/json/JSONObject;

    invoke-static {v9}, Lorg/json/JSONML;->toString(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_2

    .line 632
    :cond_5
    instance-of v9, v8, Lorg/json/JSONArray;

    if-eqz v9, :cond_6

    .line 633
    move-object v9, v8

    check-cast v9, Lorg/json/JSONArray;

    invoke-static {v9}, Lorg/json/JSONML;->toString(Lorg/json/JSONArray;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_2

    .line 635
    :cond_6
    invoke-virtual {v8}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 625
    :cond_7
    :goto_2
    add-int/lit8 v7, v7, 0x1

    goto :goto_1

    .line 639
    .end local v8    # "object":Ljava/lang/Object;
    :cond_8
    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 640
    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 641
    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 642
    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 644
    .end local v6    # "length":I
    .end local v7    # "i":I
    :goto_3
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method
