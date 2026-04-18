.class public Lorg/drinkless/tdlib/TdApi$SetChatSlowModeDelay;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetChatSlowModeDelay"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x203519c2


# instance fields
.field public chatId:J

.field public slowModeDelay:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31428
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31429
    return-void
.end method

.method public constructor <init>(JI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I

    .line 31418
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31419
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetChatSlowModeDelay;->chatId:J

    .line 31420
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$SetChatSlowModeDelay;->slowModeDelay:I

    .line 31421
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31425
    const v0, -0x203519c2

    return v0
.end method
