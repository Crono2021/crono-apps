.class public Lorg/drinkless/tdlib/TdApi$ToggleSessionCanAcceptCalls;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleSessionCanAcceptCalls"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6c6c2708


# instance fields
.field public canAcceptCalls:Z

.field public sessionId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33348
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33349
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 33338
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33339
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleSessionCanAcceptCalls;->sessionId:J

    .line 33340
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$ToggleSessionCanAcceptCalls;->canAcceptCalls:Z

    .line 33341
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33345
    const v0, 0x6c6c2708

    return v0
.end method
