.class public Lorg/json/JSONTokener;
.super Ljava/lang/Object;
.source "JSONTokener.java"


# instance fields
.field private character:J

.field private characterPreviousLine:J

.field private eof:Z

.field private index:J

.field private line:J

.field private previous:C

.field private final reader:Ljava/io/Reader;

.field private usePrevious:Z


# direct methods
.method public constructor <init>(Ljava/io/InputStream;)V
    .locals 2
    .param p1, "inputStream"    # Ljava/io/InputStream;

    .line 60
    new-instance v0, Ljava/io/InputStreamReader;

    const-string v1, "UTF-8"

    invoke-static {v1}, Ljava/nio/charset/Charset;->forName(Ljava/lang/String;)Ljava/nio/charset/Charset;

    move-result-object v1

    invoke-direct {v0, p1, v1}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V

    invoke-direct {p0, v0}, Lorg/json/JSONTokener;-><init>(Ljava/io/Reader;)V

    .line 61
    return-void
.end method

.method public constructor <init>(Ljava/io/Reader;)V
    .locals 4
    .param p1, "reader"    # Ljava/io/Reader;

    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    invoke-virtual {p1}, Ljava/io/Reader;->markSupported()Z

    move-result v0

    if-eqz v0, :cond_0

    move-object v0, p1

    goto :goto_0

    :cond_0
    new-instance v0, Ljava/io/BufferedReader;

    invoke-direct {v0, p1}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    :goto_0
    iput-object v0, p0, Lorg/json/JSONTokener;->reader:Ljava/io/Reader;

    .line 45
    const/4 v0, 0x0

    iput-boolean v0, p0, Lorg/json/JSONTokener;->eof:Z

    .line 46
    iput-boolean v0, p0, Lorg/json/JSONTokener;->usePrevious:Z

    .line 47
    iput-char v0, p0, Lorg/json/JSONTokener;->previous:C

    .line 48
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lorg/json/JSONTokener;->index:J

    .line 49
    const-wide/16 v2, 0x1

    iput-wide v2, p0, Lorg/json/JSONTokener;->character:J

    .line 50
    iput-wide v0, p0, Lorg/json/JSONTokener;->characterPreviousLine:J

    .line 51
    iput-wide v2, p0, Lorg/json/JSONTokener;->line:J

    .line 52
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "s"    # Ljava/lang/String;

    .line 70
    new-instance v0, Ljava/io/StringReader;

    invoke-direct {v0, p1}, Ljava/io/StringReader;-><init>(Ljava/lang/String;)V

    invoke-direct {p0, v0}, Lorg/json/JSONTokener;-><init>(Ljava/io/Reader;)V

    .line 71
    return-void
.end method

.method private decrementIndexes()V
    .locals 6

    .line 94
    iget-wide v0, p0, Lorg/json/JSONTokener;->index:J

    const-wide/16 v2, 0x1

    sub-long/2addr v0, v2

    iput-wide v0, p0, Lorg/json/JSONTokener;->index:J

    .line 95
    iget-char v0, p0, Lorg/json/JSONTokener;->previous:C

    const/16 v1, 0xd

    if-eq v0, v1, :cond_1

    const/16 v1, 0xa

    if-ne v0, v1, :cond_0

    goto :goto_0

    .line 98
    :cond_0
    iget-wide v0, p0, Lorg/json/JSONTokener;->character:J

    const-wide/16 v4, 0x0

    cmp-long v4, v0, v4

    if-lez v4, :cond_2

    .line 99
    sub-long/2addr v0, v2

    iput-wide v0, p0, Lorg/json/JSONTokener;->character:J

    goto :goto_1

    .line 96
    :cond_1
    :goto_0
    iget-wide v0, p0, Lorg/json/JSONTokener;->line:J

    sub-long/2addr v0, v2

    iput-wide v0, p0, Lorg/json/JSONTokener;->line:J

    .line 97
    iget-wide v0, p0, Lorg/json/JSONTokener;->characterPreviousLine:J

    iput-wide v0, p0, Lorg/json/JSONTokener;->character:J

    .line 101
    :cond_2
    :goto_1
    return-void
.end method

.method public static dehexchar(C)I
    .locals 1
    .param p0, "c"    # C

    .line 110
    const/16 v0, 0x30

    if-lt p0, v0, :cond_0

    const/16 v0, 0x39

    if-gt p0, v0, :cond_0

    .line 111
    add-int/lit8 v0, p0, -0x30

    return v0

    .line 113
    :cond_0
    const/16 v0, 0x41

    if-lt p0, v0, :cond_1

    const/16 v0, 0x46

    if-gt p0, v0, :cond_1

    .line 114
    add-int/lit8 v0, p0, -0x37

    return v0

    .line 116
    :cond_1
    const/16 v0, 0x61

    if-lt p0, v0, :cond_2

    const/16 v0, 0x66

    if-gt p0, v0, :cond_2

    .line 117
    add-int/lit8 v0, p0, -0x57

    return v0

    .line 119
    :cond_2
    const/4 v0, -0x1

    return v0
.end method

.method private incrementIndexes(I)V
    .locals 6
    .param p1, "c"    # I

    .line 201
    if-lez p1, :cond_3

    .line 202
    iget-wide v0, p0, Lorg/json/JSONTokener;->index:J

    const-wide/16 v2, 0x1

    add-long/2addr v0, v2

    iput-wide v0, p0, Lorg/json/JSONTokener;->index:J

    .line 203
    const-wide/16 v0, 0x0

    const/16 v4, 0xd

    if-ne p1, v4, :cond_0

    .line 204
    iget-wide v4, p0, Lorg/json/JSONTokener;->line:J

    add-long/2addr v4, v2

    iput-wide v4, p0, Lorg/json/JSONTokener;->line:J

    .line 205
    iget-wide v2, p0, Lorg/json/JSONTokener;->character:J

    iput-wide v2, p0, Lorg/json/JSONTokener;->characterPreviousLine:J

    .line 206
    iput-wide v0, p0, Lorg/json/JSONTokener;->character:J

    goto :goto_0

    .line 207
    :cond_0
    const/16 v5, 0xa

    if-ne p1, v5, :cond_2

    .line 208
    iget-char v5, p0, Lorg/json/JSONTokener;->previous:C

    if-eq v5, v4, :cond_1

    .line 209
    iget-wide v4, p0, Lorg/json/JSONTokener;->line:J

    add-long/2addr v4, v2

    iput-wide v4, p0, Lorg/json/JSONTokener;->line:J

    .line 210
    iget-wide v2, p0, Lorg/json/JSONTokener;->character:J

    iput-wide v2, p0, Lorg/json/JSONTokener;->characterPreviousLine:J

    .line 212
    :cond_1
    iput-wide v0, p0, Lorg/json/JSONTokener;->character:J

    goto :goto_0

    .line 214
    :cond_2
    iget-wide v0, p0, Lorg/json/JSONTokener;->character:J

    add-long/2addr v0, v2

    iput-wide v0, p0, Lorg/json/JSONTokener;->character:J

    .line 217
    :cond_3
    :goto_0
    return-void
.end method


# virtual methods
.method public back()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 82
    iget-boolean v0, p0, Lorg/json/JSONTokener;->usePrevious:Z

    if-nez v0, :cond_0

    iget-wide v0, p0, Lorg/json/JSONTokener;->index:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    .line 85
    invoke-direct {p0}, Lorg/json/JSONTokener;->decrementIndexes()V

    .line 86
    const/4 v0, 0x1

    iput-boolean v0, p0, Lorg/json/JSONTokener;->usePrevious:Z

    .line 87
    const/4 v0, 0x0

    iput-boolean v0, p0, Lorg/json/JSONTokener;->eof:Z

    .line 88
    return-void

    .line 83
    :cond_0
    new-instance v0, Lorg/json/JSONException;

    const-string v1, "Stepping back two steps is not supported"

    invoke-direct {v0, v1}, Lorg/json/JSONException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public close()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 529
    iget-object v0, p0, Lorg/json/JSONTokener;->reader:Ljava/io/Reader;

    if-eqz v0, :cond_0

    .line 530
    invoke-virtual {v0}, Ljava/io/Reader;->close()V

    .line 532
    :cond_0
    return-void
.end method

.method public end()Z
    .locals 1

    .line 128
    iget-boolean v0, p0, Lorg/json/JSONTokener;->eof:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lorg/json/JSONTokener;->usePrevious:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method protected getPrevious()C
    .locals 1

    .line 193
    iget-char v0, p0, Lorg/json/JSONTokener;->previous:C

    return v0
.end method

.method public more()Z
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 140
    iget-boolean v0, p0, Lorg/json/JSONTokener;->usePrevious:Z

    const/4 v1, 0x1

    if-eqz v0, :cond_0

    .line 141
    return v1

    .line 144
    :cond_0
    :try_start_0
    iget-object v0, p0, Lorg/json/JSONTokener;->reader:Ljava/io/Reader;

    invoke-virtual {v0, v1}, Ljava/io/Reader;->mark(I)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 147
    nop

    .line 150
    :try_start_1
    iget-object v0, p0, Lorg/json/JSONTokener;->reader:Ljava/io/Reader;

    invoke-virtual {v0}, Ljava/io/Reader;->read()I

    move-result v0

    if-gtz v0, :cond_1

    .line 151
    iput-boolean v1, p0, Lorg/json/JSONTokener;->eof:Z

    .line 152
    const/4 v0, 0x0

    return v0

    .line 154
    :cond_1
    iget-object v0, p0, Lorg/json/JSONTokener;->reader:Ljava/io/Reader;

    invoke-virtual {v0}, Ljava/io/Reader;->reset()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    .line 157
    nop

    .line 158
    return v1

    .line 155
    :catch_0
    move-exception v0

    .line 156
    .local v0, "e":Ljava/io/IOException;
    new-instance v1, Lorg/json/JSONException;

    const-string v2, "Unable to read the next character from the stream"

    invoke-direct {v1, v2, v0}, Lorg/json/JSONException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1

    .line 145
    .end local v0    # "e":Ljava/io/IOException;
    :catch_1
    move-exception v0

    .line 146
    .restart local v0    # "e":Ljava/io/IOException;
    new-instance v1, Lorg/json/JSONException;

    const-string v2, "Unable to preserve stream position"

    invoke-direct {v1, v2, v0}, Lorg/json/JSONException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method public next()C
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 170
    iget-boolean v0, p0, Lorg/json/JSONTokener;->usePrevious:Z

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    .line 171
    iput-boolean v1, p0, Lorg/json/JSONTokener;->usePrevious:Z

    .line 172
    iget-char v0, p0, Lorg/json/JSONTokener;->previous:C

    .local v0, "c":I
    goto :goto_0

    .line 175
    .end local v0    # "c":I
    :cond_0
    :try_start_0
    iget-object v0, p0, Lorg/json/JSONTokener;->reader:Ljava/io/Reader;

    invoke-virtual {v0}, Ljava/io/Reader;->read()I

    move-result v0
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 178
    .restart local v0    # "c":I
    nop

    .line 180
    :goto_0
    if-gtz v0, :cond_1

    .line 181
    const/4 v2, 0x1

    iput-boolean v2, p0, Lorg/json/JSONTokener;->eof:Z

    .line 182
    return v1

    .line 184
    :cond_1
    invoke-direct {p0, v0}, Lorg/json/JSONTokener;->incrementIndexes(I)V

    .line 185
    int-to-char v1, v0

    iput-char v1, p0, Lorg/json/JSONTokener;->previous:C

    .line 186
    return v1

    .line 176
    .end local v0    # "c":I
    :catch_0
    move-exception v0

    .line 177
    .local v0, "exception":Ljava/io/IOException;
    new-instance v1, Lorg/json/JSONException;

    invoke-direct {v1, v0}, Lorg/json/JSONException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public next(C)C
    .locals 3
    .param p1, "c"    # C
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 227
    invoke-virtual {p0}, Lorg/json/JSONTokener;->next()C

    move-result v0

    .line 228
    .local v0, "n":C
    if-eq v0, p1, :cond_1

    .line 229
    const-string v1, "Expected \'"

    if-lez v0, :cond_0

    .line 230
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\' and instead saw \'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lorg/json/JSONTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v1

    throw v1

    .line 233
    :cond_0
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\' and instead saw \'\'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lorg/json/JSONTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v1

    throw v1

    .line 235
    :cond_1
    return v0
.end method

.method public next(I)Ljava/lang/String;
    .locals 3
    .param p1, "n"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 249
    if-nez p1, :cond_0

    .line 250
    const-string v0, ""

    return-object v0

    .line 253
    :cond_0
    new-array v0, p1, [C

    .line 254
    .local v0, "chars":[C
    const/4 v1, 0x0

    .line 256
    .local v1, "pos":I
    :goto_0
    if-ge v1, p1, :cond_2

    .line 257
    invoke-virtual {p0}, Lorg/json/JSONTokener;->next()C

    move-result v2

    aput-char v2, v0, v1

    .line 258
    invoke-virtual {p0}, Lorg/json/JSONTokener;->end()Z

    move-result v2

    if-nez v2, :cond_1

    .line 261
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 259
    :cond_1
    const-string v2, "Substring bounds error"

    invoke-virtual {p0, v2}, Lorg/json/JSONTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v2

    throw v2

    .line 263
    :cond_2
    new-instance v2, Ljava/lang/String;

    invoke-direct {v2, v0}, Ljava/lang/String;-><init>([C)V

    return-object v2
.end method

.method public nextClean()C
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 274
    nop

    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONTokener;->next()C

    move-result v0

    .line 275
    .local v0, "c":C
    if-eqz v0, :cond_1

    const/16 v1, 0x20

    if-le v0, v1, :cond_0

    goto :goto_1

    .line 278
    .end local v0    # "c":C
    :cond_0
    goto :goto_0

    .line 276
    .restart local v0    # "c":C
    :cond_1
    :goto_1
    return v0
.end method

.method nextSimpleValue(C)Ljava/lang/Object;
    .locals 3
    .param p1, "c"    # C

    .line 427
    sparse-switch p1, :sswitch_data_0

    .line 442
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .local v0, "sb":Ljava/lang/StringBuilder;
    goto :goto_0

    .line 430
    .end local v0    # "sb":Ljava/lang/StringBuilder;
    :sswitch_0
    invoke-virtual {p0, p1}, Lorg/json/JSONTokener;->nextString(C)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 443
    .restart local v0    # "sb":Ljava/lang/StringBuilder;
    :goto_0
    const/16 v1, 0x20

    if-lt p1, v1, :cond_0

    const-string v1, ",:]}/\\\"[{;=#"

    invoke-virtual {v1, p1}, Ljava/lang/String;->indexOf(I)I

    move-result v1

    if-gez v1, :cond_0

    .line 444
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 445
    invoke-virtual {p0}, Lorg/json/JSONTokener;->next()C

    move-result p1

    goto :goto_0

    .line 447
    :cond_0
    iget-boolean v1, p0, Lorg/json/JSONTokener;->eof:Z

    if-nez v1, :cond_1

    .line 448
    invoke-virtual {p0}, Lorg/json/JSONTokener;->back()V

    .line 451
    :cond_1
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 452
    .local v1, "string":Ljava/lang/String;
    const-string v2, ""

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 455
    invoke-static {v1}, Lorg/json/JSONObject;->stringToValue(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    return-object v2

    .line 453
    :cond_2
    const-string v2, "Missing value"

    invoke-virtual {p0, v2}, Lorg/json/JSONTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v2

    throw v2

    nop

    :sswitch_data_0
    .sparse-switch
        0x22 -> :sswitch_0
        0x27 -> :sswitch_0
    .end sparse-switch
.end method

.method public nextString(C)Ljava/lang/String;
    .locals 5
    .param p1, "quote"    # C
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 295
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 297
    .local v0, "sb":Ljava/lang/StringBuilder;
    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONTokener;->next()C

    move-result v1

    .line 298
    .local v1, "c":C
    sparse-switch v1, :sswitch_data_0

    .line 339
    if-ne v1, p1, :cond_0

    .line 340
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 304
    :sswitch_0
    invoke-virtual {p0}, Lorg/json/JSONTokener;->next()C

    move-result v1

    .line 305
    const-string v2, "Illegal escape."

    sparse-switch v1, :sswitch_data_1

    .line 335
    invoke-virtual {p0, v2}, Lorg/json/JSONTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v2

    throw v2

    .line 323
    :sswitch_1
    const/4 v3, 0x4

    :try_start_0
    invoke-virtual {p0, v3}, Lorg/json/JSONTokener;->next(I)Ljava/lang/String;

    move-result-object v3

    const/16 v4, 0x10

    invoke-static {v3, v4}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;I)I

    move-result v3

    int-to-char v3, v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    .line 326
    goto :goto_0

    .line 324
    :catch_0
    move-exception v3

    .line 325
    .local v3, "e":Ljava/lang/NumberFormatException;
    invoke-virtual {p0, v2, v3}, Lorg/json/JSONTokener;->syntaxError(Ljava/lang/String;Ljava/lang/Throwable;)Lorg/json/JSONException;

    move-result-object v2

    throw v2

    .line 310
    .end local v3    # "e":Ljava/lang/NumberFormatException;
    :sswitch_2
    const/16 v2, 0x9

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 311
    goto :goto_0

    .line 319
    :sswitch_3
    const/16 v2, 0xd

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 320
    goto :goto_0

    .line 313
    :sswitch_4
    const/16 v2, 0xa

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 314
    goto :goto_0

    .line 316
    :sswitch_5
    const/16 v2, 0xc

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 317
    goto :goto_0

    .line 307
    :sswitch_6
    const/16 v2, 0x8

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 308
    goto :goto_0

    .line 332
    :sswitch_7
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 333
    goto :goto_0

    .line 302
    :sswitch_8
    const-string v2, "Unterminated string"

    invoke-virtual {p0, v2}, Lorg/json/JSONTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v2

    throw v2

    .line 342
    :cond_0
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_0

    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_8
        0xa -> :sswitch_8
        0xd -> :sswitch_8
        0x5c -> :sswitch_0
    .end sparse-switch

    :sswitch_data_1
    .sparse-switch
        0x22 -> :sswitch_7
        0x27 -> :sswitch_7
        0x2f -> :sswitch_7
        0x5c -> :sswitch_7
        0x62 -> :sswitch_6
        0x66 -> :sswitch_5
        0x6e -> :sswitch_4
        0x72 -> :sswitch_3
        0x74 -> :sswitch_2
        0x75 -> :sswitch_1
    .end sparse-switch
.end method

.method public nextTo(C)Ljava/lang/String;
    .locals 3
    .param p1, "delimiter"    # C
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 357
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 359
    .local v0, "sb":Ljava/lang/StringBuilder;
    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONTokener;->next()C

    move-result v1

    .line 360
    .local v1, "c":C
    if-eq v1, p1, :cond_1

    if-eqz v1, :cond_1

    const/16 v2, 0xa

    if-eq v1, v2, :cond_1

    const/16 v2, 0xd

    if-ne v1, v2, :cond_0

    goto :goto_1

    .line 366
    :cond_0
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 367
    .end local v1    # "c":C
    goto :goto_0

    .line 361
    .restart local v1    # "c":C
    :cond_1
    :goto_1
    if-eqz v1, :cond_2

    .line 362
    invoke-virtual {p0}, Lorg/json/JSONTokener;->back()V

    .line 364
    :cond_2
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method public nextTo(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "delimiters"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 381
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 383
    .local v0, "sb":Ljava/lang/StringBuilder;
    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONTokener;->next()C

    move-result v1

    .line 384
    .local v1, "c":C
    invoke-virtual {p1, v1}, Ljava/lang/String;->indexOf(I)I

    move-result v2

    if-gez v2, :cond_1

    if-eqz v1, :cond_1

    const/16 v2, 0xa

    if-eq v1, v2, :cond_1

    const/16 v2, 0xd

    if-ne v1, v2, :cond_0

    goto :goto_1

    .line 391
    :cond_0
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 386
    :cond_1
    :goto_1
    if-eqz v1, :cond_2

    .line 387
    invoke-virtual {p0}, Lorg/json/JSONTokener;->back()V

    .line 389
    :cond_2
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method public nextValue()Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 404
    invoke-virtual {p0}, Lorg/json/JSONTokener;->nextClean()C

    move-result v0

    .line 405
    .local v0, "c":C
    const-string v1, "JSON Array or Object depth too large to process."

    sparse-switch v0, :sswitch_data_0

    .line 421
    invoke-virtual {p0, v0}, Lorg/json/JSONTokener;->nextSimpleValue(C)Ljava/lang/Object;

    move-result-object v1

    return-object v1

    .line 407
    :sswitch_0
    invoke-virtual {p0}, Lorg/json/JSONTokener;->back()V

    .line 409
    :try_start_0
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2, p0}, Lorg/json/JSONObject;-><init>(Lorg/json/JSONTokener;)V
    :try_end_0
    .catch Ljava/lang/StackOverflowError; {:try_start_0 .. :try_end_0} :catch_0

    return-object v2

    .line 410
    :catch_0
    move-exception v2

    .line 411
    .local v2, "e":Ljava/lang/StackOverflowError;
    new-instance v3, Lorg/json/JSONException;

    invoke-direct {v3, v1, v2}, Lorg/json/JSONException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v3

    .line 414
    .end local v2    # "e":Ljava/lang/StackOverflowError;
    :sswitch_1
    invoke-virtual {p0}, Lorg/json/JSONTokener;->back()V

    .line 416
    :try_start_1
    new-instance v2, Lorg/json/JSONArray;

    invoke-direct {v2, p0}, Lorg/json/JSONArray;-><init>(Lorg/json/JSONTokener;)V
    :try_end_1
    .catch Ljava/lang/StackOverflowError; {:try_start_1 .. :try_end_1} :catch_1

    return-object v2

    .line 417
    :catch_1
    move-exception v2

    .line 418
    .restart local v2    # "e":Ljava/lang/StackOverflowError;
    new-instance v3, Lorg/json/JSONException;

    invoke-direct {v3, v1, v2}, Lorg/json/JSONException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v3

    :sswitch_data_0
    .sparse-switch
        0x5b -> :sswitch_1
        0x7b -> :sswitch_0
    .end sparse-switch
.end method

.method public skipTo(C)C
    .locals 9
    .param p1, "to"    # C
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 471
    :try_start_0
    iget-wide v0, p0, Lorg/json/JSONTokener;->index:J

    .line 472
    .local v0, "startIndex":J
    iget-wide v2, p0, Lorg/json/JSONTokener;->character:J

    .line 473
    .local v2, "startCharacter":J
    iget-wide v4, p0, Lorg/json/JSONTokener;->line:J

    .line 474
    .local v4, "startLine":J
    iget-object v6, p0, Lorg/json/JSONTokener;->reader:Ljava/io/Reader;

    const v7, 0xf4240

    invoke-virtual {v6, v7}, Ljava/io/Reader;->mark(I)V

    .line 476
    :cond_0
    invoke-virtual {p0}, Lorg/json/JSONTokener;->next()C

    move-result v6

    .line 477
    .local v6, "c":C
    if-nez v6, :cond_1

    .line 481
    iget-object v7, p0, Lorg/json/JSONTokener;->reader:Ljava/io/Reader;

    invoke-virtual {v7}, Ljava/io/Reader;->reset()V

    .line 482
    iput-wide v0, p0, Lorg/json/JSONTokener;->index:J

    .line 483
    iput-wide v2, p0, Lorg/json/JSONTokener;->character:J

    .line 484
    iput-wide v4, p0, Lorg/json/JSONTokener;->line:J

    .line 485
    const/4 v7, 0x0

    return v7

    .line 487
    :cond_1
    if-ne v6, p1, :cond_0

    .line 488
    iget-object v7, p0, Lorg/json/JSONTokener;->reader:Ljava/io/Reader;

    const/4 v8, 0x1

    invoke-virtual {v7, v8}, Ljava/io/Reader;->mark(I)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 491
    .end local v0    # "startIndex":J
    .end local v2    # "startCharacter":J
    .end local v4    # "startLine":J
    nop

    .line 492
    invoke-virtual {p0}, Lorg/json/JSONTokener;->back()V

    .line 493
    return v6

    .line 489
    .end local v6    # "c":C
    :catch_0
    move-exception v0

    .line 490
    .local v0, "exception":Ljava/io/IOException;
    new-instance v1, Lorg/json/JSONException;

    invoke-direct {v1, v0}, Lorg/json/JSONException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public syntaxError(Ljava/lang/String;)Lorg/json/JSONException;
    .locals 3
    .param p1, "message"    # Ljava/lang/String;

    .line 503
    new-instance v0, Lorg/json/JSONException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lorg/json/JSONTokener;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lorg/json/JSONException;-><init>(Ljava/lang/String;)V

    return-object v0
.end method

.method public syntaxError(Ljava/lang/String;Ljava/lang/Throwable;)Lorg/json/JSONException;
    .locals 3
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "causedBy"    # Ljava/lang/Throwable;

    .line 514
    new-instance v0, Lorg/json/JSONException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lorg/json/JSONTokener;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1, p2}, Lorg/json/JSONException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .line 524
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, " at "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v1, p0, Lorg/json/JSONTokener;->index:J

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " [character "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v1, p0, Lorg/json/JSONTokener;->character:J

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " line "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v1, p0, Lorg/json/JSONTokener;->line:J

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
