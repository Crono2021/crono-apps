.class public Lorg/drinkless/tdlib/TdApi$ToggleChatHasProtectedContent;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleChatHasProtectedContent"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3a20d94d


# instance fields
.field public chatId:J

.field public hasProtectedContent:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33108
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33109
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 33098
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33099
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleChatHasProtectedContent;->chatId:J

    .line 33100
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$ToggleChatHasProtectedContent;->hasProtectedContent:Z

    .line 33101
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33105
    const v0, 0x3a20d94d

    return v0
.end method
