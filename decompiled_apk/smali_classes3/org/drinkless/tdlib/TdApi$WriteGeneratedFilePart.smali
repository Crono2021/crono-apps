.class public Lorg/drinkless/tdlib/TdApi$WriteGeneratedFilePart;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "WriteGeneratedFilePart"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0xcc89e95


# instance fields
.field public data:[B

.field public generationId:J

.field public offset:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42198
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 42199
    return-void
.end method

.method public constructor <init>(JJ[B)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "bArr"    # [B

    .line 42187
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 42188
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$WriteGeneratedFilePart;->generationId:J

    .line 42189
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$WriteGeneratedFilePart;->offset:J

    .line 42190
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$WriteGeneratedFilePart;->data:[B

    .line 42191
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42195
    const v0, 0xcc89e95

    return v0
.end method
