.class public Lorg/json/HTTPTokener;
.super Lorg/json/JSONTokener;
.source "HTTPTokener.java"


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "string"    # Ljava/lang/String;

    .line 20
    invoke-direct {p0, p1}, Lorg/json/JSONTokener;-><init>(Ljava/lang/String;)V

    .line 21
    return-void
.end method


# virtual methods
.method public nextToken()Ljava/lang/String;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .line 32
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 34
    .local v0, "sb":Ljava/lang/StringBuilder;
    :cond_0
    invoke-virtual {p0}, Lorg/json/HTTPTokener;->next()C

    move-result v1

    .line 35
    .local v1, "c":C
    invoke-static {v1}, Ljava/lang/Character;->isWhitespace(C)Z

    move-result v2

    if-nez v2, :cond_0

    .line 36
    const/16 v2, 0x22

    if-eq v1, v2, :cond_4

    const/16 v2, 0x27

    if-ne v1, v2, :cond_1

    goto :goto_2

    .line 50
    :cond_1
    :goto_0
    if-eqz v1, :cond_3

    invoke-static {v1}, Ljava/lang/Character;->isWhitespace(C)Z

    move-result v2

    if-eqz v2, :cond_2

    goto :goto_1

    .line 53
    :cond_2
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 54
    invoke-virtual {p0}, Lorg/json/HTTPTokener;->next()C

    move-result v1

    goto :goto_0

    .line 51
    :cond_3
    :goto_1
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 37
    :cond_4
    :goto_2
    move v2, v1

    .line 39
    .local v2, "q":C
    :goto_3
    invoke-virtual {p0}, Lorg/json/HTTPTokener;->next()C

    move-result v1

    .line 40
    const/16 v3, 0x20

    if-lt v1, v3, :cond_6

    .line 43
    if-ne v1, v2, :cond_5

    .line 44
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 46
    :cond_5
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_3

    .line 41
    :cond_6
    const-string v3, "Unterminated string."

    invoke-virtual {p0, v3}, Lorg/json/HTTPTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v3

    throw v3
.end method
