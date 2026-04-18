.class public Lorg/drinkless/tdlib/TdApi$SendCallSignalingData;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SendCallSignalingData"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x542db19c


# instance fields
.field public callId:I

.field public data:[B


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30828
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30829
    return-void
.end method

.method public constructor <init>(I[B)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "bArr"    # [B

    .line 30818
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30819
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$SendCallSignalingData;->callId:I

    .line 30820
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SendCallSignalingData;->data:[B

    .line 30821
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30825
    const v0, 0x542db19c

    return v0
.end method
