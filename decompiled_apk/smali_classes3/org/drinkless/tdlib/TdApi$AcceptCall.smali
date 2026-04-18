.class public Lorg/drinkless/tdlib/TdApi$AcceptCall;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AcceptCall"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x268a9d30


# instance fields
.field public callId:I

.field public protocol:Lorg/drinkless/tdlib/TdApi$CallProtocol;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22684
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 22685
    return-void
.end method

.method public constructor <init>(ILorg/drinkless/tdlib/TdApi$CallProtocol;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "callProtocol"    # Lorg/drinkless/tdlib/TdApi$CallProtocol;

    .line 22674
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 22675
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$AcceptCall;->callId:I

    .line 22676
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$AcceptCall;->protocol:Lorg/drinkless/tdlib/TdApi$CallProtocol;

    .line 22677
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22681
    const v0, -0x268a9d30

    return v0
.end method
