.class public Lorg/drinkless/tdlib/TdApi$UpdateNewCallSignalingData;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateNewCallSignalingData"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x22c98d8d


# instance fields
.field public callId:I

.field public data:[B


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34708
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34709
    return-void
.end method

.method public constructor <init>(I[B)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "bArr"    # [B

    .line 34698
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34699
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewCallSignalingData;->callId:I

    .line 34700
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewCallSignalingData;->data:[B

    .line 34701
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34705
    const v0, 0x22c98d8d

    return v0
.end method
