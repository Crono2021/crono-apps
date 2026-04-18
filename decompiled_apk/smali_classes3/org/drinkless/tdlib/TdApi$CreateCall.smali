.class public Lorg/drinkless/tdlib/TdApi$CreateCall;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CreateCall"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$CallId;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x41d7d1f0


# instance fields
.field public isVideo:Z

.field public protocol:Lorg/drinkless/tdlib/TdApi$CallProtocol;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36388
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 36389
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$CallProtocol;Z)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "callProtocol"    # Lorg/drinkless/tdlib/TdApi$CallProtocol;
    .param p4, "z8"    # Z

    .line 36377
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 36378
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$CreateCall;->userId:J

    .line 36379
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$CreateCall;->protocol:Lorg/drinkless/tdlib/TdApi$CallProtocol;

    .line 36380
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$CreateCall;->isVideo:Z

    .line 36381
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36385
    const v0, -0x41d7d1f0

    return v0
.end method
