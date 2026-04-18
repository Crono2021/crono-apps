.class public Lorg/drinkless/tdlib/TdApi$RecognizeSpeech;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RecognizeSpeech"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x67d402b9


# instance fields
.field public chatId:J

.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29808
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 29809
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 29798
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 29799
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$RecognizeSpeech;->chatId:J

    .line 29800
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$RecognizeSpeech;->messageId:J

    .line 29801
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29805
    const v0, 0x67d402b9

    return v0
.end method
