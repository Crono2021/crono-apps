.class public Lorg/drinkless/tdlib/TdApi$JoinGroupCall;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "JoinGroupCall"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$GroupCallInfo;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x78c386ad


# instance fields
.field public inputGroupCall:Lorg/drinkless/tdlib/TdApi$InputGroupCall;

.field public joinParameters:Lorg/drinkless/tdlib/TdApi$GroupCallJoinParameters;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27864
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 27865
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputGroupCall;Lorg/drinkless/tdlib/TdApi$GroupCallJoinParameters;)V
    .locals 0
    .param p1, "inputGroupCall"    # Lorg/drinkless/tdlib/TdApi$InputGroupCall;
    .param p2, "groupCallJoinParameters"    # Lorg/drinkless/tdlib/TdApi$GroupCallJoinParameters;

    .line 27854
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 27855
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$JoinGroupCall;->inputGroupCall:Lorg/drinkless/tdlib/TdApi$InputGroupCall;

    .line 27856
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$JoinGroupCall;->joinParameters:Lorg/drinkless/tdlib/TdApi$GroupCallJoinParameters;

    .line 27857
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27861
    const v0, -0x78c386ad

    return v0
.end method
