.class public Lorg/drinkless/tdlib/TdApi$ToggleChatIsMarkedAsUnread;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleChatIsMarkedAsUnread"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3ac72521


# instance fields
.field public chatId:J

.field public isMarkedAsUnread:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33128
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33129
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 33118
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33119
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleChatIsMarkedAsUnread;->chatId:J

    .line 33120
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$ToggleChatIsMarkedAsUnread;->isMarkedAsUnread:Z

    .line 33121
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33125
    const v0, -0x3ac72521

    return v0
.end method
