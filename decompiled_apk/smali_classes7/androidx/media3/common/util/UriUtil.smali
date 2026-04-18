.class public final Landroidx/media3/common/util/UriUtil;
.super Ljava/lang/Object;
.source "UriUtil.java"


# static fields
.field private static final FRAGMENT:I = 0x3

.field private static final INDEX_COUNT:I = 0x4

.field private static final PATH:I = 0x1

.field private static final QUERY:I = 0x2

.field private static final SCHEME_COLON:I


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 70
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getRelativePath(Landroid/net/Uri;Landroid/net/Uri;)Ljava/lang/String;
    .locals 11
    .param p0, "baseUri"    # Landroid/net/Uri;
    .param p1, "targetUri"    # Landroid/net/Uri;

    .line 299
    invoke-virtual {p0}, Landroid/net/Uri;->isOpaque()Z

    move-result v0

    if-nez v0, :cond_a

    invoke-virtual {p1}, Landroid/net/Uri;->isOpaque()Z

    move-result v0

    if-eqz v0, :cond_0

    goto/16 :goto_6

    .line 303
    :cond_0
    invoke-virtual {p0}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v0

    .line 304
    .local v0, "baseUriScheme":Ljava/lang/String;
    invoke-virtual {p1}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v1

    .line 306
    .local v1, "targetUriScheme":Ljava/lang/String;
    const/4 v2, 0x0

    const/4 v3, 0x1

    if-nez v0, :cond_1

    .line 307
    if-nez v1, :cond_2

    move v2, v3

    goto :goto_0

    .line 308
    :cond_1
    if-eqz v1, :cond_2

    invoke-static {v0, v1}, Lcom/google/common/base/Ascii;->equalsIgnoreCase(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_2

    move v2, v3

    :cond_2
    :goto_0
    nop

    .line 309
    .local v2, "isSameScheme":Z
    if-eqz v2, :cond_9

    invoke-virtual {p0}, Landroid/net/Uri;->getAuthority()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1}, Landroid/net/Uri;->getAuthority()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroidx/media3/common/util/Util;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_3

    goto :goto_5

    .line 314
    :cond_3
    invoke-virtual {p0}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v4

    .line 315
    .local v4, "basePathSegments":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v5

    .line 317
    .local v5, "targetPathSegments":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v6, 0x0

    .line 318
    .local v6, "commonPrefixCount":I
    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v7

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v8

    invoke-static {v7, v8}, Ljava/lang/Math;->min(II)I

    move-result v7

    .line 320
    .local v7, "minSize":I
    const/4 v8, 0x0

    .local v8, "i":I
    :goto_1
    if-ge v8, v7, :cond_5

    .line 321
    invoke-interface {v4, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/String;

    invoke-interface {v5, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_4

    .line 322
    goto :goto_2

    .line 324
    :cond_4
    add-int/lit8 v6, v6, 0x1

    .line 320
    add-int/lit8 v8, v8, 0x1

    goto :goto_1

    .line 327
    .end local v8    # "i":I
    :cond_5
    :goto_2
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    .line 328
    .local v8, "relativePath":Ljava/lang/StringBuilder;
    move v9, v6

    .local v9, "i":I
    :goto_3
    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v10

    if-ge v9, v10, :cond_6

    .line 329
    const-string v10, "../"

    invoke-virtual {v8, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 328
    add-int/lit8 v9, v9, 0x1

    goto :goto_3

    .line 332
    .end local v9    # "i":I
    :cond_6
    move v9, v6

    .restart local v9    # "i":I
    :goto_4
    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v10

    if-ge v9, v10, :cond_8

    .line 333
    invoke-interface {v5, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/lang/String;

    invoke-virtual {v8, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 334
    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v10

    sub-int/2addr v10, v3

    if-ge v9, v10, :cond_7

    .line 335
    const-string v10, "/"

    invoke-virtual {v8, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 332
    :cond_7
    add-int/lit8 v9, v9, 0x1

    goto :goto_4

    .line 339
    .end local v9    # "i":I
    :cond_8
    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 311
    .end local v4    # "basePathSegments":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v5    # "targetPathSegments":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v6    # "commonPrefixCount":I
    .end local v7    # "minSize":I
    .end local v8    # "relativePath":Ljava/lang/StringBuilder;
    :cond_9
    :goto_5
    invoke-virtual {p1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 300
    .end local v0    # "baseUriScheme":Ljava/lang/String;
    .end local v1    # "targetUriScheme":Ljava/lang/String;
    .end local v2    # "isSameScheme":Z
    :cond_a
    :goto_6
    invoke-virtual {p1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static getUriIndices(Ljava/lang/String;)[I
    .locals 12
    .param p0, "uriString"    # Ljava/lang/String;

    .line 238
    const/4 v0, 0x4

    new-array v0, v0, [I

    .line 239
    .local v0, "indices":[I
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    const/4 v2, 0x0

    const/4 v3, -0x1

    if-eqz v1, :cond_0

    .line 240
    aput v3, v0, v2

    .line 241
    return-object v0

    .line 246
    :cond_0
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v1

    .line 247
    .local v1, "length":I
    const/16 v4, 0x23

    invoke-virtual {p0, v4}, Ljava/lang/String;->indexOf(I)I

    move-result v4

    .line 248
    .local v4, "fragmentIndex":I
    if-ne v4, v3, :cond_1

    .line 249
    move v4, v1

    .line 251
    :cond_1
    const/16 v5, 0x3f

    invoke-virtual {p0, v5}, Ljava/lang/String;->indexOf(I)I

    move-result v5

    .line 252
    .local v5, "queryIndex":I
    if-eq v5, v3, :cond_2

    if-le v5, v4, :cond_3

    .line 254
    :cond_2
    move v5, v4

    .line 258
    :cond_3
    const/16 v6, 0x2f

    invoke-virtual {p0, v6}, Ljava/lang/String;->indexOf(I)I

    move-result v7

    .line 259
    .local v7, "schemeIndexLimit":I
    if-eq v7, v3, :cond_4

    if-le v7, v5, :cond_5

    .line 260
    :cond_4
    move v7, v5

    .line 262
    :cond_5
    const/16 v8, 0x3a

    invoke-virtual {p0, v8}, Ljava/lang/String;->indexOf(I)I

    move-result v8

    .line 263
    .local v8, "schemeIndex":I
    if-le v8, v7, :cond_6

    .line 265
    const/4 v8, -0x1

    .line 270
    :cond_6
    add-int/lit8 v9, v8, 0x2

    const/4 v10, 0x1

    if-ge v9, v5, :cond_7

    add-int/lit8 v9, v8, 0x1

    .line 272
    invoke-virtual {p0, v9}, Ljava/lang/String;->charAt(I)C

    move-result v9

    if-ne v9, v6, :cond_7

    add-int/lit8 v9, v8, 0x2

    .line 273
    invoke-virtual {p0, v9}, Ljava/lang/String;->charAt(I)C

    move-result v9

    if-ne v9, v6, :cond_7

    move v9, v10

    goto :goto_0

    :cond_7
    move v9, v2

    .line 275
    .local v9, "hasAuthority":Z
    :goto_0
    if-eqz v9, :cond_9

    .line 276
    add-int/lit8 v11, v8, 0x3

    invoke-virtual {p0, v6, v11}, Ljava/lang/String;->indexOf(II)I

    move-result v6

    .line 277
    .local v6, "pathIndex":I
    if-eq v6, v3, :cond_8

    if-le v6, v5, :cond_a

    .line 278
    :cond_8
    move v6, v5

    goto :goto_1

    .line 281
    .end local v6    # "pathIndex":I
    :cond_9
    add-int/lit8 v6, v8, 0x1

    .line 284
    .restart local v6    # "pathIndex":I
    :cond_a
    :goto_1
    aput v8, v0, v2

    .line 285
    aput v6, v0, v10

    .line 286
    const/4 v2, 0x2

    aput v5, v0, v2

    .line 287
    const/4 v2, 0x3

    aput v4, v0, v2

    .line 288
    return-object v0
.end method

.method public static isAbsolute(Ljava/lang/String;)Z
    .locals 3
    .param p0, "uri"    # Ljava/lang/String;

    .line 154
    const/4 v0, 0x0

    if-eqz p0, :cond_0

    invoke-static {p0}, Landroidx/media3/common/util/UriUtil;->getUriIndices(Ljava/lang/String;)[I

    move-result-object v1

    aget v1, v1, v0

    const/4 v2, -0x1

    if-eq v1, v2, :cond_0

    const/4 v0, 0x1

    :cond_0
    return v0
.end method

.method private static removeDotSegments(Ljava/lang/StringBuilder;II)Ljava/lang/String;
    .locals 7
    .param p0, "uri"    # Ljava/lang/StringBuilder;
    .param p1, "offset"    # I
    .param p2, "limit"    # I

    .line 185
    if-lt p1, p2, :cond_0

    .line 187
    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 189
    :cond_0
    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->charAt(I)C

    move-result v0

    const/16 v1, 0x2f

    if-ne v0, v1, :cond_1

    .line 191
    add-int/lit8 p1, p1, 0x1

    .line 194
    :cond_1
    move v0, p1

    .line 195
    .local v0, "segmentStart":I
    move v2, p1

    .line 196
    .local v2, "i":I
    :goto_0
    if-gt v2, p2, :cond_7

    .line 198
    if-ne v2, p2, :cond_2

    .line 199
    move v3, v2

    .local v3, "nextSegmentStart":I
    goto :goto_1

    .line 200
    .end local v3    # "nextSegmentStart":I
    :cond_2
    invoke-virtual {p0, v2}, Ljava/lang/StringBuilder;->charAt(I)C

    move-result v3

    if-ne v3, v1, :cond_6

    .line 201
    add-int/lit8 v3, v2, 0x1

    .line 208
    .restart local v3    # "nextSegmentStart":I
    :goto_1
    add-int/lit8 v4, v0, 0x1

    const/16 v5, 0x2e

    if-ne v2, v4, :cond_3

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->charAt(I)C

    move-result v4

    if-ne v4, v5, :cond_3

    .line 210
    invoke-virtual {p0, v0, v3}, Ljava/lang/StringBuilder;->delete(II)Ljava/lang/StringBuilder;

    .line 211
    sub-int v4, v3, v0

    sub-int/2addr p2, v4

    .line 212
    move v2, v0

    goto :goto_3

    .line 213
    :cond_3
    add-int/lit8 v4, v0, 0x2

    if-ne v2, v4, :cond_5

    .line 214
    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->charAt(I)C

    move-result v4

    if-ne v4, v5, :cond_5

    add-int/lit8 v4, v0, 0x1

    .line 215
    invoke-virtual {p0, v4}, Ljava/lang/StringBuilder;->charAt(I)C

    move-result v4

    if-ne v4, v5, :cond_5

    .line 217
    const-string v4, "/"

    add-int/lit8 v5, v0, -0x2

    invoke-virtual {p0, v4, v5}, Ljava/lang/StringBuilder;->lastIndexOf(Ljava/lang/String;I)I

    move-result v4

    add-int/lit8 v4, v4, 0x1

    .line 218
    .local v4, "prevSegmentStart":I
    if-le v4, p1, :cond_4

    move v5, v4

    goto :goto_2

    :cond_4
    move v5, p1

    .line 219
    .local v5, "removeFrom":I
    :goto_2
    invoke-virtual {p0, v5, v3}, Ljava/lang/StringBuilder;->delete(II)Ljava/lang/StringBuilder;

    .line 220
    sub-int v6, v3, v5

    sub-int/2addr p2, v6

    .line 221
    move v0, v4

    .line 222
    move v2, v4

    .line 223
    .end local v4    # "prevSegmentStart":I
    .end local v5    # "removeFrom":I
    goto :goto_3

    .line 224
    :cond_5
    add-int/lit8 v2, v2, 0x1

    .line 225
    move v0, v2

    .line 227
    .end local v3    # "nextSegmentStart":I
    :goto_3
    goto :goto_0

    .line 203
    :cond_6
    add-int/lit8 v2, v2, 0x1

    .line 204
    goto :goto_0

    .line 228
    :cond_7
    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public static removeQueryParameter(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    .locals 5
    .param p0, "uri"    # Landroid/net/Uri;
    .param p1, "queryParameterName"    # Ljava/lang/String;

    .line 165
    invoke-virtual {p0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    .line 166
    .local v0, "builder":Landroid/net/Uri$Builder;
    invoke-virtual {v0}, Landroid/net/Uri$Builder;->clearQuery()Landroid/net/Uri$Builder;

    .line 167
    invoke-virtual {p0}, Landroid/net/Uri;->getQueryParameterNames()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 168
    .local v2, "key":Ljava/lang/String;
    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 169
    invoke-virtual {p0, v2}, Landroid/net/Uri;->getQueryParameters(Ljava/lang/String;)Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 170
    .local v4, "value":Ljava/lang/String;
    invoke-virtual {v0, v2, v4}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 171
    .end local v4    # "value":Ljava/lang/String;
    goto :goto_1

    .line 173
    .end local v2    # "key":Ljava/lang/String;
    :cond_0
    goto :goto_0

    .line 174
    :cond_1
    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v1

    return-object v1
.end method

.method public static resolve(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 10
    .param p0, "baseUri"    # Ljava/lang/String;
    .param p1, "referenceUri"    # Ljava/lang/String;

    .line 91
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 94
    .local v0, "uri":Ljava/lang/StringBuilder;
    const-string v1, ""

    if-nez p0, :cond_0

    move-object v2, v1

    goto :goto_0

    :cond_0
    move-object v2, p0

    :goto_0
    move-object p0, v2

    .line 95
    if-nez p1, :cond_1

    goto :goto_1

    :cond_1
    move-object v1, p1

    :goto_1
    move-object p1, v1

    .line 97
    invoke-static {p1}, Landroidx/media3/common/util/UriUtil;->getUriIndices(Ljava/lang/String;)[I

    move-result-object v1

    .line 98
    .local v1, "refIndices":[I
    const/4 v2, 0x0

    aget v3, v1, v2

    const/4 v4, -0x1

    const/4 v5, 0x2

    const/4 v6, 0x1

    if-eq v3, v4, :cond_2

    .line 100
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 101
    aget v2, v1, v6

    aget v3, v1, v5

    invoke-static {v0, v2, v3}, Landroidx/media3/common/util/UriUtil;->removeDotSegments(Ljava/lang/StringBuilder;II)Ljava/lang/String;

    .line 102
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 105
    :cond_2
    invoke-static {p0}, Landroidx/media3/common/util/UriUtil;->getUriIndices(Ljava/lang/String;)[I

    move-result-object v3

    .line 106
    .local v3, "baseIndices":[I
    const/4 v7, 0x3

    aget v8, v1, v7

    if-nez v8, :cond_3

    .line 109
    aget v4, v3, v7

    invoke-virtual {v0, p0, v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;II)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 112
    :cond_3
    aget v7, v1, v5

    if-nez v7, :cond_4

    .line 115
    aget v4, v3, v5

    invoke-virtual {v0, p0, v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;II)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 118
    :cond_4
    aget v7, v1, v6

    if-eqz v7, :cond_5

    .line 120
    aget v4, v3, v2

    add-int/2addr v4, v6

    .line 121
    .local v4, "baseLimit":I
    invoke-virtual {v0, p0, v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;II)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 122
    aget v2, v1, v6

    add-int/2addr v2, v4

    aget v5, v1, v5

    add-int/2addr v5, v4

    invoke-static {v0, v2, v5}, Landroidx/media3/common/util/UriUtil;->removeDotSegments(Ljava/lang/StringBuilder;II)Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 125
    .end local v4    # "baseLimit":I
    :cond_5
    aget v7, v1, v6

    invoke-virtual {p1, v7}, Ljava/lang/String;->charAt(I)C

    move-result v7

    const/16 v8, 0x2f

    if-ne v7, v8, :cond_6

    .line 128
    aget v4, v3, v6

    invoke-virtual {v0, p0, v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;II)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 129
    aget v2, v3, v6

    aget v4, v3, v6

    aget v5, v1, v5

    add-int/2addr v4, v5

    invoke-static {v0, v2, v4}, Landroidx/media3/common/util/UriUtil;->removeDotSegments(Ljava/lang/StringBuilder;II)Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 134
    :cond_6
    aget v7, v3, v2

    add-int/2addr v7, v5

    aget v9, v3, v6

    if-ge v7, v9, :cond_7

    aget v7, v3, v6

    aget v9, v3, v5

    if-ne v7, v9, :cond_7

    .line 138
    aget v4, v3, v6

    invoke-virtual {v0, p0, v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;II)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v8}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 139
    aget v2, v3, v6

    aget v4, v3, v6

    aget v5, v1, v5

    add-int/2addr v4, v5

    add-int/2addr v4, v6

    invoke-static {v0, v2, v4}, Landroidx/media3/common/util/UriUtil;->removeDotSegments(Ljava/lang/StringBuilder;II)Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 145
    :cond_7
    aget v7, v3, v5

    sub-int/2addr v7, v6

    invoke-virtual {p0, v8, v7}, Ljava/lang/String;->lastIndexOf(II)I

    move-result v7

    .line 146
    .local v7, "lastSlashIndex":I
    if-ne v7, v4, :cond_8

    aget v4, v3, v6

    goto :goto_2

    :cond_8
    add-int/lit8 v4, v7, 0x1

    .line 147
    .restart local v4    # "baseLimit":I
    :goto_2
    invoke-virtual {v0, p0, v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;II)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 148
    aget v2, v3, v6

    aget v5, v1, v5

    add-int/2addr v5, v4

    invoke-static {v0, v2, v5}, Landroidx/media3/common/util/UriUtil;->removeDotSegments(Ljava/lang/StringBuilder;II)Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method public static resolveToUri(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;
    .locals 1
    .param p0, "baseUri"    # Ljava/lang/String;
    .param p1, "referenceUri"    # Ljava/lang/String;

    .line 79
    invoke-static {p0, p1}, Landroidx/media3/common/util/UriUtil;->resolve(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method
