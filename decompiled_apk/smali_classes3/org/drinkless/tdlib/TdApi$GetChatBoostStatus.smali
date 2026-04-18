.class public Lorg/drinkless/tdlib/TdApi$GetChatBoostStatus;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetChatBoostStatus"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ChatBoostStatus;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x30537531


# instance fields
.field public chatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 12372
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12373
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 12363
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12364
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetChatBoostStatus;->chatId:J

    .line 12365
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 12369
    const v0, -0x30537531

    return v0
.end method
