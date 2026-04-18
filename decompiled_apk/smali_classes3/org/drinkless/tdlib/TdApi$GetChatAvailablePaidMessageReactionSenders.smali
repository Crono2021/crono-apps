.class public Lorg/drinkless/tdlib/TdApi$GetChatAvailablePaidMessageReactionSenders;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetChatAvailablePaidMessageReactionSenders"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$MessageSenders;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4a2f6377


# instance fields
.field public chatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 12300
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12301
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 12291
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12292
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetChatAvailablePaidMessageReactionSenders;->chatId:J

    .line 12293
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 12297
    const v0, -0x4a2f6377

    return v0
.end method
