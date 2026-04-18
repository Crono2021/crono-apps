.class public Lorg/drinkless/tdlib/TdApi$SetFileGenerationProgress;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetFileGenerationProgress"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6d754b3e


# instance fields
.field public expectedSize:J

.field public generationId:J

.field public localPrefixSize:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40350
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40351
    return-void
.end method

.method public constructor <init>(JJJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "j10"    # J

    .line 40339
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40340
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetFileGenerationProgress;->generationId:J

    .line 40341
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$SetFileGenerationProgress;->expectedSize:J

    .line 40342
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$SetFileGenerationProgress;->localPrefixSize:J

    .line 40343
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40347
    const v0, 0x6d754b3e

    return v0
.end method
