.class public final Landroidx/media3/extractor/mp4/PsshAtomUtil;
.super Ljava/lang/Object;
.source "PsshAtomUtil.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/extractor/mp4/PsshAtomUtil$PsshAtom;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String; = "PsshAtomUtil"


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static buildPsshAtom(Ljava/util/UUID;[B)[B
    .locals 1
    .param p0, "systemId"    # Ljava/util/UUID;
    .param p1, "data"    # [B

    .line 41
    const/4 v0, 0x0

    invoke-static {p0, v0, p1}, Landroidx/media3/extractor/mp4/PsshAtomUtil;->buildPsshAtom(Ljava/util/UUID;[Ljava/util/UUID;[B)[B

    move-result-object v0

    return-object v0
.end method

.method public static buildPsshAtom(Ljava/util/UUID;[Ljava/util/UUID;[B)[B
    .locals 9
    .param p0, "systemId"    # Ljava/util/UUID;
    .param p1, "keyIds"    # [Ljava/util/UUID;
    .param p2, "data"    # [B

    .line 54
    const/4 v0, 0x0

    if-eqz p2, :cond_0

    array-length v1, p2

    goto :goto_0

    :cond_0
    move v1, v0

    .line 55
    .local v1, "dataLength":I
    :goto_0
    add-int/lit8 v2, v1, 0x20

    .line 56
    .local v2, "psshBoxLength":I
    if-eqz p1, :cond_1

    .line 57
    array-length v3, p1

    mul-int/lit8 v3, v3, 0x10

    add-int/lit8 v3, v3, 0x4

    add-int/2addr v2, v3

    .line 59
    :cond_1
    invoke-static {v2}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v3

    .line 60
    .local v3, "psshBox":Ljava/nio/ByteBuffer;
    invoke-virtual {v3, v2}, Ljava/nio/ByteBuffer;->putInt(I)Ljava/nio/ByteBuffer;

    .line 61
    const v4, 0x70737368    # 3.013775E29f

    invoke-virtual {v3, v4}, Ljava/nio/ByteBuffer;->putInt(I)Ljava/nio/ByteBuffer;

    .line 62
    if-eqz p1, :cond_2

    const/high16 v4, 0x1000000

    goto :goto_1

    :cond_2
    move v4, v0

    :goto_1
    invoke-virtual {v3, v4}, Ljava/nio/ByteBuffer;->putInt(I)Ljava/nio/ByteBuffer;

    .line 63
    invoke-virtual {p0}, Ljava/util/UUID;->getMostSignificantBits()J

    move-result-wide v4

    invoke-virtual {v3, v4, v5}, Ljava/nio/ByteBuffer;->putLong(J)Ljava/nio/ByteBuffer;

    .line 64
    invoke-virtual {p0}, Ljava/util/UUID;->getLeastSignificantBits()J

    move-result-wide v4

    invoke-virtual {v3, v4, v5}, Ljava/nio/ByteBuffer;->putLong(J)Ljava/nio/ByteBuffer;

    .line 65
    if-eqz p1, :cond_3

    .line 66
    array-length v4, p1

    invoke-virtual {v3, v4}, Ljava/nio/ByteBuffer;->putInt(I)Ljava/nio/ByteBuffer;

    .line 67
    array-length v4, p1

    move v5, v0

    :goto_2
    if-ge v5, v4, :cond_3

    aget-object v6, p1, v5

    .line 68
    .local v6, "keyId":Ljava/util/UUID;
    invoke-virtual {v6}, Ljava/util/UUID;->getMostSignificantBits()J

    move-result-wide v7

    invoke-virtual {v3, v7, v8}, Ljava/nio/ByteBuffer;->putLong(J)Ljava/nio/ByteBuffer;

    .line 69
    invoke-virtual {v6}, Ljava/util/UUID;->getLeastSignificantBits()J

    move-result-wide v7

    invoke-virtual {v3, v7, v8}, Ljava/nio/ByteBuffer;->putLong(J)Ljava/nio/ByteBuffer;

    .line 67
    .end local v6    # "keyId":Ljava/util/UUID;
    add-int/lit8 v5, v5, 0x1

    goto :goto_2

    .line 72
    :cond_3
    if-eqz p2, :cond_4

    array-length v4, p2

    if-eqz v4, :cond_4

    .line 73
    array-length v0, p2

    invoke-virtual {v3, v0}, Ljava/nio/ByteBuffer;->putInt(I)Ljava/nio/ByteBuffer;

    .line 74
    invoke-virtual {v3, p2}, Ljava/nio/ByteBuffer;->put([B)Ljava/nio/ByteBuffer;

    goto :goto_3

    .line 76
    :cond_4
    invoke-virtual {v3, v0}, Ljava/nio/ByteBuffer;->putInt(I)Ljava/nio/ByteBuffer;

    .line 78
    :goto_3
    invoke-virtual {v3}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v0

    return-object v0
.end method

.method public static isPsshAtom([B)Z
    .locals 1
    .param p0, "data"    # [B

    .line 88
    invoke-static {p0}, Landroidx/media3/extractor/mp4/PsshAtomUtil;->parsePsshAtom([B)Landroidx/media3/extractor/mp4/PsshAtomUtil$PsshAtom;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public static parsePsshAtom([B)Landroidx/media3/extractor/mp4/PsshAtomUtil$PsshAtom;
    .locals 17
    .param p0, "atom"    # [B

    .line 159
    new-instance v0, Landroidx/media3/common/util/ParsableByteArray;

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Landroidx/media3/common/util/ParsableByteArray;-><init>([B)V

    .line 160
    .local v0, "atomData":Landroidx/media3/common/util/ParsableByteArray;
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->limit()I

    move-result v2

    const/16 v3, 0x20

    const/4 v4, 0x0

    if-ge v2, v3, :cond_0

    .line 162
    return-object v4

    .line 164
    :cond_0
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 165
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->bytesLeft()I

    move-result v3

    .line 166
    .local v3, "bufferLength":I
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v5

    .line 167
    .local v5, "atomSize":I
    const-string v6, "PsshAtomUtil"

    if-eq v5, v3, :cond_1

    .line 168
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Advertised atom size ("

    invoke-virtual {v2, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v7, ") does not match buffer size: "

    invoke-virtual {v2, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v6, v2}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 171
    return-object v4

    .line 173
    :cond_1
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v7

    .line 174
    .local v7, "atomType":I
    const v8, 0x70737368    # 3.013775E29f

    if-eq v7, v8, :cond_2

    .line 175
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Atom type is not pssh: "

    invoke-virtual {v2, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v6, v2}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 176
    return-object v4

    .line 178
    :cond_2
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v8

    invoke-static {v8}, Landroidx/media3/extractor/mp4/Atom;->parseFullAtomVersion(I)I

    move-result v8

    .line 179
    .local v8, "atomVersion":I
    const/4 v9, 0x1

    if-le v8, v9, :cond_3

    .line 180
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Unsupported pssh version: "

    invoke-virtual {v2, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v6, v2}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 181
    return-object v4

    .line 183
    :cond_3
    new-instance v10, Ljava/util/UUID;

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readLong()J

    move-result-wide v11

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readLong()J

    move-result-wide v13

    invoke-direct {v10, v11, v12, v13, v14}, Ljava/util/UUID;-><init>(JJ)V

    .line 184
    .local v10, "uuid":Ljava/util/UUID;
    const/4 v11, 0x0

    .line 185
    .local v11, "keyIds":[Ljava/util/UUID;
    if-ne v8, v9, :cond_5

    .line 186
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedIntToInt()I

    move-result v9

    .line 187
    .local v9, "keyIdCount":I
    new-array v11, v9, [Ljava/util/UUID;

    .line 188
    const/4 v12, 0x0

    .local v12, "i":I
    :goto_0
    if-ge v12, v9, :cond_4

    .line 189
    new-instance v13, Ljava/util/UUID;

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readLong()J

    move-result-wide v14

    move/from16 v16, v3

    .end local v3    # "bufferLength":I
    .local v16, "bufferLength":I
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readLong()J

    move-result-wide v2

    invoke-direct {v13, v14, v15, v2, v3}, Ljava/util/UUID;-><init>(JJ)V

    aput-object v13, v11, v12

    .line 188
    add-int/lit8 v12, v12, 0x1

    move/from16 v3, v16

    const/4 v2, 0x0

    goto :goto_0

    .end local v16    # "bufferLength":I
    .restart local v3    # "bufferLength":I
    :cond_4
    move/from16 v16, v3

    .end local v3    # "bufferLength":I
    .restart local v16    # "bufferLength":I
    goto :goto_1

    .line 185
    .end local v9    # "keyIdCount":I
    .end local v12    # "i":I
    .end local v16    # "bufferLength":I
    .restart local v3    # "bufferLength":I
    :cond_5
    move/from16 v16, v3

    .line 192
    .end local v3    # "bufferLength":I
    .restart local v16    # "bufferLength":I
    :goto_1
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedIntToInt()I

    move-result v2

    .line 193
    .local v2, "dataSize":I
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->bytesLeft()I

    move-result v3

    .line 194
    .end local v16    # "bufferLength":I
    .restart local v3    # "bufferLength":I
    if-eq v2, v3, :cond_6

    .line 195
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "Atom data size ("

    invoke-virtual {v9, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v12, ") does not match the bytes left: "

    invoke-virtual {v9, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v6, v9}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 197
    return-object v4

    .line 199
    :cond_6
    new-array v4, v2, [B

    .line 200
    .local v4, "data":[B
    const/4 v6, 0x0

    invoke-virtual {v0, v4, v6, v2}, Landroidx/media3/common/util/ParsableByteArray;->readBytes([BII)V

    .line 201
    new-instance v6, Landroidx/media3/extractor/mp4/PsshAtomUtil$PsshAtom;

    invoke-direct {v6, v10, v8, v4, v11}, Landroidx/media3/extractor/mp4/PsshAtomUtil$PsshAtom;-><init>(Ljava/util/UUID;I[B[Ljava/util/UUID;)V

    return-object v6
.end method

.method public static parseSchemeSpecificData([BLjava/util/UUID;)[B
    .locals 4
    .param p0, "atom"    # [B
    .param p1, "uuid"    # Ljava/util/UUID;

    .line 139
    invoke-static {p0}, Landroidx/media3/extractor/mp4/PsshAtomUtil;->parsePsshAtom([B)Landroidx/media3/extractor/mp4/PsshAtomUtil$PsshAtom;

    move-result-object v0

    .line 140
    .local v0, "parsedAtom":Landroidx/media3/extractor/mp4/PsshAtomUtil$PsshAtom;
    const/4 v1, 0x0

    if-nez v0, :cond_0

    .line 141
    return-object v1

    .line 143
    :cond_0
    iget-object v2, v0, Landroidx/media3/extractor/mp4/PsshAtomUtil$PsshAtom;->uuid:Ljava/util/UUID;

    invoke-virtual {p1, v2}, Ljava/util/UUID;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 144
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "UUID mismatch. Expected: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", got: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, v0, Landroidx/media3/extractor/mp4/PsshAtomUtil$PsshAtom;->uuid:Ljava/util/UUID;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "PsshAtomUtil"

    invoke-static {v3, v2}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 145
    return-object v1

    .line 147
    :cond_1
    iget-object v1, v0, Landroidx/media3/extractor/mp4/PsshAtomUtil$PsshAtom;->schemeData:[B

    return-object v1
.end method

.method public static parseUuid([B)Ljava/util/UUID;
    .locals 2
    .param p0, "atom"    # [B

    .line 102
    invoke-static {p0}, Landroidx/media3/extractor/mp4/PsshAtomUtil;->parsePsshAtom([B)Landroidx/media3/extractor/mp4/PsshAtomUtil$PsshAtom;

    move-result-object v0

    .line 103
    .local v0, "parsedAtom":Landroidx/media3/extractor/mp4/PsshAtomUtil$PsshAtom;
    if-nez v0, :cond_0

    .line 104
    const/4 v1, 0x0

    return-object v1

    .line 106
    :cond_0
    iget-object v1, v0, Landroidx/media3/extractor/mp4/PsshAtomUtil$PsshAtom;->uuid:Ljava/util/UUID;

    return-object v1
.end method

.method public static parseVersion([B)I
    .locals 2
    .param p0, "atom"    # [B

    .line 119
    invoke-static {p0}, Landroidx/media3/extractor/mp4/PsshAtomUtil;->parsePsshAtom([B)Landroidx/media3/extractor/mp4/PsshAtomUtil$PsshAtom;

    move-result-object v0

    .line 120
    .local v0, "parsedAtom":Landroidx/media3/extractor/mp4/PsshAtomUtil$PsshAtom;
    if-nez v0, :cond_0

    .line 121
    const/4 v1, -0x1

    return v1

    .line 123
    :cond_0
    iget v1, v0, Landroidx/media3/extractor/mp4/PsshAtomUtil$PsshAtom;->version:I

    return v1
.end method
