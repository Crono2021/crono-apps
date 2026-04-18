.class public Lorg/drinkless/tdlib/TdApi$GetChatBoostLink;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetChatBoostLink"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ChatBoostLink;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x56f16c85


# instance fields
.field public chatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 12336
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12337
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 12327
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12328
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetChatBoostLink;->chatId:J

    .line 12329
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 12333
    const v0, 0x56f16c85

    return v0
.end method
